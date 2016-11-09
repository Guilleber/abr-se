package abr_se;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;

public class ABRTest {
	@Test
	public void testSimple() {
		ABR abr = new ABR();
		assertTrue("abr should be empty", abr.isEmpty());
		assertEquals("abr should be empty", abr.nbElements(), 0);
		abr.insert(5);
		assertFalse("abr should contain 5", abr.isEmpty());
		assertEquals("abr should contain 5", abr.nbElements(), 1);
		abr.insert(0);
		assertFalse("abr should contain 5,0", abr.isEmpty());
		assertEquals("abr should contain 5,0", abr.nbElements(), 2);
		abr.insert(8);
		assertFalse("abr should contain 5,0,8", abr.isEmpty());
		assertEquals("abr should contain 5,0,8", abr.nbElements(), 3);
	}
	
	@Test
	public void testDoublons() {
		ABR abr = new ABR();
		abr.insert(5);
		abr.insert(3);
		abr.insert(8);
		assertFalse("abr should contain 5,3,8", abr.isEmpty());
		assertEquals("abr should contain 5,3,8", abr.nbElements(), 3);
		abr.insert(5);
		assertFalse("abr should contain 5,3,8", abr.isEmpty());
		assertEquals("abr should contain 5,3,8", abr.nbElements(), 3);
	}
	
	@Test
	public void testToList() {
		ABR abr = new ABR();
		abr.insert(5);
		abr.insert(3);
		abr.insert(8);
		List<int> list = new List<int>();
		abr.toList(list);
		assertEquals(list.toArray(), [3,5,8]);
	}
}