package com.barclays.json.util;

import java.util.ArrayList;
import java.util.regex.Pattern;

import com.barclays.json.beans.Message;
import com.barclays.json.beans.PipelinePattern;

public class FreeTextValidations {
	
	// Regex comparison for module id's: ^([a-zA-Z0-9]+)-([a-zA-Z0-9]+)-([a-zA-Z0-9]+){10,128}$
	
	/**
	 * @param patternList
	 * @return
	 */
	public static ArrayList<Message> validateFreeText(String  description) {
		ArrayList<Message> messages = new ArrayList<Message>(); 
	
			// Description should be alphanumeric.
			if(!Pattern.matches("^([a-zA-Z0-9\\s])$", description))
			{
				Message m = new Message();
				m.setClassName("FreeTextValidation");
				m.setErrDesc("Description contians special characters.");
				messages.add(m);
			}
			// Description char Limit: 512 chars
			if(!Pattern.matches("^([a-zA-Z0-9\\s]){10,512}$", description)) {
				Message m = new Message();
				m.setClassName("FreeTextValidation");
				m.setErrDesc("Size limit exceeded.");
				messages.add(m);
			}
			return messages;
	}

	
	 public static void main(String[] args) { 
		 ArrayList<Message> messages =  FreeTextValidations.validateFreeText("12345 678 kJKhHLhLK  L Lh GKugkug II G o O oKJ k ouGOUG OUG ougIU giu GIUgiug oG g "
	  + " KHLKHOKGKUGIU  GI L OUGU GIU Goug oiug ig ig oig oig oi goi goi goi gi pg p p p p"
	  + " kjp jpo jpoj poj oj j lkjpo jpoj poj oj l "); 
		 
	for(Message m : messages)
	  System.out.println(m.getErrDesc()); }
	 
}
