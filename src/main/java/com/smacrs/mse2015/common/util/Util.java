/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smacrs.mse2015.common.util;

import com.smacrs.mse2015.common.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author alaa
 */

@Component
public class Util {
    
    @Autowired
    UserService userService;
    
    public long getUserId(String codde,int type){
       String table="";
       if(type == 1)
           table="PgStudent";
       else if(type == 2)
           table="PgSupervisor";
       else if (type == 3)
           table="PgSupervisor";
       else if(type == 4)
           table="Employee";
       return userService.getUserId(codde, table);
    }
    
}
