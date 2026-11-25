
package javaapplication221;

import java.util.ArrayList;


public class Team {
 private ArrayList<GameCharacter> members;

    public Team() {
        this.members = new ArrayList<>();
    }

    public void addCharacter(GameCharacter character) {
       
        for (GameCharacter c : members) {
            if (c.getName().equalsIgnoreCase(character.getName())) {
                System.out.println("Warning: " + character.getName() + " is already in the team. Duplicate names not allowed!");
                return;
            }
        }
        members.add(character);
        System.out.println(character.getName() + " has been added to the team.");
    }

    public void removeCharacter(String name) {
        GameCharacter toRemove = findByName(name);
        if (toRemove != null) {
            members.remove(toRemove);
            System.out.println(name + " has been removed from the team.");
        } else {
            System.out.println("Character not found: " + name);
        }
    }

    public GameCharacter findByName(String name) {
        for (GameCharacter c : members) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    public void attackAll(GameCharacter target) {
        if (!target.isAlive()) {
            System.out.println("Target " + target.getName() + " is already dead.");
            return;
        }
        System.out.println("\n--- TEAM ALL-OUT ATTACK on " + target.getName() + " ---");
        for (GameCharacter member : members) {
            if (member.isAlive() && member instanceof Attacker) {
                ((Attacker) member).attack(target);
            }
        }
    }

    public void healTeam() {
        System.out.println("\n--- TEAM HEALING PHASE ---");
        for (GameCharacter supporter : members) {
            if (supporter.isAlive() && supporter instanceof Supporter) {
              
                GameCharacter lowestMember = null;
                double lowestRatio = 1.1; 
                
                for (GameCharacter member : members) {
                    if (member.isAlive()) {
                        double ratio = (double) member.getHealth() / member.getMaxHealth();
                        if (ratio < lowestRatio) {
                            lowestRatio = ratio;
                            lowestMember = member;
                        }
                    }
                }
                
                if (lowestMember != null) {
                    ((Supporter) supporter).heal(lowestMember);
                }
            }
        }
    }

    public int getTotalPower() {
        int total = 0;
        for (GameCharacter member : members) {
            if (member.isAlive()) {
                total += member.calculatePower();
            }
        }
        return total;
    }

    public void displayTeam() {
        System.out.println("\n--- TEAM ROSTER (Total Power: " + getTotalPower() + ") ---");
        for (GameCharacter member : members) {
            System.out.println(member.getCharacterInfo() + (member.isAlive() ? "" : " [DEFEATED]"));
        }
        System.out.println("----------------------------------------------");
    }   
}
