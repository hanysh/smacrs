/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smacrs.mse2015.common.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alaa
 */
@Entity
@Table(name = "common_user_login")
@NamedQueries({
    @NamedQuery(name = "CommonUserLogin.findAll", query = "SELECT c FROM CommonUserLogin c"),
    @NamedQuery(name = "CommonUserLogin.findById", query = "SELECT c FROM CommonUserLogin c WHERE c.id = :id"),
    @NamedQuery(name = "CommonUserLogin.findByUserName", query = "SELECT c FROM CommonUserLogin c WHERE c.userName = :userName"),
    @NamedQuery(name = "CommonUserLogin.findByPassword", query = "SELECT c FROM CommonUserLogin c WHERE c.password = :password"),
    @NamedQuery(name = "CommonUserLogin.findByActive", query = "SELECT c FROM CommonUserLogin c WHERE c.active = :active")})
public class CommonUserLogin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "password")
    private String password;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recipientUserId")
    private List<CommonMessageRecipient> commonMessageRecipientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<UgStudent> ugStudentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senderUserId")
    private List<CommonMessage> commonMessageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<PgStudent> pgStudentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<Employee> employeeList;
    @JoinColumn(name = "user_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LutUserType userTypeId;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId")
    private List<StaffMember> staffMemberList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "originatorUserId")
    private List<CommonMessageThread> commonMessageThreadList;

    public CommonUserLogin() {
    }

    public CommonUserLogin(Integer id) {
        this.id = id;
    }

    public CommonUserLogin(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<CommonMessageRecipient> getCommonMessageRecipientList() {
        return commonMessageRecipientList;
    }

    public void setCommonMessageRecipientList(List<CommonMessageRecipient> commonMessageRecipientList) {
        this.commonMessageRecipientList = commonMessageRecipientList;
    }

    public List<UgStudent> getUgStudentList() {
        return ugStudentList;
    }

    public void setUgStudentList(List<UgStudent> ugStudentList) {
        this.ugStudentList = ugStudentList;
    }

    public List<CommonMessage> getCommonMessageList() {
        return commonMessageList;
    }

    public void setCommonMessageList(List<CommonMessage> commonMessageList) {
        this.commonMessageList = commonMessageList;
    }

    public List<PgStudent> getPgStudentList() {
        return pgStudentList;
    }

    public void setPgStudentList(List<PgStudent> pgStudentList) {
        this.pgStudentList = pgStudentList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public LutUserType getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(LutUserType userTypeId) {
        this.userTypeId = userTypeId;
    }

    public Institution getInstId() {
        return instId;
    }

    public void setInstId(Institution instId) {
        this.instId = instId;
    }

    public List<StaffMember> getStaffMemberList() {
        return staffMemberList;
    }

    public void setStaffMemberList(List<StaffMember> staffMemberList) {
        this.staffMemberList = staffMemberList;
    }

    public List<CommonMessageThread> getCommonMessageThreadList() {
        return commonMessageThreadList;
    }

    public void setCommonMessageThreadList(List<CommonMessageThread> commonMessageThreadList) {
        this.commonMessageThreadList = commonMessageThreadList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommonUserLogin)) {
            return false;
        }
        CommonUserLogin other = (CommonUserLogin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.CommonUserLogin[ id=" + id + " ]";
    }
    
}
