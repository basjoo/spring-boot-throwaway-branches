package com.izeye.throwaway.person.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Person.
 *
 * @author Johnny Lim
 */
@Data
@AllArgsConstructor
public class Person {

	private final String firstName;
	private final String lastName;

}