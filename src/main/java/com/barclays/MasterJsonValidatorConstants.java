package com.barclays;

public class MasterJsonValidatorConstants {

	public static String PATTERN_JSON_URL = "C:\\Master JSON\\Patterns.json";

	// Regular Expressions used for json validations
	public static String DATE_FORMAT_ISO8601_REGEX = "^(-?(?:[1-9][0-9]*)?[0-9]{4})-(1[0-2]|0[1-9])-(3[01]|0[1-9]|[12][0-9])"
			+ "T(2[0-3]|[01][0-9]):([0-5][0-9]):([0-5][0-9])(\\\\.[0-9]+)?Z$";

	// REGEX for Free Text Validation
	public static String FREE_TEXT_ALPHANUMERIC_SIZE_LIMIT_REGEX = "^([a-zA-Z0-9\\\\s]){10,512}$";
	public static String MODULE_ID_FORMAT_REGEX = "^(([a-zA-Z0-9]+){2,20}-){2}([a-zA-Z0-9]+){2,2}$";
	public static String FREE_TEXT_TAG_FILTERING_REGEX = "^[\\s\\S]*?<(script|meta|style|embed|object|frameset|frame|iframe)[\\s\\S]*?"
			+ "<\\/(script|meta|style|embed|object|frameset|frame|iframe)>[\\s\\S]*?$";
	// REGEX for URL Format validations
	public static String URL_FORMAT_REGEX = "^(https?|ssh):\\\\/\\\\/[^\\\\s\\\\/$.?#].[^\\\\s]*[.git]$";
}
