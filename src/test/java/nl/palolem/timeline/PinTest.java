package nl.palolem.timeline;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Date;

import nl.palolem.timeline.api.pin.Icon;
import nl.palolem.timeline.api.pin.Notification;
import nl.palolem.timeline.api.pin.Pin;
import nl.palolem.timeline.api.pin.Reminder;
import nl.palolem.timeline.api.pin.action.Action.ActionType;
import nl.palolem.timeline.api.pin.action.OpenWatchAppAction;
import nl.palolem.timeline.api.pin.layout.GenericNotification;
import nl.palolem.timeline.api.pin.layout.GenericPin;
import nl.palolem.timeline.api.pin.layout.GenericReminder;
import nl.palolem.timeline.api.pin.layout.Layout.LayoutType;

import org.junit.Test;

public class PinTest extends AbstractTest {

	@Test
	public void testId() {
		Pin pin = new Pin.Builder().id("reservation-1395203").build();
		assertThat(pin.getId(), is("reservation-1395203"));
	}

	public void testTime() {
		Date date = new Date();
		Pin pin = new Pin.Builder().id("reservation-1395203").time(date).build();
		assertThat(pin.getTime(), is(date));
	}

	public void testDuration() {
		Pin pin = new Pin.Builder().id("reservation-1395203").duration(60).build();
		assertThat(pin.getDuration(), is(60));
	}

	public void testSimplePin() {
		Pin pin = new Pin.Builder().time(getDate("2015-03-19T18:00:00Z"))
				.id("example-pin-generic-1")
				.layout(new GenericPin.Builder().title("News at 6 o'clock").tinyIcon(Icon.NOTIFICATION_FLAG).build())
				.build();

		assertThat(pin.getId(), is("example-pin-generic-1"));
		assertThat(pin.getLayout().getType(), is(LayoutType.GENERIC_PIN));
		assertThat(pin.getLayout().getTitle(), is("News at 6 o'clock"));
		assertThat(pin.getLayout().getTinyIcon(), is(Icon.NOTIFICATION_FLAG));
	}

	public void testCompletePin() {
		Date start = getDate("2015-03-19T15:00:00Z");

		Pin pin = new Pin.Builder().id("meeting-453923")
				.time(start)
				.duration(60)
				.createNotification(new Notification.Builder().layout(new GenericNotification.Builder().title("New Item")
						.tinyIcon(Icon.NOTIFICATION_FLAG)
						.body("A new appointment has been added to your calendar at 4pm.")
						.build())
						.build())
				.updateNotification(new Notification.Builder().time(getDate("2015-03-19T16:00:00Z"))
						.layout(new GenericNotification.Builder().tinyIcon(Icon.NOTIFICATION_FLAG)
								.title("Reminder")
								.body("The meeting has been rescheduled to 4pm.")
								.build())
						.build())
				.layout(new GenericPin.Builder().title("Client Meeting")
						.tinyIcon(Icon.TIMELINE_CALENDAR)
						.body("Meeting in Kepler at 4:00pm. Topic: discuss pizza toppings for party.")
						.build())
				.reminder(new Reminder.Builder().time(getDate("2015-03-19T15:15:00Z"))
						.layout(new GenericReminder.Builder().tinyIcon(Icon.TIMELINE_CALENDAR)
								.title("Meeting in 15 minutes")
								.build())
						.build())
				.reminder(new Reminder.Builder().time(getDate("2015-03-19T15:05:00Z"))
						.layout(new GenericReminder.Builder().tinyIcon(Icon.TIMELINE_CALENDAR)
								.title("Meeting in 5 minutes")
								.build())
						.build())
				.action(new OpenWatchAppAction.Builder().title("View Schedule").launchCode(15).build())
				.action(new OpenWatchAppAction.Builder().title("Show Directions").launchCode(22).build())
				.build();

		assertThat(pin.getId(), is("meeting-453923"));
		assertThat(pin.getDuration(), is(60));
		assertThat(pin.getTime(), is(getDate("2015-03-19T15:00:00Z")));

		assertThat(pin.getCreateNotification().getTime(), nullValue());
		assertThat(pin.getCreateNotification().getLayout().getType(), is(LayoutType.GENERIC_NOTIFICATION));
		assertThat(pin.getCreateNotification().getLayout().getTitle(), is("New Item"));
		assertThat(pin.getCreateNotification().getLayout().getTinyIcon(), is(Icon.NOTIFICATION_FLAG));
		assertThat(pin.getCreateNotification().getLayout().getBody(),
				is("A new appointment has been added to your calendar at 4pm."));

		assertThat(pin.getUpdateNotification().getTime(), is(getDate("2015-03-19T16:00:00Z")));
		assertThat(pin.getUpdateNotification().getLayout().getType(), is(LayoutType.GENERIC_NOTIFICATION));
		assertThat(pin.getUpdateNotification().getLayout().getTitle(), is("Reminder"));
		assertThat(pin.getUpdateNotification().getLayout().getTinyIcon(), is(Icon.NOTIFICATION_FLAG));
		assertThat(pin.getUpdateNotification().getLayout().getBody(), is("The meeting has been rescheduled to 4pm."));

		assertThat(pin.getLayout().getType(), is(LayoutType.GENERIC_PIN));
		assertThat(pin.getLayout().getTitle(), is("Client Meeting"));
		assertThat(pin.getLayout().getTinyIcon(), is(Icon.TIMELINE_CALENDAR));
		assertThat(pin.getLayout().getBody(),
				is("Meeting in Kepler at 4:00pm. Topic: discuss pizza toppings for party."));

		Reminder firstReminder = pin.getReminders().get(0);
		assertThat(firstReminder.getTime(), is(getDate("2015-03-19T14:45:00Z")));
		assertThat(firstReminder.getLayout().getType(), is(LayoutType.GENERIC_REMINDER));
		assertThat(firstReminder.getLayout().getTinyIcon(), is(Icon.TIMELINE_CALENDAR));
		assertThat(firstReminder.getLayout().getTitle(), is("Meeting in 15 minutes"));

		Reminder secondReminder = pin.getReminders().get(1);
		assertThat(secondReminder.getTime(), is(getDate("2015-03-19T14:55:00Z")));
		assertThat(secondReminder.getLayout().getType(), is(LayoutType.GENERIC_REMINDER));
		assertThat(secondReminder.getLayout().getTinyIcon(), is(Icon.TIMELINE_CALENDAR));
		assertThat(secondReminder.getLayout().getTitle(), is("Meeting in 5 minutes"));

		OpenWatchAppAction firstAction = (OpenWatchAppAction) pin.getActions().get(0);
		assertThat(firstAction.getTitle(), is("View Schedule"));
		assertThat(firstAction.getType(), is(ActionType.OPEN_WATCH_APP));
		assertThat(firstAction.getLaunchCode(), is(new Integer(15)));

		OpenWatchAppAction secondAction = (OpenWatchAppAction) pin.getActions().get(1);
		assertThat(secondAction.getTitle(), is("Show Directions"));
		assertThat(secondAction.getType(), is(ActionType.OPEN_WATCH_APP));
		assertThat(secondAction.getLaunchCode(), is(new Integer(22)));
	}

}
