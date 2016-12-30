package com.msrm.corejava.generic._06exercise;

/**
 * Will the following class compile? If not, why?
 * 
 * Answer: Type variable can't be marked with static modifier. below line 21 is
 * not correct. 
 * 
 * No. You cannot create a static field of the type parameter T.
 * 
 * 
 * @author srirammuthaiah
 *
 */
public class Question09 {

	public class Singleton<T> {
		public static T getInstance() {
			if (instance == null)
				instance = new Singleton<T>();
			return instance;
		}

		private static T instance = null;
	}

}
