
public class Restaurant extends Location{

	public Restaurant(Player p,Inventory i) {
		super.locationId=2;
		super.name="Restaurant";
		super.itemName="Food";
		super.obstacle=new Zombie();
		super.player=p;
		super.inventory=i;
		
	}

	

	
}
