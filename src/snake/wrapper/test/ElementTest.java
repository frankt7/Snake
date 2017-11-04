package snake.wrapper.test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;


import org.junit.Before;
import org.junit.Test;
import org.junit.After;

import snake.wrapper.Element;

public class ElementTest {
	Field elementField;
	Field typeField;             
	
	Element<String>  strElement;
	Element<Integer> intElement;
	
	@Before
	public void setUp() throws Exception {
		try {
			elementField = Element.class.getDeclaredField("_elem");
			elementField.setAccessible(true);
		} catch(NoSuchFieldException e) {
			fail("The element field must be named _elem");
		}
		
		try {
			typeField = Element.class.getDeclaredField("_type");
			typeField.setAccessible(true);
		} catch(NoSuchFieldException e) {
			fail("The type field must be named _type");
		}
	}
	
	@After
	public void cleanUp() {
		strElement = null;
		intElement = null;
	}
	
	@Test
	public void testConstructorWithString() throws Exception {
		String elem;
		String type;
		
		strElement = new Element<String>("");
		elem = (String) elementField.get(strElement);
		type = (String) typeField.get(strElement);
		assertEquals("The constructor initializes the element field incorrectly", "", elem);
		assertEquals("The constructor initializes the type field incorrectly", "".getClass().getName(), type);
		
		strElement = new Element<String>("ajiod aoisdjw");
		elem = (String) elementField.get(strElement);
		type = (String) typeField.get(strElement);
		assertEquals("The constructor initializes the element field incorrectly", "ajiod aoisdjw", elem);
		assertEquals("The constructor initializes the type field incorrectly", "ajiod aoisdjw".getClass().getName(), type);
		
		strElement = new Element<String>("madvaoi8 9");
		elem = (String) elementField.get(strElement);
		type = (String) typeField.get(strElement);
		assertEquals("The constructor initializes the element field incorrectly", "madvaoi8 9", elem);
		assertEquals("The constructor initializes the type field incorrectly", "madvaoi8 9".getClass().getName(), type);
	}
	
	@Test
	public void testConstructorWithInt() throws Exception {
		Integer elem;
		String  type;
		
		intElement = new Element<Integer>(-40);
		elem = (Integer) elementField.get(intElement);
		type = (String) typeField.get(intElement);
		assertEquals("The constructor initializes the element field incorrectly", -40, elem.intValue());
		assertEquals("The constructor initializes the type field incorrectly", new Integer(-40).getClass().getName(), type);
		
		intElement = new Element<Integer>(0);
		elem = (Integer) elementField.get(intElement);
		type = (String) typeField.get(intElement);
		assertEquals("The constructor initializes the element field incorrectly", 0, elem.intValue());
		assertEquals("The constructor initializes the type field incorrectly", new Integer(0).getClass().getName(), type);
		
		intElement = new Element<Integer>(42);
		elem = (Integer) elementField.get(intElement);
		type = (String) typeField.get(intElement);
		assertEquals("The constructor initializes the element field incorrectly", 42, elem.intValue());
		assertEquals("The constructor initializes the type field incorrectly", new Integer(42).getClass().getName(), type);
	}
	
	@Test
	public void testConstructorWithStringButIllegalArgument() {
		try {
			strElement = new Element<String>(null);
			fail("The constructor does not throw a correct exception when null is passed in");
		} catch(IllegalArgumentException e) {
			// expected
		}
	}
	
	@Test
	public void testConstructorWithIntButIllegalArgument() {
		try {
			intElement = new Element<Integer>(null);
			fail("The constructor does not throw a correct exception when null is passed in");
		} catch(IllegalArgumentException e) {
			// expected
		}
	}
}