package com.bbc.util;

import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import com.bbc.entity.TextMsg;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MsgUtil {
    public static final String MSG_TEXT="text";
    public static final String MSG_IMAGE="image";
    public static final String MSG_VOICE="voice";
    public static final String MSG_VIDEO="video";
    public static final String MSG_LINK="link";
    public static final String MSG_LOCATION="location";
    public static final String MSG_EVENT="event";
    public static final String MSG_SUBSCRIBE="subscribe";
    public static final String MSG_UNSUBSCRIBE="unsuscribe";
    public static final String MSG_CLICK="CLICK";
    public static final String MSG_VIEW="VIEW";

    //XML to collection,(xml comes from weixin)
    public static Map<String,String> Xml2Map(HttpServletRequest req) throws IOException,DocumentException{
        Map<String,String> map=new HashMap<String,String>();
        //dom4j.jar
        SAXReader reader=new SAXReader();
        InputStream is=req.getInputStream();
        Document doc=reader.read(is);
        Element root=doc.getRootElement();

        @SuppressWarnings("unchecked")
        List<Element> list=root.elements();
        for(Element e:list){
            map.put(e.getName(),e.getText());
        }
        is.close();
        return map;
    }

    //for doPost
    public static String textMsg2Xml(TextMsg textMsg){
        //import xstream.jar
        XStream xs = new XStream();
        xs.alias("xml",textMsg.getClass());  //XML root modified
        return xs.toXML(textMsg);
    }

    //main menu
    public static String initText(String toUserName,String fromUserName,String content){
        String msg=null;
        TextMsg textMsg=new TextMsg();
        textMsg.setFromUserName(toUserName);
        textMsg.setToUserName(fromUserName);
        textMsg.setMsgType(MsgUtil.MSG_TEXT);
        textMsg.setCreateTime(new Date().getTime());
        textMsg.setContent(content);
        msg = textMsg2Xml(textMsg);
//        System.out.println(msg);
        return msg;
    }

    //menu
    public static String menuText(){
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎关注\n");
        sb.append("1、欢迎\n");
        sb.append("2、介绍\n");
        sb.append("回复？调出菜单");
        return sb.toString();
    }
    public static String oneText(){
        StringBuffer sb = new StringBuffer();
        sb.append("祝你好运\n");
        sb.append("回复？调出菜单");
        return sb.toString();
    }
    public static String twoText(){
        StringBuffer sb=new StringBuffer();
        sb.append("祝你发财\n");
        sb.append("回复？调出菜单");
        return sb.toString();
    }
}
