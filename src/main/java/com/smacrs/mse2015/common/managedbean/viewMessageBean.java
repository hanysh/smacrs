/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smacrs.mse2015.common.managedbean;

import com.smacrs.mse2015.common.entity.CommonMessage;
import com.smacrs.mse2015.common.entity.CommonMessageRecipient;
import com.smacrs.mse2015.common.entity.CommonMessageThread;
import com.smacrs.mse2015.common.entity.CommonUserLogin;
import com.smacrs.mse2015.common.entity.Institution;
import com.smacrs.mse2015.common.entity.LutUserType;
//import com.smacrs.mse2015.common.entity.User;
import com.smacrs.mse2015.common.service.UserService;
import com.smacrs.mse2015.common.util.Util;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alaa_ayoub
 */
@Named(value = "viewMessageBean")
@ViewScoped
public class viewMessageBean implements Serializable {

    /**
     * Creates a new instance of TestBean
     */
    
    int messageThreadId ;
    String subject;
    int userTypeId;

    public int getMessageThreadId() {
        return messageThreadId;
    }

    public void setMessageThreadId(int messageThreadId) {
        this.messageThreadId = messageThreadId;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }
    List<LutUserType> userTypes;

    public List<LutUserType> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(List<LutUserType> userTypes) {
        this.userTypes = userTypes;
    }
    
    @Autowired
    private UserService userService;
    @Autowired
    private Util util;
    public viewMessageBean() {
    }

    List<CommonMessage> messages;

    public List<CommonMessage> getMessages() {
        if(messages == null)
            load();
        return messages;
    }

    public void setMessages(List<CommonMessage> messages) {
        this.messages = messages;
    }
    
    @PostConstruct
    public void init(){
        userTypes=userService.getAllType();
         
//        
//        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
//    Map requestParams = context.getRequestParameterMap();
//    String type = (String) requestParams.get("id");
//        System.out.println("id        "+type);
    }

//    public String getTo() {
//        return to;
//    }
//
//    public void setTo(String to) {
//        this.to = to;
//    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
  int threadid;
    private void load(){
        FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            threadid= (Integer)session.getAttribute("Threadid");
//           threadid=Integer.parseInt(s);
           System.out.println("sss   "+threadid);
        messages=userService.getMessage(threadid);
        messageThreadId = messages.get(0).getMessageThreadId().getId();
        subject = messages.get(0).getSubject();
    }

//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getName() {
//        return name;
//    }


    public String go() {
        String go="composeMessage.xhtml";
        
        
        return go;
    }
}
