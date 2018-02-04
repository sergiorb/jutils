package es.sergiorb.java;

import java.util.Collection;
import java.util.HashSet;
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

	public static <E> boolean isCollectionWithContent(Collection<E> collection) {

		return collection != null && !collection.isEmpty();
	}

	public static <E> boolean isCollectionNullOrVoid(Collection<E> collection) {

		return collection == null || collection.isEmpty();
	}

	@SafeVarargs
	public static <E> boolean allCollectionsWithContent(Collection<E> ...collections) {
		
		if (collections == null) {
		
			return false;
		}
	
		for (Collection<E> collection : collections) {
			
			if (Jutils.isCollectionNullOrVoid(collection)) {
				
				return false;
			}
		}
		
		return true;
	}
	
	@SafeVarargs
	public static <E> boolean allCollectionsNullOrVoid(Collection<E> ...collections) {
		
		if (collections == null) {
			
			return true;
		}
	
		for (Collection<E> collection : collections) {
			
			if (Jutils.isCollectionWithContent(collection)) {
				
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean isMail(String value) {
		
		if (value == null) {
			
			return false;
		}

		return emailPatternRFC2822.matcher(value).find();
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

	public static <E> boolean valueExistInAllESets(Long value, List<Set<E>> setsList) {

		int requiredOccurrences = setsList.size();

		int occurrences = 0;

		for (int i = 0; i < setsList.size(); i++) {

			if (setsList.get(i).contains(value)) {

				occurrences++;
			}
		}

		return occurrences == requiredOccurrences;
	}

	public static Set<Long> getCommonLongValues(List<Set<Long>> setsList) {

		Set<Long> commonValues = new HashSet<>();

		setsList.stream().forEach(set -> {

			set.stream().forEach(value -> {

				if (Jutils.valueExistInAllESets(value, setsList)) {

					commonValues.add(value);
				}
			});
		});

		return commonValues;
	}


}