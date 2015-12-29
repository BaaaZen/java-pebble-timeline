package nl.palolem.timeline.api.pin.layout;

public final class GenericReminder extends Layout {

	private String locationName;

	public GenericReminder() {
		super(LayoutType.GENERIC_REMINDER);
	}

	public String getLocationName() {
		return locationName;
	}

	public static final class Builder extends Layout.Builder<GenericReminder, Builder> {

		@Override
		protected GenericReminder newObject() {
			return new GenericReminder();
		}

		@Override
		protected Builder builder() {
			return this;
		}

		@Override
		public GenericReminder build() {
			return object;
		}

		public Builder locationName(String locationName) {
			object.locationName = locationName;
			return builder;
		}
	}

}
