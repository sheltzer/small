package com.ussco.xref.utils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.commons.lang.StringUtils;

public class ApplicationResourcesReader {

	private static final String APPLICATION_RESOURCES_PROPERTIES = "resourcebundles.ApplicationResources";
	private static final String MESSAGE_PROPERTIES = "resourcebundles.message";
	private static final String IE_FIELDS_PROPERTIES = "resourcebundles.IEFields";
	private static final String QUERY_BUILDER_FETCH_SIZE = "QueryBuilderFetchSize";
	private static final String MATCHING_PROPERTIES = "resourcebundles.MatchingLogic";
	private static final String CLIENT_ID_PREFIX = "ClientId";
	private static final String DOMAIN_URL = "DomainURL";
	private static final String FILE_SHARE_CONTEXT_ROOT = "FileShareContextRoot";
	private static final String DOCUMENTS_FILE_SHARE_CONTEXT_ROOT = "DocumentsFileShareContextRoot";
	private static final String CROSSREFERENCE_USER_GUIDE_FILE_NAME="CrossReferenceUserGuide";
	private static final String MATCHING_TEMPLATE_FILE_NAME="MatchingTemplateFileName";
	private static final String FILE_SHARE_ROOT = "FileShareRoot";
	private static final String FILE_SHARE_APPENDER = "FileShareAppender";
	private static final String FILE_SHARE_INPUT = "FileShareInputDirectory";
	private static final String FILE_SHARE_OUTPUT = "FileShareOutputDirectory";
	private static final String RESELLER_LIST_MAX_SELECT = "ResellerListMaxSelect";
	private static final String MATCH_LOGIC_BATCH_SIZE = "MatchLogicBatchSize";
	private static final int MATCH_LOGIC_DEFAULT_BATCH_SIZE = 500;
	private static final String SEARCH_MAX = "SingleItemSearchMax";
	
	private static ResourceBundle bundle;
	
	public static String getMessageByKey(String key) {
		bundle = ResourceBundle.getBundle(MESSAGE_PROPERTIES);
		return bundle.getString(key);
	}
	
	public static List<String> getIEFieldDisplayNames() {
		bundle = ResourceBundle.getBundle(IE_FIELDS_PROPERTIES);
		List<String> keyList = new ArrayList<String>();
		
		Enumeration<String> keys = bundle.getKeys();
		
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			
			keyList.add(bundle.getString(key));
		}
		
