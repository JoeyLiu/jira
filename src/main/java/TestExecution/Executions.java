/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestExecution;

import java.util.ArrayList;

/**
 *
 * @author damaomao
 */
public class Executions {
    ArrayList<String> executions = new ArrayList<>();
    String assigneeType = "assignee";
    String assignee;

    
    public Executions(String assignee, ArrayList<String> issues){
        this.assignee = assignee;
        this.executions = issues;
    }
}
