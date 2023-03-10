import java.util.Objects;

public class Person {
    private final String name;
    private final String surname;
    private Integer age;
    private String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, Integer age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurname(this.surname)
                .setAddress(this.address)
                .setAge(0);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void happyBirthday() {
        if (hasAge())
            this.age++;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean hasAge() {
        return this.age != -1;
    }

    public boolean hasAddress() {
        return !this.address.equals("");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name) &&
                Objects.equals(surname, person.surname) &&
                Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Person: " +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'');

        if (
                age != -1)
            result.append(", age=" + age + '\'');

        if (!address.equals(""))
            result.append(", address='" + address + '\'');

        return result.toString();
    }
}
