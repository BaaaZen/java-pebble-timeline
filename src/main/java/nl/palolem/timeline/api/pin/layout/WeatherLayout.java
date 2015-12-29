package nl.palolem.timeline.api.pin.layout;

public final class WeatherLayout extends Layout {

	private String locationName;

	public WeatherLayout() {
		super(LayoutType.WEATHER_PIN);
	}

	public String getLocationName() {
		return locationName;
	}

	public static final class Builder extends Layout.Builder<WeatherLayout, Builder> {

		@Override
		protected WeatherLayout newObject() {
			return new WeatherLayout();
		}

		@Override
		protected Builder builder() {
			return this;
		}

		@Override
		public WeatherLayout build() {
			return object;
		}

		public Builder locationName(String locationName) {
			object.locationName = locationName;
			return builder;
		}

	}

}
