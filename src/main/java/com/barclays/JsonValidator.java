package com.barclays;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;

/**
 * @author JayatiNaik
 * @version 1.0.0
 *
 */
public abstract class JsonValidator {
	
	enum Stage{
		   PREFLIGHT, CHECKOUT, BUILD, CODEANALYSIS;
		};
		
	enum branch{
		MASTER, ONE, TWO, THREE; // 1.0, 2.0, 3.0
	};	
	
	public abstract void parseMasterJson() throws JsonParseException, IOException; 	
}
