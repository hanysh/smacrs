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
@Table(name = "inst_undergrade_course")
@NamedQueries({
    @NamedQuery(name = "InstUndergradeCourse.findAll", query = "SELECT i FROM InstUndergradeCourse i"),
    @NamedQuery(name = "InstUndergradeCourse.findById", query = "SELECT i FROM InstUndergradeCourse i WHERE i.id = :id"),
    @NamedQuery(name = "InstUndergradeCourse.findByTeachedInFirstTerm", query = "SELECT i FROM InstUndergradeCourse i WHERE i.teachedInFirstTerm = :teachedInFirstTerm"),
    @NamedQuery(name = "InstUndergradeCourse.findByTeachedInSecondTerm", query = "SELECT i FROM InstUndergradeCourse i WHERE i.teachedInSecondTerm = :teachedInSecondTerm"),
    @NamedQuery(name = "InstUndergradeCourse.findByCode", query = "SELECT i FROM InstUndergradeCourse i WHERE i.code = :code"),
    @NamedQuery(name = "InstUndergradeCourse.findByShortName", query = "SELECT i FROM InstUndergradeCourse i WHERE i.shortName = :shortName"),
    @NamedQuery(name = "InstUndergradeCourse.findByName", query = "SELECT i FROM InstUndergradeCourse i WHERE i.name = :name"),
    @NamedQuery(name = "InstUndergradeCourse.findByActive", query = "SELECT i FROM InstUndergradeCourse i WHERE i.active = :active")})
public class InstUndergradeCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "teached_in_first_term")
    private boolean teachedInFirstTerm;
    @Basic(optional = false)
    @NotNull
    @Column(name = "teached_in_second_term")
    private boolean teachedInSecondTerm;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "short_name")
    private String shortName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Column(name = "active")
    private Boolean active;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;
    @JoinColumn(name = "ug_discipline_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstUndergradeDiscipline ugDisciplineId;
    @JoinColumn(name = "dep_year_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstDepartmentYear depYearId;
    @JoinColumn(name = "dep_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstDepartment depId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private List<AcyearUndergradeCourseAssignation> acyearUndergradeCourseAssignationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "courseId")
    private List<AcyearUndergradeCourseDetails> acyearUndergradeCourseDetailsList;

    public InstUndergradeCourse() {
    }

    public InstUndergradeCourse(Integer id) {
        this.id = id;
    }

    public InstUndergradeCourse(Integer id, boolean teachedInFirstTerm, boolean teachedInSecondTerm, String code, String shortName, String name) {
        this.id = id;
        this.teachedInFirstTerm = teachedInFirstTerm;
        this.teachedInSecondTerm = teachedInSecondTerm;
        this.code = code;
        this.shortName = shortName;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean getTeachedInFirstTerm() {
        return teachedInFirstTerm;
    }

    public void setTeachedInFirstTerm(boolean teachedInFirstTerm) {
        this.teachedInFirstTerm = teachedInFirstTerm;
    }

    public boolean getTeachedInSecondTerm() {
        return teachedInSecondTerm;
    }

    public void setTeachedInSecondTerm(boolean teachedInSecondTerm) {
        this.teachedInSecondTerm = teachedInSecondTerm;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Institution getInstId() {
        return instId;
    }

    public void setInstId(Institution instId) {
        this.instId = instId;
    }

    public InstUndergradeDiscipline getUgDisciplineId() {
        return ugDisciplineId;
    }

    public void setUgDisciplineId(InstUndergradeDiscipline ugDisciplineId) {
        this.ugDisciplineId = ugDisciplineId;
    }

    public InstDepartmentYear getDepYearId() {
        return depYearId;
    }

    public void setDepYearId(InstDepartmentYear depYearId) {
        this.depYearId = depYearId;
    }

    public InstDepartment getDepId() {
        return depId;
    }

    public void setDepId(InstDepartment depId) {
        this.depId = depId;
    }

    public List<AcyearUndergradeCourseAssignation> getAcyearUndergradeCourseAssignationList() {
        return acyearUndergradeCourseAssignationList;
    }

    public void setAcyearUndergradeCourseAssignationList(List<AcyearUndergradeCourseAssignation> acyearUndergradeCourseAssignationList) {
        this.acyearUndergradeCourseAssignationList = acyearUndergradeCourseAssignationList;
    }

    public List<AcyearUndergradeCourseDetails> getAcyearUndergradeCourseDetailsList() {
        return acyearUndergradeCourseDetailsList;
    }

    public void setAcyearUndergradeCourseDetailsList(List<AcyearUndergradeCourseDetails> acyearUndergradeCourseDetailsList) {
        this.acyearUndergradeCourseDetailsList = acyearUndergradeCourseDetailsList;
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
        if (!(object instanceof InstUndergradeCourse)) {
            return false;
        }
        InstUndergradeCourse other = (InstUndergradeCourse) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.InstUndergradeCourse[ id=" + id + " ]";
    }
    
}
