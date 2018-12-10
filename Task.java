import java.util.Date;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Arrays;


/**
 * Task
 */
public class Task extends FunctionalRequirement{

    Object resource;
    String expectedStartDate;
    String expectedEndDate;
    double expectedDuration;
    double expectedEffort;
    String actualStartDate;
    String actualEndDate;
    double actualDuration;
    double actualEffort;
    double effortCompleted;
    double percentComplete;
    LinkedList predecessorTasks = new LinkedList();
    LinkedList successorTasks = new LinkedList();
    LinkedList issueList = new LinkedList();
    LinkedList startToStart = new LinkedList();
    LinkedList startToFinish = new LinkedList();
    LinkedList finishToStart = new LinkedList();
    LinkedList finishToFinish = new LinkedList();
    boolean isMileStone;
    boolean isSummaryTask;

    public Task(){

    }

    public static void main(String[] args) {
        //For testing Calculated Duration
        //Task task = new Task();
        //task.expectedStartDate = "01/11/2014";
        //task.expectedEndDate = "02/22/2018";
        //task.setCalculatedDuration();



    }


    //This method assumes that the resource class has been created
    //To test, I will have to create a dummy Resource class until resource created...
    public void setResource(Object newResource){
        resource = newResource;
    }
    
    public void removeResource(){
        resource = null;
    }
    
    public void setExpectedStartDate(String date){
        expectedStartDate = date;
    }
    
    public void setExpectedEndDate(String date){
        expectedEndDate = date;
    }
    
    public void setExpectedDuration(double duration){
        if (duration < 0){
             System.out.println("Please enter a valid duration");
        } else{
            this.expectedDuration = duration;
        }
    }
    
    //This method assumes that the system did not let them enter incorrect dates
    public void setCalculatedDuration(){
        String[] expectedStartSplit = this.expectedStartDate.split("/");
        String[] expectedEndSplit = this.expectedEndDate.split("/");
        String str1 = String.join("", expectedStartSplit);
        String str2 = String.join("", expectedEndSplit);

        try{
            SimpleDateFormat myFormat = new SimpleDateFormat("MMddyyyy");
            Date date1 = myFormat.parse(str1);
            Date date2 = myFormat.parse(str2);
            long diff = date2.getTime() - date1.getTime();
            this.expectedDuration = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        }catch (ParseException e) {
            e.printStackTrace();
        }
    } 

    public void setExpectedEffort(double effort){
        if (effort < 0){
            System.out.println("Please enter a valid effort");
       } else{
           this.expectedDuration = effort;
       }
    }
    
    public void setActualStartDate(String date){
        this.actualStartDate = date;
    }
    
    public void setActualEndDate(String date){
        this.actualEndDate = date;
    }
    
    public void setActualDuration(double duration){
        if (duration < 0){
            System.out.println("Please enter a valid duration");
        } else{
           this.expectedDuration = duration;
        }
    }
    
    
    public void setEffortCompleted(double effort){
        this.effortCompleted = effort;
    }
    
    public void setActualEffort(double effort){
        this.actualEffort = effort;
    }
    
    public void setPercentComplete(double percentEffort){
        if (percentEffort < 0){
            System.out.println("Please enter a valid percent effort");
        } else{
           this.expectedDuration = percentEffort;
        }
    }
    
    public Object getResource(){
        return this.resource;
    }
    
    public String getExpectedStartDate(){
        return this.expectedStartDate;
    }
    
    public String getExpectedEndDate(){
        return this.expectedEndDate;
    }
    
    public double getExpectedDuration(){
        return this.expectedDuration;
    }
    
    public double getExpectedEffort(){
        return this.expectedEffort;
    }
    
    public String getActualStartDate(){
        return this.actualStartDate;
    }
    
    public String getActualEndDate(){
        return this.actualEndDate;
    }
    
    public double getActualDuration(){
        return this.actualDuration;
    }

    public double getEffortCompleted(){
        return this.effortCompleted;
    }
    
    public double getActualEffort(){
        return actualEffort;
    }
    
    public double getPercentComplete(){
        return percentComplete;
    }
    
    public void addPredecessorTask(Task task){
        predecessorTasks.add(task);
    }
    
    public void addSuccessorTask(Task task){
        successorTasks.add(task);
    }
    
    public void removePredecessorTask(int id){

        //Search the linkedList and delete the predecessorTask with matching ID
        for(int i = 0; i < predecessorTasks.size(); i++){
            Task tempTask = (Task) predecessorTasks.get(i);
            if(tempTask.getIdentifier() == id){
                predecessorTasks.remove(i);
            }else{
                System.out.println("Predecessor Task not found, call System Administrator toll free at 555-555-5525");
            }
         }
    }

    public void removeSuccessorTask(int id){
        for(int i = 0; i < predecessorTasks.size(); i++){
            Task tempTask = (Task)predecessorTasks.get(i);
            if(tempTask.getIdentifier() == id){
                this.successorTasks.remove(i);
            }else{
                System.out.println("Successor Task not found, call System Administrator toll free at 555-555-5525");
            }
         }
    }
    
    public void addIssue(Object issue){
        this.issueList.add(issue);
    }
    
    public void removeIssue(int id){
        for(int i = 0; i < predecessorTasks.size(); i++){
            Task tempTask = (Task) predecessorTasks.get(i);
            if(tempTask.getIdentifier() == id){
                this.successorTasks.remove(i);
            }else{
                System.out.println("Issue not found, call System Administrator toll free at 555-555-5525");
            }
         }
    }
    public void addDependancies(Task task, String dependancyType){
         //Add the Object to linkedList, Finish to Start (fs), Start to Finish (sf), Start to Start (ss), Finish to Finish (ff)
        if (dependancyType.equals("fs")){
            this.finishToStart.add(task);
        } else if(dependancyType.equals("sf")){
            this.startToFinish.add(task);
        } else if(dependancyType.equals("ss")){
            this.startToStart.add(task);
        } else if(dependancyType.equals("ff")){
            this.finishToFinish.add(task);
        } else{
            System.out.println("Dependancy not found, call System Administrator toll free at 555-555-5525");
        }
    }

    public void setTaskAsSummary(int id){
        this.isSummaryTask = true;
    }
    
    public void setMilestone(){
        this.isMileStone = true;
    }
    
    //public void updateDependancies(Task task){
    //     FOR the.size() of the finishToStart
    //         IF task equals current task id
    //             finishToStart.remove(index)
    //         ELSE
    //             //Skip
    //     END
    
    //     FOR the.size() of the startToFinish
    //         IF task equals current task id
    //             startToFinish.remove(index)
    //         ELSE
    //             //Skip
    //     END
    
    //     FOR the.size() of the  startToStart
    //         IF task equals current task id
    //             startToStart.remove(index)
    //         ELSE
    //             //Skip
    //     END
    
    //     FOR the.size() of the finishToFinish
    //         IF task equals current task id
    //             finishToFinish.remove(index)
    //         ELSE
    //             //Skip
    
    //     END
    
    public void listAssociatedResources(){
         System.out.println("Resource ID attached: "+ this.resource.getID());    
    }
    
    public void listAssociatedIssues(){
        for(int i = 0; i < issueList.size(); i++){
            System.out.println("Issue Name: " + issueList.get(i).getName() + ", Issue ID: " + issueList.get(i).getID());
        }
    }
    
    public void removeSummaryTask(){
        isSummaryTask = false;
    }
    
}