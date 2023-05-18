import java.util.ArrayList;
import java.util.Scanner;

public class backlog {
    private ArrayList<backlogItem> item;
    private ArrayList<teamMember> members;
    private int numItems;

    public backlog(){
        this.item = new ArrayList<>();
        this.members = new ArrayList<>();
        this.numItems = 0;
    }

    //Various getters and setters that help other methods in this class work
    public ArrayList<backlogItem> getItems(){
        return this.item;
    }

    public void createBacklogItem(String[] info){
        try{
            this.item.add(new backlogItem(info[2], info[0], info[1], "not-started", this.calcHours(), Integer.parseInt(info[3])));
        }catch(Exception e){
            this.item.add(new backlogItem(info[2], info[0], info[1], "not-started", this.calcHours(), (numItems+1)));
        }
        this.numItems += 1;
    }

    public void addMembers(teamMember member){
        this.members.add(member);
    }

    public void displayBacklog(){
        for (int i = 1; i - 1 < numItems; i++){
            System.out.println(i + ". " + item.get(i-1).toString());
        }
    }

    public void displayMembers(){
        for (int i = 1; i - 1 < this.members.size(); i++){
            System.out.println(i + ". " + this.members.get(i-1).getName());
        }
    }

    //Method used for the product owner to change backlog items
    public void alterBacklogItem(int index){

        //Basic user input
        backlogItem temp = this.item.get(index);
        Scanner scan = new Scanner(System.in);
        String response = "";
        System.out.println("Select an attribute to alter");
        System.out.println("1. Change the task name");
        System.out.println("2. Change the task description");
        System.out.println("3. Change the user story");
        response = scan.nextLine();
        //Switch statement that allows you to change certain aspects of a selected task
        switch (response) {
            case "1":
                System.out.println("Enter a new Task Name");
                temp.setTaskName(scan.nextLine());
                break;
            case "2":
                System.out.println("Enter a new Task Description");
                temp.setTaskDescription(scan.nextLine());
                break;
            case "3":
                System.out.println("Enter an new User Story");
                temp.setUserStory(scan.nextLine());
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
        this.item.set(index, temp);

    }

    //Method used by team members to change status of items
    public void changeStatus(backlogItem item, int index){
        Scanner scan = new Scanner(System.in);
        int temp = -1; 
        this.item.set(index, item);
        if (item.getStatus().equals("Complete")){
            System.out.println("Enter the amount of hours it took for completion");
            while (temp < 0){
                try{
                    item.getAssignedTeamMember().addHours(Integer.parseInt(scan.nextLine()));
                }catch(Exception e){
                    System.out.println("Please Enter a number");
                }
            }
            item.getAssignedTeamMember().addHours(Integer.parseInt(scan.nextLine()));
            this.item.remove(item);
            this.numItems -= 1;
        }
    }
    public backlogItem getTaskFromIndex(int index){
        return this.item.get(index);
    }
    public teamMember getEmployeeFromIndex(int index){
        return this.members.get(index);
    }

    //method used to calc the hours for each new task
    public int calcHours(){
        int result = 0;
        for (int i = 0; i < this.members.size(); i++){
            result += members.get(i).calcEstimatedTime();
        }
        return result/this.members.size();
    }

}
