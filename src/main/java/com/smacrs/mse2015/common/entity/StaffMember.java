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
@Table(name = "staff_member")
@NamedQueries({
    @NamedQuery(name = "StaffMember.findAll", query = "SELECT s FROM StaffMember s"),
    @NamedQuery(name = "StaffMember.findById", query = "SELECT s FROM StaffMember s WHERE s.id = :id"),
    @NamedQuery(name = "StaffMember.findByName", query = "SELECT s FROM StaffMember s WHERE s.name = :name"),
    @NamedQuery(name = "StaffMember.findByCode", query = "SELECT s FROM StaffMember s WHERE s.code = :code"),
    @NamedQuery(name = "StaffMember.findByEmail", query = "SELECT s FROM StaffMember s WHERE s.email = :email")})
public class StaffMember implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "code")
    private String code;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "email")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffMemberId")
    private List<StaffMemberDiscipline> staffMemberDisciplineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
    private List<AcyearUndergradeCourseAssignation> acyearUndergradeCourseAssignationList;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CommonUserLogin userId;
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LutStaffMemberType typeId;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;
    @JoinColumn(name = "degree_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LutStaffMemberDegree degreeId;

    public StaffMember() {
    }

    public StaffMember(Integer id) {
        this.id = id;
    }

    public StaffMember(Integer id, String name, String code, String email) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<StaffMemberDiscipline> getStaffMemberDisciplineList() {
        return staffMemberDisciplineList;
    }

    public void setStaffMemberDisciplineList(List<StaffMemberDiscipline> staffMemberDisciplineList) {
        this.staffMemberDisciplineList = staffMemberDisciplineList;
    }

    public List<AcyearUndergradeCourseAssignation> getAcyearUndergradeCourseAssignationList() {
        return acyearUndergradeCourseAssignationList;
    }

    public void setAcyearUndergradeCourseAssignationList(List<AcyearUndergradeCourseAssignation> acyearUndergradeCourseAssignationList) {
        this.acyearUndergradeCourseAssignationList = acyearUndergradeCourseAssignationList;
    }

    public CommonUserLogin getUserId() {
        return userId;
    }

    public void setUserId(CommonUserLogin userId) {
        this.userId = userId;
    }

    public LutStaffMemberType getTypeId() {
        return typeId;
    }

    public void setTypeId(LutStaffMemberType typeId) {
        this.typeId = typeId;
    }

    public Institution getInstId() {
        return instId;
    }

    public void setInstId(Institution instId) {
        this.instId = instId;
    }

    public LutStaffMemberDegree getDegreeId() {
        return degreeId;
    }

    public void setDegreeId(LutStaffMemberDegree degreeId) {
        this.degreeId = degreeId;
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
        if (!(object instanceof StaffMember)) {
            return false;
        }
        StaffMember other = (StaffMember) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.StaffMember[ id=" + id + " ]";
    }
    
}
