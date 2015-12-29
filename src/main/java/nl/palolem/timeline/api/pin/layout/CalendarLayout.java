package nl.palolem.timeline.api.pin.layout;

public final class CalendarLayout extends Layout {

	private String locationName;

	public CalendarLayout() {
		super(LayoutType.CALENDAR_PIN);
	}

	public String getLocationName() {
		return locationName;
	}

	public static final class Builder extends Layout.Builder<CalendarLayout, Builder> {

		@Override
		protected CalendarLayout newObject() {
			return new CalendarLayout();
		}

		@Override
		protected Builder builder() {
			return this;
		}

		@Override
		public CalendarLayout build() {
			return object;
		}

		public Builder locationName(String locationName) {
			object.locationName = locationName;
			return builder;
		}

	}

}
