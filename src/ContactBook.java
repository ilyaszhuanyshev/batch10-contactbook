import java.io.*;
import java.util.ArrayList;

public class ContactBook {

    private ArrayList<Contact> memory;

    public ContactBook() {
        //loadMemory();
        loadData();
    }

    public void addContact(Contact contact) {
        //loadMemory();
        loadData();
        memory.add(contact);
        //saveMemory();
        saveData();
    }

    public ArrayList<Contact> getContacts() {
        //loadMemory();
        loadData();
        return memory;
    }

    public void printContacts() {
        //loadMemory();
        loadData();
        for (int i = 0; i < memory.size(); i++) {
            System.out.println((i + 1) + ") " + memory.get(i));
        }
    }

    public void deleteContact(int index) {
        //loadMemory();
        loadData();
        memory.remove(index);
        //saveMemory();
        saveData();
    }

    public void updateContact(int index, Contact contact) {
        //loadMemory();
        loadData();
        memory.set(index, contact);
        //saveMemory();
        saveData();
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

    private void loadData() {
        try {

            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("memory.data"));
            memory = (ArrayList<Contact>) inputStream.readObject();
            inputStream.close();
            if (memory == null) {
                memory = new ArrayList<>();
            }

        } catch (Exception e) {
            try {
                memory = new ArrayList<>();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("memory.data"));
                objectOutputStream.writeObject(memory);
                objectOutputStream.close();
            } catch (Exception ex) {
            }
        }
    }

    private void saveData() {
        try {

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("memory.data"));
            objectOutputStream.writeObject(memory);
            objectOutputStream.close();

        } catch (Exception e) {

        }
    }

}
