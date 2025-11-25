package se.hig.aod.lab1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.hig.aod.lab1.BinarySearchTree;

class BinarySearchTreeTest {

	private BinarySearchTree<Integer> listUnderTest;
	private final int[] fixture = {5, 2, 4, 3, 1};
	
	/**
	 * Resets list to a new empty LinkedList-instance
	 * before each test method is executed.
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		listUnderTest = new BinarySearchTree<Integer>(); 
	}

	/**
	 * Sets list to null after each test method is executed.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		listUnderTest = null;
	}

	@Test
	public void addElement()
	{
		for(int x = 0; x < 5; x++)
			listUnderTest.addElement(fixture[x]);
	}
	
	@Test
	public void searchElement()
	{
		for(int x = 0; x < 5; x++)
			listUnderTest.addElement(fixture[x]);
		
		for(int x = 0; x < 5; x++)
			assertEquals(fixture[x], listUnderTest.searchElement(fixture[x]));
	}

	@Test
	public void size()
	{
		for(int x = 0; x < 5; x++)
			listUnderTest.addElement(fixture[x]);
		
		assertEquals(5, listUnderTest.size());
	}

	@Test
	public void testToString()
	{
		for(int x = 0; x < 5; x++)
			listUnderTest.addElement(fixture[x]);
		
		assertEquals("12345", listUnderTest.toString());
	}
}
