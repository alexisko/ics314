package iCalendar;

import static org.junit.Assert.*;

import org.junit.Test;

public class InputValidatorTest {

	InputValidator test = new InputValidator();
	
	@Test
	public void testIsValidDateString() {

		//test.isValidDateString("")
		assertTrue(test.isValidDateString("12/12/1234"));
		assertFalse(test.isValidDateString("13/83/2015"));
		assertFalse(test.isValidDateString("13/12/2015"));
		assertFalse(test.isValidDateString("12/83/2015"));
		assertFalse(test.isValidDateString("10/33/2015"));
		assertFalse(test.isValidDateString("06/33/2015"));
		assertFalse(test.isValidDateString("02/33/2015"));
		assertFalse(test.isValidDateString("as/as/asdf"));
		assertFalse(test.isValidDateString("asasasdf"));
		assertFalse(test.isValidDateString(""));
		assertFalse(test.isValidDateString("1234567890"));
		assertFalse(test.isValidDateString("123/12/1234"));
		assertFalse(test.isValidDateString("12/123/1234"));
		assertFalse(test.isValidDateString("12/12/12345"));
		assertFalse(test.isValidDateString("12.12.1234"));
		
	}
	
	@Test
	public void testIsValidEndDateString() {
		
		//test.isValidEndDateString("", "")
		//assertTrue();
		//assertFalse();
		assertTrue(test.isValidEndDateString("12/12/2015", "12/12/2015"));
		assertTrue(test.isValidEndDateString("12/12/2015", "12/13/2015"));
		assertTrue(test.isValidEndDateString("12/12/2015", "12/12/2016"));
		assertTrue(test.isValidEndDateString("10/12/2015", "11/12/2015"));
		assertFalse(test.isValidEndDateString("", ""));
		assertFalse(test.isValidEndDateString("asrefedfgt", "asefgthydf"));
		assertFalse(test.isValidEndDateString("ad/sf/refg", "ag/gd/dsjg"));
		assertFalse(test.isValidEndDateString("ad/rg/htfs", "12/12/2015"));
		assertFalse(test.isValidEndDateString("12/12/2015", "ag/fd/dskj"));
		assertFalse(test.isValidEndDateString("12.12.2015", "12.12.2015"));
		assertFalse(test.isValidEndDateString("12/12/2015", "11/12/2015"));
		assertFalse(test.isValidEndDateString("12/12/2015", "12/11/2015"));
		assertFalse(test.isValidEndDateString("12/12/2015", "12/12/2014"));
		assertFalse(test.isValidEndDateString("1234567890", "1234567890"));
		
	}
	
	@Test 
	public void testStartDateEndDateComparison() {
		
		//test.startDateEndDateComparison("", "")
		assertEquals(0, test.startDateEndDateComparison("", ""));
		assertEquals(0, test.startDateEndDateComparison("12/12/2015", "12/12/2015"));
		assertEquals(0, test.startDateEndDateComparison("12/12/2015", "12/11/2015"));
		assertEquals(0, test.startDateEndDateComparison("12/12/2015", "11/12/2015"));
		assertEquals(0, test.startDateEndDateComparison("12/12/2015", "12/12/2014"));
		assertEquals(1, test.startDateEndDateComparison("12/12/2015", "12/13/2015"));
		assertEquals(1, test.startDateEndDateComparison("11/12/2015", "12/12/2015"));
		assertEquals(1, test.startDateEndDateComparison("12/12/2015", "12/12/2016"));
	}

