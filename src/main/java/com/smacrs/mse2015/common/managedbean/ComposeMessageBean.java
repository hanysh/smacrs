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
import java.util.AbstractList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alaa_ayoub
 */
@Named(value = "composeMessageBean")
//@Controller
@Dependent
public class ComposeMessageBean implements Serializable {

    /**
     * Creates a new instance of TestBean
     */
    
    String name ;
    String to;
    String subject;
    String text;
    int userTypeId;

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
    public ComposeMessageBean() {
    }

    @PostConstruct
    public void init(){
        userTypes=userService.getAllType();
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public String go() {
        String go="";
        CommonMessage message=new CommonMessage();
        message.setInstId(new Institution(1));
        message.setBody(text);
        message.setSubject(subject);
        message.setAttachements("SFsdf");
        message.setSenderUserId(new CommonUserLogin(1));
        message.setSentDate(new Date());
        int recp=util.getUserId(to, userTypeId);
        userService.insertMessage(message,recp);
        
        return go;
    }
}