		return keyList;
	}
	
	public static String getIEPropertyValue(String key) {
		bundle = ResourceBundle.getBundle(IE_FIELDS_PROPERTIES);	
		return bundle.getString(key);
	}
	
	public static List<String> getIEFieldColumnNames(List<String> keys) {
		bundle = ResourceBundle.getBundle(IE_FIELDS_PROPERTIES);
		List<String> valueList = new ArrayList<String>();
		
		Iterator<String> it = keys.iterator();
		
		while (it.hasNext()) {
			String key = it.next();
			
			valueList.add(bundle.getString(key));
		}
				
		return valueList;

	}
			
	public static List<String> getIEFieldColumnNames() {
		bundle = ResourceBundle.getBundle(IE_FIELDS_PROPERTIES);
		List<String> valueList = new ArrayList<String>();
		
		Enumeration<String> keys = bundle.getKeys();
		
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			
			valueList.add(bundle.getString(key));
		}
		
		return valueList;
		
	}
	
	public static List<String> getIEColumnNamesByValue(List<String> valueList) {
		bundle = ResourceBundle.getBundle(IE_FIELDS_PROPERTIES);
		List<String> keyList = new ArrayList<String>();
		
		Enumeration<String> keys = bundle.getKeys();
		
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			
			Iterator<String> it = valueList.iterator();
			
			while (it.hasNext()) {
				String tmp = it.next().trim();
				
				String tmp2 = bundle.getString(key).trim();
				
				if (StringUtils.equals(tmp, tmp2)) {
					keyList.add(key);
					break;
				}
			}
		}
		
		return keyList;
	}
	
	public static List<String> getIEFieldColumnNamesByPrefix(String prefix) {
		bundle = ResourceBundle.getBundle(IE_FIELDS_PROPERTIES);
		List<String> valueList = new ArrayList<String>();
		
		Enumeration<String> keys = bundle.getKeys();
		
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			
			if (key.startsWith(prefix)) {
				valueList.add(bundle.getString(key));
			}
						
		}
		
		return valueList;
		
	}
		
	public static List<String> getIEFieldColumnNamesByPrefix(List<String> keys, String prefix) {
		bundle = ResourceBundle.getBundle(IE_FIELDS_PROPERTIES);
		List<String> valueList = new ArrayList<String>();
		
		Iterator<String> it = keys.iterator();
		
		while (it.hasNext()) {
			String key = it.next();
			
			if (key.startsWith(prefix)) {
				valueList.add(key);
			}
						
		}
		
		return valueList;
		
	}
	
	public static List<String> getClientIds() {
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
		List<String> valueList = new ArrayList<String>();
		
		Enumeration<String> keys = bundle.getKeys();		
		
		while (keys.hasMoreElements()) {
			String key = keys.nextElement();
			
			if (key.startsWith(CLIENT_ID_PREFIX)) {
				valueList.add(bundle.getString(key));
			}
						
		}
		
		return valueList;
		
	}
	
	public static String getClientIdByPrefix(String prefix) {
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
						
		String ret = bundle.getString(prefix);
						
		return ret;
	}
	
	public static Map<String, Object> getMatchingLogicProperties() {
		bundle = ResourceBundle.getBundle(MATCHING_PROPERTIES);
		
		Enumeration<?> keys = bundle.getKeys();
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		while (keys.hasMoreElements()) {
			String key = (String)keys.nextElement();
			resultMap.put(key, bundle.getString(key));
		}
		return resultMap;
	}
	
	public static int getMatchingLogicBatchSize() {
		bundle = ResourceBundle.getBundle(MATCHING_PROPERTIES);
		int size = MATCH_LOGIC_DEFAULT_BATCH_SIZE;
		String batchSize = bundle.getString(MATCH_LOGIC_BATCH_SIZE);
		if (batchSize != null) {
			size = Integer.parseInt(batchSize);
		}
		
		return size;
	}

	
	
	public static int getQueryBuilderFetchSize() {
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
		
		int ret = 0;
		
		String fetchSize = bundle.getString(QUERY_BUILDER_FETCH_SIZE);
		
		if (fetchSize != null) {
			ret = Integer.parseInt(fetchSize);
		}
		
		return ret;
		
	}
	
	/**
	 * @return the fILE_SHARE_URL
	 */
	public static String getDomainUrl() {
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
		
		return bundle.getString(DOMAIN_URL);
	}

	/**
	 * @return the fILE_SHARE_ROOT
	 */
	public static String getFileShareContextRoot() {
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
		
		return bundle.getString(FILE_SHARE_CONTEXT_ROOT);
	}

	/**
	 * @return the DOCUMENTS_FILE_SHARE_CONTEXT_ROOT
	 */
	public static String getDocumentsFileShareContextRoot() {
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
		
		return bundle.getString(DOCUMENTS_FILE_SHARE_CONTEXT_ROOT);
	}
	
	/**
	 * @return the DOCUMENTS_FILE_SHARE_CONTEXT_ROOT
	 */
	public static String getCrossReferenceUserGuideFileName() {
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
		
		return bundle.getString(CROSSREFERENCE_USER_GUIDE_FILE_NAME);
	}
	
	/**
	 * @return the DOCUMENTS_FILE_SHARE_CONTEXT_ROOT
	 */
	public static String getMatchingTemplateFileName() {
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
		
		return bundle.getString(MATCHING_TEMPLATE_FILE_NAME);
	}

	/**
	 * @return the fILE_SHARE_DIRECTORY
	 */
	public static String getFileShareRoot() {
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
		
		return bundle.getString(FILE_SHARE_ROOT);
	}

	/**
	 * @return the fILE_SHARE_INPUT
	 */
	public static String getFileShareInputDirectory() {
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
		
		return bundle.getString(FILE_SHARE_INPUT);
	}

	/**
	 * @return the fILE_SHARE_OUTPUT
	 */
	public static String getFileShareOutputDirectory() {
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
		
		return bundle.getString(FILE_SHARE_OUTPUT);
	}

	/**
	 * @return the fILE_SHARE_APPENDER
	 */
	public static String getFileShareAppender() 
	{
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
		
		return bundle.getString(FILE_SHARE_APPENDER);
		
	}//end method
	
	public static String getResellerListSelectMax() {
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
		
		return bundle.getString(RESELLER_LIST_MAX_SELECT); 
	}
	
	public static int getSingleItemSearchMax() {
		bundle = ResourceBundle.getBundle(APPLICATION_RESOURCES_PROPERTIES);
		
		return Integer.parseInt(bundle.getString(SEARCH_MAX));
		
	}

	
}