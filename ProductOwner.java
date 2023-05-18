import java.util.Scanner;
//Product Owner Class
public class ProductOwner {
    private String name;

    //Constructor for the product Owner Class
    ProductOwner(String name){
        this.name = name;
    }

    //Getter
    public String getName(){
        return this.name;
    }

    //Helper Method that makes it easier to get the data to make backlog items
    public String[] getBacklogItemInfo(){
        Scanner scan = new Scanner(System.in);
        String[] result = new String[4];
        for (int i = 0; i < 4; i++){
            switch (i) {
                case 0:
                    System.out.println("Enter a name for the task");
                    break;
                case 1:
                    System.out.println("Enter a description of the task");
                    break;
                case 2:
                    System.out.println("Enter the user story for the item");
                    break;
                case 3:
                    System.out.println("Enter the priority of the task (numeric values only)");
                    break;
            }
            result[i] = scan.nextLine();
        }
        return result;
    }
}