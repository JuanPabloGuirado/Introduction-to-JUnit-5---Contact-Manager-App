package com.JuanP.JUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ContactManagerTest {
	
	ContactManager contactManager;
	
	//Trying out the different test life cycle phases
	@BeforeAll
	public void setupAll() {
		System.out.println("Should print before all tests");
	}
	
	//creating an instance of ContactManager with @BeforeEach
	@BeforeEach
	public void setup() {
		contactManager = new ContactManager();
	}
	
	/**
	 * Testing if a contact is created successfully
	 * Verifying the expected output with the actual output using Assertions class from JUnit 
	**/
	@Test
	public void shouldCreateContact() {
		contactManager.addContact("Juan", "Perez", "0123456789");
		//After adding the contact we check if list is empty
		Assertions.assertFalse(contactManager.getAllContacts().isEmpty());
		//Next we are checking if there's exactly one element in the list
		Assertions.assertEquals(1, contactManager.getAllContacts().size());
		//
		Assertions.assertTrue(contactManager.getAllContacts().stream()
				.filter(contact -> contact.getFirstName().equals("Juan") &&
						contact.getLastName().equals("Perez") &&
						contact.getPhoneNumber().equals("0123456789"))
				.findAny()
				.isPresent());
	}
	
	@Test
	@DisplayName("Should not create contact when first name is null")
	public void shouldThrowRuntimeExceptionWhenFirstNameIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			contactManager.addContact(null, "Perez", "0123456789");
		});
	}
	
	@Test
	@DisplayName("Should not create contact when last name is null")
	public void shouldThrowRuntimeExceptionWhenLastNameIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			contactManager.addContact("Juan", null, "0123456789");
		});
	}
	
	@Test
	@DisplayName("Should not create contact when phone number is null")
	public void shouldThrowRuntimeExceptionWhenPhoneNumberIsNull() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			contactManager.addContact("Juan", "Perez", null);
		});
	}	
	
	@AfterEach
	public void tearDown() {
		System.out.println("Should print after each test");
	}	
	
	@AfterAll
	public void tearDownAll() {
		System.out.println("Should be executed at the end of the test");
	}
}
