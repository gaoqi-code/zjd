package com.bbc.util;
import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
    /**
     * 向指定URL发送GET方法的请求
     *
     * @param apiUrl
     *            发送请求的URL
     * @param param
     *            请求参数，请求参数应该是 name1=value1&name2=value2 的形式。
     * @return URL 所代表远程资源的响应结果
     */
    public static String sendGet(String apiUrl, String param) {
        String str= null;
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setReadTimeout(5000);//将读超时设置为指定的超时，以毫秒为单位。用一个非零值指定在建立到资源的连接后从 Input 流读入时的超时时间。如果在数据可读取之前超时期满，则会引发一个 java.net.SocketTimeoutException。
            con.setDoInput(true);//指示应用程序要从 URL 连接读取数据。
            con.setRequestMethod("GET");//设置请求方式
            if(con.getResponseCode() == 200){//当请求成功时，接收数据（状态码“200”为成功连接的意思“ok”）
                InputStream is = con.getInputStream();
                str = formatIsToString(is);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return str;
    }

    public static String formatIsToString(InputStream is)throws Exception{
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        int len = -1;
        try {
            while( (len=is.read(buf)) != -1){
                baos.write(buf, 0, len);
            }
            baos.flush();
            baos.close();
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(baos.toByteArray(),"utf-8");
    }


    public static String httpsRequest(String requestUrl, String requestMethod, String output) {
        try{
            URL url = new URL(requestUrl);
            HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            connection.setRequestMethod(requestMethod);
            if (null != output) {
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(output.getBytes("UTF-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            connection.disconnect();
            return buffer.toString();
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return "";
    }
}
