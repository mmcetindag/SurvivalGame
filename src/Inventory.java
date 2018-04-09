
public class Inventory {
	public boolean water,food,fireWood=false;
	public int id,weaponID,armorID;
	public int defend=0;
	public String weaponString;
	public String armorString;
	public void addWeapon(int id , String name , int damage)
	{
		this.weaponID=id;
		this.weaponString=name + " " + "+" + damage +" damage";
		
	}
	
	public void addArmor(int id ,String name , int avoid)
	{
		this.armorID=id;
		this.armorString="Armor: " + name + " Armor " + avoid + " avoid.";
		
	}
	public void defend(int avoid)
	{
		defend=avoid;
	}
	public int getDefend()
	{
		return defend;
	}
	
	public boolean isWater() {
		return water;
	}
	public void setWater(boolean water) {
		this.water = water;
	}
	public boolean isFood() {
		return food;
	}
	public void setFood(boolean food) {
		this.food = food;
	}
	public boolean isFireWood() {
		return fireWood;
	}
	public void setFireWood(boolean fireWood) {
		this.fireWood = fireWood;
	}
}
