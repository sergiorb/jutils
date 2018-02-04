package es.sergiorb.java;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public abstract class Jutils {

	public static Pattern emailPatternRFC2822 = Pattern.compile(
			"(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\""
					+ "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\"
					+ "[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*"
					+ "[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4]"
					+ "[0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|"
					+ "[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a"
					+ "\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");

	public static boolean isEmpty(String value) {

		return value == null || value.isEmpty();
	}

	public static boolean hasContent(String value) {

		return !Jutils.isEmpty(value);
	}

	public static <T> boolean isCollectionWithContent(Collection<T> collection) {

		return collection != null && !collection.isEmpty();
	}

	public static <T> boolean isCollectionNullOrVoid(Collection<T> collection) {

		return collection == null || collection.isEmpty();
	}

	@SafeVarargs
	public static <T> boolean allCollectionsWithContent(Collection<T> ...collections) {
		
		if (collections == null) {
		
			return false;
		}
	
		for (Collection<T> collection : collections) {
			
			if (Jutils.isCollectionNullOrVoid(collection)) {
				
				return false;
			}
		}
		
		return true;
	}
	
	@SafeVarargs
	public static <T> boolean allCollectionsNullOrVoid(Collection<T> ...collections) {
		
		if (collections == null) {
			
			return true;
		}
	
		for (Collection<T> collection : collections) {
			
			if (Jutils.isCollectionWithContent(collection)) {
				
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isMail(String value) {

		return (value == null) ? false : emailPatternRFC2822.matcher(value).find();
	}

	public static <T> Integer[] listToIntegerArray(List<T> list) {

		return (Integer[]) list.toArray(new Integer[list.size()]);
	}

	public static <T> Long[] listToLongArray(List<T> list) {

		return (Long[]) list.toArray(new Long[list.size()]);
	}

	public static <T> Long[] setToLongArray(Set<T> set) {

		return (Long[]) set.toArray(new Long[set.size()]);
	}

}
