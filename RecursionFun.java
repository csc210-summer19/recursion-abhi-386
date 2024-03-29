/**
 * Complete the seven methods methods in this file using recursion, no loops.
 * Also complete these three methods inside LinkedList<E>: get(int) removeAll(E)
 * duplicateAll(E)
 * 
 * Also complete one method in ObstacleCourse that uses recursive backtracking.
 * findExit(int, int)
 * 
 * Note: I believe the given unit test tests all methods. We will be using this
 * same for for correctness of code.
 * 
 * We will not be using code coverage for points.
 *
 * @author Rick Mercer and Abhishek Agarwal
 */
public class RecursionFun {
	public int combinations(int n, int k) {
		if (k == 1) {
			return n;
		} else if (n == k) {
			return 1;
		} else {
			return combinations(n - 1, k - 1) + combinations(n - 1, k);
		}
	}

	// Complete recursive method intWithCommas that returns the argument as a
	// String
	// with commas in the correct places.
	//
	// intWithCommas(999) returns "999"
	// intWithCommas(1234) returns "1,234"
	// intWithCommas(1007) returns "1,007"
	// intWithCommas(1023004567) returns "1,023,004,567"
	//
	// Precondition: n >= 0
	public String intWithCommas(int n) {
		if (n == 0) {
			return "";
		} else {
			int rem = n % 1000;
			int quo = n / 1000;
			String str = "" + rem;
			if (rem / 100 <= 0 && quo > 0) {
				if (rem / 10 > 0) {
					str = "0" + rem;
				} else {
					str = "00" + rem;
				}
			}
			if (quo > 0) {
				return intWithCommas(quo) + "," + str;
			} else {
				return "" + str;
			}
		}
	}

	// Write recursive method reverseArray that reverses the array elements in a
	// filled array of ints. Use recursion; do not use a loop. The following
	// assertions must pass:
	//
	// int[] a = { 2, 4, 6 };
	// rf.reverseArray(a);
	// assertEquals(6, a[0]);
	// assertEquals(4, a[1]);
	// assertEquals(2, a[2]);
	//
	// Precondition: x.length > 0
	public void reverseArray(int[] x) {
		// You need a private helper that needs additional arguments.
		// like x and x.length to keep track of array the indexes
		// with no loop. Here is an example with the private helper
		// immediately below.
		reverseArray(x, 0, x.length - 1);
	}

	private void reverseArray(int[] x, int index, int len) {
		if (len < index) {
			x = x;
		} else {
			int temp = x[len];
			x[len] = x[index];
			x[index] = temp;
			reverseArray(x, index + 1, len - 1);
		}
	}

	// Write recursive method arrayRange that returns the maximum
	// integer minus the minimum integer in the filled array of
	// integers, Use recursion; do not use a loop.
	// Precondition: a.length > 0
	public int arrayRange(int[] a) {
		return arrayrange(a, a[0], a[0], 0);
	}

	private int arrayrange(int[] a, int max, int min, int index) {
		if (index < a.length) {
			if (a[index] > max) {
				max = a[index];
			} else if (a[index] < min) {
				min = a[index];
			}
			return arrayrange(a, max, min, index + 1);
		}
		return max - min;
	}

// Return true if nums has all int elements in ascending order.
	// If not isSorted, return false.
	public boolean isSorted(int[] nums) {
		return sorted(nums, 0, nums.length - 1);

	}

	private boolean sorted(int[] nums, int index, int len) {
		if (index >= len) {
			return true;
		} else {
			if (nums[index] > nums[index + 1]) {
				return false;
			} else {
				return sorted(nums, index + 1, len);
			}
		}
	}

// Complete method found to return true if search is found in strs.
	// If not found, return false. Use equals, not ==.
	public boolean found(String search, String[] strs) {
		return found(strs, search, 0);
	}

	private boolean found(String[] strs, String search, int index) {
		if (index >= strs.length) {
			return false;
		} else {
			if (strs[index].contentEquals(search)) {
				return true;
			} else {
				return found(strs, search, index + 1);
			}
		}
	}
}
