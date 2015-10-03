/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smacrs.mse2015.common.managedbean;

import com.smacrs.mse2015.common.entity.User;
import com.smacrs.mse2015.common.service.UserService;

import java.io.Serializable;

import javax.inject.Named;
import javax.enterprise.context.Dependent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 *
 * @author alaa_ayoub
 */
@Named(value = "testBean")
@Controller
@Dependent
public class TestBean implements Serializable {

    /**
     * Creates a new instance of TestBean
     */
    
    String name ;
    String pass;
    
    @Autowired
    private UserService userService;
    public TestBean() {
    }


    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public String go() {
        String go="";
        User user = new User();
        user.setUserName(name);
        user.setPassword(pass);
        User loginUser = userService.getUser(user);
        System.out.println("user   ::: " + loginUser.getId());
        if (loginUser != null) {
            go="go";
        }
        return go;
    }
}
