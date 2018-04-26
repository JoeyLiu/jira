/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Requests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author damaomao
 */
public class Login{
    public String Send(String body){
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
        final String url = "https://itfjira.mercedes-benz-finance.com.cn/jira/rest/gadget/1.0/login";
    
        //String result = "";
        try {
            HttpsURLConnection conn = util.getHttpsConn(url);
            
            // 设置通用的请求属性
            conn.setRequestMethod("POST");
            
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/5.0 (Windows NT 6.3; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/65.0.3325.181 Safari/537.36");
            conn.setRequestProperty("Host", "itfjira.mercedes-benz-finance.com.cn");
            //conn.setRequestProperty("Content-Length", "375");
            //conn.setRequestProperty("AO-7DEABF", AO);
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            conn.setRequestProperty("Referer", "https://itfjira.mercedes-benz-finance.com.cn/jira/secure/enav/");
            conn.setRequestProperty("Accept-Encoding", "gzip, deflate, br");
            conn.setRequestProperty("Accept-Language", "en,zh-CN;q=0.9,zh;q=0.8");
//            conn.setRequestProperty("Cookie", cookie);
            
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
            response = this.Parser(conn);
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
    public String Parser(HttpsURLConnection conn){
        String response = "";

            Map<String, List<String>> map = conn.getHeaderFields();
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                if(null != entry.getKey() && "Set-Cookie".equals(entry.getKey())){
                    
                    for(String s:entry.getValue()){
                        if(s.contains("JSESSIONID")){
                            //System.out.println(s);
                            response = s.substring(s.indexOf("JSESSIONID")+11, s.indexOf("JSESSIONID")+43);
                        }
                    }
                }
                else{                                       
                   //System.out.println(entry.getKey() + ": " + entry.getValue());
                    //System.out.println("Content-Encoding: " + conn.getHeaderField("Content-Encoding"));
                }
               //String cookie = conn.getHeaderField("Set-Cookie");
              
               //System.out.println(cookie);
               //response = cookie.substring(cookie.indexOf("JSESSIONID")+11, cookie.indexOf("JSESSIONID")+43);
              
            }
            String user = conn.getHeaderField("X-AUSERNAME");
            System.out.println("Logged in as: " + user);
            System.out.println("Session ID: " + response);
            return response;
    }
}
