package nl.palolem.timeline.api.pin.action;

import nl.palolem.timeline.util.AbstractBuilder;
import nl.palolem.timeline.util.StringUtil;

import com.fasterxml.jackson.annotation.JsonValue;

public abstract class Action {

	public enum ActionType {
		OPEN_WATCH_APP, HTTP;

		@JsonValue
		public String toValue() {
			return StringUtil.toCamelCase(name());
		}
	}

	public Action(ActionType type) {
		this.type = type;
	}

	protected String title;

	protected ActionType type;

	public String getTitle() {
		return title;
	}

	public ActionType getType() {
		return type;
	}

	protected static abstract class Builder<T extends Action, B extends Builder<T, B>> extends AbstractBuilder<T, B> {

		public B title(String title) {
			object.title = title;
			return builder;
		}

		public B type(ActionType type) {
			object.type = type;
			return builder;
		}

	}
}
