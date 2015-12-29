package nl.palolem.timeline.api.pin.layout;

public final class SportsLayout extends Layout {

	private String rankAway;

	private String rankHome;

	private String nameAway;

	private String nameHome;

	private String recordAway;

	private String recordHome;

	private String scoreAway;

	private String scoreHome;

	private String sportsGameState;

	public SportsLayout() {
		super(LayoutType.SPORTS_PIN);
	}

	public String getRankAway() {
		return rankAway;
	}

	public String getRankHome() {
		return rankHome;
	}

	public String getNameAway() {
		return nameAway;
	}

	public String getNameHome() {
		return nameHome;
	}

	public String getRecordAway() {
		return recordAway;
	}

	public String getRecordHome() {
		return recordHome;
	}

	public String getScoreAway() {
		return scoreAway;
	}

	public String getScoreHome() {
		return scoreHome;
	}

	public String getSportsGameState() {
		return sportsGameState;
	}

	public static final class Builder extends Layout.Builder<SportsLayout, Builder> {

		@Override
		protected SportsLayout newObject() {
			return new SportsLayout();
		}

		@Override
		protected Builder builder() {
			return this;
		}

		@Override
		public SportsLayout build() {
			return object;
		}

		public Builder rankAway(String rankAway) {
			object.rankAway = rankAway;
			return builder;
		}

		public Builder rankHome(String rankHome) {
			object.rankHome = rankHome;
			return builder;
		}

		public Builder nameAway(String nameAway) {
			object.nameAway = nameAway;
			return builder;
		}

		public Builder nameHome(String nameHome) {
			object.nameHome = nameHome;
			return builder;
		}

		public Builder recordAway(String recordAway) {
			object.recordAway = recordAway;
			return builder;
		}

		public Builder recordHome(String recordHome) {
			object.recordHome = recordHome;
			return builder;
		}

		public Builder scoreAway(String scoreAway) {
			object.scoreAway = scoreAway;
			return builder;
		}

		public Builder scoreHome(String scoreHome) {
			object.scoreHome = scoreHome;
			return builder;
		}

		public Builder sportsGameState(String sportsGameState) {
			object.sportsGameState = sportsGameState;
			return builder;
		}

	}

}
