/**
 * FunctionalRequirement
 */
public class FunctionalRequirement {

    int uniqueIdentifier;
    String name;
    String description;
    String dueDate;

    public FunctionalRequirement(){
        
    }

    public static void main(String[] args) {
        
    }

    public int getIdentifier(){
        return this.uniqueIdentifier;
    }

    public String getName(){
        return this.name;
    }
    
    public String getDescription(){
        return this.description;
    }

    public void setIdentifier(int id){
        this.uniqueIdentifier = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Object saveAndSendToDatabase(){
        //This object should be replaced with the task/deliverable/etc object
        return null;
    }

}