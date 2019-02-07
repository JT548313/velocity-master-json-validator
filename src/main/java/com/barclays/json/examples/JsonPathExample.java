package com.barclays.json.examples;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import com.barclays.MasterJsonValidatorConstants;
import com.barclays.json.beans.PipelinePattern;
import com.barclays.json.beans.PipelinePatterns;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

public class JsonPathExample {
	
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		
		StringWriter json = JsonPathExample.readPatternJson();
		String jsonDataSourceString = json.toString();
		String jsonpathCreatorNamePath = "$.patterns[*]..name";
		//String jsonpathCreatorLocationPath = "$[patterns]";
		
		DocumentContext jsonContext = JsonPath.parse(jsonDataSourceString);
		List<String> jsonpathCreatorName = jsonContext.read(jsonpathCreatorNamePath);
		for(int i=0; i<jsonpathCreatorName.size(); i++)
		System.out.println(jsonpathCreatorName.get(i));
		
		Object document = Configuration.defaultConfiguration().jsonProvider().parse(jsonDataSourceString);

		String author0 = JsonPath.read(document, "$.patterns[0].display.name");
		System.out.println(author0+"\n");
		
		ReadContext ctx = JsonPath.parse(jsonDataSourceString);

		Configuration configuration = Configuration.defaultConfiguration();
		List<String> authorsOfBooksWithISBN = ctx.read("$.patterns[*]..name");
	
		List<String> patterns = JsonPath
		                            .using(configuration)
		                            .parse(jsonDataSourceString)
		                            .read("$.patterns[*]..name", List.class);
		
		for(int i=0; i<patterns.size(); i++)
			System.out.println(patterns.get(i));

	}

	@SuppressWarnings("deprecation")
	private static StringWriter readPatternJson() {
		// TODO Auto-generated method stub
		JsonFactory f = new JsonFactory();
	    JsonParser jp;
	    ArrayList<PipelinePattern> patternList = null;
	    PipelinePatterns patterns= null;
		try {
			jp = f.createJsonParser(new File(MasterJsonValidatorConstants.PATTERN_JSON_URL)); // For reference MasterJsonValidatorConstants.PATTERN_JSON_URL
			ObjectMapper mapper = new ObjectMapper();
			patterns = mapper.readValue(jp, PipelinePatterns.class);
			patternList = patterns.getPatterns();
			  
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException io) {
			// TODO Auto-generated catch block
			io.printStackTrace();
		}
		
		//create ObjectMapper instance
				ObjectMapper objectMapper = new ObjectMapper();
		//configure Object mapper for pretty print
				objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		//writing to console, can write to any output stream such as file
				StringWriter stringPaternList = new StringWriter();
				try {
					objectMapper.writeValue(stringPaternList, patterns);
				} catch (IOException ioe) {
					// TODO Auto-generated catch block
					ioe.printStackTrace();
				}
				//System.out.println("Employee JSON is\n"+stringPaternList);
				
				return stringPaternList;
	}
		

	
}