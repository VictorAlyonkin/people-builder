public class PersonBuilder {
    private String name;
    private String surname;
    private Integer age;
    private String address;


    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(Integer age) {
        if (age < 0)
            throw new IllegalArgumentException("Укажите корректный возраст!");
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (
                this.name == null ||
                        this.surname == null)
            throw new IllegalStateException("Не указаны обязательные поля!");

        this.age = this.age == null ? -1 : this.age;
        this.address = this.address == null ? "" : this.address;
        return new Person(this.name, this.surname, this.age, this.address);
    }
}