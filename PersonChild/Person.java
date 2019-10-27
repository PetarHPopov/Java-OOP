package PersonChild;

public class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws IllegalAccessException {
        this.name = name;
        this.setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) throws IllegalAccessException {
        if (age < 1){
            throw new IllegalAccessException("Age must be positive!");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Age: %d",this.name,this.age);
    }
}
