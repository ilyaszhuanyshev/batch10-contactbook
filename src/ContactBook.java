import java.io.*;
import java.util.ArrayList;

public class ContactBook {

    private ArrayList<Contact> memory;

    public ContactBook() {
        loadMemory();
    }

    public void addContact(Contact contact) {
        loadMemory();
        memory.add(contact);
        saveMemory();
    }

    public ArrayList<Contact> getContacts() {
        loadMemory();
        return memory;
    }

    public void printContacts() {
        loadMemory();
        for (int i = 0; i < memory.size(); i++) {
            System.out.println((i + 1) + ") " + memory.get(i));
        }
    }

    public void deleteContact(int index) {
        loadMemory();
        memory.remove(index);
        saveMemory();
    }

    public void updateContact(int index, Contact contact) {
        loadMemory();
        memory.set(index, contact);
        saveMemory();
    }

    private void saveMemory() {
        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("memory.txt"));
            for (Contact contact : memory) {
                bufferedWriter.write(contact.getName() + "\n");
                bufferedWriter.write(contact.getSurname() + "\n");
                bufferedWriter.write(contact.getPhone() + "\n");
            }
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadMemory() {

        memory = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("memory.txt"));
            String name;
            while ((name = bufferedReader.readLine()) != null) {
                Contact contact = new Contact();
                contact.setName(name);
                String surname = bufferedReader.readLine();
                String phone = bufferedReader.readLine();
                contact.setSurname(surname);
                contact.setPhone(phone);
                memory.add(contact);
            }
            bufferedReader.close();
        } catch (Exception e) {
            try {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("memory.txt"));
                bufferedWriter.write("");
                bufferedWriter.close();
            } catch (Exception ex) {
            }
        }
    }

}
