package com.ussco.xref.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ussco.xref.constants.XREFConstants;
import com.ussco.xref.model.domain.AdditionalField;

/**
 *
 * @author MUKHERS
 * @version 1.0
 *
 */
public class XrefUtils {
	/**
	 *
	 * @param strToFilter
	 * @return String
	 */
	public static final String filterString(final String strToFilter, final boolean removeComma) {
		String filteredString;
		if (StringUtils.isNotBlank(strToFilter)) {
			filteredString = removeComma ? removeAndReplace(strToFilter, XREFConstants.COMMA_SEPERATOR,
					XREFConstants.ONE_SPACE_STRING) : strToFilter.trim();

		} else {
			filteredString = StringUtils.EMPTY;
		}
		return filteredString;
	}

	/**
	 * Converts List to CSV string.If value passed in list ==NULL, value will be
	 * ignored.
	 *
	 * @param listTobeConverted
	 * @return String
	 */
	public static final String convertListofStringsToCSV(final List<String> listTobeConverted) {
		final StringBuilder builder = new StringBuilder();
		if (listTobeConverted != null && !listTobeConverted.isEmpty()) {
			int count = 1;
			for (String value : listTobeConverted) {
				if (value != null) {
					builder.append(removeAndReplace(value, XREFConstants.COMMA_SEPERATOR,
							XREFConstants.ONE_SPACE_STRING));
				}
				if (count != listTobeConverted.size()) {
					builder.append(XREFConstants.COMMA_SEPERATOR);
				}
				count++;
			}
		}

		return builder.toString();

	}

	public static String removeAndReplace(final String str, final String subStrToBeRemoved,
			final String subStrToReplaceWith) {
		String outputString = (str != null ? str : StringUtils.EMPTY);
		if (StringUtils.isNotBlank(str) && StringUtils.isNotEmpty(subStrToBeRemoved)
				&& StringUtils.isNotEmpty(subStrToReplaceWith)) {
			outputString = StringUtils.replace(str, subStrToBeRemoved, subStrToReplaceWith);

			// if(StringUtils.contains(str,XREFConstants.COMMA_SEPERATOR)) {
			// outputString=XREFConstants.QUOTE+str+XREFConstants.QUOTE;
			// }
		}
		return outputString;

	}

	/**
	 *
	 * @param str
	 * @param subStrToBeRemoved
	 * @param subStrToReplaceWith
	 * @return
	 */

	public static String removeAndReplace(String str, final String[] subStrToBeRemoved, final String subStrToReplaceWith) {
		String outputString = (str != null ? str : StringUtils.EMPTY);

		if (StringUtils.isNotBlank(str) && subStrToBeRemoved != null && subStrToReplaceWith != null) {
			for (String strTobeReplaced : subStrToBeRemoved) {
				outputString = StringUtils.replace(str, strTobeReplaced, subStrToReplaceWith);
				str = outputString;
			}

		}
		return outputString;

	}

	/**
	 * Removes all the special characters from a input String.
	 *
	 * @param strignToClean
	 * @return String
	 */
	public static final String clean(final String stringToClean) {
		StringBuilder outputString = new StringBuilder();
		if (StringUtils.isNotBlank(stringToClean)) {
			for (int i = 0; i < stringToClean.length(); i++) {
				char c = stringToClean.charAt(i);
				boolean flag = Character.isLetterOrDigit(c);
				if (flag == true) {
					outputString.append(c);
				}
			}
		} else {
			outputString.append(StringUtils.EMPTY);

		}
		return outputString.toString();
	}

	/**
	 *
	 * @param numberOfTimes
	 * @return
	 */
	public static String constructCsvStyleString(final int numberOfTimes) {
		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < numberOfTimes; i++) {
			builder.append(XREFConstants.COMMA_SEPERATOR);
		}
		return builder.toString();

	}

	public static String[] addArrays(final String[] arrayToAdd, final String[] arrayToBeAdded) {
		// ..Convert String[] to list for easy manupulation purposes
		List<String> listToAddOn = (arrayToAdd != null && Arrays.asList(arrayToAdd) != null) ? new ArrayList<String>(
				Arrays.asList(arrayToAdd)) : new ArrayList<String>();
		List<String> lsitToBeAdded = (arrayToBeAdded != null && Arrays.asList(arrayToBeAdded) != null) ? new ArrayList<String>(
				Arrays.asList(arrayToBeAdded))
				: new ArrayList<String>();
		filtercollection(listToAddOn);
		filtercollection(lsitToBeAdded);
		listToAddOn.addAll(lsitToBeAdded);
		String[] finalStringArr;
		try {
			finalStringArr = listToAddOn.toArray(new String[listToAddOn.size()]);
		} catch (NullPointerException e) {
			finalStringArr = new String[0];
		}

		return finalStringArr;

	}

	public static void filtercollection(Collection<String> inputColl) {
		Collection<String> outputColl = new ArrayList<String>();
		if (inputColl != null && inputColl.size() > 0) {

			for (String str : inputColl) {
				if (StringUtils.isBlank(str)) {
					outputColl.add(str);
				}
			}

			inputColl.removeAll(outputColl);

		}
	}

	public static boolean isAllFieldsNullOrEmpty(final Collection<String> coll) {
		boolean flag = false;

		if (coll != null && !coll.isEmpty()) {
			int count = 0;
			for (String string : coll) {
				if (StringUtils.isBlank(string)) {
					count++;
				}

			}
		} else {
			flag = true;
		}

		return flag;
	}

	public static String getFileType(final String filePath) {
		String fileType = null;
		if (StringUtils.isNotBlank(filePath)) {
			if (filePath.endsWith(XREFConstants.FILE_TYPE_EXCEL)) {
				fileType = OutputTypeEnum.EXCEL.toString();
			} else if (filePath.endsWith(XREFConstants.FILE_TYPE_EXCEL_2007)) {
				fileType = OutputTypeEnum.EXCEL_2007.toString();
			} else if (filePath.endsWith(XREFConstants.FILE_TYPE_CSV)) {
				fileType = OutputTypeEnum.CSV.toString();
			}
		}
		return fileType;
	}

	public static String replaceStringWithOther(String str,final String strToReplace , final String strToReplaceWith){
		if(StringUtils.isNotBlank(str)){
			str=StringUtils.replace(str, strToReplace, strToReplaceWith);
		}

		return str;
	}

	/**
	 * @return
	 */
	public static List<AdditionalField> buildAdditionalFieldCodeSet() {
		List<AdditionalField> additionalFieldList = new ArrayList<AdditionalField>();
		//List<String> additionalFieldNames = ApplicationResourcesReader.getIEFieldDisplayNames();


			AdditionalField additionalField = new AdditionalField();
			additionalField.setLabel("Field 1");
			additionalField.setId("Field 1");

			additionalFieldList.add(additionalField);

			additionalField = new AdditionalField();
			additionalField.setLabel("Field 2");
			additionalField.setId("Field 2");

			additionalFieldList.add(additionalField);
			additionalField = new AdditionalField();
			additionalField.setLabel("Field 3");
			additionalField.setId("Field 3");

			additionalFieldList.add(additionalField);
		return additionalFieldList;
	}
}
