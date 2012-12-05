package com.octo.livecoding;

import java.util.List;

public class PageGenerator {
	
	public String generate() {

		List<Result> results = ResultDao.query();
		String pageText = new String();

		pageText += "<html>";
		pageText += "<head>";
		pageText += "<title>";
		pageText += "Quaterly Report";
		pageText += "</title>";
		pageText += "</head>";
		pageText += "<body>";
		pageText += "<h1>";
		pageText += "Quaterly Report";
		pageText += "</h1><table>";
		if (results.size() != 0) {
			pageText += "<table border=\"1\">";
			for (Result result : results) {
				pageText += "<tr border=\"1\">";
				pageText += "<td>" + result.getDepartement() + "</td>";
				pageText += "<td>" + result.getManager() + "</td>";
				pageText += "<td>" + (result.getNetProfit() / 100) + "<td>";
				pageText += "<td>" + (result.getOperatingExpense() / 100)
						+ "<td>";
				pageText += "</tr>";
			}
			pageText += "</table>";
		} else {
			pageText += "<p>No results for this period</p>";
		}
		pageText += "</body>";
		pageText += "</html>";

		return pageText;
	}

}
