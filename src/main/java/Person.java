import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String city;
    protected boolean hasAge;
    protected boolean hasAddress;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.hasAge = false;
        this.hasAddress = false;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.hasAge = true;
        this.hasAddress = false;
    }

    public Person(String name, String surname, int age, String city, boolean hasAge, boolean hasAddress) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.city = city;
        this.hasAge = hasAge;
        this.hasAddress = hasAddress;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Введен отрицательный возраст");
        } else {
            this.age = age;
            hasAge = true;
        }
    }

    /**
     * С момента создания объекта возраст может быть изменён только увеличением на единицу
     * через вызов метода happyBirthday()
     */
    public void happyBirthday() {
        if (hasAge) {
            age++;
        }
    }

    /**
     * Возраст человека может быть неизвестен, в этом случае метод boolean hasAge()
     * должен вернуть false, иначе - true
     */
    public boolean hasAge() {
        return hasAge;
    }

    /**
     * Текущий город жительства (String).
     * Может быть известен (в этом случае метод boolean hasAddress() должен вернуть true,
     * иначе - false) и выставлен в любой через setAddress(String city).
     */
    public boolean hasAddress() {
        return hasAddress;
    }

    public void setAddress(String city) {
        this.city = city;
        hasAddress = true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    // прочитать про OptionalInt
    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getCity() {
        return city;
    }

    /**
     * метод PersonBuilder newChildBuilder(), который будет возвращать полузаполненный билдер для ребёнка,
     * а именно: с уже заполненными фамилией (родительской),
     * возрастом и текущим городом жительства (родительским).
     */
    public PersonBuilder newChildBuilder() {

        return new PersonBuilder()
                .setSurname(surname)
                .setAge(0)
                .setCity(city);
    }

    @Override
    public String toString() {
        return "name = " + name +
                ", {surname = " + surname +
                ", age = " + age +
                ", city = " + city + "}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
