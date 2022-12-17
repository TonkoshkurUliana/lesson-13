public class Human {
    private int weight;
    private int hight;

    public Human(int weight, int hight) {
        this.weight = weight;
        this.hight = hight;
    }

    public int weight() {
        return weight;
    }

    public Human setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public int hight() {
        return hight;
    }

    public Human setHigh(int hight) {
        this.hight = hight;
        return this;
    }

    @Override
    public String toString() {
        return "Human{" +
                "weight=" + weight +
                ", hight=" + hight +
                '}';
    }
}
