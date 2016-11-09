package com.msrm.techgig.pgm.qa;

/**
 * <h3>Retail Problem</h3>
 * 
 * In a Retail company, gifts have to be distributed to employees waiting in a
 * queue. Gifts have been kept is a rectangular block. Consider side lengths of
 * the block are integer values.
 * 
 * The distribution procedure is as follows:-
 * 
 * 1. If block is not square in shape, then the largest possible square piece of
 * items is taken and gifted to the first employee in the queue.
 * 
 * 2. If block is square in shape, then complete block of gifts is given to the
 * first employee in the queue.
 * 
 * Once an employee receives his share of gift, he leaves the queue. The
 * remaining portion of the gift block is dealt in same fashion and the whole or
 * a portion of its gifts is given to the next employee in the queue.
 * 
 * Company has got a carton of gifts to be distributed among the employees all
 * over the company. The gift blocks in the carton are of different sizes. A
 * block of length i and breadth j is considered to be different from a block of
 * length j and breadth i.
 * 
 * For every i such that M <= i <= N and every j such that P <= j <= Q (where M,
 * N, P and Q are integers). Each gift block in carton is unique in length (i)
 * and breadth (j).
 * 
 * Given the values of M, N, P and Q (where M, N values are the ranges for
 * length of gift block and P, Q values are the ranges for breadth of gift
 * block).
 * 
 * Find the number of employees who will receive gifts from the carton.
 * 
 * Input specification: M, N, P, Q are of integer type (M, N values are the
 * ranges for length of gift block. P, Q values are the ranges for breadth of
 * gift block).
 * 
 * Output specification: Number of employees who will receive gift from the
 * carton.
 * 
 * Example:-
 * 
 * M = 5, N = 6, P = 3, Q = 4
 * 
 * Here i can be from 5 to 6 and j can be from 3 to 4. So the four gift blocks
 * will be in carton of sizes 5x3, 5x4, 6x3, 6x4
 * 
 * <pre>
 * First we choose a gift block of size 5x3
 * first employee would receive 3x3 portion (remaining 2x3 portion)
 * next employee would receive 2x2 portion (remaining 2x1 portion)
 * now the remaining portion are 2 squares pieces of (1x1), which can be given
 * to 2 more employees
 * 
 * So the gift block with the size of 5x3 can be distributed to 
 * 4 employees
 * 
 * Similarly we can find out number of employees for rest of the 
 * combinations (i.e. 5x4, 6x3, 6x4) in the given range
 * 
 * Gift block with the size of 5x3 can be distributed to 4 employees.
 * Gift block with the size of 5x4 can be distributed to 5 employees.
 * Gift block with the size of 6x3 can be distributed to 2 employees.
 * Gift block with the size of 6x4 can be distributed to 3 employees.
 * 
 * So the whole carton can be distributed among 14 employees. Hence the
 * output will be 14.
 * </pre>
 * 
 * @author srirammuthaiah
 *
 */
public class EmployeeGiftDistribution {

	public static void main(String[] args) {
		int minLength = 5;
		int maxLength = 6;
		int minBreadth = 3;
		int maxBreadth = 4;
		int employeeCount = calculatePossibleWays(minLength, maxLength, minBreadth, maxBreadth);
		System.out.println("No of employees for gift distribution: " + employeeCount);
		System.out.println(
				"No of employees for gift distribution: " + calculatePossibleWays(0, 1, 1, 0));
		System.out.println(
				"No of employees for gift distribution: " + calculatePossibleWays(3, 7, 5, 2));
	}

	public static int calculatePossibleWays(int minLength, int maxLength, int minBreadth,
			int maxBreadth) {

		if (minLength < 1 || maxLength < 1 || minBreadth < 1 || maxBreadth < 1)
			return 0;

		int sum = 0;
		// maximum four possible ways
		sum += countEmployeesForGiftBlocks(minLength, minBreadth);
		sum += countEmployeesForGiftBlocks(minLength, maxBreadth);
		sum += countEmployeesForGiftBlocks(maxLength, minBreadth);
		sum += countEmployeesForGiftBlocks(maxLength, maxBreadth);
		return sum;
	}

	public static int countEmployeesForGiftBlocks(int m, int n) {
		if (m < 1 || n < 1)
			return 0;

		if (m == 1)
			return n;
		if (n == 1)
			return m;
		if (m > n)
			return 1 + countEmployeesForGiftBlocks(m - n, n);
		else if (m < n)
			return 1 + countEmployeesForGiftBlocks(m, n - m);
		return 1;
	}

}
