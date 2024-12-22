import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // Map to store contacts using their unique contact ID as the key
    private final Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact to the service
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID must be unique");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Retrieve a contact by its ID
    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        return contacts.get(contactId);
    }

    // Delete a contact by its ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactId);
    }

    // Update the first name of a contact by its ID
    public boolean updateContactFirstName(String contactId, String firstName) {
        Contact contact = getContact(contactId);
        if (contact != null) {
            contact.setFirstName(firstName);
            return true;
        }
        return false;
    }

    // Update the last name of a contact by its ID
    public boolean updateContactLastName(String contactId, String lastName) {
        Contact contact = getContact(contactId);
        if (contact != null) {
            contact.setLastName(lastName);
            return true;
        }
        return false;
    }

    // Update the phone number of a contact by its ID
    public boolean updateContactPhone(String contactId, String phone) {
        Contact contact = getContact(contactId);
        if (contact != null) {
            contact.setPhone(phone);
            return true;
        }
        return false;
    }

    // Update the address of a contact by its ID
    public boolean updateContactAddress(String contactId, String address) {
        Contact contact = getContact(contactId);
        if (contact != null) {
            contact.setAddress(address);
            return true;
        }
        return false;
    }
}
