package nl.palolem.timeline;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import nl.palolem.timeline.api.pin.Pin;
import nl.palolem.timeline.api.response.Response;
import nl.palolem.timeline.util.PebbleException;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class Timeline {

	private static final String PINS_URL = "https://timeline-api.getpebble.com/v1/user/pins";

	private static ObjectMapper mapper = createObjectMapper();

	public static void sendPin(String token, Pin pin) throws IOException, PebbleException {
		String url = String.format("%s/%s", PINS_URL, pin.getId());

		HttpURLConnection connection = null;

		try {
			connection = (HttpURLConnection) new URL(url).openConnection();
			connection.setDoOutput(true);
			connection.setRequestMethod("PUT");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.setRequestProperty("X-User-Token", token);

			OutputStream os = connection.getOutputStream();
			mapper.writer().writeValue(os, pin);
			os.flush();

			int statusCode = connection.getResponseCode();
			if (statusCode != 200) {
				InputStream is = connection.getErrorStream();
				Response response = mapper.readValue(is, Response.class);
				throw new PebbleException(String.format("Error sending pin: %s", response.getSummary()), response);
			}
		} finally {
			if (connection != null) {
				connection.disconnect();
			}
		}
	}

	public static String serialize(Pin pin) throws JsonProcessingException {
		return mapper.writeValueAsString(pin);
	}

	public static String serializeAndFormat(Pin pin) throws JsonProcessingException {
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pin);
	}

	private static ObjectMapper createObjectMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
				.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false)
				.setSerializationInclusion(Include.NON_NULL);
		return mapper;
	}
}
