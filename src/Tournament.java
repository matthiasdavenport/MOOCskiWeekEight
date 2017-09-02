import java.util.Scanner;

public class Tournament {
    private Skier skier;
    private Scanner reader;

    public Tournament(Scanner reader) {
        this.reader = reader;
    }

    public void start() {
        String name = "", command = "";
        int round = 1;

        System.out.println("Kumpula ski jumping week\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase");
        while (true) {
            System.out.print("  Participant name: ");
            name = this.reader.nextLine();
            if (name.isEmpty()) {
                break;
            } else {
                skier = new Skier(name);
                this.skier.addSkier(skier);
            }
        }

        System.out.println("\nThe tournament begins!\n");

        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            command = reader.nextLine();
            if (command.equals("jump")) {
                System.out.println("\nRound " + round + "\n");
                System.out.println("Jumping order: ");
                this.skier.printJumpingOrder();

            } else {
                break;
            }
        }
    }


}
