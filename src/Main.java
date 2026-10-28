import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        PlayerPool pool = new PlayerPool();

        draftPlayers(pool, input);
    }

    public static void draftPlayers(PlayerPool pool, Scanner input) {

        System.out.println("CHOOSE YOUR MAIN SETTER");
        Player mainSetter = Draft.choosePlayer(pool.getSetters(), input);

        System.out.println();

        System.out.println("CHOOSE YOUR SUBSTITUTE SETTER");
        Player subSetter = Draft.choosePlayer(pool.getSetters(), input);

        System.out.println();

        System.out.println("Great choices! Your main setter: " + mainSetter);
        System.out.println("Your substitute setter: " + subSetter);

        System.out.println();

        System.out.println("CHOOSE YOUR MAIN LIBERO");
        Player mainLibero = Draft.choosePlayer(pool.getLiberos(), input);

        System.out.println();

        System.out.println("CHOOSE YOUR SUBSTITUTE LIBERO");
        Player subLibero = Draft.choosePlayer(pool.getLiberos(), input);

        System.out.println();

        System.out.println("Great choices! Your main libero: " + mainLibero);
        System.out.println("Your substitute libero: " + subLibero);

        System.out.println();

        System.out.println("CHOOSE YOUR FIRST MAIN OUTSIDE");
        Player mainOutside1 = Draft.choosePlayer(pool.getOutsides(), input);

        System.out.println();

        System.out.println("CHOOSE YOUR SECOND MAIN OUTSIDE");
        Player mainOutside2 = Draft.choosePlayer(pool.getOutsides(), input);

        System.out.println();

        System.out.println("CHOOSE YOUR FIRST SUBSTITUTE OUTSIDE");
        Player subOutside1 = Draft.choosePlayer(pool.getOutsides(), input);

        System.out.println();

        System.out.println("CHOOSE YOUR SECOND SUBSTITUTE OUTSIDE");
        Player subOutside2 = Draft.choosePlayer(pool.getOutsides(), input);

        System.out.println();

        System.out.println("Great choices! Your main outsides: "
                + mainOutside1 + " and " + mainOutside2);

        System.out.println("Your substitute outsides: "
                + subOutside1 + " and " + subOutside2);

        Team team = new Team(
                mainSetter,
                subSetter,
                mainLibero,
                subLibero,
                mainOutside1,
                mainOutside2,
                subOutside1,
                subOutside2
        );

        System.out.println("\nYOUR TEAM");
        team.displayTeam();

        team.choosePlaystyle(input);
        team.displayTeamStats();

        int cpuPlaystyle;

        if (team.getAverageAttack() > team.getAverageReceive()) {
            cpuPlaystyle = 2;
        } else if (team.getAverageReceive() > team.getAverageAttack()) {
            cpuPlaystyle = 1;
        } else {
            cpuPlaystyle = 3;
        }

        Player cpuMainSetter =
                Draft.chooseBestSettingPlayer(pool.getSetters());

        Player cpuSubSetter =
                Draft.chooseBestSettingPlayer(pool.getSetters());

        Player cpuMainLibero =
                Draft.chooseBestReceivePlayer(pool.getLiberos());

        Player cpuSubLibero =
                Draft.chooseBestReceivePlayer(pool.getLiberos());

        Player cpuMainOutside1;
        Player cpuMainOutside2;

        if (cpuPlaystyle == 1) {

            cpuMainOutside1 =
                    Draft.chooseBestAttackPlayer(pool.getOutsides());

            cpuMainOutside2 =
                    Draft.chooseBestAttackPlayer(pool.getOutsides());

        } else if (cpuPlaystyle == 2) {

            cpuMainOutside1 =
                    Draft.chooseBestReceivePlayer(pool.getOutsides());

            cpuMainOutside2 =
                    Draft.chooseBestReceivePlayer(pool.getOutsides());

        } else {

            cpuMainOutside1 =
                    Draft.chooseBestAttackPlayer(pool.getOutsides());

            cpuMainOutside2 =
                    Draft.chooseBestReceivePlayer(pool.getOutsides());
        }

        Player cpuSubOutside1 = pool.getOutsides().remove(0);
        Player cpuSubOutside2 = pool.getOutsides().remove(0);

        Team cpuTeam = new Team(
                cpuMainSetter,
                cpuSubSetter,
                cpuMainLibero,
                cpuSubLibero,
                cpuMainOutside1,
                cpuMainOutside2,
                cpuSubOutside1,
                cpuSubOutside2
        );

        cpuTeam.setPlaystyle(cpuPlaystyle);

        System.out.println("\nCPU TEAM");
        cpuTeam.displayTeam();

        System.out.println("\nCPU TEAM STATS");
        cpuTeam.displayTeamStats();

        System.out.println("\nCPU SERVES");

        System.out.println("What serve are you preparing for?");
        System.out.println("1. Jumpserve");
        System.out.println("2. Float serve");
        int preparation = input.nextInt();

        int target =(int)(Math.random() * 100);

        Player receiver;

        if (target < 40) {
            receiver = team.getMainLibero();
        } else if (target < 67) {
            receiver = team.getMainOutside1();
        } else if (target < 94) {
            receiver = team.getMainOutside2();
        } else {
            receiver = team.getMainSetter();
        }
        int serveType = (int)(Math.random() * 4);

        String serve;

        int serveCategory;
        if (serveType == 0) {
            serve = "Jump Serve";
            serveCategory = 1;
        } else if (serveType == 1) {
            serve = "Float Serve";
            serveCategory = 2;
        } else if (serveType == 2) {
            serve = "Jump Float";
            serveCategory = 2;
        } else {
            serve = "Hybrid Serve";
            serveCategory = (int)(Math.random() * 2) + 1;
        }
        System.out.println("CPU used a " + serve +"!");

        boolean preparedCorrectly = preparation == serveCategory;

        if (preparedCorrectly) {
            System.out.println("Good job! You read the serve right.");

        } else {
            System.out.println("You prepared for the wrong serve!");
        }
        System.out.println("The serve goes to " + receiver.getName() + "!");

        int receiveScore = receiver.getReceive();

        if (preparedCorrectly) {
            receiveScore += 10;
        } else {
            receiveScore -= 10;
        }

        receiveScore += (int)(Math.random() * 41) - 20;
        int passQuality;

        if (receiveScore >= 90) {
            System.out.println("PERFECT PASS! 3/3");
            passQuality = 3;
        } else if (receiveScore >= 75) {
            System.out.println("GOOD PASS! 2/3");
            passQuality = 2;
        } else if (receiveScore >= 60) {
            System.out.println("BAD PASS! 1/3");
            passQuality = 1;
        } else if (receiveScore >= 40) {
            System.out.println("SHANK!");
            passQuality = 0;
        } else {
            System.out.println("ACE!");

            passQuality = -1;
        }

        if (passQuality == -1) {
            System.out.println("CPU wins the point!");
            return;
        }

        if (passQuality == 0) {
            System.out.println("The pass is shanked!");

            int saveChance = (int)(Math.random() * 100);

            if (saveChance < 60) {
                System.out.println("Your team manages to save the ball!");
                passQuality = 1;
            } else {
                System.out.println("Nobody saved it! CPU wins the point.");
                return;
            }
        }

        System.out.println("\n Who do you want to set?");
        System.out.println("1. " + team.getMainOutside1().getName());
        System.out.println("2. " + team.getMainOutside2().getName());

        int hitterChoice = input.nextInt();

        Player hitter;

        if (hitterChoice == 1) {
            hitter = team.getMainOutside1();
        } else {
            hitter = team.getMainOutside2();
        }

        System.out.println(team.getMainSetter().getName() + " sets " + hitter.getName() + "!");

        int settingScore = team.getMainSetter().getSetting();

        if (passQuality == 3) {
            settingScore += 15;
        } else if (passQuality == 2) {
            settingScore += 5;
        } else {
            settingScore -= 15;
        }

        settingScore += (int)(Math.random() * 21) - 10;

        int setQuality;

        if (settingScore >= 90) {
            System.out.println("PERFECT SET!");
            setQuality = 3;
        } else if (settingScore >= 75) {
            System.out.println("GOOD SET!");
            setQuality = 2;
        } else if (settingScore >= 55) {
            System.out.println("BAD SET!");
            setQuality = 1;
        } else {
            System.out.println("SETTING ERROR! CPU wins the point.");
            return;
        }

        
    }
}