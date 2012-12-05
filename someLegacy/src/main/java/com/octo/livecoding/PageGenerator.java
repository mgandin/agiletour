package com.octo.livecoding;

import java.util.List;

/**
 * 12/12/2002
 * @author gandinmathieu
 *
 */
public class PageGenerator {
	
	/**
	 * 
	 * @return
	 */
	public String generate() {

		List<Result> results = retrieveResultsFromDao();
		String pageText = new String();

		// WTF
		pageText = generateHeader(pageText);
		pageText += "<body>";
		pageText += "<h1>";
		pageText += "Quaterly Report";
		pageText += "</h1><table>";
		if (results.size() != 0) {
			pageText += "<table border=\"1\">";
			// WTF
			for (Result result : results) {
				pageText = generateResults(pageText, result);
			}
			pageText += "</table>";

		} else {
			pageText += "<p>No results for this period</p>";
		}
		pageText += "</table>";

		pageText += "</body>";
		pageText += "</html>";

		// WTF
		return pageText;
	}

	private String generateResults(String pageText, Result result) {
		pageText += "<tr border=\"1\">";
		pageText += "<td>" + result.getDepartement() + "</td>";
		pageText += "<td>" + result.getManager() + "</td>";
		pageText += "<td>" + (result.getNetProfit() / 100) + "</td>";
		pageText += "<td>" + (result.getOperatingExpense() / 100)
				+ "</td>";
		pageText += "</tr>";
		return pageText;
	}

	private String generateHeader(String pageText) {
		pageText += "<html>";
		pageText += "<head>";
		pageText += "<title>";
		pageText += "Quaterly Report";
		pageText += "</title>";
		pageText += "</head>";
		return pageText;
	}

	protected List<Result> retrieveResultsFromDao() {
		List<Result> results = ResultDao.query();
		return results;
	}

}
