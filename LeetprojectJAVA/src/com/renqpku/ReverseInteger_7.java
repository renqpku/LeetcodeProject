package com.renqpku;

/**
 * Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321 Example2: x = -123, return -321
 * 
 * 
 * Have you thought about this? Here are some good questions to ask before
 * coding. Bonus points for you if you have already thought through this!
 * 
 * If the integer's last digit is 0, what should the output be? ie, cases such
 * as 10, 100.
 * 
 * Did you notice that the reversed integer might overflow? Assume the input is
 * a 32-bit integer, then the reverse of 1000000003 overflows. How should you
 * handle such cases?
 * 
 * For the purpose of this problem, assume that your function returns 0 when the
 * reversed integer overflows.
 * 
 * Note: The input is assumed to be a 32-bit signed integer. Your function
 * should return 0 when the reversed integer overflows.
 * 
 * @author renqiang
 *
 */

public class ReverseInteger_7 {

	public int reverse(int x) {
		String str_x = new Integer(x).toString();
		int leng = str_x.length();
		StringBuffer sb = new StringBuffer();
		int result;

		boolean isNegitive = false;

		if (str_x.charAt(0) == '-')
			isNegitive = true;

		boolean isZeroPrefix = true;
		for (int i = 1; i <= str_x.length(); i++) {
			if (str_x.charAt(leng - i) == '0' && isZeroPrefix) {
				continue;
			} else {
				isZeroPrefix = false;
			}
			sb.append(str_x.charAt(leng - i));
		}

		if (isNegitive) {
			sb.insert(0, '-');
			sb.deleteCharAt(sb.length() - 1);
		}

		try {
			result = Integer.parseInt(sb.toString());
		} catch (Exception e) {
			result = 0;
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger_7 ri7 = new ReverseInteger_7();

		ri7.reverse(-1234);
	}

	//best solution
	public int reverse2(int x)
	{
	    int result = 0;

	    while (x != 0)
	    {
	        int tail = x % 10;
	        int newResult = result * 10 + tail;
	        if ((newResult - tail) / 10 != result)
	        { return 0; }
	        result = newResult;
	        x = x / 10;
	    }

	    return result;
	}
}
