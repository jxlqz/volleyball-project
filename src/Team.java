import java.util.Scanner;
public class Team {
    private Player mainSetter;
    private Player subSetter;
    private Player mainLibero;
    private Player subLibero;

    private Player mainOutside1;
    private Player mainOutside2;
    private Player subOutside1;
    private Player subOutside2;

    private int playstyle;

    public Team(Player mainSetter, Player subSetter, Player mainLibero, Player subLibero, Player mainOutside1, Player mainOutside2, Player subOutside1, Player subOutside2) {
        this.mainSetter = mainSetter;
        this.subSetter = subSetter;
        this.mainLibero = mainLibero;
        this.subLibero = subLibero;
        this.mainOutside1 = mainOutside1;
        this.mainOutside2 = mainOutside2;
        this.subOutside1 = subOutside1;
        this.subOutside2 = subOutside2;

    }


    public void displayTeam() {
        System.out.println("STARTERS");
        System.out.println("Setter: " + mainSetter.getName());
        System.out.println("Libero: " + mainLibero.getName());
        System.out.println("Outside 1: " + mainOutside1.getName());
        System.out.println("Outside 2: " + mainOutside2.getName());

        System.out.println("\nSUBS");
        System.out.println("Setter: " + subSetter.getName());
        System.out.println("Libero: " + subLibero.getName());
        System.out.println("Outside 1: " + subOutside1.getName());
        System.out.println("Outside 2: " + subOutside2.getName());
    }

    public double getAverageAttack() {
        double total = mainSetter.getAttack() + mainOutside1.getAttack() + mainOutside2.getAttack();
        double average = total / 3.0;

        if (playstyle == 1) {
            average += 10;
        } else if (playstyle == 2) {
            average -= 5;
        }

        return average;
    }

    public double getAverageSetting() {
        double average = mainSetter.getSetting();

        if (playstyle == 1) {
            average -= 5;
        } else if (playstyle == 2) {
            average += 5;
        }

        return average;
    }

    public double getAverageReceive() {
        double total = mainLibero.getReceive() + mainOutside1.getReceive() + mainOutside2.getReceive();

        double average = total / 3.0;

        if (playstyle == 2) {
            average += 10;
        } else if (playstyle == 1) {
            average -= 5;
        }

        return average;
    }

    public int getPlaystyle() {
        return playstyle;
    }

    public void displayTeamStats() {
        System.out.println("\nTEAM STATS");
        System.out.println("Attack Average: " + getAverageAttack());
        System.out.println("Setting Average: " + getAverageSetting());
        System.out.println("Receive Average: " + getAverageReceive());
    }

    public void choosePlaystyle(Scanner input) {
        System.out.println("\nChoose your playstyle: ");
        System.out.println("1. Attack Focused");
        System.out.println("2. Defense Focused");
        System.out.println("3. Balanced");

        System.out.print("Enter your choice: ");
        playstyle = input.nextInt();

        if (playstyle == 1) {
            System.out.println("You choice Attack Focused!");
        } else if (playstyle == 2) {
            System.out.println("You chose Defense Focused!");
        } else if (playstyle == 3) {
            System.out.println("You chose Balanced!");
        }
    }

    public void setPlaystyle(int playstyle) {
        this.playstyle = playstyle;
    }

    public Player getMainSetter() {
        return mainSetter;
    }

    public Player getMainLibero() {
        return mainLibero;
    }

    public Player getMainOutside1() {
        return mainOutside1;
    }

    public Player getMainOutside2() {
        return mainOutside2;
    }




}