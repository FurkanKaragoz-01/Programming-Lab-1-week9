package javaapplication221;

public abstract class GameCharacter {

    private String name;
    private int level;
    private int health;
    private int maxHealth;

    public GameCharacter(String name, int level, int maxHealth) {
        this.name = name;

        if (level < 1 || level > 100) {
            System.out.println("Warning: Invalid level for " + name + ". Setting to 1.");
            this.level = 1;
        } else {
            this.level = level;
        }

        if (maxHealth < 1) {
            System.out.println("Warning: Invalid maxHealth for " + name + ". Setting to 100.");
            this.maxHealth = 100;
        } else {
            this.maxHealth = maxHealth;
        }

        this.health = this.maxHealth;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public int takeDamage(int damage) {
        if (!isAlive()) {
            return 0;
        }

        int actualDamage = Math.min(this.health, damage);
        this.health -= actualDamage;
        return actualDamage;
    }

    public int restoreHealth(int amount) {
        if (!isAlive()) {
            System.out.println(name + " is defeated and cannot be healed.");
            return 0;
        }

        int space = this.maxHealth - this.health;
        int restored = Math.min(space, amount);
        this.health += restored;
        return restored;
    }

    public abstract String getCharacterInfo();

    public abstract int calculatePower();
}
