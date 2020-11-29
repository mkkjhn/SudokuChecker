import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import org.junit.Before;

@RunWith(Parameterized.class)
public class SudokuVerifierParameterizedTest {
	
	//Voluntary - implement tests as Parameterized tests:	
	//text tutorial: https://www.tutorialspoint.com/junit/junit_parameterized_test.htm
	//video tutorial: https://www.youtube.com/watch?v=ryBetrexwt4	
	
	//implement and document tests to test Sudokuverifier with boundary values. Use templates from Task 1 to derive and document test cases.
	
	// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
	// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
	
	private SudokuVerifier verifier = new SudokuVerifier();
	
	//@Parameterized.Parameter(0)
	public String testString;
	//@Parameterized.Parameter(1)
	public int expectedResult;
	
	//@Parameterized.Parameter(2)
	public Class<? extends Exception> expectedException;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void initializeTestVariables() {
		
	}
	
	//collection of test data with inputs (testString) and expected results
	@Parameterized.Parameters
	public static Collection<Object[]> data() throws NumberFormatException {
		return Arrays.asList(new Object[][] {
			{ "417369825632158947958724316825437169791586432346912758289643571573291684164875293", 0, null },
			{ "017369825632158947958724316825437169791586432346912758289643571573291684164875293", -1, null },			
			{ "A17369825632158947958724316825437169791586432346912758289643571573291684164875293", 1, NumberFormatException.class },
			{ "’17369825632158947958724316825437169791586432346912758289643571573291684164875293", 1, NumberFormatException.class },
			{ "417469825632158947958724316825437169791586432346912758289643571573291684164875293", -3, null },
			{ "417369825432158947958724316825437169791586432346912758289643571573291684164875293", -4, null },
			{ "417369825432158947958724316825437169791586432346912758289643571573291684164875293", -2, null },
			{ "41736982563215894795872431682543716979158643234691275828964357157329168416487529", -1, null }
			});
		}
	
	// Test class constructor
	public SudokuVerifierParameterizedTest(String testString, int expectedResult, Class exception) {
	      this.testString = testString;
	      this.expectedResult = expectedResult;
	      this.expectedException = exception;
	      }
	
	@Test 
	public void testSudokuVerifierParameterizedTest() {
		
		if (expectedException != null) {
	        thrown.expect(expectedException);
	        throw new NumberFormatException();	        
	    }
		else {
			assertEquals(verifier.verify(testString), expectedResult);
		}
		
	}
	
	/*
	@Test
	public void returnCorrect() {
		int returnNumber = verifier.verify(testString);
		assertEquals(returnNumber, expectedResult);
	}
	*/
}
