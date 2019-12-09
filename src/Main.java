import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ContactList contactList = new ContactList();
        /*
        Main menu:

        1. get all contacts
        2. add contact
        3. remove contact
        4. edit contact

         */

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
                System.out.println();
        }

        /*
        Main menu -> get all contacts

        */


        /*
        Main menu -> add contact

        Name: ***
        Number: ***

        */

        /*
        Main menu -> remove contact

        Name: ***

        */

        /*
        Main menu -> edit contact

        Name: ***
        New Name: ***
        New number: ***

        */

    }
}
