package com.guilhermefgl.crudsellerclient.util.validor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NameValidatorTest {

	@Test
	public void testIsValid() {
		assertFalse(NameValidator.isValid(null));
		assertFalse(NameValidator.isValid(""));
		assertFalse(NameValidator.isValid("name"));
		assertFalse(NameValidator.isValid("too long name - :::::::::::::::::::::::::::::::::::"));
		assertTrue(NameValidator.isValid("a valid name"));
	}

}
