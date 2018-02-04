package es.sergiorb.java;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;


public class JutilsTest {

	@Test
	public void isEmpty_Test() {
		
		assertTrue(Jutils.isEmpty(null));
		assertTrue(Jutils.isEmpty(""));
		assertFalse(Jutils.isEmpty(" "));
	}
	
	@Test
	public void hasContent_Test() {
		
		assertTrue(Jutils.hasContent(" "));
		assertFalse(Jutils.hasContent(""));
		assertFalse(Jutils.hasContent(null));
	}
	
	@Test
	public void isCollectionWithContent_Test() {
		
		Collection<String> stringsCollection = Arrays.asList("A", "B", "C");
		Collection<String> emptyStringsCollection = Arrays.asList();
		
		assertFalse(Jutils.isCollectionWithContent(null));
		assertTrue(Jutils.isCollectionWithContent(stringsCollection));
		assertFalse(Jutils.isCollectionWithContent(emptyStringsCollection));
	}
	
	@Test
	public void isCollectionNullOrVoid_Test() {
		
		Collection<String> stringsCollection = Arrays.asList("A", "B", "C");
		Collection<String> emptyStringsCollection = Arrays.asList();
		
		assertTrue(Jutils.isCollectionNullOrVoid(null));
		assertFalse(Jutils.isCollectionNullOrVoid(stringsCollection));
		assertTrue(Jutils.isCollectionNullOrVoid(emptyStringsCollection));
	}
	
	@Test
	public void allCollectionsWithContent_Test() {
		
		Collection<String> stringsCollectionA = Arrays.asList("A", "B", "C");
		Collection<String> stringsCollectionB = Arrays.asList("A", "B", "C");
		Collection<String> emptyStringsCollection = Arrays.asList();
		Collection<String> nullCollection = null;
		
		assertFalse(Jutils.allCollectionsWithContent(nullCollection));
		assertFalse(Jutils.allCollectionsWithContent(null, null));
		assertFalse(Jutils.allCollectionsWithContent(stringsCollectionA, null));
		assertFalse(Jutils.allCollectionsWithContent(null, stringsCollectionB));
		assertFalse(Jutils.allCollectionsWithContent(stringsCollectionA, emptyStringsCollection));
		assertFalse(Jutils.allCollectionsWithContent(emptyStringsCollection, stringsCollectionB));
		assertTrue(Jutils.allCollectionsWithContent(stringsCollectionA, stringsCollectionB));
	}
	
	@Test
	public void allCollectionsNullOrVoid_Test() {
		
		Collection<String> stringsCollection = Arrays.asList("A", "B", "C");
		Collection<String> emptyStringsCollectioA = Arrays.asList();
		Collection<String> emptyStringsCollectionB = Arrays.asList();
		Collection<String> nullCollection = null;
		
		assertTrue(Jutils.allCollectionsNullOrVoid(nullCollection));
		assertTrue(Jutils.allCollectionsNullOrVoid(null, null));
		assertTrue(Jutils.allCollectionsNullOrVoid(emptyStringsCollectioA, null));
		assertTrue(Jutils.allCollectionsNullOrVoid(null, emptyStringsCollectionB));
		assertFalse(Jutils.allCollectionsNullOrVoid(emptyStringsCollectioA, stringsCollection));
		assertFalse(Jutils.allCollectionsNullOrVoid(stringsCollection, emptyStringsCollectionB));
		assertTrue(Jutils.allCollectionsNullOrVoid(emptyStringsCollectioA, emptyStringsCollectionB));	
	}
	
	@Test
	public void isMail_Test() {
		
		assertFalse(Jutils.isMail(null));
		assertFalse(Jutils.isMail(""));
		assertFalse(Jutils.isMail(" "));
		assertFalse(Jutils.isMail("foo.com"));
		assertFalse(Jutils.isMail("foo@"));
		assertFalse(Jutils.isMail("es.foo@"));
		assertFalse(Jutils.isMail("foo@."));
		assertTrue(Jutils.isMail("foo@bar.es"));	
	}
	
	@Test
	public void listToIntegerArray_Test() {
		
		List<Integer> list = Arrays.asList(1, 2, 3);
				
		assertEquals(Integer[].class, Jutils.listToIntegerArray(list).getClass());
	}
	
	@Test
	public void listToLongArray_Test() {
	
		List<Long> list = Arrays.asList(1L, 2L, 3L);
		
		assertEquals(Long[].class, Jutils.listToLongArray(list).getClass());
	}
	
	@Test
	public void setToLongArray_Test() {
		
		Set<Long> set = new HashSet<>(Arrays.asList(1L, 2L, 3L));
		
		assertEquals(Long[].class, Jutils.setToLongArray(set).getClass());
	}
	
}
