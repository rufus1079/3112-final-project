import java.util.Scanner;

public class Employee{
    private String name;
    private backlog tasks;

    Employee(String name, backlog tasks){
        this.name = name;
        this.tasks = tasks;
    }
    //Method that allows employees to change the status of a task but only if they are assigned to it
    public void changeStatus(int index, teamMember member){
        if (member.equals(this.tasks.getItems().get(index).getAssignedTeamMember())){
            backlogItem temp = this.tasks.getItems().get(index);
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a new status for this task");
            temp.setStatus(scan.nextLine());
            this.tasks.changeStatus(temp, index);
        }
        else{
            System.out.println("You cannot change the status of a task that your are not assigned to");
        }
    }

    //Method allows employees to change priority of tasks
    public void updateItem(int index){
        backlogItem temp = this.tasks.getItems().get(index);
        int numTemp = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a new priority for this task");
        while (numTemp < 0){
            try{
                temp.setPriority(Integer.parseInt(scan.nextLine()));
            }catch(Exception e){
                System.out.println("Please Enter a number");
            }
        }
        this.tasks.changeStatus(temp, index);
    }

    public String getName(){
        return this.name;
    }
}

