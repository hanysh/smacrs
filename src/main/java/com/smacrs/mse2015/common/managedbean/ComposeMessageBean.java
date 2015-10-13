/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smacrs.mse2015.common.managedbean;

import com.smacrs.mse2015.common.entity.CommonMessage;
import com.smacrs.mse2015.common.entity.CommonMessageThread;
import com.smacrs.mse2015.common.entity.CommonUserLogin;
import com.smacrs.mse2015.common.entity.Institution;
import com.smacrs.mse2015.common.entity.LutUserType;
//import com.smacrs.mse2015.common.entity.User;
import com.smacrs.mse2015.common.service.UserService;
import com.smacrs.mse2015.common.util.BaseBean;
import com.smacrs.mse2015.common.util.Util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alaa_ayoub
 */
@Named(value = "composeMessageBean")
//@Controller
@Dependent
public class ComposeMessageBean extends BaseBean{

    /**
     * Creates a new instance of TestBean
     */
    String name;
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
    public void init() {
        message = new CommonMessage();
        userTypes = userService.getAllType();
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

    CommonMessage message;

    boolean disable;

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
    
    public CommonMessage getMessage() {
         load();
        if(reply != null && !reply.isEmpty() && reply.equals("true")){
            disable=true;
            System.out.println("rply    "+reply);
        }
        if(msgThread != null && !msgThread.isEmpty() ){
        System.out.println("thhh    "+msgThread);
        message.setMessageThreadId(new CommonMessageThread(Integer.parseInt(msgThread)));
        }
        if(subject != null && !subject.isEmpty() ){
        message.setSubject(subject);
        }
        return message;
    }

    public void setMessage(CommonMessage message) {
        this.message = message;
    }

    public String go() {
 
//        CommonMessage message=new CommonMessage();
        message.setInstId(new Institution(getInstitutionId()));
//        message.setBody(text);
//        message.setSubject(subject);
//        message.setAttachements("SFsdf");
        message.setSenderUserId(new CommonUserLogin(getUserId()));
        message.setSentDate(new Date());
        int recp = util.getUserId(to, userTypeId);
        userService.insertMessage(message, recp,disable);

        return "inbox";
    }

    public void upload(FileUploadEvent event) {
        try {
            UploadedFile uploadedFile = event.getFile();
            String fileName = uploadedFile.getFileName();
            copyFile(fileName, event.getFile().getInputstream());
        } catch (IOException ex) {
            Logger.getLogger(ComposeMessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void copyFile(String fileName, InputStream in) {
        try {

            String destination = "D:\\tmp\\";
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(destination + fileName));

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }

            in.close();
            out.flush();
            out.close();

            System.out.println("New file created!");
            message.setAttachements(destination + fileName);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    String reply;
    String msgThread;
    public void load(){
       
    FacesContext context = FacesContext.getCurrentInstance();
    Map requestParams = context.getExternalContext().getRequestParameterMap();
    reply = (String) requestParams.get("messagereply");
    subject = (String) requestParams.get("messagesSubject");
    msgThread= (String) requestParams.get("messageThead");
//        System.out.println("id        "+type);
        
//        Map<String, String> params = 
//                FacesContext.getExternalContext().getRequestParameterMap();
    }
}
