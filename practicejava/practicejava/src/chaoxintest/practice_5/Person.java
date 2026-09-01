package chaoxintest.practice_5;

public class Person {

    private long id;
    private String name;

    public Person(long id, String name) {
        this.id = id;
        this.name = name;
    }

}
class Student extends Person{
    private String school;

    public Student(long id, String name, String school) {
        super(id, name);
        this.school = school;
    }


    }
