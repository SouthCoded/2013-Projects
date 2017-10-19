import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Hotel {
	 public static String name;
	 public static int number;
	 public static String room;
	 public static ArrayList<String>guestArray = new ArrayList<String>();
	 public static Scanner Sc = new Scanner(System.in);
	 public static boolean openA = true;
	 public static boolean openB = true;
	 public static boolean switcher = false;
	 
	 //just some variables that the entire class can use
	

		public static void welcome (){
			 System.out.println("This is an automated checker inner and checker outer");
			 System.out.println("What is your name ( first and last please) ?");
			 String Sf = Sc.next();
			 
			 checker(Sf);
			
			 if(switcher == false){
				 System.out.println("How many are in your party?");
				 int Sg = Sc.nextInt();
				 System.out.println("Here is your room number " + Sf);
			 	Hotel Guest = new Hotel(Sf,Sg,room);
			 	//creates a profile of the Guest for the hotel
			 	System.out.println(room);
			 	//prints out the room number
			 	System.out.println("Have a nice day!");
			 	System.out.println("");
			 }
			 else{
				 System.out.println("Checkout complete. Please come again!");
				 switcher = false;
			 }
		}
		
		public Hotel(String A, int B, String C){
			  //constructor used to create the guests profile
			  name = A;
			  number = B;
			  room = Hotel.roomNum(B); //this one is special it uses a method
		  }
		
		  public static String guestName(){
			  return name;
			  //just returns the name if needed
		  }
		  public static int peopleNum () {
			  return number;
			  //same thing
		  }
		  public static String roomNum (int A) {
			  
			  if( A <= 2 && openA == true){
				  openA = false;
				  return "Your room number is 1";
			  }
			  else if(A<=2 && openB == true){
				  openB= false;
				  return "Your room number is 2";
			  }
			  else{
	              return "Oh I am sorry but we have no available rooms today";
			  }

		  }
		  public static String checker(String p){
				  if(guestArray.isEmpty()){
				  }
				  else{
			      for(int y=0;y<guestArray.size();y++){
					 if( p.equals(guestArray.get(y))){
						 switcher = true;
						 System.out.println("You are already registered would you like to checkout? (yes or no)");
						 String Sh = Sc.next();
						 if(Sh.equals("yes")){
							System.out.println("What room did you have?");
							int Sk = Sc.nextInt();
							Hotel.checkout(Sk);
							guestArray.remove(y);
							System.out.println("");
						 }
						 System.out.println("");
					 }	
					 else{
						 break;
					 }
				  }
			  }
			  return "We have not seen you before welcome";
		  }
		  public static void checkout(int sk) {
			  switch(sk){
				case 1: openA=true;break;
				case 2 :openB=true;break;
				}
				
			}
	 
		  //all of the above are methods
		  public static void main(String[] args) {
				 for(int x=0;x<100;x++){
			     	welcome();
			  }
			 }
}
