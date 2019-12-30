import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        ContactList contactList = new ContactList();
        mainMenu(contactList);
    }

    public static void mainMenu(ContactList contactList) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Main menu:\n");
        System.out.println("1. get all contacts");
        System.out.println("2. add contact");
        System.out.println("3. remove contact");
        System.out.println("4. edit contact\n");
        System.out.print(">: ");

        int menuChoice = 0;
        Scanner mainMenu = new Scanner(System.in);
        menuChoice = mainMenu.nextInt();

        switch (menuChoice) {
            case 1:

                if (contactList.getContacts().size() <= 0) {
                    System.out.println();
                    System.out.println("No contacts available!");
                    System.out.println();
                    mainMenu(contactList);
                } else {
                    contactList.printContacts();
                    mainMenu(contactList);
                }
                break;
            case 2:
                String[] step2UserData = promptUserForContactCreationData(contactList);
                String step2Name = step2UserData[0];
                String step2Number = step2UserData[1];
                contactList.addContact(new Contact(step2Name, step2Number));
                System.out.println("");
                System.out.println("Contact created!");
                mainMenu(contactList);
                break;
            case 3:
                // print all contacts with indices, eg: 1: name - number

                ArrayList<Contact> contacts = contactList.getContacts();
                printAllContactsWithIndices(contacts);

                // user inputs index of contact to delete

                contactList.removeContact(contacts.get(getUserInputForContactDeletion()));
                // we get the Contact object to delete in contactList and delete it
                // return to main menu
                mainMenu(contactList);

                break;
            case 4:
                // get all contacts with indices
                printAllContactsWithIndices(contactList.getContacts());
                // get contact to delete
                int whichContactToDelete = getUserInputForContactDeletion();
                // add new contact
                String[] step4UserData = promptUserForContactCreationData(contactList);
                String step4UName = step4UserData[0];
                String step4UNumber = step4UserData[1];

                contactList.editContact(contactList.getContacts().get(whichContactToDelete), new Contact(step4UName, step4UNumber));
                // edit
                // main menu
                mainMenu(contactList);
                break;
        }
    }

    public static int getUserInputForContactDeletion() {
        int contactToDeleteIndex;
        Scanner contactToDeleteScanner = new Scanner(System.in);
        contactToDeleteIndex = contactToDeleteScanner.nextInt();
        return contactToDeleteIndex - 1;
    }

    public static void printAllContactsWithIndices(ArrayList<Contact> contacts) throws InvocationTargetException, IllegalAccessException {
        for (int i = 0;i < contacts.size();i++) {
            Contact currentContact = contacts.get(i);
            int currentIndex = i + 1;

            StringBuilder stringBuilder = new StringBuilder();

            for (Method m : currentContact.getClass().getMethods()) {
                if (m.getName().startsWith("get") && m.getParameterTypes().length == 0 && !m.getName().startsWith("getClass")) {
                    stringBuilder
                            .append(m.getName().substring(3))
                            .append(": ")
                            .append(m.invoke(currentContact))
                            .append("   ");
                }
            }

            System.out.println(currentIndex + ": " + stringBuilder.toString());
        }
    }

    // TODO: Unbind function from Contact implementation
    public static String[] promptUserForContactCreationData(ContactList contactList) {
        Field[] fields = Contact.class.getDeclaredFields();
        String name = null;
        String number = null;

        for (int i = 0; i < fields.length; i++) {
            System.out.print("Enter " + fields[i].getName() + ": ");
            String addMenuChoice;
            Scanner addContactMainMenu = new Scanner(System.in);
            addMenuChoice = addContactMainMenu.nextLine();

            if (i == 0) {
                name = addMenuChoice;
            } else if (i == 1) {
                number = addMenuChoice;
            }
        }
        return new String[] {name, number};
    }
}
