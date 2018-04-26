/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author damaomao
 */
public class User implements IUser{
    List<String> executions = new ArrayList<>();
    
    String assigneeType = "assignee";
    String assignee;    
    
    public User(String userID){
        this.assignee = userID;
    }
    
    public void addIssue(String issueID){
        executions.add(issueID);
    }
    
    public String[][] getIssueList(){
        return convertToIssueID();
    }
    
    public void setAssignee(String userID){
        this.assignee = userID;
    }
    
    public String[][] convertToIssueID(){
        
        System.out.println(executions.size());
        int size = executions.size();
        int group = (size/120)+1;
        String[][] ids = new String[group][120];
        for(int i=0;i<size;i++){
            int groupid = i/120;
            ids[groupid][i%120] = executions.get(i);
        }
        
        return ids;
    }
}
