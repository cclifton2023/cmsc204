import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GradeBookTester 
{
	GradeBook g1;
	 
	@BeforeEach
	 
	void setUp() throws Exception 
	{
		g1 = new GradeBook(5);
		g1.addScore(42);
		g1.addScore(89);
	}
	  
	@AfterEach
	 
	void tearDown() throws Exception 
	{
		g1 = null;
	}
	 
	@Test
	void testAddScore() 
	{
		assertTrue(g1.toString().equals("42.0 89.0 "));
	}
	 
	@Test
	void testSum() 
	{
		assertEquals(131, g1.sum(), .0001);
	}

	@Test
	void testMinimum() 
	{
	 assertEquals(42, g1.minimum(), .001);
	}
	@Test
	void testFinalScore() 
	{
		assertEquals(g1.finalScore(), 42, 89);
	}
}