package rpg;

import java.util.ArrayList;

public class Player extends Character {
	private int numAttackUpgrades, numDefUpgrades;
	
	private int gold, restsLeft, pots;
	private String chosenClass;
	
	private Weapon[] playerWeapons = new Weapon[5];
	
    private ArrayList<Weapon> playerWeaponsBought = new ArrayList<Weapon>();
    
	private String[] attackUpgrades = {"Strength", "Power", "Might", "Godlike Strength"};
	private String[] defUpgrades = {"Heavy Bones", "stoneskin", "scale Armor", "Holy Aura"};
	
	private String[] playerClass = {"sorcier", "chevalier", "mendiant"};
	
	private int x = 0;
	private int y = 4;
	
    
	//player constructor
	public Player(String name) {
		super(name, 100, 0);
		this.numAttackUpgrades = 0;
		this.numDefUpgrades = 0;
		this.gold = 5;
		this.restsLeft = 1;
		this.pots = 0;
		this.chosenClass = "";
		this.playerWeapons[0] = new Weapon("épée du hero", 5);
		this.playerWeapons[1] = new Weapon("épée du hero", 5);
		this.playerWeapons[2] = new Weapon("hallebarde", 7);
		this.playerWeapons[3] = new Weapon("lance sacrée", 9);
		chooseTrait();
		chooseClass();
		
	}
	
	
	public int getPlayerXposition() {
		return this.x;
		
	}
	
    public int getPlayerYposition() {
    	return this.y;
	}
    
    public void setPositivePlayerXPosition() {
    	this.x++;
    }
    public void setPositivePlayerYPosition() {
    	this.y++;
    }
    public void setNegativePlayerXPosition() {
    	this.x--;
    }
    public void setNegativePlayerYPosition() {
    	this.y--;
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
	public void buyWeapon(Weapon weaponBought) {
		this.playerWeaponsBought.add(weaponBought);
	}
	
	public Weapon getWeapon(int numWeapon) {
		return this.playerWeapons[numWeapon];
	}
	public void renderWeaponBought() {
		for(Weapon elem: this.playerWeaponsBought)
	       {
	       	 System.out.println (elem.getWeaponName());
	       	 
	       }
		
	}
	
	public void equipWeapon(int indexOfWeapon) {
		
			this.numAttackUpgrades += this.playerWeaponsBought.get(indexOfWeapon).getWeaponDamagePoints();
			
		
	}
	
	
	public void chooseTrait() {
		GameLoop.clearConsole();
		GameLoop.printHeading("Choisissez une capacité :");
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
		
	}
	public void chooseClass() {
		GameLoop.clearConsole();
		GameLoop.printHeading("Choisissez une classe :");
		System.out.println("(1)" + playerClass[0] + " " + "HP: 150, pièces d'or: 15 ");
		System.out.println("(2)" + playerClass[1] + " " + "HP: 200, pièces d'or: 20 ");
		System.out.println("(3)" + playerClass[2] + " " + "HP: 250, pièces d'or: 25 ");
		int input2 = GameLoop.readInt("->", 3);
		
		GameLoop.clearConsole();
		if(input2 == 1) {
			GameLoop.printHeading("vois avez choisi" + " " + playerClass[0] + "!");
			this.maxHp = 150;
			this.hp = 150;
			this.gold = 15;
			this.chosenClass= playerClass[0];
			
		}else if(input2 == 2) {
			GameLoop.printHeading("vous aves choisi la classe" + " " + playerClass[1] + "!" );
			this.maxHp = 200;
			this.hp = 200;
			this.gold = 20;
			this.chosenClass = playerClass[1];
		}else if(input2 == 3) {
			GameLoop.printHeading("vous aves choisi la classe" + " " + playerClass[2] + "!" );
			this.maxHp = 250;
			this.hp = 250;
			this.gold = 25;
			this.chosenClass = playerClass[2];
		}
	}
	
	public String getChosenClass(){
		return this.chosenClass;
	}

}
