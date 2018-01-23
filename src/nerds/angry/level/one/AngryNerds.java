package nerds.angry.level.one;

public class AngryNerds {
		private static int count;
		public AngryNerds() {
			count++;
		}
		public static AngryNerds getInstance() {
			return new AngryNerds();
		}
		public Integer getCount() {
			return count;
		}
}
