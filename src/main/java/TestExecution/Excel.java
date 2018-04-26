/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestExecution;

import Requests.IRequest;
import Requests.IssueID;
import Requests.UserID;
import Users.IUser;
import Users.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 *
 * @author damaomao
 */
public class Excel {
    //static String AO = "nhg2xgqOzR9TGZixjoOJe7Vxrtq02Vnfs8ekttIxiXwSFg/wu4wO6rmNax04sInk5XC9VpUCLq9PjEji3ZNg8A==";
    //static String cookie = "175B2C303EE824A5A851490A6218B9FB";
    public static Map read(String filename, String AO, String cookie) {
        Map<String, IUser> map = new HashMap();
        String tester = "";
        String issueNo = "";
        File file = new File(filename);  
        InputStream inputStream = null;  
        Workbook workbook = null;  
        try {  
            inputStream = new FileInputStream(file);  
            workbook = new XSSFWorkbook(inputStream);  
            inputStream.close();  

            Sheet sheet = workbook.getSheetAt(1);  

            int rowLength = sheet.getPhysicalNumberOfRows();  

            Row row;  
            IRequest request = new IssueID();
            for (int i = 0; i < rowLength; i++) {  
                row = sheet.getRow(i);  
               tester = row.getCell(0).getStringCellValue();
                issueNo = row.getCell(1).getStringCellValue();
                
                //issueNo = request.Parser(request.Send(issueNo, AO, cookie));
                //System.out.println(issueNo);
                if(map.get(tester) != null){
                    map.get(tester).addIssue(issueNo);
                    
                }else{
                    IUser user = new User(tester);
                    map.put(tester,user);
                    map.get(tester).addIssue(issueNo);
                }
                
            }  

        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return map;
    }  
}
