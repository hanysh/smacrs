/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smacrs.mse2015.common.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author alaa
 */
@Entity
@Table(name = "acyear_undergrade_course_assignation")
@NamedQueries({
    @NamedQuery(name = "AcyearUndergradeCourseAssignation.findAll", query = "SELECT a FROM AcyearUndergradeCourseAssignation a"),
    @NamedQuery(name = "AcyearUndergradeCourseAssignation.findById", query = "SELECT a FROM AcyearUndergradeCourseAssignation a WHERE a.id = :id"),
    @NamedQuery(name = "AcyearUndergradeCourseAssignation.findByFirstTerm", query = "SELECT a FROM AcyearUndergradeCourseAssignation a WHERE a.firstTerm = :firstTerm"),
    @NamedQuery(name = "AcyearUndergradeCourseAssignation.findBySecondTerm", query = "SELECT a FROM AcyearUndergradeCourseAssignation a WHERE a.secondTerm = :secondTerm")})
public class AcyearUndergradeCourseAssignation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_term")
    private Boolean firstTerm;
    @Column(name = "second_term")
    private Boolean secondTerm;
    @JoinColumn(name = "teacher_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StaffMember teacherId;
    @JoinColumn(name = "section_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AcyearSection sectionId;
    @JoinColumn(name = "group_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private AcyearGroup groupId;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstUndergradeCourse courseId;
    @JoinColumn(name = "acyear_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstAcademicYear acyearId;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;

    public AcyearUndergradeCourseAssignation() {
    }

    public AcyearUndergradeCourseAssignation(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getFirstTerm() {
        return firstTerm;
    }

    public void setFirstTerm(Boolean firstTerm) {
        this.firstTerm = firstTerm;
    }

    public Boolean getSecondTerm() {
        return secondTerm;
    }

    public void setSecondTerm(Boolean secondTerm) {
        this.secondTerm = secondTerm;
    }

    public StaffMember getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(StaffMember teacherId) {
        this.teacherId = teacherId;
    }

    public AcyearSection getSectionId() {
        return sectionId;
    }

    public void setSectionId(AcyearSection sectionId) {
        this.sectionId = sectionId;
    }

    public AcyearGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(AcyearGroup groupId) {
        this.groupId = groupId;
    }

    public InstUndergradeCourse getCourseId() {
        return courseId;
    }

    public void setCourseId(InstUndergradeCourse courseId) {
        this.courseId = courseId;
    }

    public InstAcademicYear getAcyearId() {
        return acyearId;
    }

    public void setAcyearId(InstAcademicYear acyearId) {
        this.acyearId = acyearId;
    }

    public Institution getInstId() {
        return instId;
    }

    public void setInstId(Institution instId) {
        this.instId = instId;
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
        if (!(object instanceof AcyearUndergradeCourseAssignation)) {
            return false;
        }
        AcyearUndergradeCourseAssignation other = (AcyearUndergradeCourseAssignation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.AcyearUndergradeCourseAssignation[ id=" + id + " ]";
    }
    
}
