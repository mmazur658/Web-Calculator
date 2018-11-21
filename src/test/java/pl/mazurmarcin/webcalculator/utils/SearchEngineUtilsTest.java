package pl.mazurmarcin.webcalculator.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchEngineUtilsTest {

	private SearchEngineUtilsImpl searchEngineUtilsImpl = new SearchEngineUtilsImpl();

	@Test
	void checkIfTableHasAnyParameters() {

		String[] searchParameters = { "", "", "", "Marcin Mazur", "" };
		assertTrue(searchEngineUtilsImpl.hasTableAnyParameters(searchParameters));

	}

	@Test
	void shouldPrepareHqlUsingContactFormMessageSearchParameters() {

		String[] searchParameters = { "Marcin Mazur", "","", "2018-11-15 00:00:00.0","","new" };
		String[] fieldsName = { "senderName", "senderEmail", "messageSubject", "date", "listType" };
		String searchType = "FROM users WHERE ";

		String expectedHql = searchEngineUtilsImpl.prepareHqlUsingContactFormMessageSearchParameters(searchParameters,
				searchType, fieldsName);

		assertEquals(
				"FROM users WHERE senderName like '%Marcin Mazur%' AND date >= '2018-11-15 00:00:00.0' AND isActive = true ORDER BY id DESC",
				expectedHql);

	}

}
