package com.els.utils;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import com.els.entities.Salaried;

public final class Utils {

	private Utils() {
		throw new IllegalStateException("Utils class");
	}

	/**
	 * this method return the value of property selected
	 * 
	 * @param salaried
	 *            the salaried
	 * @param creteria
	 *            the attribute selected
	 * @return the value of property
	 */
	public static String fetchSalariedProperty(Salaried salaried, String creteria) {
		switch (creteria) {
		case "salariedId":
			return salaried.getSalariedId();
		case "firstName":
			return salaried.getFirstName();
		case "lastName":
			return salaried.getLastName();
		case "tel":
			return salaried.getTel();
		default:
			return "";
		}
	}

	/**
	 * this method return predicate to distinct between salaries by attribute value
	 * 
	 * @param keyExtractor
	 *            function that return the attribute value of salaried
	 * @return predicate
	 */
	public static Predicate<Salaried> distinctByKey(Function<? super Salaried, String> keyExtractor) {
		Set<String> seen = ConcurrentHashMap.newKeySet();
		return t -> {
			String attributeValue = keyExtractor.apply(t);
			if (!attributeValue.isEmpty()) {
				return seen.add(attributeValue);
			}
			return true;
		};
	}
}
