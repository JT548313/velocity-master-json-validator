package com.barclays.json.validator.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONObject;

import com.barclays.json.validator.MasterJsonValidatorConstants;
import com.barclays.json.validator.beans.Pattern;
import com.barclays.json.validator.beans.Patterns;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidatorUtil {
	
	@SuppressWarnings("deprecation")
	public static ArrayList<Pattern> readJsonFile(String filePath) throws JsonParseException, IOException {
		JsonFactory f = new JsonFactory();
	    JsonParser jp = f.createJsonParser(new File(filePath)); // For reference MasterJsonValidatorConstants.PATTERN_JSON_URL

		ObjectMapper mapper = new ObjectMapper();
		Patterns patterns = mapper.readValue(jp, Patterns.class);
		ArrayList<Pattern> patternList = patterns.getPatterns();
		  
        return patternList;
	}
}
