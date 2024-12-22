import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ContactServiceTest {

    private ContactService service;

    @BeforeEach
    public void setup() {
        service = new ContactService();
    }

    @Test
    void testAddContactSuccess() {
        Contact contact = new Contact("12345", "Landon", "Phillips", "5555555555", "123 Dallas tx");
        service.addContact(contact);
        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    void testAddContactDuplicateIdFails() {
        Contact contact = new Contact("12345", "Landon", "Phillips", "5555555555", "123 Dallas tx");
        service.addContact(contact);
        assertThrows(IllegalArgumentException.class, () -> service.addContact(new Contact("12345", "John", "Doe", "0987654321", "456 Elm St")));
    }

    @Test
    void testDeleteContactSuccess() {
        Contact contact = new Contact("12345", "Landon", "Phillips", "5555555555", "123 Dallas tx");
        service.addContact(contact);
        service.deleteContact("12345");
        assertThrows(IllegalArgumentException.class, () -> service.getContact("12345"));
    }

    @Test
    void testUpdateContactFirstName() {
        Contact contact = new Contact("12345", "Landon", "Phillips", "5555555555", "123 Dallas tx");
        service.addContact(contact);
        service.updateContactFirstName("12345", "John");
        assertEquals("John", service.getContact("12345").getFirstName());
    }

    @Test
    void testUpdateContactLastName() {
        Contact contact = new Contact("12345", "Landon", "Phillips", "5555555555", "123 Dallas tx");
        service.addContact(contact);
        service.updateContactLastName("12345", "Smith");
        assertEquals("Smith", service.getContact("12345").getLastName());
    }

    @Test
    void testUpdateContactPhone() {
        Contact contact = new Contact("12345", "Landon", "Phillips", "5555555555", "123 Dallas tx");
        service.addContact(contact);
        service.updateContactPhone("12345", "0987654321");
        assertEquals("0987654321", service.getContact("12345").getPhone());
    }

    @Test
    void testUpdateContactAddress() {
        Contact contact = new Contact("12345", "Landon", "Phillips", "5555555555", "123 Dallas tx");
        service.addContact(contact);
        service.updateContactAddress("12345", "456 Elm St");
        assertEquals("456 Elm St", service.getContact("12345").getAddress());
    }
}
