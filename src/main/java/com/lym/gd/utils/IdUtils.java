package com.lym.gd.utils;


import com.lym.gd.entity.User;

import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * 获取实体类ID🆔
 * 加上实体类名称作为前缀，以做区分
 *
 * @author liuyaming
 * @date 2018/3/12 下午7:43
 */
public class IdUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static String getCourseId(){
        return "course"+getUUID();
    }

    public static String getCourseAttachmentId(){
        return "courseAttachment" + getUUID();
    }

    public static String getMessageId(){
        return "message"+getUUID();
    }

    public static String getMessageTemplateId(){
        return "messageTemplate"+getUUID();
    }

    public static String getResourceId(){
        return "resource"+getUUID();
    }

    public static String getStudentCourseId(){
        return "studentCourse"+getUUID();
    }

    public static String getUserId(){
        return "user"+getUUID();
    }

    public static String getWorkId(){
        return "work"+getUUID();
    }

    public static String getWorkAttachmentId(){
        return "workAttachment"+getUUID();
    }

  public static String getFileID() {
    return "file" + getUUID();
  }

  public static String getUserAndSessionId(HttpSession session){

      User user = (User) session.getAttribute("user");

      String userId = user.getUserId();

      String sessionId = session.getId();

      return userId + "##" + sessionId;
  }

  public static String getUserAndSessionIdAndName(HttpSession session){
        return getUserAndSessionId(session) + "##name";
  }
}
