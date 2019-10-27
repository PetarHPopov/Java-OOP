package repository;

public class Person {
    private String name;
    private int age;
    private String birthDate;

    public Person(String name, int age, String birthDate) {
        this.name = name;
        this.age = age;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Name: %s%n",this.name));
        stringBuilder.append(String.format("Age: %d%n",this.age));
        stringBuilder.append(String.format("Birthday: %s",this.birthDate));

      return   stringBuilder.toString().trim();
    }
}
