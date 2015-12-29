package nl.palolem.timeline.api.pin.action;

import java.util.HashMap;
import java.util.Map;

import nl.palolem.timeline.api.pin.Icon;

public final class HttpAction extends Action {

	private String url;

	private String method;

	private Map<String, String> headers = new HashMap<String, String>();

	private String bodyText;

	private Object bodyJSON;

	private String successText;

	private Icon successIcon;

	private String failureText;

	private Icon failureIcon;

	public HttpAction() {
		super(ActionType.HTTP);
	}

	public String getUrl() {
		return url;
	}

	public String getMethod() {
		return method;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public String getBodyText() {
		return bodyText;
	}

	public Object getBodyJSON() {
		return bodyJSON;
	}

	public String getSuccessText() {
		return successText;
	}

	public Icon getSuccessIcon() {
		return successIcon;
	}

	public String getFailureText() {
		return failureText;
	}

	public Icon getFailureIcon() {
		return failureIcon;
	}

	public static final class Builder extends Action.Builder<HttpAction, Builder> {

		@Override
		protected HttpAction newObject() {
			return new HttpAction();
		}

		@Override
		protected Builder builder() {
			return this;
		}

		@Override
		public HttpAction build() {
			return object;
		}

		public Builder url(String url) {
			object.url = url;
			return builder;
		}

		public Builder method(String method) {
			object.method = method;
			return builder;
		}

		public Builder header(String key, String value) {
			object.headers.put(key, value);
			return builder;
		}

		public Builder bodyText(String bodyText) {
			object.bodyText = bodyText;
			return builder;
		}

		public Builder bodyJSON(Object bodyJSON) {
			object.bodyJSON = bodyJSON;
			return builder;
		}

		public Builder successText(String successText) {
			object.successText = successText;
			return builder;
		}

		public Builder successIcon(Icon successIcon) {
			object.successIcon = successIcon;
			return builder;
		}

		public Builder failureText(String failureText) {
			object.failureText = failureText;
			return builder;
		}

		public Builder failureIcon(Icon failureIcon) {
			object.failureIcon = failureIcon;
			return builder;
		}

	}
}
