import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ContactBook contactBook = new ContactBook();
        Scanner sc = new Scanner(System.in);
        String key;

        while (true) {

            clearConsole();
            System.out.println("PRESS [1] TO ADD CONTACT");
            System.out.println("PRESS [2] TO LIST CONTACTS");
            System.out.println("PRESS [3] TO DELETE CONTACT");
            System.out.println("PRESS [4] TO EDIT CONTACT");
            System.out.println("PRESS [0] TO EXIT");

            String choice = sc.next();

            if (choice.equals("1")) {

                clearConsole();
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
                System.out.println("Contact added successfully!");
                System.out.println("\nPress any key to continue...");
                key = sc.next();

            } else if (choice.equals("2")) {

                clearConsole();
                contactBook.printContacts();
                System.out.println("\nPress any key to continue...");
                key = sc.next();

            } else if (choice.equals("3")) {

                clearConsole();
                contactBook.printContacts();
                System.out.println("Insert index to delete:");
                int index = sc.nextInt();
                contactBook.deleteContact(index - 1);
                System.out.println("Contact deleted successfully!");
                System.out.println("\nPress any key to continue...");
                key = sc.next();

            } else if (choice.equals("4")) {

                clearConsole();
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
                System.out.println("\nPress any key to continue...");
                key = sc.next();

            } else if (choice.equals("0")) {
                break;
            } else {
                clearConsole();
                System.out.println("Incorrect Command");
                System.out.println("\nPress any key to continue...");
                key = sc.next();
            }
        }
    }

    private static void clearConsole() {
        try {
            String operatingSystem = System.getProperty("os.name"); // Check the current operating system

            if (operatingSystem.contains("Windows")) {
                // Clears the console for Windows
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Clears the console for Unix/Linux
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}