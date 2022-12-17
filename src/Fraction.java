import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

public class Fraction {

    private String name;
    private ArrayList<Deputy> fraction;

    Scanner sc = new Scanner(System.in);

    public Fraction(String name, ArrayList<Deputy> fraction) {
        this.name = name;
        this.fraction = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Fraction setName(String name) {
        this.name = name;
        return this;
    }

    public ArrayList<Deputy> getFraction() {

        return fraction;
    }

    public Fraction setFruction(ArrayList<Deputy> fruction) {
        this.fraction = fruction;
        return this;
    }


    public void addDeputy() {
        System.out.println("Введіть ім'я: ");
        String name = sc.next();
        System.out.println("Введіть прізвище: ");
        String surname = sc.next();
        Random r = new Random();
        int weight = r.nextInt(100 - 50);
        int hight = r.nextInt(190 - 150);
        int age = r.nextInt(55 - 22);
        System.out.print("Взятки брав: ");
        boolean bribeman = sc.nextBoolean();
        if (bribeman) {
            System.out.print("Скільки?: ");
            int growthInt = sc.nextInt();
            fraction.add(new Deputy(weight, hight, surname, name, age, bribeman, growthInt));
        } else if (!bribeman) {
            fraction.add(new Deputy(weight, hight, surname, name, age, bribeman, 0));
        }
    }

    public void removeDeputy() {
        System.out.print("Введіть ім'я фракції:");
        String name = sc.next();
        Iterator<Deputy> iterator = fraction.iterator();
        while (iterator.hasNext()) {
            Deputy findDeputy = iterator.next();
            if (findDeputy.getName().toLowerCase().equals(name.toLowerCase())) {
                iterator.remove();
            }
        }
    }

    public void allDeputyFraction() {
        fraction.forEach(d -> System.out.println(d));
    }

    public void deleteAllDeputy() {
        fraction.removeAll(fraction);
    }
}
