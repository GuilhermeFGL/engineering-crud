package com.guilhermefgl.crudsellerclient.util.validor;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CpfValidatorTest {

	@Test
	public void testIsValid() {
		assertFalse(CpfValidator.isValid(null));
		assertFalse(CpfValidator.isValid(""));
		assertFalse(CpfValidator.isValid("asdfghjklqw"));
		assertFalse(CpfValidator.isValid("111"));
		assertFalse(CpfValidator.isValid("111111111111"));
		assertTrue(CpfValidator.isValid("11111111111"));
	}

}
