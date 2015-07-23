package iCalendar;

// Calculates the Great Circle Distance between two .ics events
public class GreatCircleDistance {
	private String startTime = "";
	private String date = "";
	private String endTime = "";
	private String eventName = "";

	public GreatCircleDistance()
	{

	}

	//sets startTime from reading DSTART line of .ics file
	public void setStartTimeFromFile(String currentLine)
	{
		if(currentLine.startsWith("DTSTART;TZID="))
		{
			startTime = currentLine.substring(lastOccurenceOfT(currentLine), currentLine.length());
		}
	}

	public String getStartTimeFromFile()
	{
		return startTime;
	}


	//must complete
	public void setEndTimeFromFile(String currentLine)
	{
		if(currentLine.startsWith("DTEND;TZID="))
		{
			endTime = currentLine.substring(lastOccurenceOfT(currentLine), currentLine.length());
		}
	}

	//must complete
	public String getEndTimeFromFile()
	{
		return endTime;
	}


	public void setDateFromFile(String currentLine)
	{
		if(currentLine.startsWith("DTSTART;TZID="))
		{

			int index = currentLine.indexOf(':');
			date = currentLine.substring(index+1, index +9);
		}
	}

	public String getDateFromFile()
	{
		return date;
	}

	public void setEventNameFromFile(String currentLine)
	{
		if(currentLine.startsWith("SUMMARY"))
		{

			int index = currentLine.indexOf(':');
			eventName = currentLine.substring(index+1, currentLine.length());
		}
	}
	
	public String getEventNameFromFile()
	{
		return eventName;
	}
	
	
	//helper method to find the time of an event in a file
	private int lastOccurenceOfT(String str)
	{
		int index = 0;

		for(int i = 0; i < str.length(); i++)
		{
			if(str.charAt(i) == 'T')
			{
				index = i +1;
			}
		}
		return index;
	}



	// parameters to be used (String event1, String event2, String lat1, String lon1, String lat2, String lon2)
	public static String CircleDistance()
	{
		// These are set to test method. Move variables to parameter to use properly
		String event1, event2, lat1, lon1, lat2, lon2;
		event1 = "Test Day";
		event2 = "Family Dinner";
		lat1 = "12.123456";
		lon1 = "-12.123456";
		lat2 = "65.654321";
		lon2 = "-65.654321";

		// Convert latitude and longitude to radians
		double x1 = Math.toRadians(Double.parseDouble(lat1));
		double y1 = Math.toRadians(Double.parseDouble(lon1));
		double x2 = Math.toRadians(Double.parseDouble(lat2));
		double y2 = Math.toRadians(Double.parseDouble(lon2));

		// Calculate Great Circle Distance in radians
		double angle = Math.acos((Math.cos(x1) * Math.cos(x2)) + (Math.sin(x1) * Math.sin(x2)) * (Math.cos(y1 - y2)));

		// Convert to degrees
		angle = Math.toDegrees(angle);

		// Get distance in kilometers. Rounds kilometers to 2 decimal places
		double kilometers = (double) Math.round((angle * 111.32) * 100) / 100;

		// Get distance in statute miles. Rounds miles to 2 decimal places
		double miles =  (double) Math.round((kilometers * 0.621371) * 100) / 100;

		// Concatenate into one string for easy return
		String comment = event1 + " is " + kilometers + " kilometers away from " + event2 + ". " +
				event1 + " is " + miles + " miles away from " + event2 + ".";

		return comment;
	}


}