package local.readyapitest;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.squashtest.ta.galaxia.squash.tf.galaxia.annotations.TFMetadata;
import com.smartbear.ready.cmd.runner.pro.*;

public class RESTTest {
	
	/**
	 * Example of ReadyAPI test execution with Junit5 
	 * ReadyAPI project contains one test suite with two tests of REST API on https://jsonplaceholder.typicode.com/
	 */

	// Specify the path to the Ready API project file
	final String project_location = "src/test/resources/REST-Test-Project-readyapi-project.xml";

	private SoapUIProTestCaseRunner runner;


	@BeforeEach
	void setup() {

		// Create a test runner object
		runner = new SoapUIProTestCaseRunner();

		// Specify the path to the project file
		runner.setProjectFile(project_location);


	}

	// DisplayName overrides the method name displayed in Squash test list.
	@DisplayName("TestCaseOK")
	@TFMetadata(key = "linked-TC", value = {"for_autolink_insert_TC_UUID"})
	@Test
	public void TestOK() throws Exception {
		// Specify the test suite to run
		runner.setTestSuite("TestSuite 1");
				
		// Specify the test case to run
		// It must be in the test suite specified above
		runner.setTestCase("Test_OK");

		// Command the runner to create a printable report
		runner.setPrintReport(true);

		// Start the test run
		try {
			runner.run();
		} catch (Exception e) {
			// print message if the test fails
			Assert.fail(e.getMessage());
		}
	}

	@Test
	@TFMetadata(key = "linked-TC", value = {"for_autolink_insert_TC_UUID" })
	public void TestKO() {

		// Create a test runner object
		SoapUIProTestCaseRunner runner = new SoapUIProTestCaseRunner();

		// Specify the path to the project file
		runner.setProjectFile(project_location);

		// Specify the test suite to run
		runner.setTestSuite("TestSuite 1");

		// Specify the test case to run
		// It must be in the test suite specified above
		runner.setTestCase("Test_KO");

		// Command the runner to create a printable report
		runner.setPrintReport(true);

		// Start the test run
		try {
			runner.run();
		} catch (Exception e) {
			// print message if the test fails
			Assert.fail(e.getMessage());
		}
	}
}
