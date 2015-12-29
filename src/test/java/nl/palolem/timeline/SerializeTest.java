package nl.palolem.timeline;

import java.io.IOException;
import java.util.Date;

import nl.palolem.timeline.api.pin.Icon;
import nl.palolem.timeline.api.pin.Pin;
import nl.palolem.timeline.api.pin.action.HttpAction;
import nl.palolem.timeline.api.pin.layout.GenericPin;
import nl.palolem.timeline.util.PebbleException;

import org.junit.Ignore;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;

public class SerializeTest extends AbstractTest {

	private String token = "my-token";

	@Test
	@Ignore("fill token")
	public void testSerialize() throws IOException {
		Pin pin = new Pin.Builder().time(new Date())
				.id("example-pin-generic-1")
				.layout(new GenericPin.Builder().title("News at 6 o'clock").tinyIcon(Icon.NOTIFICATION_FLAG).build())
				.build();

		try {
			Timeline.sendPin(token, pin);
		} catch (PebbleException e) {
			System.out.println(e.getResponse().getSummary());
		}
	}

	@Test
	public void testSendPin() throws JsonProcessingException {
		Pin pin = new Pin.Builder().time(getDate("2015-11-30T23:00:00Z"))
				.id("example-pin-generic-2")
				.layout(new GenericPin.Builder().title("News at 6 o'clock").tinyIcon(Icon.NOTIFICATION_FLAG).build())
				.build();

		System.out.println(Timeline.serializeAndFormat(pin));
	}

	@Test
	public void testSendPinAction() throws JsonProcessingException {
		JsonTestData testData = new JsonTestData();
		testData.setType("confirm");
		testData.setValue(true);

		Pin pin = new Pin.Builder().time(getDate("2015-11-30T23:00:00Z"))
				.id("example-pin-generic-2")
				.layout(new GenericPin.Builder().title("News at 6 o'clock").tinyIcon(Icon.NOTIFICATION_FLAG).build())
				.action(new HttpAction.Builder().title("Confirm Meeting")
						.url("http://some-meeting-service.com/api/v1/meetings/46146717")
						.method("PUT")
						.header("X-Request-Source", "pebble-timeline")
						.bodyJSON(testData)
						.successIcon(Icon.GENERIC_CONFIRMATION)
						.successText("Confirmed!")
						.build())
				.build();

		System.out.println(Timeline.serializeAndFormat(pin));
	}

	private class JsonTestData {

		private String type;

		private boolean value;

		@SuppressWarnings("unused")
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		@SuppressWarnings("unused")
		public boolean isValue() {
			return value;
		}

		public void setValue(boolean value) {
			this.value = value;
		}
	}
}
