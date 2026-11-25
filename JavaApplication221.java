
package javaapplication221;

public class JavaApplication221 {

   
    public static void main(String[] args) {
       System.out.println("=== INITIALIZING LABORATORY PROJECT ===\n");

        
        System.out.println("--- Testing Invalid Inputs ---");
        Warrior invalidLevelChar = new Warrior("Weakling", 150, 100, 10); 
        System.out.println();

        
        Team myTeam = new Team();
        
        Warrior warrior = new Warrior("Furkan", 10, 150, 20); 
        Mage mage = new Mage("Hasan", 12, 100, 50);        
        Healer healer = new Healer("Erdem", 8, 80, 15);     

        myTeam.addCharacter(warrior);
        myTeam.addCharacter(mage);
        myTeam.addCharacter(healer);
        
        
        Warrior duplicate = new Warrior("Thorin", 5, 100, 5);
        myTeam.addCharacter(duplicate); 

        
        Warrior enemy = new Warrior("Golem", 25, 300, 30);
        System.out.println("\nAn enemy appeared: " + enemy.getCharacterInfo());
        
        myTeam.displayTeam();

        
        
       
        System.out.println("\n================= ROUND 1 =================");
        
        myTeam.attackAll(enemy);
        
      
        System.out.println("\n--- ENEMY ATTACK PHASE ---");
        if (enemy.isAlive()) {
            enemy.attack(warrior);
        }
        
        
        myTeam.healTeam();
        myTeam.displayTeam();
        System.out.println("Golem's Health: " + enemy.getHealth() + "/" + enemy.getMaxHealth());

      
        System.out.println("\n================= ROUND 2 =================");
        
        myTeam.attackAll(enemy);
        
        
        System.out.println("\n--- ENEMY ATTACK PHASE ---");
        if (enemy.isAlive()) {
            enemy.attack(mage);
        }
        
        
        myTeam.healTeam();
        myTeam.displayTeam();
        System.out.println("Golem's Health: " + enemy.getHealth() + "/" + enemy.getMaxHealth());

        
        System.out.println("\n================= post-battle team ops =================");
        
        
        System.out.println("Searching for 'Gandalf':");
        GameCharacter found = myTeam.findByName("Gandalf");
        if (found != null) {
            System.out.println("Found: " + found.getCharacterInfo());
        }

        
        myTeam.removeCharacter("Elrond");
        
        
        System.out.println("Searching for deleted 'Elrond':");
        GameCharacter notFound = myTeam.findByName("Elrond");
        if (notFound == null) {
            System.out.println("Character not found.");
        }

        myTeam.displayTeam();
    }
    
}
