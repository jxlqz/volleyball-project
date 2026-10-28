import java.util.ArrayList;
import java.util.Scanner;
public class Draft {


    public static Player choosePlayer(ArrayList<Player> players, Scanner input) {
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i+1) + "." + players.get(i));
        }

        System.out.print("Choose a player: ");
        int choice = input.nextInt();
        input.nextLine();
        Player chosenPlayer = players.remove(choice - 1);
        System.out.print("Choose a name for your player: ");
        String newName = input.nextLine();

        chosenPlayer.setName(newName);

        return chosenPlayer;
    }

    public static Player chooseBestAttackPlayer(ArrayList<Player> players) {
        Player best = players.get(0);

        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getAttack() > best.getAttack()) {
                best = players.get(i);
            }
        }

        players.remove(best);
        return best;
    }

    public static Player chooseBestReceivePlayer(ArrayList<Player> players) {
        Player best = players.get(0);

        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getReceive() > best.getReceive()) {
                best = players.get(i);
            }
        }

        players.remove(best);
        return best;
    }

    public static Player chooseBestSettingPlayer(ArrayList<Player> players) {
        Player best = players.get(0);

        for (int i = 1; i < players.size(); i++) {
            if (players.get(i).getSetting() > best.getSetting()) {
                best = players.get(i);
            }
        }

        players.remove(best);
        return best;
    }




}