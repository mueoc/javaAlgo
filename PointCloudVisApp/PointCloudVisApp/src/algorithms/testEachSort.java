package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.List;

import algorithms.BubbleSort;
import algorithms.MergeSorter;
import algorithms.SelectionSorter;

class testEachSort {

	private BubbleSort<Integer> listUnderTestBubble;
	private MergeSorter<Integer> listUnderTestMerge;
	private SelectionSorter<Integer> listUnderTestSelection;

	private final List<Integer> sortedFixture = new ArrayList<>(List.of(4, 5, 3, 1, 2));
	//private final List<Integer> sortedFixtureL = new LinkedList<>(List.of(4, 5, 3, 1, 2));

	private final List<Integer> sorted = List.of(1, 2, 3, 4, 5);

	
	/**
	 * Resets list to a new empty LinkedList-instance
	 * before each test method is executed.
	 * 
	 * @throws Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		listUnderTestBubble = new BubbleSort<Integer>();
		listUnderTestMerge = new MergeSorter<Integer>(); 
		listUnderTestSelection = new SelectionSorter<Integer>();
	}

	/**
	 * Sets list to null after each test method is executed.
	 * 
	 * @throws Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		listUnderTestBubble = null;
		listUnderTestMerge = null;
		listUnderTestSelection = null;
	}

	@Test
	public void sortBubbleSort()
	{
		listUnderTestBubble.sort(sortedFixture);
		assertEquals(sorted, sortedFixture);
	}

	@Test
	public void sortMergeSort()
	{
		listUnderTestMerge.sort(sortedFixture);
		assertEquals(sorted, sortedFixture);
	}

	@Test
	public void sortSelectionSort()
	{
		listUnderTestSelection.sort(sortedFixture);
		assertEquals(sorted, sortedFixture);
	}
}