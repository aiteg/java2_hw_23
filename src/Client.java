import java.util.List;

public class Client {
    int uniqueID;
    String name;
    int age;
    List<Phone> phones;

    public Client(int uniqueID, String name, int age, List<Phone> phones) {
        this.uniqueID = uniqueID;
        this.name = name;
        this.age = age;
        this.phones = phones;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public int getUniqueID() {
        return uniqueID;
    }

    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "uniqueID=" + uniqueID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phones.toString() +
                '}';
    }
}
