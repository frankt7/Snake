package snake.test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;

import org.junit.Before;
import org.junit.Test;

import snake.Snake;
import snake.node.Node;

public class SnakeTest {
	Field nodeField;
	Field sizeField;
	
	Snake snake;
	
	@Before
	public void setUp() throws Exception {
		snake = new Snake();
		
		try {
			nodeField = Snake.class.getDeclaredField("_head");
			nodeField.setAccessible(true);
		} catch(NoSuchFieldException e) {
			fail("The node field must be named _head");
		}
		
		try {
			sizeField = Snake.class.getDeclaredField("_size");
			sizeField.setAccessible(true);
		} catch(NoSuchFieldException e) {
			fail("The size field must be named _size");
		}
	}
	
	@Test
	public void testConstructor() throws Exception {
		Node head = getHead();
		int  size = getSize();
		
		assertNull("Constructor did not create an empty Snek, an empty Snek is just a null head", head);
		assertEquals("Constructor did not initialize the size field correctly", 0, size);
	}
	
	@Test
	public void testAddWithEmptySnekAndString() throws Exception {
		snake.<String>add(0, "hello gustavo");
		Node head = getHead();
		int  size = getSize();
		
		assertEquals("add did not add the supplied element to the list correctly", "hello gustavo", head.<String>getElement());
		assertEquals("add did not update the size field correctly", 1, size);
	}
	
	@Test
	public void testAddWithEmptySnekAndInt() throws Exception {
		snake.<Integer>add(0, 0xDEADFACE);
		Node head = getHead();
		int  size = getSize();
		
		assertEquals("add did not add the supplied element to the list correctly", 0xDEADFACE, head.<Integer>getElement().intValue());
	}
	
	private void setSize(int newSize) throws Exception {
		sizeField.set(snake, newSize);
	}
	
	private int getSize() throws Exception {
		Integer size = (Integer) sizeField.get(snake);
		return size.intValue();
	}
	
	private void setHead(Node newHead) throws Exception {
		nodeField.set(snake, newHead);
	}
	
	private Node getHead() throws Exception {
		return (Node) nodeField.get(snake);
	}
}