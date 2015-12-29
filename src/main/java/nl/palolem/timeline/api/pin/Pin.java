package nl.palolem.timeline.api.pin;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nl.palolem.timeline.api.pin.action.Action;
import nl.palolem.timeline.api.pin.layout.Layout;
import nl.palolem.timeline.util.AbstractBuilder;

public final class Pin {

	private String id;

	private Date time;

	private Integer duration;

	private Notification createNotification;

	private Notification updateNotification;

	private Layout layout;

	private List<Reminder> reminders = new ArrayList<Reminder>();

	private List<Action> actions = new ArrayList<Action>();

	private Pin() {
	}

	public String getId() {
		return id;
	}

	public Date getTime() {
		return time;
	}

	public Integer getDuration() {
		return duration;
	}

	public Notification getCreateNotification() {
		return createNotification;
	}

	public Notification getUpdateNotification() {
		return updateNotification;
	}

	public Layout getLayout() {
		return layout;
	}

	public List<Reminder> getReminders() {
		return reminders;
	}

	public List<? extends Action> getActions() {
		return actions;
	}

	public static class Builder extends AbstractBuilder<Pin, Builder> {

		@Override
		protected Pin newObject() {
			return new Pin();
		}

		@Override
		protected Builder builder() {
			return this;
		}

		@Override
		public Pin build() {
			return object;
		}

		public Builder id(String id) {
			object.id = id;
			return builder;
		}

		public Builder time(Date time) {
			object.time = time;
			return builder;
		}

		public Builder duration(Integer duration) {
			object.duration = duration;
			return builder;
		}

		public Builder createNotification(Notification notification) {
			object.createNotification = notification;
			return builder;
		}

		public Builder updateNotification(Notification notification) {
			object.updateNotification = notification;
			return builder;
		}

		public Builder layout(Layout layout) {
			object.layout = layout;
			return builder;
		}

		public Builder reminder(Reminder reminder) {
			object.reminders.add(reminder);
			return builder;
		}

		public Builder action(Action action) {
			object.actions.add(action);
			return builder;
		}

	}

}
