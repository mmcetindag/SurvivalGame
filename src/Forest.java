
public class Forest extends Location {

	public Forest(Player p,Inventory i) {
		super.locationId=3;
		super.name="Forest";
		super.itemName="Fire Wood";
		super.obstacle=new Vampire();
		super.player=p;
		super.inventory=i;
		
	}
}
