public class Contact {

    private String name;
    private String surname;
    private String phone;

    public Contact(){
        this.name = "No Name";
        this.surname = "No Surname";
        this.phone = "No Phone";
    }

    public Contact(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return getName() + " - " + getSurname() + " - " + getPhone();
    }
}
