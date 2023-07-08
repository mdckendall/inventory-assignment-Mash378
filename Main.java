import java.util.ArrayList;
import java.util.Scanner;

class Inventory {
  public String Name;
  public String Serial_Number;
  public int Value;
  public Inventory (String Name, String Serial_Number, int Value){
    this.Name= Name;
    this.Serial_Number= Serial_Number;
    this.Value= Value;
  }

}

class Main {
	public static void main(String[] args) {
    ArrayList<Inventory> inventory = new ArrayList<Inventory>();
    Inventory item;
    int number=0;
    Scanner input = new Scanner(System.in);
    do{
      System.out.println("Press 1 to add an item.");
      System.out.println("Press 2 to delete an item.");
      System.out.println("Press 3 to update an item.");
      System.out.println("Press 4 to show all the items.");
      System.out.println("Press 5 to quit the program.");
      number= input.nextInt();
      input.nextLine();
      String serial;
      String name;
      int value;
      switch(number){
        case 1:
          System.out.println("Enter the name:");
          name = input.nextLine();
          System.out.println("Enter the serial number:");
          String Serial_number= input.nextLine();
          System.out.println("Enter the value in dollars (whole number):");
          value= input.nextInt();
          item = new Inventory(name,Serial_number,value);
          inventory.add(item);
          break;
        case 2:
          System.out.println("Enter the serial number of the item to delete:");
          serial = input.nextLine();
          for(int i=0;i<inventory.size();i++){
            if(inventory.get(i).Serial_Number.equals(serial)) inventory.remove(i);
          }
          break;
        case 3:
          System.out.println("Enter the serial number of the item to change:");
          serial = input.nextLine();
          System.out.println("Enter the new name:");
          name= input.nextLine();
          System.out.println("Enter the new value in dollars:");
          value= input.nextInt();
          for(int i=0;i<inventory.size();i++){
            if(inventory.get(i).Serial_Number.equals(serial)){
              inventory.get(i).Name= name;
              inventory.get(i).Value=value;
            }
          }
        case 4:
          for(Inventory i: inventory){
            System.out.println(i.Name+","+i.Serial_Number+","+i.Value);
          }
      }
        
    }while (number!=5);
	}
}