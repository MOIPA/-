package com.example.tr.instantcool2.Utils;

import android.util.Xml;

import com.example.tr.instantcool2.JavaBean.Conversation;

import org.xmlpull.v1.XmlPullParser;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by TR on 2017/10/10.
 */

public class StreamUtil {

    public static String readStream(InputStream in) throws Exception {

        // 定义一个内存输出流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int len = -1;
        byte[] buffer = new byte[1024]; // 1kb
        while ((len = in.read(buffer)) != -1) {

            baos.write(buffer, 0, len);
        }
        in.close();
        String content = new String(baos.toByteArray());

        return content;

    }

    /**
     * <?xml version='1.0'encoding='UTF-8?>
     *<contents>
         *<conversation>
         *  <targetaccount>tzq</targetaccount>
         *  <targetname></targetname>
         *</conversation>
         *<conversation>
         *  <targetaccount>sx</targetaccount>
         *  <targetname>ssx</targetname>
         *</conversation>
     *</contents>
     */
    public static List<Conversation> XmlParserConversation(InputStream in)throws Exception{

        List<Conversation> list = null;
        Conversation conversation=null;

        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(in,"utf-8");
        int eventType = parser.getEventType();
        while(eventType!=XmlPullParser.END_DOCUMENT){

            switch (eventType){
                case XmlPullParser.START_TAG :
                    if(parser.getName().equals("contents"))list = new ArrayList<Conversation>();
                    else if(parser.getName().equals("conversation"))conversation = new Conversation();
                    else if(parser.getName().equals("targetaccount")){
                        conversation.setTargetaccount(parser.nextText());
                    }else if(parser.getName().equals("targetname")){
                        conversation.setTargetname(parser.nextText());
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if(parser.getName().equals("conversation")){
                        list.add(conversation);
                    }
                    break;
            }

            eventType = parser.next();
        }

        return list;
    }

}
