import java.util.Scanner;

public class main {
    public static void main(String[] args){
        //Initiaiting our objects and variables
        backlog b1 = new backlog();
        ProductOwner paul = new ProductOwner("Paul");
        scrumMaster james = new scrumMaster("James", b1);
        teamMember mark = new teamMember("Mark", b1);
        b1.addMembers(mark);
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
        String response = "";
        //While loop that doesn't end until the user types "exit" the second while loop in each of the cases doesn't exit unit the user types 'back'
        while(cont == true){
            //Users can select a role and depending on the role they get different options
            System.out.println("Select a Position or enter 'exit' to quit");
            System.out.println("1. Product Owner");
            System.out.println("2. Scrum Master");
            System.out.println("3. Employee");
            response = scan.nextLine();
            boolean cont2 = true;
            switch (response) {
                //Options for the product manager role
                case "1":
                    while (cont2 == true){
                        System.out.println("Welcome back " + paul.getName() + "!");
                        System.out.println("Select an option or enter 'back' to go back");
                        System.out.println("1. Add new backlog item");
                        System.out.println("2. Update existing backlog item");
                        System.out.println("3. Display Backlog");
                        response = scan.nextLine();
                        switch (response){
                            case "1":
                                String[] temp = paul.getBacklogItemInfo();
                                b1.createBacklogItem(temp);
                                break;
                            case "2":
                                System.out.println("Select a task below to alter");
                                b1.displayBacklog();
                                response = scan.nextLine();
                                try{
                                    b1.alterBacklogItem(Integer.parseInt(response)- 1);
                                }
                                catch(Exception e){
                                    System.out.println("Invalid input");
                                }
                                break;
                            case "3":
                                b1.displayBacklog();
                                break;
                            case "back":
                                cont2 = false;
                                break;
                            default: 
                                System.out.println("Please enter a valid input");
                                break;
                        }
                    }
                    break;
                case "2": 
                //Options for the Scrum Master Role
                    while (cont2 == true){
                        System.out.println("Welcome back " + james.getName() + "!");
                        System.out.println("Select an option or enter 'back' to go back");
                        System.out.println("1. Assign a task");
                        System.out.println("2. Update priority of existing backlog item");
                        System.out.println("3. Display Backlog");
                        response = scan.nextLine();
                        switch (response){
                            case "1":
                                System.out.println("Select a task below to assign");
                                b1.displayBacklog();
                                response = scan.nextLine();
                                try{
                                    backlogItem temp = b1.getTaskFromIndex(Integer.parseInt(response)-1);
                                    System.out.println("Select a team member below to assign the task to");
                                    b1.displayMembers();
                                    response = scan.nextLine();
                                    teamMember temp2 = b1.getEmployeeFromIndex(Integer.parseInt(response)-1);
                                    james.assignTask(temp2, temp);
                                }
                                catch(Exception e){
                                    System.out.println("Invalid input");
                                }
                                break;   
                            case "2":
                                System.out.println("Select a task below to alter");
                                b1.displayBacklog();
                                response = scan.nextLine();
                                try{
                                   james.updateItem(Integer.parseInt(response)- 1); 
                                }
                                 catch(Exception e){
                                    System.out.println("Invalid input");
                                 }
                                break;
                            case "3":
                                b1.displayBacklog();
                                break;                           
                            case "back":
                                cont2 = false;
                                break;
                            default: 
                                System.out.println("Please enter a valid input");
                                break;
                        }
                    }
                    break;
                case "3": 
                //Options for the employee role
                    while (cont2 == true){
                        System.out.println("Welcome!");
                        System.out.println("Select an option or enter 'back' to go back");
                        System.out.println("1. Change the status of a backlog item");
                        System.out.println("2. Update the priority of an existing backlog item");
                        System.out.println("3. Display Backlog");
                        response = scan.nextLine();
                        switch (response){
                            case "1":
                                System.out.println("Select a task below to alter");
                                b1.displayBacklog();
                                response = scan.nextLine();
                                try{
                                    mark.changeStatus(Integer.parseInt(response)- 1, mark);
                                }
                                catch(Exception e){
                                    System.out.println("Invalid input");
                                 }
                                break;
                            case "2":
                                System.out.println("Select a task below to alter");
                                b1.displayBacklog();
                                response = scan.nextLine();
                                try{
                                  mark.updateItem(Integer.parseInt(response)- 1);  
                                }
                                catch(Exception e){
                                    System.out.println("Invalid input");
                                 }
                                break;
                            case "3":
                                b1.displayBacklog();
                                break;
                            case "back":
                                cont2 = false;
                                break;
                            default: 
                                System.out.println("Please enter a valid input");
                                break;
                        }
                    }
                    break;
                case "exit": 
                    cont = false;
                    break;
                default: 
                    System.out.println("Please enter a valid input");
                    break;
            }
            
        }

    }
}
