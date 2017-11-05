package snake.wrapper.test;

import static org.junit.Assert.*;

import java.lang.reflect.Field;


import org.junit.Before;
import org.junit.Test;

import snake.wrapper.Element;

@SuppressWarnings("unchecked")
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
	
	@Test
	public void testConstructorWithString() throws Exception {
		testConstructorWithString("");
		testConstructorWithString("JOij983JIEJijwo3 oiJI");
		testConstructorWithString(" 823 jIODJ oiwj");
	}
	
	@Test
	public void testConstructorWithInt() throws Exception {
		testConstructorWithInt(-40);
		testConstructorWithInt(0);
		testConstructorWithInt(42);
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
	
	private void testConstructorWithString(String str) throws Exception {
		String elem;
		Class<String> type;
		
		strElement = new Element<String>(str);
		elem = (String) elementField.get(strElement);
		type = (Class<String>) typeField.get(strElement);
		assertEquals("The constructor initializes the element field incorrectly", str, elem);
		assertEquals("The constructor initializes the type field incorrectly", str.getClass(), type);
	}
	
	private void testConstructorWithInt(Integer val) throws Exception {
		Integer elem;
		Class<Integer> type;
		
		intElement = new Element<Integer>(val);
		elem = (Integer) elementField.get(intElement);
		type = (Class<Integer>) typeField.get(intElement);
		assertEquals("The constructor initializes the element field incorrectly", val.intValue(), elem.intValue());
		assertEquals("The constructor initializes the type field incorrectly", val.getClass(), type);
	}
}