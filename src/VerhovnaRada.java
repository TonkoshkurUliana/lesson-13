import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class VerhovnaRada extends Exception {
    List<Fraction> goverment = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addFraction() {
        System.out.print("Введіть ім'я фракції: ");
        String name = sc.next();
        goverment.add(new Fraction(name, new ArrayList<Deputy>()));
    }

    public void removeFraction() throws Exception {
        boolean flag = false;
        System.out.print("Введіть ім'я фракції:");
        String name = sc.next();
        Iterator<Fraction> iterator = goverment.iterator();
        while (iterator.hasNext()) {
            Fraction findFraction = iterator.next();
            if (findFraction.getName().equalsIgnoreCase(name)) {
                iterator.remove();
                flag = true;
            } else if (!iterator.hasNext() || flag) {
                throw new Exception("The fuction isn't true");
            }
        }
    }

    public void allFraction() {
        for (Fraction fraction : goverment) {
            System.out.println(fraction.getName());
        }
    }

    public void thisFraction() throws Exception {
        System.out.print("Введіть ім'я фракції:");
        String name = sc.next();

        Fraction fr = findFraction(name);
        if (fr != null) {
            fr.allDeputyFraction();
        } else {
            throw new Exception("The fuction isn't true");
        }
    }


    public void addDeputyToFraction() throws Exception {
        System.out.println("");
        System.out.print("Введіть ім'я фракції:");
        String name = sc.next();

        Fraction fr = findFraction(name);
        if (fr != null) {
            fr.addDeputy();
        } else {
            throw new Exception("The fuction isn't true");
        }

    }

    public void removeDeputyFromFraction() throws Exception {

        System.out.print("Введіть ім'я фракції:");
        String name = sc.next();

        Fraction fr = findFraction(name);
        if (fr != null) {
            System.out.print("Введіть ім'я депутата:");
            String namedeputy = sc.next();
            Iterator<Deputy> iteratodeputy = fr.getFraction().iterator();
            while (iteratodeputy.hasNext()) {
                Deputy findDeputy = iteratodeputy.next();
                if (findDeputy.getName().equalsIgnoreCase(namedeputy)) {
                    iteratodeputy.remove();
                } else {
                    throw new Exception("The fuction isn't true");
                }
            }
        }
    }


    public void biggestBribeDeputy() {
        int max = 0;
        String nameMax = "";
        for (Fraction fraction : goverment) {
            for (Deputy deputy : fraction.getFraction()) {
                if (deputy.getBribeMan()) {
                    if (deputy.getBribe() > max) {
                        max = deputy.getBribe();
                        nameMax = String.valueOf(deputy);
                    }
                }
            }
        }
        System.out.println("Найбільший хабарник " + nameMax);
    }

    public void allBribeDeputy() {

        for (Fraction fraction : goverment) {
            for (Deputy deputy : fraction.getFraction()) {
                if (deputy.getBribeMan()) {
                    System.out.println(deputy);
                }
            }
        }
    }

    public void cleanFraction() throws Exception {
        System.out.print("Введіть ім'я фракції:");
        String name = sc.next();
        Fraction fr = findFraction(name);
        if (fr != null) {
            fr.deleteAllDeputy();
        } else {
            throw new Exception("The fuction isn't true");
        }
    }

    private Fraction findFraction(String name) {
        for (Fraction fraction : goverment) {
            if (fraction.getName().equalsIgnoreCase(name)) {
                return fraction;
            }
        }
        return null;
    }
}