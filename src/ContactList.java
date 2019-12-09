public class ContactList {
    String[][] contacts = {};

    public String[][] getContacts() {
        return this.contacts;
    }

    public void printContacts() {
        for (int i = 0;i < getContacts().length;i++) {
            for (int j = 0;j < getContacts()[i].length;j++) {
                // name - number
//                       0                  1
//               [ [name1, name2], [number1, number2] ]

                System.out.println(getContacts()[i] + " - " + getContacts()[i + 1][i]);
            }
        }

        for (i;i < getContacts()) {

        }

        for (j;j < getContacts()[]) {}

    }

}
