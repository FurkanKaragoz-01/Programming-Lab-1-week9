
package javaapplication221;

public class Healer extends GameCharacter implements Supporter {
  private int healAmount;

    public Healer(String name, int level, int maxHealth, int healAmount) {
        super(name, level, maxHealth);
        this.healAmount = healAmount;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 5 + healAmount;
    }

    @Override
    public int heal(GameCharacter target) {
        if (!isAlive()) return 0;
        if (target == null || !target.isAlive()) return 0;
        
        int hpToRestore = healAmount + getLevel();
        int restored = target.restoreHealth(hpToRestore);
        System.out.println(getName() + " (Healer) heals " + target.getName() + " restoring " + restored + " HP.");
        return restored;
    }

    @Override
    public String getCharacterInfo() {
        return "[Healer] " + getName() + " | Lvl: " + getLevel() + " | HP: " + getHealth() + "/" + getMaxHealth() + " | HealAmount: " + healAmount + " | Power: " + calculatePower();
    }  
}
