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
    double percentComplete;
    LinkedList predecessorTasks = new LinkedList();
    LinkedList successorTasks = new LinkedList();
    LinkedList issueList = new LinkedList();
    LinkedList startToStart = new LinkedList();
    LinkedList startToFinish = new LinkedList();
    LinkedList finishToStart = new LinkedList();
    LinkedList finishToFinish = new LinkedList();
    boolean isMilestone;
    boolean isSummaryTask;

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
    
    // addPredecessorTask(task: Object){
    //     predecessorTasks.add(task)
    // }
    
    // addSuccessorTask(task: Object){
    //     successorTasks.add(task)
    // }
    
    // removePredecessorTask(id: int){
    //     FOR the length of the predecessorTasks
    //         IF id equals current task id
    //             predecessorTasks.remove(index)
    //             //Break out of loop
    //         ELSE
    //             //Skip
    // }
    
    // + removeSuccessorTask(id: int){
    // FOR the length of the successorTasks
    //         IF id equals current task id
    //             successorTasks.remove(index)
    //             //Break out of loop
    //         ELSE
    //             //Skip
    // }
    
    // addIssue(issue: Object){
    //     issueList.add(issue);
    // }
    
    // removeIssue(id: int){
    // FOR the length of the issues
    //         IF id equals current issue id
    //             issue.remove(index)
    //             //Break out of loop
    //         ELSE
    //             //Skip
    // }
    // addDependancies(task: Object, dependancyType: String){
    //     //Add the Object to linkedList, Finish to Start (fs), Start to Finish (sf), Start to Start (ss), Finish to Finish (ff)
    //     IF dependancy is fs
    //         //Add task to finishToStart LinkedList
    //     ELSE IF dependancy is sf
    //         /Add task to startToFinish LinkedList
    //     ELSE IF dependancy is ss
    //         /Add task to startToStart LinkedList
    //     ELSE IF dependancy is fs
    //         /Add task to finishToFinish LinkedList
    // }
    
    // setTaskAsSummary(id: int){
    //     isSummaryTask = true
    // }
    
    // setMilestone(){
    //     isMileStone = true;
    // }
    
    // updateDependancies(task: Object){
    //     FOR the length of the finishToStart
    //         IF task equals current task id
    //             finishToStart.remove(index)
    //         ELSE
    //             //Skip
    //     END
    
    //     FOR the length of the startToFinish
    //         IF task equals current task id
    //             startToFinish.remove(index)
    //         ELSE
    //             //Skip
    //     END
    
    //     FOR the length of the  startToStart
    //         IF task equals current task id
    //             startToStart.remove(index)
    //         ELSE
    //             //Skip
    //     END
    
    //     FOR the length of the finishToFinish
    //         IF task equals current task id
    //             finishToFinish.remove(index)
    //         ELSE
    //             //Skip
    
    //     END
    
    // listAssociatedResources(){
    //     PRINT Resource ID    
    // }
    
    // listAssociatedIssues(){
    // FOR the length of the issueList
    //         IF issue equals current issue id
    //             PRINT issue id
    //         ELSE
    //             //Skip
    //     END
    // }
    
    public void removeSummaryTask(){
        isSummaryTask = false;
    }
    
}