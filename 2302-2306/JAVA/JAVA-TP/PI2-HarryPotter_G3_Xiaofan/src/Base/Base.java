package Base;

public class Base {
    public static int HP;
    private static double SA;
    private static int numPotions;

    public Base() {
        this.HP = HP;
        this.SA = SA;
        this.numPotions = numPotions;
    }

    public static int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public static double getSA() {
        return SA;
    }

    public void setSA(double SA) {
        this.SA = SA;
    }

    public static int getNumPotions() {
        return numPotions;
    }

    public void setNumPotions(int numPotions) {
        this.numPotions = numPotions;
    }

    public static void usePotion(){
        numPotions -= 1;
    }

    public static void addPotion(){ numPotions += 1;}
}
