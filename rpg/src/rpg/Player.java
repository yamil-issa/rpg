package rpg;

public class Player extends Character {
	public int numAttackUpgrades, numDefUpgrades;
	
	public String[] attackUpgrades = {"Strength", "Power", "Might", "Godlike Strength"};
	public String[] defUpgrades = {"Heavy Bones", "stoneskin", "scale Armor", "Holy Aura"};
    
	//player constructor
	public Player(String name) {
		super(name, 100, 0);
		this.numAttackUpgrades = 0;
		this.numDefUpgrades = 0;
		chooseTrait();
		
	}

	@Override
	public int attack() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int defend() {
		// TODO Auto-generated method stub
		return 0;
	}
	public void chooseTrait() {
		GameLoop.clearConsole();
		GameLoop.printHeading("Choisissez un trait:");
		System.out.println("(1)" + attackUpgrades[numAttackUpgrades]);
		System.out.println("(2)" + defUpgrades[numDefUpgrades]);
		int input = GameLoop.readInt("->", 2);
		
		GameLoop.clearConsole();
		if(input == 1) {
			GameLoop.printHeading("vois avez choisi" + " " + attackUpgrades[numAttackUpgrades] + "!");
			numAttackUpgrades++;
			
		}else {
			GameLoop.printHeading("vous aves choisi" + " " + defUpgrades[numDefUpgrades] + "!" );
			numDefUpgrades++;
		}
		GameLoop.toContinue();
	}

}
