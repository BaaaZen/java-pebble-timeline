package nl.palolem.timeline.api.response;

import java.util.List;

public class Response {

	private enum ErrorCode {
		INVALID_JSON, INVALID_API_KEY, INVALID_USER_TOKEN, RATE_LIMIT_EXCEEDED, SERVICE_UNAVAILABLE;
	}

	private ErrorCode errorCode;

	private String errorMessage;

	private List<ErrorDetail> errorDetails;

	public ErrorCode getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(ErrorCode errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public List<ErrorDetail> getErrorDetails() {
		return errorDetails;
	}

	public void setErrorDetails(List<ErrorDetail> errorDetails) {
		this.errorDetails = errorDetails;
	}

	public String getSummary() {
		StringBuilder sb = new StringBuilder();
		sb.append(getErrorCode());

		if (getErrorDetails() != null && getErrorDetails().size() > 0) {
			for (ErrorDetail detail : getErrorDetails()) {
				sb.append(" - ");
				sb.append(detail.getMessage());
			}
		} else {
			sb.append(" - ");
			sb.append(getErrorMessage());
		}

		return sb.toString();
	}

}
