import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private int age;
    private String city;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.age = 0;
        this.city = "";
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = "";
    }

    public boolean hasAge() {
        OptionalInt age = OptionalInt.of(this.age);
        return !age.isEmpty();
    }

    public boolean hasAddress() {
        return !this.city.isEmpty();
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public OptionalInt getAge() {
        if (hasAge()) {
            return OptionalInt.of(this.age);
        } else {
            return OptionalInt.of(0);
        }
    }

    public String getAddress() {
        if (hasAddress()) {
            return this.city;
        } else {
            return "";
        }
    }

    public void setAddress(String address) {
        this.city = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age++;
        }
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() +
                (hasAge() ? " " + getAge().getAsInt() + " лет" : "") +
                (hasAddress() ? " из " + getAddress() : "");
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSurname());
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder personBuilder = new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setAddress(city);
        return personBuilder;
    }
}
