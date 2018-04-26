/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestExecution;

import Requests.AO;
import Requests.IRequest;
import Requests.IssueID;
import Requests.BulkAssign;
import Requests.Login;
import Requests.UserID;
import Users.IUser;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author damaomao
 */
public class assign {
    static String assignee;
    static String issueNo;
   
    public static void main(String[] args) throws InterruptedException{
        long begin = System.currentTimeMillis();
        int count = 0;
        Login login = new Login();
        String sessionID = login.Send("os_username=hshansh&os_password=Abcd12345$");
        String ao = AO.get(sessionID);
        //Login login = new Login();
        //String result = login.Send("os_username=hshansh&os_password=Abcd12345$");
        //System.out.println(ao);
        //System.exit(0);
        
        Gson gson = new Gson();
//        String body = json.toJson(execs);
//        System.out.println(body);
        
        //run();
        Map<String, IUser> map = Excel.read("D:/test.xlsx","",sessionID);
        
        for(Entry<String, IUser> entry: map.entrySet()){
            String username = entry.getKey().replace(" ", "+");
            
            String userID = UserID.get(username, sessionID);
            IUser user = entry.getValue();
            user.setAssignee(userID);
            
            String[][] issueList = user.getIssueList();
            //System.out.println(username + ": " + );
            //change to userID
            for(String[] list: issueList){
                int counts = 0;
                for(String id:list){
                    if(id != null) counts++;
                }
                //System.out.println(counts);
            }
            
            //bulk assign
           //System.out.println(username + "(" + userID + "): " + issueList.size() + " executions");
            System.out.println(entry.getKey() + ": " + gson.toJson(entry.getValue()));
            //count += issueList.size();
            //run();
           
           
          
           
         
            //Thread.sleep(100);
            //count++;
        }
        long end = System.currentTimeMillis();
        System.out.println("Total assigned: " + count + " in " + (end-begin) + " ms");
    }
//    static void run(){
//
//        Execution issue = new Execution();
//        issue.setAO("kbsVJv0zeDVwpRjon09PKdN/aApRYTQWY/A4Hbt8ScopPb6rcsyLjSeX9UYO3wZlVALOvihEOKhwbYSycSbKmQ==");
//        issue.setAsignee(assignee);
//        issue.setIssue(issueNo);
//        issue.setCookie("E52DD89B0FEFD0DC5CEF2D5EB7CF2446");
//        
//        IRequest request = new RequestIssueID(issue);
//        request.Send();
//        String body = request.Parser();
//        System.out.println(body);
//        
//        request = new ChangeAssignee(body, issue.AO, issue.cookie);
//        request.Send();
//        System.out.println(request.Parser());
//    }
}
