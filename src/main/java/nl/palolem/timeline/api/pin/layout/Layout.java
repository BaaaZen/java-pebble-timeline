package nl.palolem.timeline.api.pin.layout;

import nl.palolem.timeline.api.pin.Icon;
import nl.palolem.timeline.util.AbstractBuilder;
import nl.palolem.timeline.util.StringUtil;

import com.fasterxml.jackson.annotation.JsonValue;

public abstract class Layout {

	public enum LayoutType {
		GENERIC_PIN, CALENDAR_PIN, SPORTS_PIN, WEATHER_PIN, GENERIC_NOTIFICATION, GENERIC_REMINDER;

		@JsonValue
		public String toValue() {
			return StringUtil.toCamelCase(name());
		}
	}

	protected LayoutType type;

	protected String title;

	protected String subtitle;

	protected String body;

	protected Icon tinyIcon;

	protected Icon smallIcon;

	protected Icon largeIcon;

	protected String primaryColor;

	protected String secondaryColor;

	protected String backgroundColor;

	// TODO : Headings, paragraphs, lastUpdate

	public Layout(LayoutType type) {
		this.type = type;
	}

	public LayoutType getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public String getSubtitle() {
		return subtitle;
	}

	public String getBody() {
		return body;
	}

	public Icon getTinyIcon() {
		return tinyIcon;
	}

	public Icon getSmallIcon() {
		return smallIcon;
	}

	public Icon getLargeIcon() {
		return largeIcon;
	}

	public String getPrimaryColor() {
		return primaryColor;
	}

	public String getSecondaryColor() {
		return secondaryColor;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	protected static abstract class Builder<T extends Layout, B extends Builder<T, B>> extends AbstractBuilder<T, B> {

		public B title(String title) {
			object.title = title;
			return builder;
		}

		public B subtitle(String subtitle) {
			object.subtitle = subtitle;
			return builder;
		}

		public B body(String body) {
			object.body = body;
			return builder;
		}

		public B tinyIcon(Icon tinyIcon) {
			object.tinyIcon = tinyIcon;
			return builder;
		}

		public B smallIcon(Icon smallIcon) {
			object.smallIcon = smallIcon;
			return builder;
		}

		public B largeIcon(Icon largeIcon) {
			object.largeIcon = largeIcon;
			return builder;
		}

		public B primaryColor(String primaryColor) {
			object.primaryColor = primaryColor;
			return builder;
		}

		public B secondaryColor(String secondaryColor) {
			object.secondaryColor = secondaryColor;
			return builder;
		}

		public B backgroundColor(String backgroundColor) {
			object.backgroundColor = backgroundColor;
			return builder;
		}
	}

}
