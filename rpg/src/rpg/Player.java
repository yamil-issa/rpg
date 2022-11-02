package rpg;

public class Player extends Character {
	private int numAttackUpgrades, numDefUpgrades;
	
	int gold, restsLeft, pots;
	
	private String[] attackUpgrades = {"Strength", "Power", "Might", "Godlike Strength"};
	private String[] defUpgrades = {"Heavy Bones", "stoneskin", "scale Armor", "Holy Aura"};
    
	//player constructor
	public Player(String name) {
		super(name, 100, 0);
		this.numAttackUpgrades = 0;
		this.numDefUpgrades = 0;
		this.gold = 5;
		this.restsLeft = 1;
		this.pots = 0;
		chooseTrait();
		
	}

	@Override
	public int attack() {
		
		return (int) (Math.random()*(xp/4 + numAttackUpgrades*3 + 3) + xp/10 + numAttackUpgrades*2 + numDefUpgrades + 1);
	}

	@Override
	public int defend() {
		return (int) (Math.random()*(xp/4 + numDefUpgrades*3 + 3) + xp/10 + numDefUpgrades*2 + numAttackUpgrades + 1);
		
	}
	public int getNumAttackUpgrades() {
		return this.numAttackUpgrades;
	}
	public int getNumDefUpgrades() {
		return this.numAttackUpgrades;
	}
    public int restoreHp(int hpRestored) {
    	return this.hp += hpRestored;
    }
	public String[] getAttackUpgrades() {
		return this.attackUpgrades;
	}
	public String[] getDefUpgrades() {
		return this.defUpgrades;
	}
	public int getGold() {
		return this.gold;
	}
	public int getPots() {
		return this.pots;
	}
	public int getRestsLeft() {
		return this.restsLeft;
	}
	public int setRestsLeft() {
		return this.restsLeft++;
	}
	public int setGold(int goldEarned) {
		return this.gold += goldEarned;
	}
	public int setPots() {
		return this.pots++;
	}
	public int buy(int price) {
		return this.gold -= price;
	}
	public int useRests() {
		return this.restsLeft--;
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
