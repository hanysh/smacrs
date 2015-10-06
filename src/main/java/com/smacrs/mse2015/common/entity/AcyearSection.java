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
@Table(name = "acyear_section")
@NamedQueries({
    @NamedQuery(name = "AcyearSection.findAll", query = "SELECT a FROM AcyearSection a"),
    @NamedQuery(name = "AcyearSection.findById", query = "SELECT a FROM AcyearSection a WHERE a.id = :id"),
    @NamedQuery(name = "AcyearSection.findByDisplayName", query = "SELECT a FROM AcyearSection a WHERE a.displayName = :displayName"),
    @NamedQuery(name = "AcyearSection.findByDescription", query = "SELECT a FROM AcyearSection a WHERE a.description = :description"),
    @NamedQuery(name = "AcyearSection.findByActive", query = "SELECT a FROM AcyearSection a WHERE a.active = :active")})
public class AcyearSection implements Serializable {
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
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sectionId")
    private List<AcyearUndergradeCourseAssignation> acyearUndergradeCourseAssignationList;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AcyearGroup groupId;
    @JoinColumn(name = "dep_year_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstDepartmentYear depYearId;
    @JoinColumn(name = "dep_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstDepartment depId;
    @JoinColumn(name = "acyear_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstAcademicYear acyearId;

    public AcyearSection() {
    }

    public AcyearSection(Integer id) {
        this.id = id;
    }

    public AcyearSection(Integer id, String displayName) {
        this.id = id;
        this.displayName = displayName;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public List<AcyearUndergradeCourseAssignation> getAcyearUndergradeCourseAssignationList() {
        return acyearUndergradeCourseAssignationList;
    }

    public void setAcyearUndergradeCourseAssignationList(List<AcyearUndergradeCourseAssignation> acyearUndergradeCourseAssignationList) {
        this.acyearUndergradeCourseAssignationList = acyearUndergradeCourseAssignationList;
    }

    public Institution getInstId() {
        return instId;
    }

    public void setInstId(Institution instId) {
        this.instId = instId;
    }

    public AcyearGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(AcyearGroup groupId) {
        this.groupId = groupId;
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

    public InstAcademicYear getAcyearId() {
        return acyearId;
    }

    public void setAcyearId(InstAcademicYear acyearId) {
        this.acyearId = acyearId;
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
        if (!(object instanceof AcyearSection)) {
            return false;
        }
        AcyearSection other = (AcyearSection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.AcyearSection[ id=" + id + " ]";
    }
    
}
