import java.util.ArrayList;

public class ContactBook {

    private ArrayList<Contact> memory;

    public ContactBook() {
        memory = new ArrayList<>();
        addContact(new Contact("Ilyas", "Zhuanyshev", "8734545454"));
        addContact(new Contact("Meryema", "Garic", "87353553412"));
        addContact(new Contact("Melik", "Keskiner", "8734999000"));
        addContact(new Contact("Kubra", "Coksurer", "8722222452"));
    }

    public void addContact(Contact contact) {
        memory.add(contact);
    }

    public ArrayList<Contact> getContacts() {
        return memory;
    }

    public void printContacts() {
        for (int i = 0; i < memory.size(); i++) {
            System.out.println((i + 1) + ") " + memory.get(i));
        }
    }

    public void deleteContact(int index){
        memory.remove(index);
    }

    public void updateContact(int index, Contact contact){
        memory.set(index, contact);
    }

}
