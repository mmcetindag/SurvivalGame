import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

public class Location {
	public String name,itemName;
	public int locationId=-10;
	public boolean item;
	Obstacle obstacle=new Obstacle();
	Player player=new Player();
	Inventory inventory=new Inventory();
	Scanner scan=new Scanner(System.in);
	
	public Location(){}
	public Location(Player p , Inventory i)
	{	
		this.player=p;
		this.inventory=i;
	
	}
	public Location(int locationId,String name, String itemName,String obstacleName , Player p, Inventory i)
	{	
		this.locationId=locationId;
		this.name=name;
		this.itemName=itemName;
		this.player=p;
		this.inventory=i;
		
	} 
	
	public void getLocation()
	{
			int obsNum=obstacle.obstacleNumber();
			System.out.println("You are in the " + name + " !!");
			System.out.println("!!Be Careful!! There are " + obsNum + " " + obstacle.getName()+ "<s>"  + "in the" + name);
			System.out.println(inventory.isFood());
			System.out.print("<C>ombat or <F>lee?:");
			String combat=scan.next();
			if(combat.equals("c"))
			{
				if(combat(obsNum)==true)
				{
					System.out.println("You KILLED all the enemies in the "+ name + "!!!");
					if(itemName.equals("Food") && inventory.isFood()==false)
					{
						System.out.println("You win " + itemName +  " item :) :)");
						inventory.setFood(true);
					}
					else if(itemName.equals("Water") && inventory.isWater()==false)
					{
						System.out.println("You win " + itemName +  " item :) :)");
						inventory.setWater(true);
					}
					else if(itemName.equals("Fire Wood") && inventory.isFireWood()==false )
					{
						System.out.println("You win " + itemName +  " item :) :)");
						inventory.setFireWood(true);
					}
		
					printMenu();
				}
				else
				{
					System.out.println("You are lose!!");
					System.out.println("Game Over!");
				}
			}
			else
			{
				printMenu();
			}
		
	}
	
	public boolean combat(int obsNum)
	{
		for(int i=0; i<obsNum;i++)
		{
			int obstacleHealth=obstacle.getHealth();
			
			playerStats();
			enemyStats();
			while(player.health>0 && obstacle.health>0)
			{	
			
			System.out.print("<H>it or <F>lee?: ");
			String hit=scan.next();
			if(hit.equals("h"))
				{
		
				System.out.println("You hit the enemy!!");
				obstacle.health=obstacle.health-player.damage;
				System.out.println("Player Health: " + player.health);
				System.out.println("Enemy Health: " + obstacle.health );
				System.out.println();
				System.out.println("Enemy hits you!!!");
				player.health=player.health-(obstacle.damage+inventory.getDefend());
				System.out.println("Player Health: " + player.health);
				System.out.println("Enemy Health: " + obstacle.health );
				}
				else
				{
					printMenu();
					break;
				}
			}
			if(obstacle.health<player.health)
			{
				System.out.println("You KILLED an enemmy!!");
				player.money=player.money+obstacle.getMoney();
				player.setMoney(player.money);
				System.out.println("You current money:" + 	player.getMoney());
				obstacle.setHealth(obstacleHealth);
			
			
			}
			else
			{
			
				return false;
				
			}
			
		}
		return true;
	}
	
	
	public void playerStats()
	{	String weapon;	
		if(inventory.weaponString!=null)
			 weapon=inventory.weaponString;
		else
			weapon="Bat +0 damage.";
	
		System.out.println("Player Stats\n----------\nHealth: " + player.getHealth() +"\nDamage: " + player.getDamage() + "\nWeapon:"+ weapon + "\nMoney:" + player.getMoney());
		if(inventory.armorString!=null)
		{
			System.out.println(inventory.armorString);
		}
		
	}
	
	public void enemyStats()
	{
		System.out.println("\nEnemy Stats\n----------\nName: " + obstacle.getName() + "\nHealth: " +  obstacle.getHealth() +"\nDamage: " + obstacle.getDamage());

	}

	public void printMenu()
	{
		
		System.out.println("Please select location you want to go!");
		System.out.println("1. Safehouse --> Your village , no enemies!");
		System.out.println("2. Restaurant --> There will be zombies!");
		System.out.println("3. Forest --> There will be vampires!");
		System.out.println("4. River --> There will be bears!");
		System.out.println("5. Toolstore --> You can buy stuff!");
		System.out.println("0. Need Help??");
		System.out.print("Your choice:");
		int select=scan.nextInt();
		while(select<0 || select>=6)
		{	
			System.out.print("Your choice:");
			select=scan.nextInt();
		}
		if(locationId==select)
		{
			System.out.println("You already in the " + name + " Please select another location!!!");
			printMenu();
		}
		if(select==1)
		{
			Location safehouse=new Safehouse(player,inventory);
			safehouse.getLocation();
		}
		else if(select==2){
			Location restaurant=new Restaurant(player,inventory);
			restaurant.getLocation();
		}
		
		else if(select==3){
			Location forest=new Forest(player,inventory);
			forest.getLocation();
		}
		
		else if(select==4){
			Location river=new River(player,inventory);
			river.getLocation();
		}
		
		else if(select==5){
			Location toolstore=new Toolstore(player,inventory);
			toolstore.getLocation();
		}
		else {
			
			Location helpcenter=new Help(player,inventory);
			helpcenter.getLocation();
		}
		

	}
	
}
