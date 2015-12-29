package nl.palolem.timeline.api.pin.layout;

public final class GenericPin extends Layout {

	public GenericPin() {
		super(LayoutType.GENERIC_PIN);
	}

	public static final class Builder extends Layout.Builder<GenericPin, Builder> {

		@Override
		protected GenericPin newObject() {
			return new GenericPin();
		}

		@Override
		protected Builder builder() {
			return this;
		}

		@Override
		public GenericPin build() {
			return object;
		}
	}

}
