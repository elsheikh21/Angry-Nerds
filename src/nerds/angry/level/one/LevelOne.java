package nerds.angry.level.one;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

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

	public static String hasAllUniqueChars(String string) {
		if (string == null || string.length() < 2) {
			return "T";
		}
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < string.length(); i++) {
			if (set.contains(string.charAt(i))) {
				return "F";
			}
			set.add(string.charAt(i));
		}
		return "T";
	}

	public static void printSumOfDigits(int number) {
		int sum = 0;
		while (number > 0) {
			sum += number % 10;
			number /= 10;
		}
		System.out.println(sum);
	}

	public static void addObjectsToListAndPrintCount(ArrayList<AngryNerds> list, int n) {
		for (int i = 0; i < n; i++) {
			list.add(AngryNerds.getInstance());
		}
		if (list.size() > 0) {
			AngryNerds a = list.get(0);
			System.out.println(a.getCount());
		} else {
			System.out.println(0);
		}
	}

	public static void printALinkedList(ListNode head) {
		if (head == null) {
			return;
		}
		System.out.print(head.data + " ");
		printALinkedList(head.next);
	}

	public static void printNumberOfSetBits(int n) {
		int setBitsCount = 0;
		while (n > 0) {
			if ((n & 1) == 1) {
				setBitsCount++;
			}
			n = n / 2;
		}
		System.out.println(setBitsCount);
	}

	public static void printPattern(int start, int difference, int upperLimit) {
		int line = 1;
		int k = 1;
		for (int i = start; i <= upperLimit; i += difference, k++) {
			System.out.print(i);
			if (k == line) {
				System.out.println();
				line++;
				k = 0;
			}
		}
	}

	public static void printNthNodeOfALinkedList(ListNode head, int n) {
		if (head == null) {
			System.out.println("X");
			return;
		}
		if (n == 1) {
			System.out.println(head.data);
			return;
		}
		printNthNodeOfALinkedList(head.next, n - 1);
	}

	public static void printDuplicates(String string) {
		String stringLowered = string.toLowerCase();
		String temp = "";
		for (int i = 0; i < stringLowered.length(); i++) {
			char toCheck = stringLowered.charAt(i);
			for (int j = i + 1; j < stringLowered.length(); j++) {
				if (toCheck == stringLowered.charAt(j) && !temp.contains(String.valueOf(toCheck))) {
					temp += toCheck;
					break;
				}
			}
		}
		char[] c = temp.toCharArray();
		Arrays.sort(c);
		System.out.println(c);
		// System.out.println(sort(temp)); // in case of Arrays.sort is not allowed
	}

	public static char[] sort(String input) {
		char[] charArray = input.toCharArray();
		int length = charArray.length;
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				if (charArray[j] < charArray[i]) {
					char temp = charArray[i];
					charArray[i] = charArray[j];
					charArray[j] = temp;
				}
			}
		}
		return charArray;
	}

	public static List<Integer> addToList(String string1, String string2) {
		List<Integer> list = new ArrayList<>();
		if (string1.equals("1")) {
			String[] ints = string2.split(",");
			for (String s : ints) {
				list.add(Integer.parseInt(s));
			}
		} else if (string1.equals("2")) {
			list.add(Integer.parseInt(string2));
		}
		return list;
	}

	public static void printMaxAndMin(TreeNode root) {
		if (root == null) {
			return;
		}
		int[] values = new int[2];
		if (root.data < 0) {
			values[0] = -1000;
			values[1] = 1000;
		} else {
			values[0] = 0;
			values[1] = 1000;
		}

		findMaxAndMin(root, values);
		System.out.println(values[1] + " " + values[0]);
	}

	private static void findMaxAndMin(TreeNode root, int values[]) {
		if (root == null) {
			return;
		}
		if (values[0] > root.data) {
			values[0] = root.data;
		}
		if (values[1] < root.data) {
			values[1] = root.data;
		}
		findMaxAndMin(root.left, values);
		findMaxAndMin(root.right, values);
	}

	public static void printDiscountedAmount(float total) {
		if (2000 > total && total >= 1000) {
			total -= total * 0.05;
		}
		if (3000 > total && total >= 2000) {
			total -= total * 0.10;
		}
		if (total >= 3000) {
			total -= total * 0.15;
		}
		System.out.println(total);
	}

	public static void reverse(char[] array) {
		if (array == null || array.length < 2) {
			return;
		}
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			swap(array, left, right);
			left++;
			right--;
		}
	}

	private static void swap(char[] array, int left, int right) {
		char temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}

	public static void printMinimumCommonElement(int[] array1, int[] array2) {
		int[] resArray = intersection(array1, array2);
		if (resArray == null || resArray.length == 0) {
			System.out.println("X");
			return;
		}
		System.out.println(resArray[0]);
	}

	public static int[] intersection(int[] arr1, int[] arr2) {
		if (arr1.length == 0 || arr2.length == 0) {
			return null;
		}
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		for (int i = 0; i < arr1.length; i++) {
			int toCheck = arr1[i];
			if (Arrays.binarySearch(arr2, toCheck) >= 0) {
				arrayList.add(toCheck);
			}
		}
		int[] arr = new int[arrayList.size()];
		for (int i = 0; i < arrayList.size(); i++) {
			arr[i] = arrayList.get(i);
		}
		Arrays.sort(arr);
		return arr;
	}

	public static String printMaximumOccurringAlphabet(String input) {
		input = input.toLowerCase();
		Map<Character, Integer> m = new HashMap<>();
		int maxCount = 0;
		char maxChar = ' ';
		int value = 1;
		for (int i = 0; i < input.length(); i++) {
			char key = input.charAt(i);
			if (!(key >= 'a' && key <= 'z')) {
				continue;
			}
			if (m.containsKey(key)) {
				value = m.get(key) + 1;
			} else {
				value = 1;
			}
			m.put(key, value);
			if (maxCount <= value) {
				maxCount = value;
				maxChar = key;
			}
		}
		if (maxCount != 0) {
			return (maxChar + " - " + maxCount);
		} else {
			return "No maximum occurring alphabet found!";
		}
	}

	public static void reArrangeArrayElements(int[] array) {
		int n = array.length;
		for (int i = 0; i < n; i += 2) {
			rotateSubarrayBy1Element(array, i);
		}
	}

	private static void rotateSubarrayBy1Element(int[] array, int startPosition) {
		int n = array.length;
		int temp = array[n - 1];
		for (int j = n - 1; j > startPosition; j--) {
			array[j] = array[j - 1];
		}
		array[startPosition] = temp;
	}

	public static void printLevel(TreeNode root, int n) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int level = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size > 0) {
				TreeNode node = queue.remove();
				if (node.data == n) {
					System.out.println(level);
					return;
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
				size--;
			}
			level++;
		}
	}

	public static ListNode removeNumber(ListNode head, int value) {
		if (head == null) {
			return head;
		}
		ListNode current = head;
		ListNode trailcurrent = null;
		while (current != null) {
			if (current.data == value) {
				if (current == head) {
					head = head.next;
					current = head;
				} else {
					trailcurrent.next = current.next;
					current = trailcurrent.next;
				}
			} else {
				trailcurrent = current;
				current = current.next;
			}
		}
		return head;
	}

	public static void printNumbers(int[] array) {
		int n = array.length;
		int[] greatestOnLeft = new int[n + 1];
		int[] smallestOnRight = new int[n + 1];

		greatestOnLeft[0] = Integer.MIN_VALUE;
		for (int i = 1; i <= n; i++) {
			if (greatestOnLeft[i - 1] < array[i - 1]) {
				greatestOnLeft[i - 1] = array[i - 1];
			}
		}

		smallestOnRight[n] = Integer.MAX_VALUE;
		for (int i = n - 1; i >= 0; i--) {
			if (smallestOnRight[i + 1] < array[i]) {
				smallestOnRight[i + 1] = array[i];
			}
		}

		for (int i = 0; i < n - 1; i++) {
			if (greatestOnLeft[i] < array[i + 1] && array[i] < smallestOnRight[i + 1]) {
				System.out.print(array[i] + " ");
			}
		}
	}

}
