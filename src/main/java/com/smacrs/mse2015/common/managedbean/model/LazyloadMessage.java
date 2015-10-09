/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smacrs.mse2015.common.managedbean.model;

import com.smacrs.mse2015.common.entity.CommonMessage;
import com.smacrs.mse2015.common.service.UserService;
import java.util.List;
import java.util.Map;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortMeta;
import org.primefaces.model.SortOrder;


/**
 *
 * @author alaa
 */
public class LazyloadMessage extends LazyDataModel<CommonMessage>{

    private int count;
    private int allcount;
    public static Map<String, Object> filters;
    UserService userService;

    public Map<String, Object> getFilters() {
        return filters;
    }

    public void setFilters(Map<String, Object> filters) {
        LazyloadMessage.filters = filters;
    }

    public LazyloadMessage(UserService userService, int count) {
        this.userService = userService;
        this.count = count;
        this.allcount = count;
    }

    @Override
    public Object getRowKey(CommonMessage message) {
        return message.getId();
    }

    @Override
    public CommonMessage getRowData(String rowKey) {
        return super.getRowData(rowKey); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getRowIndex() {
        return super.getRowIndex(); //To change body of generated methods, choose Tools | Templates.
    }

    
  
    @Override
    public int getRowCount() {
        return this.count;
    }

    @Override
    public List<CommonMessage> load(int first, int pageSize, List<SortMeta> multiSortMeta, Map<String, Object> filters) { 
        List<CommonMessage> list = this.userService.findMessage(filters, first, pageSize);     
        this.count = this.userService.getMessageCount(filters);
            LazyloadMessage.filters = filters;
        this.count = this.allcount;
        return list;
    }

    @Override
    public List<CommonMessage> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
       List<CommonMessage> list = this.userService.findMessage(filters, first, pageSize);       
       this.count = this.userService.getMessageCount(filters);
        LazyloadMessage.filters = filters;
        this.count = this.allcount;
        return list;
    }
}