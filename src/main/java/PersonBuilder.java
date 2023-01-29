public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String city;
    protected boolean hasAge = false;
    protected boolean hasAddress = false;

    public PersonBuilder setName(String name) throws IllegalArgumentException {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Необходимо задать имя");
        } else this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) throws IllegalArgumentException {
        if (surname == null || surname.isEmpty()) {
            throw new IllegalArgumentException("Необходимо задать фамилию");
        } else this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Возраст указан некорректно(отрицательное число)");
        } else {
            this.age = age;
            this.hasAge = true;
        }
        return this;
    }

    public PersonBuilder setCity(String city) {
        this.city = city;
        this.hasAddress = true;
        return this;
    }

    /**
     * метод Person build(), возвращающий объект класса Person с указанными билдеру данными.
     * В случае, если мы билдеру не указали достаточное количество данных (например, не указали фамилию),
     * то метод build() должен выкинуть IllegalStateException с осмысленным сообщением.
     * Если же мы передали неподходящие данные билдеру (например, некорректный возрст builder.setAge(-100)),
     * то именно этот метод должен выкинуть IllegalArgumentException с осмысленным сообщением.
     */
    public Person build() throws IllegalArgumentException {

        if (name == null || surname == null) {
            throw new IllegalStateException("Имя или фамилия не заданы");
        }
        return new Person(name, surname, age, city, hasAge, hasAddress);
    }

}
