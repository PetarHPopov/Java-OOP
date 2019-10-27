package PersonChild;

public class Child extends Person {
    private int age;

    public Child(String name, int age) throws IllegalAccessException {
        super(name, age);
    }

    @Override
    public void setAge(int age) throws IllegalAccessException {
        if (age > 15) {
            throw new IllegalAccessException("Child's age must be lesser than 15!");
        }
        super.setAge(age);
    }
}
