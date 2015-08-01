package iCalendar;
/*This class is implements methods to validate all input from users*/
public class InputValidator {

	public InputValidator()
	{

	}

	//method to check that the date input is valid
	public boolean isValidDateString(String date)
	{
		boolean isValidDate = false;
		//checks if the date entered is in the proper format and has numbers
		if(date.length() == 10 && isInteger(date.substring(0,2)) && isInteger(date.substring(3,5)) && 
				isInteger(date.substring(6, date.length())) && 
				date.substring(2,3).equals("/") && date.substring(5,6).equals("/") )
		{
			try {
				int month = Integer.parseInt(date.substring(0,2));
				int day = Integer.parseInt(date.substring(3,5));
				
				if(month > 0 && month <= 12) { //checking if month is correct
					if(month == 1 || month == 3 || month == 5 || month == 7 || 
							month == 8 || month == 10 || month == 12) { //checking if days are correct
						if(day > 0 && day <= 31) { 
							isValidDate = true;
						}
					} else if(month == 4 || month == 6 || month == 9 || month == 11) { //checking if days are correct
						if(day > 0 && day <= 30) {
							isValidDate = true;
						}
					} else if(month == 2) { //checking if days are correct
						if(day > 0 && day <= 28) {
							isValidDate = true;
						}
					}
				}
			} catch (NumberFormatException e) {
			    return isValidDate;
			}
		}
		return isValidDate;
	}
	
	//method to check that the end date is valid
	public boolean isValidEndDateString(String start, String end) {
		boolean isValidEndDate = false;
		//checks if the date entered is in the proper format and has numbers
		if(end.length() == 10 && isInteger(end.substring(0,2)) && isInteger(end.substring(3,5)) && 
				isInteger(end.substring(6, end.length())) && 
				end.substring(2,3).equals("/") && end.substring(5,6).equals("/") )
		{
			try {
				//start date
				int monthS = Integer.parseInt(start.substring(0,2));
				int dayS = Integer.parseInt(start.substring(3,5));
				int yearS = Integer.parseInt(start.substring(6, end.length()));
				
				//end date
				int monthE = Integer.parseInt(end.substring(0,2));
				int dayE = Integer.parseInt(end.substring(3,5));
				int yearE = Integer.parseInt(end.substring(6, end.length()));
				
				//checking end month
				if(monthE > 0 && monthE <= 12) {
					if(monthE > monthS) { //if end date month is greater
						isValidEndDate = true;
					} else if(monthE == monthS) { //if end date month is equal
						if(monthE == 1 || monthE == 3 || monthE == 5 || monthE == 7 || 
								monthE == 8 || monthE == 10 || monthE == 12) { //checking if days are correct
							if(dayE > 0 && dayE <= 31) { 
								if(dayE > dayS) { 
									isValidEndDate = true;
								} else if(dayE == dayS) {
									if(yearE > yearS || yearE == yearS) { //comparing end and start years
										isValidEndDate = true;
									}
								}
							}
						} else if(monthE == 4 || monthE == 6 || monthE == 9 || monthE == 11) { //checking if days are correct
							if(dayE > 0 && dayE <= 30) {
								if(dayE > dayS) {
									isValidEndDate = true;
								} else if(dayE == dayS) {
									if(yearE > yearS || yearE == yearS) { //comparing end and start years
										isValidEndDate = true;
									}
								}
							}
						} else if(monthE == 2) { //checking if days are correct
							if(dayE > 0 && dayE <= 28) {
								if(dayE > dayS) {
									isValidEndDate = true;
								} else if(dayE == dayS) {
									if(yearE > yearS || yearE == yearS) { //comparing end and start years
										isValidEndDate = true;
									}
								}
							}
						}
					}
				}
			} catch (NumberFormatException e) {
				return isValidEndDate;
			}
		}
		return isValidEndDate;
	}
	
	public int startDateEndDateComparison(String start, String end) {
		int result = 0; //start date and end date are on the same day
		try {
			int monthS = Integer.parseInt(start.substring(0,2));
			int dayS = Integer.parseInt(start.substring(3,5));
			int yearS = Integer.parseInt(start.substring(6, end.length()));
			
			//end date
			int monthE = Integer.parseInt(end.substring(0,2));
			int dayE = Integer.parseInt(end.substring(3,5));
			int yearE = Integer.parseInt(end.substring(6, end.length()));
			
			if(monthE > monthS) {
				result = 1; //end date is after start date
			} else if(monthE == monthS) {
				if(dayE > dayS) {
					result = 1; //end date is after start date
				} else if (dayE == dayS) {
					if(yearE > yearS) {
						result = 1; //end date is after start date
					}
				}
			}
		} catch (NumberFormatException e) {
			return result;
		}
		return result;
	}

