package pl.mazurmarcin.webcalculator.utils;

public interface SearchEngineUtils {

	public boolean hasTableAnyParameters(String[] searchParameters);

	public String prepareHqlUsingContactFormMessageSearchParameters(String[] searchParameters, String searchType,
			String[] fieldsName);

}
