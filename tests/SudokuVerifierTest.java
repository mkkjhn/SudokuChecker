import static org.junit.Assert.*;

import org.junit.Test;

public class SudokuVerifierTest {

//implement tests to test Sudokuverifier with boundary values.  Use templates from Task 1 to derive and document test cases.
	
// A correct Sudoku string: 417369825632158947958724316825437169791586432346912758289643571573291684164875293
// An incorrect Sudoku string: 123456789912345678891234567789123456678912345567891234456789123345678912234567891
String c = "417369825632158947958724316825437169791586432346912758289643571573291684164875293";
String i = "123456789912345678891234567789123456678912345567891234456789123345678912234567891";

/* Rules
 * R0 Cell contains a character (a - !)			: return  1
 * R1 Cell can only contain numbers 1 - 9 		: return -1 when violated
 * R2 Digits appear only once in sub-grid 		: return -2 when violated
 * R3 Digit appears only once in a the rows 	: return -3 when violated
 * R4 Digit appears only once in the columns	: return -4 when violated
 * 
 * Sudoku solution correct : return 0 
 */
SudokuVerifier v = new SudokuVerifier();

	@Test
	public void testcase1_CorrectString() {
		int a = v.verify(c);
		assertEquals("correct string", a, 0);
	}

	@Test
	public void testcase2_IncorrectCellValue_0() {		
		String ii = "017369825632158947958724316825437169791586432346912758289643571573291684164875293";
		int a = v.verify(ii);
		assertEquals("incorrect cell value", a, -1);
		
	}
	
	@Test (expected = NumberFormatException.class)
	public void testcase3_IncorrectCellValue_A() throws NumberFormatException {		
		
		String iii = "A17369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		// should throw NumberFormatException
		int a = v.verify(iii);
		//assertEquals("incorrect, cell contains illegal character", a, 1);
		
	}
	
	@Test (expected = NumberFormatException.class)
	public void testcase4_IncorrectCellValue_NaughtyChar() throws NumberFormatException {		
		
		String iv = "’17369825632158947958724316825437169791586432346912758289643571573291684164875293";
		
		// should throw NumberFormatException
		int a = v.verify(iv);
		//assertEquals("incorrect, cell contains illegal character", a, 1);
		
	}
	
	@Test 
	public void testcase5_Incorrect_RowValuesNotUnique() {		
		String _v = ""
				+ "417469825" // correct:"417369825" -> "417469825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293";
		int a = v.verify(_v);
		assertEquals("incorrect, row values are not unique", a, -3);
		
	}
	
	@Test 
	public void testcase6_Incorrect_ColumnValuesNotUnique() {		
		String vi = ""
				+ "417369825"
				+ "432158947" // correct:"632158947" -> "432158947"
				+ "958724316"
				+ "825437169" 
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293";
		int a = v.verify(vi);
		assertEquals("incorrect, column values are not unique", a, -4);
		
	}
	
	@Test 
	public void testcase7_Incorrect_SubGridValuesNotUnique() {		
		String vii = ""
				+ "417369825"
				+ "432158947" // correct:"632158947" -> "432158947"
				+ "958724316"
				+ "825437169" 
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "164875293";
		int a = v.verify(vii);
		assertEquals("incorrect, sub-grid values are not unique", a, -2);
		
	}
	
	@Test 
	public void testcase8_Incorrect_SudokoGridLength_80() {		
		String viii = ""
				+ "417369825"
				+ "632158947"
				+ "958724316"
				+ "825437169"
				+ "791586432"
				+ "346912758"
				+ "289643571"
				+ "573291684"
				+ "16487529";
		int a = v.verify(viii);
		assertEquals("incorrect sudoku grid length", a, -1);
		
	}
}
