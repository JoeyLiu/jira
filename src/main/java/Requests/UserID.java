/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests;

import TestExecution.Executions;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author damaomao
 */
public class UserID {
    //static String response = "";
    public static String get(String username, String sessionID){    
        String response = "";
        PrintWriter out = null;
        BufferedReader in = null;
        
        //String issue = this.execution.Issue;
       String url = "https://itfjira.mercedes-benz-finance.com.cn/jira/rest/api/1.0/users/picker?showAvatar=true&query="
                + username
                + "&_=1524146942835";
        String cookie = "JSESSIONID=" + sessionID + "; " + 
                    "atlassian.xsrf.token=BPG5-GWTN-WZYV-Q7R0|ea376c159aecc94a80f7cde1751425082d2ffb06|lin";
        //String result = "";
        //System.out.println(url);
        try {
            HttpsURLConnection conn = util.getHttpsConn(url);
            
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
            conn.setRequestProperty("Host", "itfjira.mercedes-benz-finance.com.cn");
            //conn.setRequestProperty("Content-Length", "375");
            //conn.setRequestProperty("AO-7DEABF", execution.AO);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Referer", "https://itfjira.mercedes-benz-finance.com.cn/jira/secure/enav/");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            conn.setRequestProperty("Accept-Language", "en,zh-CN;q=0.9,zh;q=0.8");
            conn.setRequestProperty("Cookie", cookie);
            
            conn.setRequestMethod("GET");
            conn.connect();

              String sCurrentLine;
              //String sTotalString;
              sCurrentLine = "";
              //sTotalString = "";
              InputStream l_urlStream;
              l_urlStream = conn.getInputStream();
              
              
              GZIPInputStream gzin = new GZIPInputStream(l_urlStream);
              // 三层包装
              BufferedReader l_reader = new BufferedReader(new InputStreamReader(
                gzin,"utf-8"));
              while ((sCurrentLine = l_reader.readLine()) != null) {
               response += sCurrentLine + "\r\n";
              }
              //System.out.println(sTotalString);
              
            //util.getResponseHeader(conn);

        } catch (Exception e) {
            System.out.println("发送请求出现异常！"+e);
            e.printStackTrace();
        }
        //使用finally块来关闭输出流、输入流
        finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
       //System.out.println(response);
        return Parser(response);
    }
    public static String Parser(String response){
        String userID = "";
            //String id = response.substring(21, 26);
            //System.out.println(response);
            int begin = response.lastIndexOf("<users><name>");
            
            int end = response.lastIndexOf("</name><html>");
            userID = response.substring(begin+13, end);
            //System.out.println(sTotalString.indexOf("assigneeUserName"));
            //String currentAssignee = response.substring(response.indexOf("assigneeUserName") + 19, response.indexOf("assigneeUserName")+26);
            //System.out.println("Current Assignee: " + currentAssignee);
            //ArrayList<String> issues = new ArrayList<>();
            //issues.add(id);
            //Executions execs = new Executions(execution.Asignee, issues);
            //Gson json = new Gson();
            //String body = json.toJson(execs);
            //return body;
            return userID;
    }
}
