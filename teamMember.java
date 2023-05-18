import java.util.ArrayList;

public class teamMember extends Employee {
    private boolean hasTask;
    private ArrayList<Integer> taskHours;

    teamMember(String name, backlog tasks){
        super(name, tasks);
        this.hasTask = false;
        this.taskHours = new ArrayList<>();
    }

    //Getters and setters
    public boolean getHasTask() {
        return hasTask;
    }

    public void setHasTask(boolean hasTask){
        this.hasTask = hasTask;
    }

    public void addHours(int hours){
        this.taskHours.add(hours);
    }

    //Method used to calc the average time spent on tasks
    public double calcEstimatedTime(){
        if (this.taskHours.size() == 0){
            return 10;
        }
        int temp = 0;
        for (int i = 0; i < taskHours.size(); i++){
            temp += this.taskHours.get(i);
        }
        return temp/this.taskHours.size();
    }
    
}
