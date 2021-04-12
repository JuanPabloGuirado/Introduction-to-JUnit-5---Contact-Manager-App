package com.JuanP.JUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ContactManagerTest {

	/**
	 * Testing if a contact is created successfully
	 * Verifying the expected output with the actual output using Assertions class from JUnit 
	**/
	@Test
	public void shouldCreateContact() {
		ContactManager contactManager = new ContactManager();
		contactManager.addContact("Juan", "Perez", "0123456789");
		//After adding the contact we check if list is empty
		Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
		//Next we are checking if there's exactly one element in the list
		Assertions.assertEquals(1, contactManager.getAllContacts().size());
	}
}
