
public class Safehouse extends Location {
	
	public Safehouse(Player p,Inventory i) {
		super.locationId=1;
		super.name="Safe House";
		super.player=p;
		super.inventory=i;
		
	}
	
	public void getLocation()
	{
		
	
	
		if(inventory.isFireWood()==true && inventory.isFood()==true && inventory.isWater()==true)
		{
			System.out.println("Congratulations! You brought items that your village needs.");
			System.out.println("You Win!!");
		}
		else{
		
		player.setHealth(player.getrealHealth());
		System.out.println("You are healed!!");
		System.out.println("You are in the SAFEHOUSE now!!");

	
		printMenu();
		}
	}

}
