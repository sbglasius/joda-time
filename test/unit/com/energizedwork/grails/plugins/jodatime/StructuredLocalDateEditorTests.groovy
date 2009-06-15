package com.energizedwork.grails.plugins.jodatime

import com.energizedwork.grails.plugins.jodatime.StructuredJodaDateTimeEditor
import org.joda.time.DateTime
import org.joda.time.LocalDate
import org.joda.time.LocalDateTime
import org.joda.time.LocalTime

class StructuredLocalDateEditorTests extends GroovyTestCase {

	void testAssembleRequiresYearForDateTypes() {
		def editor = new StructuredJodaDateTimeEditor(LocalDate)
		shouldFail(IllegalArgumentException) {
			editor.assemble(LocalDate, [month: 11, day: 29])
		}
	}

	void testAssembleLocalDateUsingOnlyYear() {
		def editor = new StructuredJodaDateTimeEditor(LocalDate)
		def expected = new LocalDate(1977, 1, 1)
		def actual = editor.assemble(LocalDate, [year: '1977'])
		assertEquals(expected, actual)
	}

	void testAssembleLocalDateUsingYearMonthDay() {
		def editor = new StructuredJodaDateTimeEditor(LocalDate)
		def expected = new LocalDate(2009, 2, 20)
		def actual = editor.assemble(LocalDate, [year: '2009', month: '02', day: '20'])
		assertEquals(expected, actual)
	}

	void testAssembleLocalDateTimeUsingOnlyYear() {
		def editor = new StructuredJodaDateTimeEditor(LocalDateTime)
		def expected = new LocalDateTime(2009, 1, 1, 0, 0)
		def actual = editor.assemble(LocalDateTime, [year: '2009'])
		assertEquals(expected, actual)
	}

	void testAssembleLocalDateUsingYearMonthDayHourMinute() {
		def editor = new StructuredJodaDateTimeEditor(LocalDateTime)
		def expected = new LocalDateTime(2009, 3, 6, 17, 21, 33)
		def actual = editor.assemble(LocalDateTime, [year: '2009', month: '03', day: '06', hour: '17', minute: '21', second: '33'])
		assertEquals(expected, actual)
	}

	void testAssembleDateTimeUsingOnlyYear() {
		def editor = new StructuredJodaDateTimeEditor(DateTime)
		def expected = new DateTime(2009, 1, 1, 0, 0, 0, 0)
		def actual = editor.assemble(DateTime, [year: '2009'])
		assertEquals(expected, actual)
	}

	void testAssembleDateUsingYearMonthDayHourMinute() {
		def editor = new StructuredJodaDateTimeEditor(DateTime)
		def expected = new DateTime(2009, 3, 6, 17, 21, 33, 0)
		def actual = editor.assemble(DateTime, [year: '2009', month: '03', day: '06', hour: '17', minute: '21', second: '33'])
		assertEquals(expected, actual)
	}

	void testAssembleRequiresHourForTimeTypes() {
		def editor = new StructuredJodaDateTimeEditor(LocalTime)
		shouldFail(IllegalArgumentException) {
			editor.assemble(LocalTime, [minute: 29])
		}
	}

	void testAssembleLocalTimeUsingOnlyHour() {
		def editor = new StructuredJodaDateTimeEditor(LocalTime)
		def expected = new LocalTime(17, 0)
		def actual = editor.assemble(LocalTime, [hour: '17'])
		assertEquals(expected, actual)
	}

	void testAssembleLocalTimeUsingHourMinute() {
		def editor = new StructuredJodaDateTimeEditor(LocalTime)
		def expected = new LocalTime(17, 55, 33)
		def actual = editor.assemble(LocalTime, [hour: '17', minute: '55', second: '33'])
		assertEquals(expected, actual)
	}

}