/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestExecution;

/**
 *
 * @author damaomao
 */
public class Execution {
    public String Asignee;
    public String Issue;
    public String IssueID;
    public String cookie;
    public String AO;
    
    public void setAsignee(String asignee){
        this.Asignee = asignee;
    }
    
    public void setIssue(String issue){
        this.Issue = issue;
    }
    
    public void setIssueID(String IssueID){
        this.IssueID = IssueID;
    }
    
    public void setCookie(String session){
        this.cookie = "JSESSIONID=" + session + "; " + 
                    "atlassian.xsrf.token=BPG5-GWTN-WZYV-Q7R0|ea376c159aecc94a80f7cde1751425082d2ffb06|lin";
    }
    
    public void setAO(String AO){
        this.AO = AO;
    }
    
}