	@Test
	public void testIsValidTimeString() {
		
		//test.isValidTimeString("")
		assertTrue(test.isValidTimeString("01:12 am"));
		assertTrue(test.isValidTimeString("01:12 pm"));	
		assertFalse(test.isValidTimeString(""));
		assertFalse(test.isValidTimeString("aa:12 pm"));
		assertFalse(test.isValidTimeString("12/12 pm"));
		assertFalse(test.isValidTimeString("12:aa pm"));
		assertFalse(test.isValidTimeString("12:12pm"));
		assertFalse(test.isValidTimeString("12:12 qm"));
		assertFalse(test.isValidTimeString("12:12 pq"));
		assertFalse(test.isValidTimeString("123:123 pm"));
		assertFalse(test.isValidTimeString("15:12 pm"));
		assertFalse(test.isValidTimeString("12:76 pm"));
		assertFalse(test.isValidTimeString("15:89 pm"));
		
	}
	
	@Test
	public void testIsValidEndTimeString() {
		
		//test.isValidEndTimeString(, "", "")
		assertTrue(test.isValidEndTimeString(1, "12:00 AM", "12:00 AM"));
		assertTrue(test.isValidEndTimeString(1, "12:00 AM", "02:00 PM"));
		assertTrue(test.isValidEndTimeString(0, "08:00 AM", "10:00 AM"));
		assertTrue(test.isValidEndTimeString(0, "08:00 PM", "10:00 PM"));
		assertTrue(test.isValidEndTimeString(0, "08:00 AM", "10:00 PM"));
		assertFalse(test.isValidEndTimeString(1, "12:00 AM", "13:78 PM"));
		assertFalse(test.isValidEndTimeString(1, "12:00 AM", "AB:cd PM"));
		assertFalse(test.isValidEndTimeString(0, "", ""));
		assertFalse(test.isValidEndTimeString(0, "12:00 AM", "11:00 AM"));
		assertFalse(test.isValidEndTimeString(0, "12:00 PM", "11:00 PM"));
		
	}

	@Test
	public void testIsValidClassification() {
		
		//test.isValidClassification("")
		assertTrue(test.isValidClassification("public"));
		assertTrue(test.isValidClassification("PUBLIC"));
		assertTrue(test.isValidClassification("private"));
		assertTrue(test.isValidClassification("PRIVATE"));
		assertTrue(test.isValidClassification("confidential"));
		assertTrue(test.isValidClassification("CONFIDENTIAL"));
		assertTrue(test.isValidClassification("NA"));
		assertTrue(test.isValidClassification("na"));
		assertFalse(test.isValidClassification(""));
		assertFalse(test.isValidClassification("aA1!/"));
				
	}

	@Test
	public void testIsValidGeographicPosition() {
		
		//test.isValidGeographicPosition("")
		assertTrue(test.isValidGeographicPosition("00.000000"));
		assertTrue(test.isValidGeographicPosition("+00.000000"));
		assertTrue(test.isValidGeographicPosition("-00.000000"));
		assertTrue(test.isValidGeographicPosition("12.123456"));
		assertTrue(test.isValidGeographicPosition("00.0"));
		assertTrue(test.isValidGeographicPosition("+00.0"));
		assertTrue(test.isValidGeographicPosition("-00.0"));
		assertFalse(test.isValidGeographicPosition("*00.000000"));
		assertFalse(test.isValidGeographicPosition("as.000000"));
		assertFalse(test.isValidGeographicPosition("+as.000000"));
		assertFalse(test.isValidGeographicPosition("-as.000000"));
		assertFalse(test.isValidGeographicPosition("00/000000"));
		assertFalse(test.isValidGeographicPosition("+00/000000"));
		assertFalse(test.isValidGeographicPosition("-00/000000"));
		assertFalse(test.isValidGeographicPosition("00.asdfas"));
		assertFalse(test.isValidGeographicPosition("+00.asdfas"));
		assertFalse(test.isValidGeographicPosition("-00.asdfas"));
		assertFalse(test.isValidGeographicPosition("0.000000"));
		assertFalse(test.isValidGeographicPosition("+0.000000"));
		assertFalse(test.isValidGeographicPosition("-0.000000"));
		assertFalse(test.isValidGeographicPosition("000.000000"));
		assertFalse(test.isValidGeographicPosition("00.00000000"));
		assertFalse(test.isValidGeographicPosition(""));
		
	}

}
