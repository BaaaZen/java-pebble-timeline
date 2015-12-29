package nl.palolem.timeline.api.pin;

import java.util.Date;

import nl.palolem.timeline.api.pin.layout.Layout;
import nl.palolem.timeline.util.AbstractBuilder;

public final class Notification {

	private Layout layout;

	private Date time;

	public Layout getLayout() {
		return layout;
	}

	public Date getTime() {
		return time;
	}

	public static class Builder extends AbstractBuilder<Notification, Builder> {

		@Override
		protected Notification newObject() {
			return new Notification();
		}

		@Override
		protected Builder builder() {
			return this;
		}

		@Override
		public Notification build() {
			return object;
		}

		public Builder layout(Layout layout) {
			object.layout = layout;
			return builder;
		}

		public Builder time(Date time) {
			object.time = time;
			return builder;
		}
	}

}
