package com.barclays.json.util;

import java.util.ArrayList;
import java.util.regex.Pattern;

import org.joda.time.DateTime;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import com.barclays.json.beans.Message;

public class DateFormatValidations {

	/**
	 * @param date
	 * @return
	 */
	public static ArrayList<Message> validateDateFormat(String date) {

		final ArrayList<Message> messages = new ArrayList<Message>();
		DateTime isoDate = null;
		DateTimeFormatter parser2 = ISODateTimeFormat.date();
		// Parse date against ISO 8601 Format using Joda Time library
		try {
			isoDate = parser2.parseDateTime(date);
		} catch (IllegalFieldValueException ie) {
			Message m = new Message();
			m.setClassName("DateFormatValidations");
			m.setErrDesc(ie.getMessage());
			messages.add(m);
			return messages;
		} catch (IllegalArgumentException ia) {
			Message m = new Message();
			m.setClassName("DateFormatValidations");
			m.setErrDesc(ia.getMessage());
			messages.add(m);
			return messages;
		}
		// Parse date against ISO 8601 Date Time Regex.
		validateISO8601DateFomat(isoDate.toString(), messages);
		// Date should not be in the past.
		checkForPastDate(isoDate, messages);
		return messages;

	}

	/**
	 * @param isoDate
	 * @param messages
	 */
	private static void validateISO8601DateFomat(String date, final ArrayList<Message> messages) {

		// Match parsed date against ISO 8601 Date time Regex
		if (!Pattern.matches("^(-?(?:[1-9][0-9]*)?[0-9]{4})-(1[0-2]|0[1-9])-(3[01]|0[1-9]|[12][0-9])"
				+ "T(2[0-3]|[01][0-9]):([0-5][0-9]):([0-5][0-9])(\\.[0-9]+)?Z$", date)) {
			Message m = new Message();
			m.setClassName("DateFormatValidations");
			m.setErrDesc("Failure!!\nIncorrect date format");
			messages.add(m);
		}
	}

	/**
	 * @param isoDate
	 * @param messages
	 */
	private static void checkForPastDate(DateTime isoDate, ArrayList<Message> messages) {
		if (isoDate.isBefore(new DateTime())) {
			Message m = new Message();
			m.setClassName("DateFormatValidations");
			m.setErrDesc("Failure!!\nFrom/To Date should not be in the past");
			messages.add(m);
		}

	}

	public static void main(String[] args) {
		ArrayList<Message> messages = DateFormatValidations.validateDateFormat("2019-2-19");

		if (messages.size() > 0) {
			for (Message m : messages)
				System.out.println(m.getErrDesc());
		} else {
			System.out.println("Date Validation Successful!!");
		}
	}
}
