/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests;

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
public class BulkAssign implements IRequest{
    //Executions issues;
    String body;
    String AO;
    String cookie;
     
    public BulkAssign(){
        
    }
    public String Send(String body, String AO, String cookie){
         /**
     * 向指定 URL 发送POST方法的请求
     * 
     * @param url
     *            发送请求的 URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return 所代表远程资源的响应结果
     */
    
        String response = "";  
        PrintWriter out = null;
        BufferedReader in = null;
        
        //String issue = this.execution.Issue;
        final String url = "https://itfjira.mercedes-benz-finance.com.cn/jira/rest/zephyr/latest/execution/bulkAssign";
    
        //String result = "";
        try {
            HttpsURLConnection conn = util.getHttpsConn(url);
            
            // 设置通用的请求属性
            conn.setRequestMethod("PUT");
            
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
            conn.setRequestProperty("Host", "itfjira.mercedes-benz-finance.com.cn");
            //conn.setRequestProperty("Content-Length", "375");
            conn.setRequestProperty("AO-7DEABF", AO);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("Referer", "https://itfjira.mercedes-benz-finance.com.cn/jira/secure/enav/");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            conn.setRequestProperty("Accept-Language", "en,zh-CN;q=0.9,zh;q=0.8");
            conn.setRequestProperty("Cookie", cookie);
            
            //conn.setRequestMethod("GET");
            conn.connect();
            // 获取URLConnection对象对应的输出流
            out = new PrintWriter(conn.getOutputStream());
            // 发送请求参数
            out.print(body);
            // flush输出流的缓冲
            out.flush();
            long end = System.currentTimeMillis();
            //System.out.println(end-begin);
            // 一旦发送成功，用以下方法就可以得到服务器的回应：
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
            System.out.println("发送 POST 请求出现异常！"+e);
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
       
   
        return response;
    }
    public String Parser(String response){
           // String id = response.substring(21, 26);
            //System.out.println("Execution ID: " + id);
            //System.out.println(sTotalString.indexOf("assigneeUserName"));
            //String currentAssignee = response.substring(response.indexOf("assigneeUserName") + 19, response.indexOf("assigneeUserName")+26);
            //System.out.println("Current Assignee: " + currentAssignee);
            
            //ArrayList<String> issues = new ArrayList<>();
            //issues.add(id);
            //Executions execs = new Executions(execution.Asignee, issues);
            //Gson json = new Gson();
            //String body = json.toJson(execs);
            return response;
    }
}
