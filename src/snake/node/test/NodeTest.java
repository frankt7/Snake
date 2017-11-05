package snake.node.test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import snake.node.Node;

public class NodeTest {
	Field nextField;
	Field elementField;
	
	Node node;
	
	@Before
	public void setUp() throws Exception {
		try {
			nextField = Node.class.getDeclaredField("_next");
			nextField.setAccessible(true);
		} catch(NoSuchFieldException e) {
			fail("The next field should be named _next");
		}
		
		try {
			elementField = Node.class.getDeclaredField("_elem");
			elementField.setAccessible(true);
		} catch(NoSuchFieldException e) {
			fail("The element field must be named _elem");
		}
	}
	
	@Test
	public void testGetElementWithString() {
		String actual;
		
		node = new <String>Node("");
		actual = node.<String>getElement();
		assertEquals("getElement() does not return the correct value", "", actual);
		
		node = new <String>Node("ahsdiufh HIU uiHU 893");
		actual = node.<String>getElement();
		assertEquals("getElement() does not return the correct value", "ahsdiufh HIU uiHU 893", actual);
	}
	
	@Test
	public void testGetElementWithInt() {
		int actual;
		
		node = new <Integer>Node(-0xDEADBEEF);
		actual = node.<Integer>getElement().intValue();
		assertEquals("getElement() does not return the correct value", -0xDEADBEEF, actual);
		
		node = new <Integer>Node(0);
		actual = node.<Integer>getElement().intValue();
		assertEquals("getElement() does not return the correct value", 0, actual);
		
		node = new <Integer>Node(0xCAFEBABE);
		actual = node.<Integer>getElement().intValue();
		assertEquals("getElement() does not return the correct value", 0xCAFEBABE);
	}
	
	@Test
	public void testGetElementWithList() {
		List<Object> actual;
		List<Object> expected;
		
		expected = new ArrayList<Object>();
		node = new <List<Object>>Node(expected);
		actual = node.<List<Object>>getElement();
		assertEquals("getElement() does not return the correct value", expected, actual);
		
		expected = new Vector<Object>();
		node = new <List<Object>>Node(expected);
		actual = node.<List<Object>>getElement();
		assertEquals("getElement() does not return the correct value", expected, actual);
	}
}
