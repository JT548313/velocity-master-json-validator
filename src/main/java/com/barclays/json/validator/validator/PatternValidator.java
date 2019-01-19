package com.barclays.json.validator.validator;

import java.io.IOException;

import com.barclays.json.validator.JsonValidator;
import com.barclays.json.validator.MasterJsonValidatorConstants;
import com.barclays.json.validator.util.JsonValidatorUtil;
import com.fasterxml.jackson.core.JsonParseException;

/**
 * @author JayatiNaik
 * @version 1.0.0
 *
 */
public class PatternValidator extends JsonValidator {

	
	 /**
     * This method is responsible to read Pattern JSON file from Git Repository. 
     * Loaded JSON will be parsed for validity. As per the requirement many business
     * rules will be checked.
     *
     * @return messageBean
	 * @throws IOException 
	 * @throws JsonParseException 
     */
	@Override
	public void parseMasterJson() throws JsonParseException, IOException {
		JsonValidatorUtil.readJsonFile(MasterJsonValidatorConstants.PATTERN_JSON_URL);
	}


}