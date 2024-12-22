import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContactTest {

    @Test
    void testCreateContactSuccess() {
        Contact contact = new Contact("12345", "Landon", "Phillips", "5555555555", "123 Dallas TX");
        assertNotNull(contact);
        assertEquals("12345", contact.getContactId());
        assertEquals("Landon", contact.getFirstName());
        assertEquals("Phillips", contact.getLastName());
        assertEquals("5555555555", contact.getPhone());
        assertEquals("123 Dallas TX", contact.getAddress());
    }

    @Test
    void testCreateContactFailsInvalidContactIdTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345678901", "John", "Doe", "1234567890", "123 Elm St"));
    }

    @Test
    void testCreateContactFailsNullContactId() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact(null, "John", "Doe", "1234567890", "123 Elm St"));
    }

    @Test
    void testCreateContactFailsInvalidPhoneNumberTooShort() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Doe", "12345", "123 Elm St"));
    }

    @Test
    void testCreateContactFailsInvalidPhoneNumberTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Doe", "123456789012345", "123 Elm St"));
    }

    @Test
    void testCreateContactFailsInvalidFirstNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "Omarrrrrrrrrrr", "Doe", "1234567890", "123 Elm St"));
    }

    @Test
    void testCreateContactFailsInvalidLastNameTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Doeeeeeeeeee", "1234567890", "123 Elm St"));
    }

    @Test
    void testCreateContactFailsInvalidAddressTooLong() {
        assertThrows(IllegalArgumentException.class, () ->
                new Contact("12345", "John", "Doe", "1234567890", "123 This Address Is Way Too Long To Be Valid"));
    }
}