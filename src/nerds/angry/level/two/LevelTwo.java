package nerds.angry.level.two;

public class LevelTwo {
	public static void rotateArray(int[] array, int k) {
		if(array == null || array.length < 2) {
            return;
        }
		for (int j = 0; j < k; j++) {
			int first = array[0];
			for(int i = 0; i < array.length - 1; i++) {
				array[i] = array[i + 1];
			}
			array[array.length - 1] = first;
		}
	}

	public static int getLengthOfLongestSubstringNonRepeatingChars(String str) {
		// Write your code here
		return -1;
	}
	
}

