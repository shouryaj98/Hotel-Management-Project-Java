import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Food implements Serializable
{
      private int itemno;
     private int quantity;
     private float price;
    
    Food(int itemno,int quantity)
    {
        this.itemno=itemno;
        this.quantity=quantity;
        switch(itemno)
        {
            case 1:price=quantity*50;
                break;
            case 2:price=quantity*60;
                break;
            case 3:price=quantity*70;
                break;
            case 4:price=quantity*30;
                break;
        }
    }


    public int getItemno() {
        return itemno;
    }

    public void setItemno(int itemno) {
        this.itemno = itemno;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}


class Singleroom implements Serializable
{
    private String name;
    private String contact;
    private String gender;
    private ArrayList<Food> food =new ArrayList<>();

   
    Singleroom()
    {
        this.setName("");
    }
    Singleroom(String name,String contact,String gender)
    {
        this.setName(name);
        this.setContact(contact);
        this.setGender(gender);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<Food> getFood() {
        return food;
    }

    public void setFood(ArrayList<Food> food) {
        this.food = food;
    }
}
class Doubleroom extends Singleroom implements Serializable
{ 
    private String name2;
    private String contact2;
    private String gender2;
    
    Doubleroom()
    {
        this.setName("");
        this.setName2("");
    }
    Doubleroom(String name,String contact,String gender,String name2,String contact2,String gender2)
    {
        this.setName(name);
        this.setContact(contact);
        this.setGender(gender);
        this.setName2(name2);
        this.setContact2(contact2);
        this.setGender2(gender2);
    }

    public String getName2() {
        return name2;
    }

    public void setName2(String name2) {
        this.name2 = name2;
    }

    public String getContact2() {
        return contact2;
    }

    public void setContact2(String contact2) {
        this.contact2 = contact2;
    }

    public String getGender2() {
        return gender2;
    }

    public void setGender2(String gender2) {
        this.gender2 = gender2;
    }
}
class NotAvailable extends Exception
{
   NotAvailable(){
       super("Not Available");
   }
}

class holder implements Serializable
{
    private Doubleroom[] luxury_doubler =new Doubleroom[10]; //Luxury
    private Doubleroom[] deluxe_doubler =new Doubleroom[20]; //Deluxe
    private Singleroom[] luxury_singletree =new Singleroom[10]; //Luxury
    private Singleroom[] deluxe_singletree =new Singleroom[20]; //Deluxe

    public Doubleroom[] getLuxury_doubler() {
        return luxury_doubler;
    }

    public void setLuxury_doubler(Doubleroom[] luxury_doubler) {
        this.luxury_doubler = luxury_doubler;
    }

    public Doubleroom[] getDeluxe_doubler() {
        return deluxe_doubler;
    }

    public void setDeluxe_doubler(Doubleroom[] deluxe_doubler) {
        this.deluxe_doubler = deluxe_doubler;
    }

    public Singleroom[] getLuxury_singletree() {
        return luxury_singletree;
    }

    public void setLuxury_singletree(Singleroom[] luxury_singletree) {
        this.luxury_singletree = luxury_singletree;
    }

    public Singleroom[] getDeluxe_singletree() {
        return deluxe_singletree;
    }

    public void setDeluxe_singletree(Singleroom[] deluxe_singletree) {
        this.deluxe_singletree = deluxe_singletree;
    }
}

class Hotel
{
    static holder hotel_ob=new holder();
    static Scanner sc = new Scanner(System.in);
    static void CustDetails(int i,int rn)
    {
        String name, contact, gender;
        String name2 = null, contact2 = null; 
        String gender2="";
        System.out.print("\nEnter customer name: ");
        name = sc.next();
        System.out.print("Enter contact number: ");
        contact=sc.next();
        System.out.print("Enter gender: ");
        gender = sc.next();
        if(i<3)
        {
        System.out.print("Enter second customer name: ");
        name2 = sc.next();
        System.out.print("Enter contact number: ");
        contact2=sc.next();
        System.out.print("Enter gender: ");
        gender2 = sc.next();
        }      
        
          switch (i) {
            case 1:
                hotel_ob.getLuxury_doubler()[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 2:
                hotel_ob.getDeluxe_doubler()[rn]=new Doubleroom(name,contact,gender,name2,contact2,gender2);
                break;
            case 3:
                hotel_ob.getLuxury_singletree()[rn]=new Singleroom(name,contact,gender);
                break;
            case 4:
                hotel_ob.getDeluxe_singletree()[rn]=new Singleroom(name,contact,gender);
                break;
            default:System.out.println("Wrong option");
                break;
        }
    }
    
    static void bookroom(int i)
    {
        int j;
        int rn;
        System.out.println("\nChoose room number from : ");
        switch (i) {
            case 1:
                for(j=0; j< hotel_ob.getLuxury_doubler().length; j++)
                {
                    if(hotel_ob.getLuxury_doubler()[j]==null)
                    {
                        System.out.print(j+1+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try {
                    rn = sc.nextInt();
                    rn--;

                    if(rn < 0 || rn >= hotel_ob.getLuxury_doubler().length)
                    {
                        System.out.println("Invalid room number");
                        return;
                    }

                    if(hotel_ob.getLuxury_doubler()[rn] != null)
                        throw new NotAvailable();

                    CustDetails(i,rn);
                }
                catch(NotAvailable e)
                {
                    System.out.println(e.getMessage());
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Please enter numbers only.");
                    sc.nextLine();
                }
            case 2:
                 for(j=0; j< hotel_ob.getDeluxe_doubler().length; j++)
                {
                    if(hotel_ob.getDeluxe_doubler()[j]==null)
                    {
                        System.out.print(j+11+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                rn=sc.nextInt();
                rn=rn-11;
                    if(rn < 0 || rn >= hotel_ob.getDeluxe_doubler().length)
                    {
                        System.out.println("Invalid room number");
                        return;
                    }
                if(hotel_ob.getDeluxe_doubler()[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(NotAvailable e)
                {
                    System.out.println(e.getMessage());
                    return;
                }
                catch (InputMismatchException e) {
                    System.out.println("Please enter numbers only.");
                    sc.nextLine(); // clear invalid input
                    return;
                }
                break;
            case 3:
                  for(j=0; j< hotel_ob.getLuxury_singletree().length; j++)
                {
                    if(hotel_ob.getLuxury_singletree()[j]==null)
                    {
                        System.out.print(j+31+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                rn=sc.nextInt();
                rn=rn-31;
                    if(rn < 0 || rn >= hotel_ob.getLuxury_singletree().length)
                    {
                        System.out.println("Invalid room number");
                        return;
                    }
                if(hotel_ob.getLuxury_singletree()[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(NotAvailable e)
                {
                    System.out.println(e.getMessage());
                    return;
                }
                catch (InputMismatchException e) {
                    System.out.println("Please enter numbers only.");
                    sc.nextLine(); // clear invalid input
                    return;
                }

                break;
            case 4:
                  for(j=0; j< hotel_ob.getDeluxe_singletree().length; j++)
                {
                    if(hotel_ob.getDeluxe_singletree()[j]==null)
                    {
                        System.out.print(j+41+",");
                    }
                }
                System.out.print("\nEnter room number: ");
                try{
                rn=sc.nextInt();
                rn=rn-41;
                    if(rn < 0 || rn >= hotel_ob.getDeluxe_singletree().length)
                    {
                        System.out.println("Invalid room number");
                        return;
                    }
                if(hotel_ob.getDeluxe_singletree()[rn]!=null)
                    throw new NotAvailable();
                CustDetails(i,rn);
                }
                catch(NotAvailable e)
                {
                   System.out.println(e.getMessage());
                    return;
                }
                catch (InputMismatchException e) {
                    System.out.println("Please enter numbers only.");
                    sc.nextLine(); // clear invalid input
                    return;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Room Booked");
    }
    
    static void features(int i)
    {
        switch (i) {
            case 1:System.out.println("Number of double beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:4000 ");
                break;
            case 2:System.out.println("Number of double beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:3000  ");
                break;
            case 3:System.out.println("Number of single beds : 1\nAC : Yes\nFree breakfast : Yes\nCharge per day:2200  ");
                break;
            case 4:System.out.println("Number of single beds : 1\nAC : No\nFree breakfast : Yes\nCharge per day:1200 ");
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
    }
    
    static void availability(int i)
    {
      int j,count=0;
        switch (i) {
            case 1:
                for(j=0;j<10;j++)
                {
                    if(hotel_ob.getLuxury_doubler()[j]==null)
                        count++;
                }
                break;
            case 2:
                for(j=0; j< hotel_ob.getDeluxe_doubler().length; j++)
                {
                    if(hotel_ob.getDeluxe_doubler()[j]==null)
                        count++;
                }
                break;
            case 3:
                for(j=0; j< hotel_ob.getLuxury_singletree().length; j++)
                {
                    if(hotel_ob.getLuxury_singletree()[j]==null)
                        count++;
                }
                break;
            case 4:
                for(j=0; j< hotel_ob.getDeluxe_singletree().length; j++)
                {
                    if(hotel_ob.getDeluxe_singletree()[j]==null)
                        count++;
                }
                break;
            default:
                System.out.println("Enter valid option");
                break;
        }
        System.out.println("Number of rooms available : "+count);
    }
    
    static void bill(int rn,int rtype)
    {
        double amount=0;
        String list[]={"Sandwich","Pasta","Noodles","Coke"};
        System.out.println("\n*******");
        System.out.println(" Bill:-");
        System.out.println("*******");
               
        switch(rtype)
        {
            case 1:
                amount+=4000;
                    System.out.println("\nRoom Charge - "+4000);
                    System.out.println("\n===============");
                    System.out.println("Food Charges:- ");
                    System.out.println("===============");
                     System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb: hotel_ob.getLuxury_doubler()[rn].getFood())
                    {
                        amount+=obb.getPrice();
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.getItemno()-1],obb.getQuantity(),obb.getPrice() );
                    }
                    
                break;
            case 2:amount+=3000;
                    System.out.println("Room Charge - "+3000);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("===============");
                     System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb: hotel_ob.getDeluxe_doubler()[rn].getFood())
                    {
                        amount+=obb.getPrice();
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.getItemno()-1],obb.getQuantity(),obb.getPrice() );
                    }
                break;
            case 3:amount+=2200;
                    System.out.println("Room Charge - "+2200);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb: hotel_ob.getLuxury_singletree()[rn].getFood())
                    {
                        amount+=obb.getPrice();
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.getItemno()-1],obb.getQuantity(),obb.getPrice() );
                    }
                break;
            case 4:amount+=1200;
                    System.out.println("Room Charge - "+1200);
                    System.out.println("\nFood Charges:- ");
                    System.out.println("===============");
                    System.out.println("Item   Quantity    Price");
                    System.out.println("-------------------------");
                    for(Food obb: hotel_ob.getDeluxe_singletree()[rn].getFood())
                    {
                        amount+=obb.getPrice();
                        String format = "%-10s%-10s%-10s%n";
                        System.out.printf(format,list[obb.getItemno()-1],obb.getQuantity(),obb.getPrice() );
                    }
                break;
            default:
                System.out.println("Not valid");
        }
        System.out.println("\nTotal Amount- "+amount);
    }
    
    static void deallocate(int rn,int retype)
    {
        int j;
        char w;
        switch (retype) {
            case 1:               
                if(hotel_ob.getLuxury_doubler()[rn]!=null)
                    System.out.println("Room used by "+ hotel_ob.getLuxury_doubler()[rn].getName());
                else 
                {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println("Do you want to checkout ?(y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn, retype);
                    hotel_ob.getLuxury_doubler()[rn]=null;
                    System.out.println("Deallocated successfully");
                }
                
                break;
            case 2:
                if(hotel_ob.getDeluxe_doubler()[rn]!=null)
                    System.out.println("Room used by "+ hotel_ob.getDeluxe_doubler()[rn].getName());
                else 
                {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ?(y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn, retype);
                    hotel_ob.getDeluxe_doubler()[rn]=null;
                    System.out.println("Deallocated successfully");
                }
                 
                break;
            case 3:
                if(hotel_ob.getLuxury_singletree()[rn]!=null)
                    System.out.println("Room used by "+ hotel_ob.getLuxury_singletree()[rn].getName());
                else 
                 {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn, retype);
                    hotel_ob.getLuxury_singletree()[rn]=null;
                    System.out.println("Deallocated successfully");
                }
                
                break;
            case 4:
                if(hotel_ob.getDeluxe_singletree()[rn]!=null)
                    System.out.println("Room used by "+ hotel_ob.getDeluxe_singletree()[rn].getName());
                else 
                 {    
                    System.out.println("Empty Already");
                        return;
                }
                System.out.println(" Do you want to checkout ? (y/n)");
                 w=sc.next().charAt(0);
                if(w=='y'||w=='Y')
                {
                    bill(rn, retype);
                    hotel_ob.getDeluxe_singletree()[rn]=null;
                    System.out.println("Deallocated successfully");
                }
                break;
            default:
                System.out.println("\nEnter valid option : ");
                break;
        }
    }
    
    static void order(int rn,int rtype)
    {
        int i,q;
        char wish;
         try{
             System.out.println("\n==========\n   Menu:  \n==========\n\n1.Sandwich\tRs.50\n2.Pasta\t\tRs.60\n3.Noodles\tRs.70\n4.Coke\t\tRs.30\n");
        do
        {
            i = sc.nextInt();
            System.out.print("Quantity- ");
            q=sc.nextInt();
           
              switch(rtype){
            case 1: hotel_ob.getLuxury_doubler()[rn].getFood().add(new Food(i,q));
                break;
            case 2: hotel_ob.getDeluxe_doubler()[rn].getFood().add(new Food(i,q));
                break;
            case 3: hotel_ob.getLuxury_singletree()[rn].getFood().add(new Food(i,q));
                break;
            case 4: hotel_ob.getDeluxe_singletree()[rn].getFood().add(new Food(i,q));
                break;                                                 
        }
              System.out.println("Do you want to order anything else ? (y/n)");
              wish=sc.next().charAt(0); 
        }while(wish=='y'||wish=='Y');  
        }
         catch (InputMismatchException e) {
             System.out.println("Please enter correct input");
             sc.nextLine();
         }
        if(hotel_ob.getLuxury_doubler()[rn] == null)
        {
            System.out.println("Room not booked");
            return;
        }

    }
}


class write implements Runnable
{
    holder hotel_ob;
    write(holder hotel_ob)
    {
        this.hotel_ob=hotel_ob;
    }
    @Override
    public void run() {
          try{
        FileOutputStream fout=new FileOutputStream("backup");
        ObjectOutputStream oos=new ObjectOutputStream(fout);
        oos.writeObject(hotel_ob);
        }
        catch(Exception e)
        {
            System.out.println("Error in writing "+e);
        }         
        
    }
    
}

public class Main {
    public static void main(String[] args){
        
        try
        {           
        File f = new File("backup");
        if(f.exists())
        {
            FileInputStream fin=new FileInputStream(f);
            ObjectInputStream ois=new ObjectInputStream(fin);
            Hotel.hotel_ob=(holder)ois.readObject();
        }
        Scanner sc = new Scanner(System.in);
        int ch,ch2;
        char wish;
        x:
        do{

        System.out.println("\nEnter your choice :\n1.Display room details\n2.Display room availability \n3.Book\n4.Order food\n5.Checkout\n6.Exit\n");
        ch = sc.nextInt();
        switch(ch){
            case 1: System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room \n4.Deluxe Single Room\n");
                    ch2 = sc.nextInt();
                    Hotel.features(ch2);
                break;
            case 2:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                     ch2 = sc.nextInt();
                     Hotel.availability(ch2);
                break;
            case 3:System.out.println("\nChoose room type :\n1.Luxury Double Room \n2.Deluxe Double Room \n3.Luxury Single Room\n4.Deluxe Single Room\n");
                     ch2 = sc.nextInt();
                     Hotel.bookroom(ch2);                     
                break;
            case 4:
                 System.out.print("Room Number -");
                     ch2 = sc.nextInt();
                     if(ch2>60)
                         System.out.println("Room doesn't exist");
                     else if(ch2>40)
                         Hotel.order(ch2-41,4);
                     else if(ch2>30)
                         Hotel.order(ch2-31,3);
                     else if(ch2>10)
                         Hotel.order(ch2-11,2);
                     else if(ch2>0)
                         Hotel.order(ch2-1,1);
                     else
                         System.out.println("Room doesn't exist");
                     break;
            case 5:                 
                System.out.print("Room Number -");
                     ch2 = sc.nextInt();
                     if(ch2>60)
                         System.out.println("Room doesn't exist");
                     else if(ch2>40)
                         Hotel.deallocate(ch2-41,4);
                     else if(ch2>30)
                         Hotel.deallocate(ch2-31,3);
                     else if(ch2>10)
                         Hotel.deallocate(ch2-11,2);
                     else if(ch2>0)
                         Hotel.deallocate(ch2-1,1);
                     else
                         System.out.println("Room doesn't exist");
                     break;
            case 6:break x;
                
        }
           
            System.out.println("\nContinue : (y/n)");
            wish=sc.next().charAt(0); 
            if(!(wish=='y'||wish=='Y'||wish=='n'||wish=='N'))
            {
                System.out.println("Invalid Option");
                System.out.println("\nContinue : (y/n)");
                wish=sc.next().charAt(0); 
            }
            
        }while(wish=='y'||wish=='Y');    
        
        Thread t=new Thread(new write(Hotel.hotel_ob));
        t.start();
        }        
            catch(Exception e)
            {
                e.printStackTrace();
                System.out.println("Not a valid input");
            }
    }
}
