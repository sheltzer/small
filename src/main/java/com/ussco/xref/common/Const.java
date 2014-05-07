/**
 * Copyright United Stationers Supply Company
 *
 * This material is confidential, proprietary product of
 * United Stationers Supply Co. for the sole and exclusive use
 * by United Stationers Supply Co. or an authorized dealer.
 *
 * United Stationers retains the exclusive right to compile and
 * publish this material. By accepting this material, you agree
 * to respect the confidential nature of this material and not
 * make copies of the whole or any part thereof, or distribute
 * the same, or divulge the contents of the materials to any
 * person not an authorized dealer or customer of United
 * Stationers Supply Co. without permission.
*/
package com.ussco.xref.common;

/**
 * @author Sandy Heltzer
 *
 */
public class Const {

	public final static String SORT_ASC = "ASC";
	public final static String SORT_DSC = "DSC";

	public final static String SORT_COL_DELIM = "||";

	public static class RequestQueuePrimaryFilter {
		public final static String ALL = "all";
		public static final String FAILED = "FB";
		public static final String COMPLETED = "FN";
		public static final String IN_PROCESS = "IP";
		public static final String ENQUEUED = "NQ";
	}

}
