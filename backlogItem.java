//Backlog Item Class
public class backlogItem {
    private String userStory;
    private String taskName;
    private String taskDescription;
    private String status;
    private teamMember assignedTeamMember;
    private boolean hasTeamMemberAssigned;
    private int estimatedTime;
    private int priority;

    backlogItem(String userStory, String taskName, String taskDescription, String status, int estiamtedTime, int priority) {
        this.userStory = userStory;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.status = status;
        this.assignedTeamMember = null;
        this.hasTeamMemberAssigned = false;
        this.estimatedTime = estiamtedTime;
        this.priority = priority;
    }

    //Getter and Setters for all the fields
    public String getUserStory(){
        return this.userStory;
    }
    public String getTaskName(){
        return this.taskName;
    }
    public String getTaskDescription(){
        return this.taskDescription;
    }
    public String getStatus(){
        return this.status;
    }
    public int getEstimatedTime(){
        return this.estimatedTime;
    }
    public int getPriority(){
        return this.priority;
    }

    public void setUserStory(String userStory){
        this.userStory = userStory;
    }

    public void setTaskName(String taskName){
        this.taskName = taskName;
    }

    public void setTaskDescription(String taskDescription){
        this.taskDescription = taskDescription;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public void setPriority(int priority){
        this.priority = priority;
    }
    
    public void setAssignedTeamMember(teamMember member){
        this.assignedTeamMember = member;
        this.hasTeamMemberAssigned = true;
    }

    public teamMember getAssignedTeamMember(){
        return this.assignedTeamMember;
    }

    public boolean getDoesTaskHaveAssignedTeamMember(){
        return this.hasTeamMemberAssigned;
    }

    //To string method that is used in the display method in backlog.java
    public String toString(){
        String result = "";
        result += "Task Name: " + this.taskName + "\n";
        result += "Assigned Team Member: " + this.assignedTeamMember + "\n";
        result += "Task Description: " + this.taskDescription +"\n";
        result += "User Story: " + this.userStory + "\n";
        result += "Task Status: " + this.status + "\n";
        result += "Estimated Time of completion: " + this.estimatedTime + "\n";
        result += "Task Priority: " + this.priority + "\n";
        return  result; 
    }
    
}
