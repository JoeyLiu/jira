/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Users;

import java.util.List;

/**
 *
 * @author damaomao
 */
public interface IUser {
    public void addIssue(String issueID);
    public String[][] getIssueList();
    public void setAssignee(String userID);
    public String[][] convertToIssueID();
}
