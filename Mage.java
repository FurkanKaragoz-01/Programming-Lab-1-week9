
package javaapplication221;


public class Mage extends GameCharacter implements Supporter , Attacker{
 private int mana;

    public Mage(String name, int level, int maxHealth, int mana) {
        super(name, level, maxHealth);
        this.mana = mana;
    }

    @Override
    public int calculatePower() {
        return getLevel() * 8 + mana;
    }

   
    @Override
    public int attack(GameCharacter target) {
        if (!isAlive()) return 0;
        if (target == null || !target.isAlive()) return 0;
        
        
        if (this.mana < 20) {
            System.out.println(getName() + " (Mage) does not have enough mana to attack!");
            return 0;
        }
        
        int power = calculatePower(); 
        this.mana -= 20;
        
        int damage = power / 3;
        int dealt = target.takeDamage(damage);
        System.out.println(getName() + " (Mage) cast an attack on " + target.getName() + " dealing " + dealt + " damage. (Used 20 mana, remaining: " + mana + ")");
        return dealt;
    }

    @Override
    public int heal(GameCharacter target) {
        if (!isAlive()) return 0;
        if (target == null || !target.isAlive()) return 0;
        
       
        if (this.mana < 15) {
            System.out.println(getName() + " (Mage) does not have enough mana to heal!");
            return 0;
        }
        
        this.mana -= 15;
        int healAmount = getLevel() * 2;
        int restored = target.restoreHealth(healAmount);
        System.out.println(getName() + " (Mage) healed " + target.getName() + " restoring " + restored + " HP. (Used 15 mana, remaining: " + mana + ")");
        return restored;
    }

    @Override
    public String getCharacterInfo() {
        return "[Mage] " + getName() + " | Lvl: " + getLevel() + " | HP: " + getHealth() + "/" + getMaxHealth() + " | Mana: " + mana + " | Power: " + calculatePower();
    }  
}
