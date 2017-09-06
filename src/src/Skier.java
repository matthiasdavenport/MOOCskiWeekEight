import java.util.ArrayList;
import java.util.Collections;

public class Skier implements Comparable<Skier> {
    private ArrayList<Skier> skiers;
    private ArrayList<Jump> jumps;
    private String name;

    public Skier(String name) {
        this.skiers = new ArrayList<Skier>();
        this.jumps = new ArrayList<Jump>();
        this.name = name;
        this.skiers.add(this);
    }

    public void addSkier(Skier skier) {
       this.skiers.add(skier);
    }

    public void addJump() {
        Jump jump = new Jump();
        this.jumps.add(jump);
    }

    public int jumpsTotal() {
        int total = 0;
        if(this.jumps.size() > 0) {
            for (Jump each : this.jumps) {
                total += each.getTotal();
            }
        }

       return total;
    }

    public ArrayList<Jump> getJumps() {
        return this.jumps;
    }

    public String getName() {
        return this.name;
    }

    public void jumping() {
        int counter = 1;
        for(Skier each : this.skiers) {
            System.out.println("  " + counter + ". " + each.getName() + " (" + each.jumpsTotal() + " points)");
            each.addJump();
            counter++;
        }
    }

    public String getRoundResults() {
        int i = this.jumps.size() - 1;
        String returnStatement = "";
        ArrayList<Jump> eachJumps;
        for(Skier each : this.skiers) {
            eachJumps = each.getJumps();

            returnStatement += "  " + each.getName() + "\n";

            returnStatement += "    length: " + eachJumps.get(i).getLength() + "\n";
            returnStatement += "    judge votes: " + eachJumps.get(i).getJudgeScores() + "\n\n";

        }

        return returnStatement;
    }

    public String getTournamentResults() {
        String returnStatement = "";
        int i = 0;
        returnStatement += "\nThanks!\n\n";
        returnStatement += "Tournament results: \n";
        returnStatement += "Position    Name\n";

        for(Skier each : this.skiers) {
            returnStatement += (i + 1) + "           " + each.getName() + " (" + each.jumpsTotal() + ")\n";
            returnStatement += "            jump lengths:";
            returnStatement += each.getJumpLengths(each);
        }
        return returnStatement;
    }

    public String getJumpLengths(Skier skier) {
        String returnStatement = "";
       ArrayList<Jump> jumps = skier.getJumps();
       for(int i = 0; i < jumps.size() - 1; i++) {
           returnStatement += " " + jumps.get(i).getLength() + " m,";
       }
       int i = jumps.size();
       returnStatement += " " + jumps.get(i - 1).getLength() + " m\n";

       return returnStatement;
    }

    @Override
    public int compareTo(Skier skier) {
        return this.jumpsTotal() - skier.jumpsTotal();
    }

    public void sort() {
        Collections.sort(this.skiers);
    }

    public void reverse() {
        Collections.reverse(this.skiers);
    }


}


