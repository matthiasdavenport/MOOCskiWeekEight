import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Tournament tournament = new Tournament(reader);

        tournament.start();
        // Write your main program here. Implementing your own classes will be very useful.
    }
}