public class scrumMaster extends Employee {
    scrumMaster(String name, backlog tasks){
        super(name, tasks);
    }
    //Method that assigns tasks to members
    public void assignTask(teamMember player, backlogItem task){
        if (player.getHasTask() == true) {
            System.out.println("This Team Member already has a task assigned to them");
        }
        else if (task.getDoesTaskHaveAssignedTeamMember() == true) {
            System.out.println("This Task already has a team member assigned to it");
        }
        else {
            player.setHasTask(true);
            task.setAssignedTeamMember(player);
        }
    }
}
