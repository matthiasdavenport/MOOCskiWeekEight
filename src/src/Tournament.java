import java.util.Scanner;

public class Tournament {
    private Skier skier;
    private Scanner reader;

    public Tournament(Scanner reader) {
        this.reader = reader;
    }

    public void start() {
        String name, command;
        int round = 1;

        System.out.println("Kumpula ski jumping week\n");
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase. ");

        System.out.print("  Participant name: ");
        name = this.reader.nextLine();
        if (name.isEmpty()) {}

        else {
            this.skier = new Skier(name);
        }

        while (true) {
            System.out.print("  Participant name: ");
            name = this.reader.nextLine();
            if (name.isEmpty()) {
                break;
            } else {
                Skier ranSkier = new Skier(name);
                this.skier.addSkier(ranSkier);
            }
        }

        System.out.println("\nThe tournament begins!\n");

        while (true) {
            System.out.print("Write \"jump\" to jump; otherwise you quit: ");
            command = reader.nextLine();
            if (command.equals("jump")) {
                System.out.println("\nRound " + round + "\n");
                System.out.println("Jumping order: ");

                this.skier.sort();

                this.skier.jumping();

                System.out.println("\nResults of round " + round);
                System.out.println(this.skier.getRoundResults());
                round++;

            } else {
                this.skier.sort();
                this.skier.reverse();
                System.out.println(this.skier.getTournamentResults());
                break;
            }
        }
    }


}
