public class Person{
    private String name;
    private int age;
    public Person(String intialName) {
            this.age = 0;
            this.name = intialName;
    }
    public void printPerson() {
            System.out.println(this.name + ", age" + this.age + " years");
    }
        }
