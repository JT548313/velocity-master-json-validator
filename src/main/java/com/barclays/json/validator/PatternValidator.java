package com.barclays.json.validator;

import java.io.IOException;
import java.util.ArrayList;

import com.barclays.JsonValidator;
import com.barclays.MasterJsonValidatorConstants;
import com.barclays.json.beans.PipelinePattern;
import com.barclays.json.util.JsonValidatorUtil;
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
	public void parseMasterJson() {
		ArrayList<PipelinePattern> patternList = JsonValidatorUtil.readJsonFile(MasterJsonValidatorConstants.PATTERN_JSON_URL);
		
		
		
	}


}