	//method that checks if the time entered is valid
	public boolean isValidTimeString(String time)
	{
		boolean isValidTime = false;
		//checks if the time entered is in the proper format and has numbers
		if(!time.equals("") && time.length() < 12 && isInteger(time.substring(0, 2)) && time.substring(2,3).equals(":") &&
				isInteger(time.substring(3,5)) && time.substring(5,6).equals(" ") &&
				(time.substring(6,8).equalsIgnoreCase("am")  || time.substring(6,8).equalsIgnoreCase("pm")))
		{
			try {
				int hour = Integer.parseInt(time.substring(0, 2));
				int mins = Integer.parseInt(time.substring(3,5));
				
				if(hour > 0 && hour <= 12) { //checking hours
					if(mins > 0 && mins <= 59) { //checking minutes
						isValidTime = true;
					}
				}
			} catch (NumberFormatException e) {
				return isValidTime;
			}
		}
		return isValidTime;

	}

	//method that checks if the end time is valid
	public boolean isValidEndTimeString(int result, String start, String end) {
		boolean isValidEndTime = false;
		try {
			if(!end.equals("") && end.length() < 12 && isInteger(end.substring(0, 2)) && end.substring(2,3).equals(":") &&
					isInteger(end.substring(3,5)) && end.substring(5,6).equals(" ") &&
					(end.substring(6,8).equalsIgnoreCase("am")  || end.substring(6,8).equalsIgnoreCase("pm"))) {
				//start time
				int hourS = Integer.parseInt(start.substring(0, 2));
				int minS = Integer.parseInt(start.substring(3,5));
				
				//end time
				int hourE = Integer.parseInt(end.substring(0, 2));
				int minE = Integer.parseInt(end.substring(3,5));
				
				if(hourE > 0 && hourE <= 12) { //checking hours
					if(minE > 0 && minE <= 59) { //checking minutes
						if(result == 1) { //end date is after start date
							isValidEndTime = true;
						} else if(result == 0) { //start date and end date are on the same day
							if(start.substring(6,8).equalsIgnoreCase("am") && end.substring(6,8).equalsIgnoreCase("am")) {
								if(hourE > hourS) {
									isValidEndTime = true;
								} else if(hourE == hourS) {
									if(minE > minS) {
										isValidEndTime = true;
									}
								}
							} else if (start.substring(6,8).equalsIgnoreCase("pm") && end.substring(6,8).equalsIgnoreCase("pm")) {
								if(hourE > hourS) {
									isValidEndTime = true;
								} else if(hourE == hourS) {
									if(minE > minS) {
										isValidEndTime = true;
									}
								}
							} else if (end.substring(6,8).equalsIgnoreCase("am") || end.substring(6,8).equalsIgnoreCase("pm")) {
								isValidEndTime = true;
							}
						}
					}
				}
			}
		} catch (NumberFormatException e) {
			return isValidEndTime;
		}
		return isValidEndTime;
	}
	
	//method that checks if the classification entered is valid
	public boolean isValidClassification(String classification)
	{
		boolean isValidClassification = false;
		if(classification.equalsIgnoreCase("public") || classification.equalsIgnoreCase("private") ||
				classification.equalsIgnoreCase("confidential") || classification.equalsIgnoreCase("NA"))
		{
			isValidClassification = true;
		}
		return isValidClassification;

	}

	//helper method to check if string is an integer
	private boolean isInteger(String str)
	{
		try
		{
			Integer.parseInt(str);
			return true;
		}
		catch(NumberFormatException e)
		{
			return false;
		}
	}

	//method that checks if the geo position is valid
	public boolean isValidGeographicPosition(String position)
	{
		boolean isValidPosition = false;

		if(!position.equals("") && !position.substring(0, 1).equals("+") && !position.substring(0, 1).equals("-"))
		{
			position = "+" + position;
		}

		if(!position.equals("") && position.length() < 11 && isInteger(position.substring(1,3)) && 
				isInteger(position.substring(4,position.length())) && position.substring(3,4).equals(".") &&
				position.substring(4,position.length()).length() < 7 
				&& (position.substring(0,1).equals("+") || position.substring(0,1).equals("-")))
		{
			isValidPosition = true;
		}	

		return isValidPosition;
	}

}



