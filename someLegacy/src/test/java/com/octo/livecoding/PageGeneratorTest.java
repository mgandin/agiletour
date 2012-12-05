package com.octo.livecoding;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;


public class PageGeneratorTest {

	@Test public void shouldReturnSomething() {
		PageGenerator page = new PageGenerator() {

			@Override
			protected List<Result> retrieveResultsFromDao() {
				return new ArrayList<Result>();
			}
			
		};
		Assert.assertNotNull(page.generate());
	}
	
	@Test public void shouldReturnSomethingWithoutAnyResult() {
		// Given
		PageGenerator page = new PageGenerator() {

			@Override
			protected List<Result> retrieveResultsFromDao() {
				return new ArrayList<Result>();
			}
			
		};
		
		String viewExpected = "<html><head><title>Quaterly Report</title></head><body>"
			+ "<h1>Quaterly Report</h1>"
			+ "<table>"
			+ "<p>No results for this period</p>"
			+ "</table>"
			+ "</body></html>";
		
		// When
		String view = page.generate();
		
		// Then
		Assert.assertEquals(viewExpected, view);
	}
	
	@Test public void shouldReturnAPageWithResult() {
		// Given
		PageGenerator page = new PageGenerator() {

			@Override
			protected List<Result> retrieveResultsFromDao() {
				Result result = new Result();
				result.setDepartement("Media");
				result.setManager("Mathieu Gandin");
				result.setNetProfit(new Double(5000));
				result.setOperatingExpense(new Double(5000));
				List<Result> results = new ArrayList<Result>();
				results.add(result);
				return results;
			}
			
		};
		
		String viewExpected = "<html><head><title>Quaterly Report</title></head><body>"
			+ "<h1>Quaterly Report</h1>"
			+ "<table>"
			+ "<table border=\"1\">"
			+ "<tr border=\"1\">"
			+ "<td>Media</td>"
			+ "<td>Mathieu Gandin</td>"
			+ "<td>50.0</td><td>50.0</td>"
			+ "</tr></table>"
			+ "</table>"
			+ "</body></html>";
		// When
		String view = page.generate();
		
		// Then
		Assert.assertEquals(viewExpected, view);
	}
	
}
