package rpg;

public abstract class Character {
	protected String name;
	protected int maxHp, hp, xp;
	
	//character conctructor
	public Character(String name, int maxHp, int xp) {
		this.name = name;
		this.maxHp = maxHp;
		this.xp = xp;
		this.hp = maxHp;
		
	}
    public abstract int attack();
    public abstract int defend();
}
