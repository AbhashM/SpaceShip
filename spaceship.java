import java.util.Random;

public class SpaceShip {

 

 

 

 
   //variables
   private int hullEnergy;

   private int ShieldEnergy;

   private final int REPAIR_AMT = 25;

   private String name = "SpaceShip";

   private final int FIRST_HULLENERGY = 99;

   private final int FIRST_SHIELDENERGY = 50;

 

   

   public void sethullEnergy(int h){

      h = this.hullEnergy;

   }

   

   public int gethullEnergy(){

   return hullEnergy;

}

 

public void setShieldEnergy(int h){

   h = ShieldEnergy;

}

 

public SpaceShip(String name1){

   this.name = name1;

   hullEnergy = FIRST_HULLENERGY;

   ShieldEnergy =  FIRST_SHIELDENERGY;

}

//This part generates the power of the laser

public int fireLasers(){  

Random rand = new Random();

int laserPower = rand.nextInt((50-10)+1)+10;

return laserPower;

}

//This part makes the spaceships get damage

public void takeDamage(int laserPower){

   int hle = hullEnergy;

   int sh = ShieldEnergy;

   int rawShieldEnergy = sh -laserPower;

  ShieldEnergy = Math.max(0, rawShieldEnergy);

   int leftoverlaserPower = laserPower - sh;

   laserPower = Math.max(leftoverlaserPower, 0);

   int rawHullEnergy = hullEnergy - laserPower;

   hullEnergy = Math.max(rawHullEnergy,0);

   }

//this part makes the spaceships heal

   public void repair() {

   int rawHullEnergy = hullEnergy + REPAIR_AMT;

   hullEnergy = Math.min(rawHullEnergy,FIRST_HULLENERGY);//so we dont get a negative value

   int leftoverEnergy = rawHullEnergy - hullEnergy;

   int rawShieldEnergy = ShieldEnergy +leftoverEnergy;

   ShieldEnergy = Math.min(rawShieldEnergy,FIRST_SHIELDENERGY);  

   }

         
     
      public String statusReport() {

      return(this.getShipName() + " has a shield value of " +this.ShieldEnergy+" and has a hull value of "+this.hullEnergy);

      }

      public String getShipName() {

      return name;

   }

   public int getShieldEnergy(){

   return ShieldEnergy;

   }

   public  int getHullEnergy() {

   return hullEnergy;

   }
   //This part simulates battle
   public static void spaceBattle(SpaceShip GoingMerry , SpaceShip ThousandSunny){

   int GoingMerrydamage;

   int ThousandSunnydamage;

   

   int ShieldResult = GoingMerry.getShieldEnergy();

   int hullResult = GoingMerry.getHullEnergy();

   System.out.println("A space battle between GoingMerry and ThousandSunny is taking place.");

   System.out.println(" ");

   System.out.println(GoingMerry.getShipName() + " takes aim and fires the first laser!");

   

   GoingMerrydamage = GoingMerry.fireLasers();

   ThousandSunnydamage = ThousandSunny.fireLasers();

   GoingMerry.takeDamage(ThousandSunnydamage);

   ThousandSunny.takeDamage(GoingMerrydamage);
   System.out.println( ThousandSunny.getShipName() + " has taken " + GoingMerrydamage + " damage!");
   System.out.println(" ");
   System.out.println( ThousandSunny.getShipName() + " has returned fired.");
   System.out.println( GoingMerry.getShipName() + " has taken " + ThousandSunnydamage + " damage!");


 

   

   System.out.println(" ");

   

   System.out.println("Repair crews have been depolyed!");

   

   GoingMerry.repair();

   ThousandSunny.repair();

   System.out.println(" ");

   

   System.out.println(GoingMerry.statusReport() +".");
 
   System.out.println(ThousandSunny.statusReport()+".");

     

System.out.println("====================== The skrimish has concluded  =========================================");

System.out.println("*");

System.out.println("*");

System.out.println("*");

}

public static void main(String [] args) {

 

SpaceShip GoingMerry = new SpaceShip("GoingMerry");

SpaceShip ThousandSunny = new SpaceShip("ThousandSunny");

System.out.println(GoingMerry.statusReport());//To get the battle outcome

System.out.println(ThousandSunny.statusReport());

System.out.println(" ");

 

spaceBattle(GoingMerry, ThousandSunny);//To make the skrimish happen 10 times

spaceBattle(GoingMerry, ThousandSunny);

spaceBattle(GoingMerry, ThousandSunny);

spaceBattle(GoingMerry, ThousandSunny);

spaceBattle(GoingMerry, ThousandSunny);

spaceBattle(GoingMerry, ThousandSunny);

spaceBattle(GoingMerry, ThousandSunny);

spaceBattle(GoingMerry, ThousandSunny);

spaceBattle(GoingMerry, ThousandSunny);

spaceBattle(GoingMerry, ThousandSunny);

}

}
