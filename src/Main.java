import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ContactBook contactBook = new ContactBook();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("PRESS [1] TO ADD CONTACT");
            System.out.println("PRESS [2] TO LIST CONTACTS");
            System.out.println("PRESS [3] TO DELETE CONTACT");
            System.out.println("PRESS [4] TO EDIT CONTACT");
            System.out.println("PRESS [0] TO EXIT");

            String choice = sc.next();

            if (choice.equals("1")) {
                System.out.println("Insert name:");
                String name = sc.next();
                System.out.println("Insert surname:");
                String surname = sc.next();
                System.out.println("Insert phone:");
                String phone = sc.next();

                Contact contact = new Contact();
                contact.setName(name);
                contact.setSurname(surname);
                contact.setPhone(phone);

                contactBook.addContact(contact);

            } else if (choice.equals("2")) {

                contactBook.printContacts();

            } else if (choice.equals("3")) {

                System.out.println("Insert index to delete:");
                int index = sc.nextInt();
                contactBook.deleteContact(index - 1);
                System.out.println("Contact deleted successfully!");

            } else if (choice.equals("4")) {

                contactBook.printContacts();

                System.out.println("Choose index to edit contact:");
                int index = sc.nextInt();

                System.out.println("Insert new name: ");
                String name = sc.next();
                System.out.println("Insert new surname: ");
                String surname = sc.next();
                System.out.println("Insert new phone: ");
                String phone = sc.next();

                Contact newContact = new Contact();
                newContact.setName(name);
                newContact.setSurname(surname);
                newContact.setPhone(phone);

                contactBook.updateContact(index-1, newContact);
                System.out.println("Contact updated successfully!");

            } else if (choice.equals("0")) {
                break;
            } else {
                System.out.println("Incorrect Command");
            }
        }
    }
}