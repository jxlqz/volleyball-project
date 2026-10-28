class Player {
    private String name;
    private Role role;

    private int attack;
    private int setting;
    private int receive;

    private static int totalStats = 170;


    public Player(String name, Role role) {
        this.name = name;
        this.role = role;
        generateStats();
    }

    private void generateStats() {
        boolean valid = false;

        while (!valid) {
            attack = randomNumber(role.getMinAttack(), role.getMaxAttack());
            setting = randomNumber(role.getMinSetting(), role.getMaxSetting());
            receive = totalStats - attack - setting;

            if (receive >= role.getMinReceive() && receive <= role.getMaxReceive()) {
                valid = true;
            }
        }
    }

    private int randomNumber(int min, int max) {
        return min + (int)(Math.random() * (max - min + 1));
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    public int getAttack() {
        return attack;
    }

    public int getSetting() {
        return setting;
    }

    public int getReceive() {
        return receive;
    }

    public String toString() {
        return name
                + " | Role: " + role.getRoleName()
                + " | Attack: " + attack
                + " | Setting: " + setting
                + " | Receive: " + receive;
    }

    public void setName(String name) {
        this.name = name;
    }
}