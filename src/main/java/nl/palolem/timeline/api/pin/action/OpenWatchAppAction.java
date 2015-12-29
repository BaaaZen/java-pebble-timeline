package nl.palolem.timeline.api.pin.action;

public final class OpenWatchAppAction extends Action {

	private Integer launchCode;

	public OpenWatchAppAction() {
		super(ActionType.OPEN_WATCH_APP);
	}

	public Integer getLaunchCode() {
		return launchCode;
	}

	public static final class Builder extends Action.Builder<OpenWatchAppAction, Builder> {

		@Override
		protected OpenWatchAppAction newObject() {
			return new OpenWatchAppAction();
		}

		@Override
		protected Builder builder() {
			return this;
		}

		@Override
		public OpenWatchAppAction build() {
			return object;
		}

		public Builder launchCode(Integer launchCode) {
			object.launchCode = launchCode;
			return builder;
		}

	}
}
