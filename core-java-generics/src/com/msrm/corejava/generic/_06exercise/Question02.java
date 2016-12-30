package com.msrm.corejava.generic._06exercise;

/**
 * Will the following class compile? If not, why?
 * 
 * @author srirammuthaiah
 *
 */
public class Question02 {

	public final class Algorithm {
		public static <T> T max(T x, T y) {
			return x > y ? x : y;
		}
	}

}
