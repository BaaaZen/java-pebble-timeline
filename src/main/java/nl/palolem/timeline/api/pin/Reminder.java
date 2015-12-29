package nl.palolem.timeline.api.pin;

import java.util.Date;

import nl.palolem.timeline.api.pin.layout.Layout;
import nl.palolem.timeline.util.AbstractBuilder;

public final class Reminder {

	private Date time;

	private Layout layout;

	public Date getTime() {
		return time;
	}

	public Layout getLayout() {
		return layout;
	}

	public static class Builder extends AbstractBuilder<Reminder, Builder> {

		@Override
		protected Reminder newObject() {
			return new Reminder();
		}

		@Override
		protected Builder builder() {
			return this;
		}

		@Override
		public Reminder build() {
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
