import java.util.ArrayList;
import java.util.Collections;

public class Skier implements Comparable<Skier> {
    private ArrayList<Skier> skiers;
    private ArrayList<Jump> jumps;
    private String name;

    public Skier(String name) {
        this.skiers = new ArrayList<Skier>();
        this.name = name;
    }

    public void addSkier(Skier skier) {
       skiers.add(skier);
    }


    public int jumpsTotal() {
        int total = 0;
       for(Jump each : this.jumps) {
          total += each.getTotal();
       }
       return total;
    }

    public String getName() {
        return this.name;
    }

    public void printJumpingOrder() {
        int counter = 1;
        this.skiers.sort();
        for(Skier each : this.skiers) {
            System.out.println("  " + counter + ". " + each.getName() + "(" + each.jumpsTotal() + " points)");
        }
    }

    @Override
    public int compareTo(Skier skier) {
        return this.jumpsTotal() - skier.jumpsTotal();
    }

    private void sort() {
        Collections.sort(this.skiers);
    }


}


