package org.evosuite.coverage.epa;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.evosuite.Properties;
import org.evosuite.Properties.Criterion;
import org.evosuite.TestGenerationContext;
import org.evosuite.testcase.DefaultTestCase;
import org.evosuite.testcase.TestChromosome;
import org.evosuite.testcase.variable.VariableReference;
import org.evosuite.testsuite.TestSuiteChromosome;
import org.junit.After;
import org.junit.Assume;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import com.examples.with.different.packagename.epa.BoundedStackWithInvalidadState;

public class TestInvalidState extends TestEPATransitionCoverage {

	private static final String BOUNDED_STACK_EPA_XML = String.join(File.separator, System.getProperty("user.dir"),
			"src", "test", "resources", "epas", "MyBoundedStack.xml");

	private int DEFAULT_TIMEOUT = Properties.TIMEOUT;

	@Before
	public void prepareTest() throws FileNotFoundException, ParserConfigurationException, SAXException, IOException {
		final File epaXMLFile = new File(BOUNDED_STACK_EPA_XML);
		Assume.assumeTrue(epaXMLFile.exists());
		Properties.EPA_XML_PATH = BOUNDED_STACK_EPA_XML;
		Properties.TIMEOUT = Integer.MAX_VALUE;
		EPAMonitor.reset();
	}

	@After
	public void tearDown() {
		Properties.EPA_XML_PATH = null;
		Properties.TIMEOUT = DEFAULT_TIMEOUT;
	}

	@Test
	public void testInvalidState() throws ClassNotFoundException, NoSuchMethodException, SecurityException, IOException,
			SAXException, ParserConfigurationException {
		Properties.TARGET_CLASS = BoundedStackWithInvalidadState.class.getName();
		Properties.EPA_XML_PATH = BOUNDED_STACK_EPA_XML;
		Properties.CRITERION = new Properties.Criterion[] { Criterion.EPATRANSITION };

		EPATransitionCoverageFactory factory = new EPATransitionCoverageFactory(Properties.TARGET_CLASS,
				EPAFactory.buildEPA(Properties.EPA_XML_PATH));
		List<EPATransitionCoverageTestFitness> goals = factory.getCoverageGoals();
		assertEquals(7, goals.size());

		DefaultTestCase test = createTestCase0();
		TestSuiteChromosome suite = new TestSuiteChromosome();
		suite.addTest(test);
		TestChromosome testChromosome = suite.getTestChromosome(0);

		int covered = 0;
		int uncovered = 0;
		double totalFitness = 0.0;
		for (EPATransitionCoverageTestFitness g : goals) {
			double fitness = g.getFitness(testChromosome);
			if (fitness == 0.0) {
				covered++;
			} else {
				uncovered++;
			}
			totalFitness += fitness;
		}

		assertEquals(7, covered + uncovered);
		assertEquals(2, covered);
		assertEquals(5, uncovered);
		assertEquals(5.0, totalFitness, 0.00000000001);

	}

	/**
	 * Builds the test case:
	 * 
	 * <code>
	 * stack = new BoundedStack(); 
	 * stack.push(10);
	 * stack.break(); 
	 * stack.push(10);
	 * </code>
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws NoSuchMethodException
	 */
	private DefaultTestCase createTestCase0() throws ClassNotFoundException, NoSuchMethodException {
		Class<?> clazz = TestGenerationContext.getInstance().getClassLoaderForSUT().loadClass(Properties.TARGET_CLASS);
		Constructor<?> constructor = clazz.getConstructor();
		EPATestCaseBuilder builder = new EPATestCaseBuilder();
		VariableReference bounded_stack_var = builder.addConstructorStatement(constructor);
		Method push_method = clazz.getMethod("push", int.class);
		VariableReference int_value_var = builder.addIntegerStatement(10);
		builder.addMethodStatement(bounded_stack_var, push_method, int_value_var);
		Method break_method = clazz.getMethod("breakObjectState");
		builder.addMethodStatement(bounded_stack_var, break_method);
		builder.addMethodStatement(bounded_stack_var, push_method, int_value_var);
		DefaultTestCase test = builder.toTestCase();
		return test;
	}

}
