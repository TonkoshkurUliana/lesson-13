import java.util.Scanner;

public class Deputy extends Human {

    private String lastName;
    private String name;
    private int age;
    private boolean bribeMan;
    private int bribe;

    public Deputy(int weight, int hight, String lastName, String name, int age, boolean bribeMan, int intbribe) {
        super(weight, hight);
        this.lastName = lastName;
        this.name = name;
        this.age = age;
        this.bribeMan = bribeMan;
        bribe = intbribe;
    }

    public String getLastName() {
        return lastName;
    }

    public Deputy setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getName() {
        return name;
    }

    public Deputy setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Deputy setAge(int age) {
        this.age = age;
        return this;
    }

    public boolean getBribeMan() {
        return bribeMan;
    }

    public Deputy setBribeMan(boolean bribeMan) {
        this.bribeMan = bribeMan;
        return this;
    }

    public int getBribe() {
        return bribe;
    }

    public Deputy setBribe(int bribe) {
        this.bribe = bribe;
        return this;
    }

    int givebribe() {
        int count = 0;
        if (!this.bribeMan) {
            System.out.println(" Цей депутат не бере хабарів");
        } else {
            System.out.println(" Введіть суму хабаря");
            Scanner sc = new Scanner(System.in);
            count = sc.nextInt();

            if (count > 5000) {
                System.out.println("Поліція ув'язнить депутата");
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return "Deputy{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", bribeMan=" + bribeMan +
                ", bribe=" + bribe +
                '}';
    }
}
