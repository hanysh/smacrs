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
@Table(name = "inst_academic_year")
@NamedQueries({
    @NamedQuery(name = "InstAcademicYear.findAll", query = "SELECT i FROM InstAcademicYear i"),
    @NamedQuery(name = "InstAcademicYear.findById", query = "SELECT i FROM InstAcademicYear i WHERE i.id = :id"),
    @NamedQuery(name = "InstAcademicYear.findByDisplayName", query = "SELECT i FROM InstAcademicYear i WHERE i.displayName = :displayName"),
    @NamedQuery(name = "InstAcademicYear.findByDescription", query = "SELECT i FROM InstAcademicYear i WHERE i.description = :description"),
    @NamedQuery(name = "InstAcademicYear.findByStartYear", query = "SELECT i FROM InstAcademicYear i WHERE i.startYear = :startYear"),
    @NamedQuery(name = "InstAcademicYear.findByEndYear", query = "SELECT i FROM InstAcademicYear i WHERE i.endYear = :endYear"),
    @NamedQuery(name = "InstAcademicYear.findByActive", query = "SELECT i FROM InstAcademicYear i WHERE i.active = :active")})
public class InstAcademicYear implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "display_name")
    private String displayName;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_year")
    private int startYear;
    @Basic(optional = false)
    @NotNull
    @Column(name = "end_year")
    private int endYear;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acyearId")
    private List<AcyearGroup> acyearGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acyearId")
    private List<AcyearPostgradeCourseDetails> acyearPostgradeCourseDetailsList;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acyearId")
    private List<AcyearPostgradeCourseAssignation> acyearPostgradeCourseAssignationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acyearId")
    private List<AcyearUndergradeCourseAssignation> acyearUndergradeCourseAssignationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acyearId")
    private List<AcyearSection> acyearSectionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "acyearId")
    private List<AcyearUndergradeCourseDetails> acyearUndergradeCourseDetailsList;

    public InstAcademicYear() {
    }

    public InstAcademicYear(Integer id) {
        this.id = id;
    }

    public InstAcademicYear(Integer id, String displayName, int startYear, int endYear) {
        this.id = id;
        this.displayName = displayName;
        this.startYear = startYear;
        this.endYear = endYear;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<AcyearGroup> getAcyearGroupList() {
        return acyearGroupList;
    }

    public void setAcyearGroupList(List<AcyearGroup> acyearGroupList) {
        this.acyearGroupList = acyearGroupList;
    }

    public List<AcyearPostgradeCourseDetails> getAcyearPostgradeCourseDetailsList() {
        return acyearPostgradeCourseDetailsList;
    }

    public void setAcyearPostgradeCourseDetailsList(List<AcyearPostgradeCourseDetails> acyearPostgradeCourseDetailsList) {
        this.acyearPostgradeCourseDetailsList = acyearPostgradeCourseDetailsList;
    }

    public Institution getInstId() {
        return instId;
    }

    public void setInstId(Institution instId) {
        this.instId = instId;
    }

    public List<AcyearPostgradeCourseAssignation> getAcyearPostgradeCourseAssignationList() {
        return acyearPostgradeCourseAssignationList;
    }

    public void setAcyearPostgradeCourseAssignationList(List<AcyearPostgradeCourseAssignation> acyearPostgradeCourseAssignationList) {
        this.acyearPostgradeCourseAssignationList = acyearPostgradeCourseAssignationList;
    }

    public List<AcyearUndergradeCourseAssignation> getAcyearUndergradeCourseAssignationList() {
        return acyearUndergradeCourseAssignationList;
    }

    public void setAcyearUndergradeCourseAssignationList(List<AcyearUndergradeCourseAssignation> acyearUndergradeCourseAssignationList) {
        this.acyearUndergradeCourseAssignationList = acyearUndergradeCourseAssignationList;
    }

    public List<AcyearSection> getAcyearSectionList() {
        return acyearSectionList;
    }

    public void setAcyearSectionList(List<AcyearSection> acyearSectionList) {
        this.acyearSectionList = acyearSectionList;
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
        if (!(object instanceof InstAcademicYear)) {
            return false;
        }
        InstAcademicYear other = (InstAcademicYear) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.InstAcademicYear[ id=" + id + " ]";
    }
    
}
