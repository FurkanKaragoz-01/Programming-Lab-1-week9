
package javaapplication221;


public class Warrior extends GameCharacter implements Attacker {
  private int armor;

    public Warrior(String name, int level, int maxHealth, int armor) {
        super(name, level, maxHealth);
        this.armor = armor;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 10 + armor * 2;
    }

    @Override
    public int takeDamage(int damage) {
        if (!isAlive()) return 0;
        
      
        int reducedDamage = damage - (armor / 2);
        if (reducedDamage < 1) {
            reducedDamage = 1;
        }
        
        return super.takeDamage(reducedDamage);
    }

    @Override
    public int attack(GameCharacter target) {
        if (!isAlive()) {
            System.out.println(getName() + " is defeated and cannot attack.");
            return 0;
        }
        if (target == null || !target.isAlive()) {
            System.out.println("Target is already defeated or invalid.");
            return 0;
        }
        
        int damage = calculatePower() / 4;
        int dealt = target.takeDamage(damage);
        System.out.println(getName() + " (Warrior) attacks " + target.getName() + " dealing " + dealt + " damage.");
        return dealt;
    }

    @Override
    public String getCharacterInfo() {
        return "[Warrior] " + getName() + " | Lvl: " + getLevel() + " | HP: " + getHealth() + "/" + getMaxHealth() + " | Armor: " + armor + " | Power: " + calculatePower();
    }  
}
