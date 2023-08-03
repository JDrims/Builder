public class PersonBuilder {
    private Person person;
    private String name = "";
    private String surname = "";
    private int age = 0;
    private String address = "";

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name.isEmpty()) {
            throw new IllegalStateException("Name undefined");
        }
        if (surname.isEmpty()) {
            throw new IllegalStateException("Surname undefined");
        }
        if (age > 0) {
            person = new Person(name, surname, age);
        } else {
            person = new Person(name, surname);
        }
        person.setAddress(this.address);
        return person;
    }
}
