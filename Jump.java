import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;

public class Jump {
    private int length;
    private ArrayList<Integer> judges;
    private int judgeScore;
    private int total;

    public Jump() {
        this.length = ThreadLocalRandom.current().nextInt(60, 120 + 1);
        this.judgeScore = calculateJudgeScore();
        this.total = this.calculateTotal();
    }


    public int getTotal() {
        return this.total;
    }

    private int calculateTotal() {

        this.total = this.length + this.calculateJudgeScore();

        return this.total;
    }

    public int getLength() {
        return this.length;
    }

    public ArrayList<Integer> getJudgeScores() {
        int judge1, judge2, judge3, judge4, judge5, sum = 0;

        judge1 = ThreadLocalRandom.current().nextInt(10, 20 + 1);
        judge2 = ThreadLocalRandom.current().nextInt(10, 20 + 1);
        judge3 = ThreadLocalRandom.current().nextInt(10, 20 + 1);
        judge4 = ThreadLocalRandom.current().nextInt(10, 20 + 1);
        judge5 = ThreadLocalRandom.current().nextInt(10, 20 + 1);

         this.judges = new ArrayList<Integer>();

        judges.add(judge1);
        judges.add(judge2);
        judges.add(judge3);
        judges.add(judge4);
        judges.add(judge5);

    }

    private int calculateJudgeScore() { //There has to be a better way to do this.
     int sum = 0;

       for(int each : this.judges) {
          sum += each;
       }

       return sum - (Collections.max(this.judges) + Collections.min(this.judges));
    }
}
