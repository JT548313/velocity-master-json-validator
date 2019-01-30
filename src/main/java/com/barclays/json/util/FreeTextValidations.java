package com.barclays.json.util;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.barclays.json.beans.Message;

public class FreeTextValidations {
	
	
	
	/**
	 * @param patternList
	 * @return
	 */
	public static ArrayList<Message> validateFreeText(String  description) {
		ArrayList<Message> messages = new ArrayList<Message>(); 
	
			// Description should be alphanumeric and char Limit: 512 chars
			if(!Pattern.matches("^([a-zA-Z0-9\\s]){10,512}$", description)) {
				Message m = new Message();
				m.setClassName("FreeTextValidation");
				m.setErrDesc("Description field should not consist of any special caharacters, with max limit of 512 chars.");
				messages.add(m);
			}
			return messages;
	}

	
	public static ArrayList<Message> validateModuleIdFormat(String  moduleId) {
		ArrayList<Message> messages = new ArrayList<Message>(); 
		
		// Regex comparison for module id's
		// reference, "openshift-v3-preflight"
		// Char Limit, 128 chars
		if(!Pattern.matches("^(([a-zA-Z0-9]+){2,20}-){2}([a-zA-Z0-9]+){2,2}$", moduleId)) {
			Message m = new Message();
			m.setClassName("ModuleIdFormatValidation");
			m.setErrDesc("Module Id format mismatched. Expected format of module Id is \"xxxx-xxxx-xxxx\" with max char limit of 128 chars");
			messages.add(m);
		}
		return messages;
	}
	
	 public static void main(String[] args) { 
		 ArrayList<Message> messages =  FreeTextValidations.validateModuleIdFormat("oweewrwerwe-v3erwer-e222"); 
		 
	for(Message m : messages)
	  System.out.println(m.getErrDesc()); }
	 
}
