/**
 * 
 */
/**
 * @author pnomula
 *
 */
package org.testcases;

import org.report.Logger;
import org.testng.annotations.AfterSuite;

public class Configuration {
	
	@AfterSuite
	public void finishTestSuite() {
		System.out.println("finish suite");
		Logger.finishSuite();
	}
	
}
