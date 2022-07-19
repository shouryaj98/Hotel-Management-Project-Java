package hotel.management.input;

public class UserInput {

    //Asks for user's name
    public String getName(){
        String name = "";
        while(name.isBlank()){
            System.out.print("\nEnter customer name: ");
            name = ScannerInput.getString();
        }
        return name;
    }

    //Ask for user's contact number
    public String getContactNumber(){
        String contactNumber = "";
        while(contactNumber.isBlank()){
            System.out.print("\nEnter contact number: ");
            contactNumber = ScannerInput.getString();
        }
        return contactNumber;
    }

    //Ask for user's contact number
    public String getGender(){
        String gender = "";
        while(gender.isBlank()){
            System.out.print("\nEnter gender: ");
            gender = ScannerInput.getString();
        }
        return gender;
    }
}
