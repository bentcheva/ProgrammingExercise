package exercise.testing;

import static org.junit.Assert.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import exercise.coding.PayRoll;
import exercise.coding.Utils;

/**
 * This test case test the response of the application to different user inputs. 
 * @author Bobi
 *
 */
public class PayRollTest {

	private PayRoll pr;
	private String selectOne = "1";
	private InputStream insOne = new ByteArrayInputStream(selectOne.getBytes());
	private String selectTwo = "2";
	private InputStream insTwo = new ByteArrayInputStream(selectTwo.getBytes());
	private String selectAny = "hjy";
	private InputStream insAny = new ByteArrayInputStream(selectAny.getBytes());
	private Scanner scanOne;
	private Scanner scanTwo;
	private Scanner scanAny;
	
	private String employee0 = "Joe,Doe,-7889,8,kkk";
	private String employee1 = "Joe,Doe,34500,8,9";
	private String employee2 = "Joe,Doe,hhhhh,8,9";
	private String employee3 = "Joe,Doe,34567,hh,9";
	private String employee4 = "Joe,Doe,34567,8,kkk";
	private String employee5 = "Joe,Doe,34567,-8,9";
	
	private InputStream insSubOne = new ByteArrayInputStream(employee0.getBytes());
	private InputStream insSubTwo = new ByteArrayInputStream(employee1.getBytes());
	private InputStream insSubThree = new ByteArrayInputStream(employee2.getBytes());
	private InputStream insSubFour = new ByteArrayInputStream(employee3.getBytes());
	private InputStream insSubFive = new ByteArrayInputStream(employee4.getBytes());
	private InputStream insSubSix = new ByteArrayInputStream(employee5.getBytes());
	
	private Scanner scanFour;
	private Scanner scanFive;
	private Scanner scanSix;
	private Scanner scanSeven;
	private Scanner scanEight;
	private Scanner scanNine;
	
	
	@Before
	public void setUp() throws Exception {
		System.out.println("Running: setUp().");
		pr = new PayRoll();
		scanOne  = new Scanner(insOne);
		scanTwo  = new Scanner(insTwo);
		scanAny  = new Scanner(insAny);
		scanFour  = new Scanner(insSubOne);
		scanFive  = new Scanner(insSubTwo);
		scanSix  = new Scanner(insSubThree);
		scanSeven  = new Scanner(insSubFour);
		scanEight  = new Scanner(insSubFive);
		scanNine  = new Scanner(insSubSix);
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Running: tearDown().");
		pr = null;
	}

	@Test
	public void testSubMenu() {
		System.out.println("\n************************************");
		System.out.println(getClass().getSimpleName());
		System.out.println("\nTesting the sub menu.");
		Utils.useCase(employee0);
		assertFalse(pr.subMenu(scanFour));
		Utils.useCase(employee1);
		assertTrue(pr.subMenu(scanFive));
		Utils.useCase(employee2);
		assertFalse(pr.subMenu(scanSix));
		Utils.useCase(employee3);
		assertFalse(pr.subMenu(scanSeven));
		Utils.useCase(employee4);
		assertFalse(pr.subMenu(scanEight));
		Utils.useCase(employee5);
		assertFalse(pr.subMenu(scanNine));
		
	}

	@Test
	public void testMenu() {
		System.out.println("\n************************************");
		System.out.println(getClass().getSimpleName());
		System.out.println("\nTesting the main menu.");
		Utils.useCase("selection " + selectOne);
		assertEquals(1, pr.menu(scanOne));
		Utils.useCase("selection " + selectTwo);
		assertEquals(2, pr.menu(scanTwo));
		Utils.useCase("selection " + selectAny);
		assertEquals(-1, pr.menu(scanAny));
	}

}
