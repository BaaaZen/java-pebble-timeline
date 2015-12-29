package nl.palolem.timeline.api.response;

public class ErrorDetail {

	private String message;

	private String path;

	private String type;

	private ErrorContext context;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ErrorContext getContext() {
		return context;
	}

	public void setContext(ErrorContext context) {
		this.context = context;
	}

}
