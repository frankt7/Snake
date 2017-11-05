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
		assertEquals("add did not update the size field correctly", 1, size);
	}
	
	@Test
	public void testAddWithNonEmptySnekAtFirst() throws Exception {
		Node newHead = new <Double>Node(123.321, new <Character>Node('\0'));
		setHead(newHead);
		setSize(2);
		
		snake.<Character>add(0, '\u2605');
		Node head = getHead();
		int  size = getSize();
		
		assertEquals("add did not update the size field correctly", 3, size);
		assertEquals("add did not insert the element correctly", '\u2605', head.<Character>getElement().charValue());
		
		head = head.getNext();
		assertEquals("add did not insert the element correctly", 123.321, head.<Double>getElement().doubleValue(), 0.001);
		
		head = head.getNext();
		assertEquals("add did not insert the element correctly", '\0', head.<Character>getElement().charValue());
		
		head = head.getNext();
		assertNull("the last element's next field should be null", head);
	}
	
	@Test
	public void testAddWithNonEmptySnekAtMiddle() throws Exception {
		Node newHead = new <String>Node("blah", new <Boolean>Node(true, new <Boolean>Node(false)));
		setHead(newHead);
		setSize(3);
		
		snake.<Float>add(1, 3.14f);
		Node head = getHead();
		int  size = getSize();
		
		assertEquals("add did not update the size field correctly", 4, size);
		assertEquals("add did not insert the element correctly", "blah", head.<String>getElement());
		
		head = head.getNext();
		assertEquals("add did not insert the element correctly", 3.14f, head.<Float>getElement().floatValue(), 0.001);
		
		head = head.getNext();
		assertEquals("add did not insert the element correctly", true, head.<Boolean>getElement().booleanValue());
		
		head = head.getNext();
		assertEquals("add did not insert the element correctly", false, head.<Boolean>getElement().booleanValue());
		
		head = head.getNext();
		assertNull("the last element's next field should be null", head);
	}
	
	@Test
	public void testAddWithNonEmptySnekAtLast() throws Exception {
		Node newHead = new <Integer>Node(123, new <String>Node("123"));
		setHead(newHead);
		setSize(2);
		
		snake.<String>add(1, "123");
		Node head = getHead();
		int  size = getSize();
		
		assertEquals("add did not update the size field correctly", 3, size);
		assertEquals("add did not insert the element correctly", 123, head.<Integer>getElement().intValue());
		
		head = head.getNext();
		assertEquals("add did not insert the element correctly", "123", head.<String>getElement());
		
		head = head.getNext();
		assertEquals("add did not insert the element correctly", "123", head.<String>getElement());
		
		head = head.getNext();
		assertNull("the last element's next field should be null", head);
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