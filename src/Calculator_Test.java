import java.io.IOException;
import java.util.Iterator;

import org.apache.xmlbeans.XmlException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.impl.wsdl.WsdlTestSuite;
import com.eviware.soapui.impl.wsdl.testcase.WsdlTestCase;
import com.eviware.soapui.model.support.PropertiesMap;
import com.eviware.soapui.model.testsuite.TestRunner;
import com.eviware.soapui.model.testsuite.TestRunner.Status;
import com.eviware.soapui.support.SoapUIException;



public class Calculator_Test {
	@Test
	public void calculator() throws XmlException, IOException, SoapUIException {
		
		WsdlProject testProject = new WsdlProject("./data/Calc-soapui-project.xml");
		WsdlTestSuite testSuite = testProject.getTestSuiteByName("Calculator TestSuite");
		for (int i = 0; i < testSuite.getTestCaseCount(); i++) {
			WsdlTestCase testCase =  testSuite.getTestCaseAt(i);
			TestRunner testRun = testCase.run(new PropertiesMap(), false);
			Assert.assertEquals(Status.FINISHED, testRun.getStatus());			
		}
			
	}
	
}
