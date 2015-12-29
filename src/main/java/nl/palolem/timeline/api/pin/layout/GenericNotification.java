package nl.palolem.timeline.api.pin.layout;

public final class GenericNotification extends Layout {

	public GenericNotification() {
		super(LayoutType.GENERIC_NOTIFICATION);
	}

	public static final class Builder extends Layout.Builder<GenericNotification, Builder> {

		@Override
		protected GenericNotification newObject() {
			return new GenericNotification();
		}

		@Override
		protected Builder builder() {
			return this;
		}

		@Override
		public GenericNotification build() {
			return object;
		}
	}

}
