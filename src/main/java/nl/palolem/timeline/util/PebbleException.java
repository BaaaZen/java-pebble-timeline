package nl.palolem.timeline.util;

import nl.palolem.timeline.api.response.Response;

public class PebbleException extends Exception {

	private static final long serialVersionUID = 1L;

	private Response response;

	public PebbleException(String message, Response response) {
		super(message);
		this.response = response;
	}

	public Response getResponse() {
		return response;
	}
}