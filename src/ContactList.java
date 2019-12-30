import java.lang.reflect.Field;
import java.util.ArrayList;

public class ContactList {
    ArrayList<Contact> contacts = new ArrayList<>();

    public ArrayList<Contact> getContacts() {
        return this.contacts;
    }

    public void printContacts() {
        getContacts().forEach(element -> System.out.println(element.getName() + " - " + element.getNumber()));
    }

    public void addContact(Contact contact) {
        getContacts().add(contact);
    }

    public void removeContact(Contact contact) {
        getContacts().remove(contact);
    }

    public void editContact(Contact oldContact, Contact newContact) {
        Field[] fields = Contact.class.getDeclaredFields();
        for (int  i = 0;i < fields.length;i++) {
            int pos = getContacts().indexOf(oldContact); // get old contacts position
            removeContact(oldContact); // remove old contact in position `pos`
            getContacts().add(pos, newContact); // add new contact on position of old contact
        }
    }
}
