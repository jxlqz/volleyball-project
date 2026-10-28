public class Libero implements Role {

    public String getRoleName() {
        return "Libero";
    }

    public int getMinAttack() {
        return 0;
    }

    public int getMaxAttack() {
        return 0;
    }

    public int getMinSetting() {
        return 55;
    }

    public int getMaxSetting() {
        return 75;
    }

    public int getMinReceive() {
        return 90;
    }

    public int getMaxReceive() {
        return 100;
    }
}