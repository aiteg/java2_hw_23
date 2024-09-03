public class Phone {
    String number;
    PhoneType phoneType;

    public Phone(String number, PhoneType phoneType) {
        this.number = number;
        this.phoneType = phoneType;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "number='" + number + '\'' +
                ", phoneType=" + phoneType +
                '}';
    }
}
