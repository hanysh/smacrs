/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smacrs.mse2015.common.managedbean;

import com.smacrs.mse2015.common.entity.CommonMessage;
import com.smacrs.mse2015.common.entity.LutUserType;
import com.smacrs.mse2015.common.managedbean.model.LazyloadMessage;
import com.smacrs.mse2015.common.service.UserService;
import java.io.IOException;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.servlet.http.HttpSession;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author alaa_ayoub
 */
@Named(value = "messageBean")
@ViewScoped
public class MessageBean implements Serializable {

    /**
     * Creates a new instance of TestBean
     */
 
    
    List<CommonMessage> messgelist;
    CommonMessage selectedMessage;
    List<LutUserType> userTypes;
    int userTypeId;

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public List<LutUserType> getUserTypes() {
        return userTypes;
    }

    public void setUserTypes(List<LutUserType> userTypes) {
        this.userTypes = userTypes;
    }
    
    public CommonMessage getSelectedMessage() {
        return selectedMessage;
    }

    public void setSelectedMessage(CommonMessage selectedMessage) {
        this.selectedMessage = selectedMessage;
    }
    int count;


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CommonMessage> getMessgelist() {
        return messgelist;
    }

    public void setMessgelist(List<CommonMessage> messgelist) {
        this.messgelist = messgelist;
    }
    
    @Autowired
    private UserService userService;
    public MessageBean() {
    }

    @PostConstruct
    public void init(){
        userTypes=userService.getAllType(); 
        count=userService.getMessageCount("inbox", 1, null);
        
    }


    public String go() {
        String go="";
        return go;
    }
    
    private LazyDataModel<CommonMessage> commonMessagelazy;
    private List<CommonMessage> commonMessageFiltered;

    public List<CommonMessage> getCommonMessageFiltered() {
        return commonMessageFiltered;
    }

    public void setCommonMessageFiltered(List<CommonMessage> commonMessageFiltered) {
        this.commonMessageFiltered = commonMessageFiltered;
    }

    public LazyDataModel<CommonMessage> getCommonMessagelazy() {
        if (this.commonMessagelazy == null) {
            this.commonMessagelazy = new LazyloadMessage(userService, "inbox", 1, count,null);
        }
        return this.commonMessagelazy;
    }
    public void setCommonMessagelazy(LazyDataModel<CommonMessage> commonMessagelazy) {
        this.commonMessagelazy = commonMessagelazy;
    }
    
     public void onRowSelect(SelectEvent event) {
        try {
            //        FacesContext.getCurrentInstance().getExternalContext().getFlash().put("selectedMessage", event.getObject());
//
//        return "viewMessage.xhtml?faces-redirect=true";
//             FacesMessage msg = new FacesMessage("Car Selected", ((CommonMessage) event.getObject()).getSubject());
//            System.out.println("ssss   "+selectedMessage);
//            System.out.println("eeeeee   "+((CommonMessage) event.getObject()));
            CommonMessage msg=(CommonMessage) event.getObject();
          
            FacesContext facesContext = FacesContext.getCurrentInstance();
            HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(true);
            session.setAttribute("Threadid", msg.getMessageThreadId().getId());
            FacesContext.getCurrentInstance().getExternalContext().redirect("viewMessage.xhtml");
        
        } catch (IOException ex) {
            Logger.getLogger(MessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
     public void apply(){
         Map<String,Object> filters=new HashMap<String,Object>();
         if(userTypeId !=0){
             filters.put("","");
         }
          this.commonMessagelazy = new LazyloadMessage(userService, "inbox", 1, count,null);
     }
}
