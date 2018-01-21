package nerds.angry.level.one;

public class LevelOne {
	public static float getAreaOfCircle(int radius) {
		return (float) (3.1428572 * radius * radius);
	}

	public static void divide(int a, int b) {
		if (a == 0) {
			System.out.println("Cannot divide by 0");
			return;
		}
		if (b == 0) {
			System.out.println("Cannot divide by 0");
			return;
		}
		System.out.println((double) a / b);
	}
}
