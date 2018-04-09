
public class Toolstore extends Location{
	public int id,avoid,money,damage;
	public String name;
	public Toolstore(Player p,Inventory i) {
		super.locationId=5;
		super.name="Toolstore";
		super.player=p;
		super.inventory=i;
		
	}
	public void getLocation()
	{
		System.out.println("Welcome to Tool Store!");
		System.out.println("What do you want to purchase??\n1. Weapon\n2. Armor\n3. Cancel");
		System.out.print("Your choice:");
		int select=scan.nextInt();
		if(select==1)
		{
			buyWeaponMenu();
			
		}
		else if(select==2)
		{
			buyArmorMenu();
		}
		else
		{
			printMenu();
		}
		
	}
	
	public void weaponType(int id)
	{
		if(id==1)
		{
			this.id=1;
			this.name="Pistol";
			this.damage=2;
			this.money=25;
		}
		else if(id==2)
		{
			this.id=2;
			this.name="Sword";
			this.damage=4;
			this.money=35;
			
		}
		else
		{	this.id=3;
			this.name="Rifle";
			this.damage=7;
			this.money=45;
		}
			
	}
	public void armorType(int id)
	{
		if(id==1)
		{	this.id=1;
			this.name="Light";
			this.avoid=-1;
			this.money=15;
		}
		else if(id==2)
		{	this.id=2;
			this.name="Medium";
			this.avoid=-3;
			this.money=25;
			
		}
		else
		{	this.id=3;
			this.name="Heavy";
			this.avoid=-5;
			this.money=40;
		}
			
	}
	
	
	

	public void buyWeapon(int id)
	{
	
			weaponType(id);
			System.out.println(player.getMoney());
			if(player.getMoney()>=money)
			{
				
				player.setMoney(player.getMoney()-money);
				player.setDamage(player.getDamage()+damage);
				System.out.println("You have successfully bought and equipped the item " + name);
				inventory.addWeapon(this.id,this.name,this.damage);
			
			}
			else
			{
				System.out.println("The Item you want to purchase is TOO expensive for you!");
				
			}
		
		
	}
	
	public void buyArmor(Obstacle o,int id)
	{
	
			armorType(id);
		
			if(player.getMoney()>=money)
			{
				
				player.setMoney(player.getMoney()-money);
				inventory.defend(this.avoid);
				System.out.println("You have successfully bought and equipped the item " + name);
				inventory.addArmor(this.id,this.name,this.avoid);
				
			}
			else
			{
				System.out.println("The Item you want to purchase is TOO expensive for you!");
			}
		
		
	}
	
	public void buyWeaponMenu()
	{
		
		System.out.println("1. Pistol <Price: 25 - Damage : +2>");
		System.out.println("2. Sword <Price: 34 - Damage : +4>");
		System.out.println("3. Pistol <Price: 45 - Damage : +7>");
		System.out.println("4. Cancel");
		System.out.print("Your Choice");
		int select=scan.nextInt();
		if(select!=4){
			buyWeapon(select);
			printMenu();
		}
		else
			printMenu();
	}
	
	
	public void buyArmorMenu()
	{
	
		Obstacle o=new Obstacle();
		System.out.println("1. Light <Price: 15 - Damage : -1>");
		System.out.println("2. Medium <Price: 25 - Damage : -3>");
		System.out.println("3. Heavy <Price: 40 - Damage : -5>");
		System.out.println("4. Cancel");
		System.out.print("Your Choice");
		int select=scan.nextInt();
		if(select!=4){
			buyArmor(o,select);
			printMenu();
		}
		else
			printMenu();
	}
}
