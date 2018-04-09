import java.util.Random;

public class Obstacle {
	public String name;
	public int 	id , damage , money , health,maxNum;
	public Obstacle(){}
	public Obstacle(String name , int id,int damage , int health , int money,int maxNum)
	{
		this.id=id;
		this.name=name;
		this.damage=damage;
		this.money=money;
		this.health=health;
		this.maxNum=maxNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}

	public int obstacleNumber()
	{	
		Random r=new Random();
		return 	r.nextInt(maxNum)+1;
		
		
	}
}
