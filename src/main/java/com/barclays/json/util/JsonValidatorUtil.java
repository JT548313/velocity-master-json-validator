package com.barclays.json.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.barclays.json.beans.PipelinePattern;
import com.barclays.json.beans.PipelinePatterns;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonValidatorUtil {
	
	@SuppressWarnings("deprecation")
	public static ArrayList<PipelinePattern> readJsonFile(String filePath) {
		JsonFactory f = new JsonFactory();
	    JsonParser jp;
	    ArrayList<PipelinePattern> patternList = null;
		try {
			jp = f.createJsonParser(new File(filePath)); // For reference MasterJsonValidatorConstants.PATTERN_JSON_URL
			
			System.out.println(jp.getText());
			ObjectMapper mapper = new ObjectMapper();
			PipelinePatterns patterns = mapper.readValue(jp, PipelinePatterns.class);
			patternList = patterns.getPatterns();
			  
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException io) {
			// TODO Auto-generated catch block
			io.printStackTrace();
		}

        return patternList;
	}
}
