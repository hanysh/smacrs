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
@Table(name = "acyear_postgrade_course_assignation")
@NamedQueries({
    @NamedQuery(name = "AcyearPostgradeCourseAssignation.findAll", query = "SELECT a FROM AcyearPostgradeCourseAssignation a"),
    @NamedQuery(name = "AcyearPostgradeCourseAssignation.findById", query = "SELECT a FROM AcyearPostgradeCourseAssignation a WHERE a.id = :id"),
    @NamedQuery(name = "AcyearPostgradeCourseAssignation.findByFirstTerm", query = "SELECT a FROM AcyearPostgradeCourseAssignation a WHERE a.firstTerm = :firstTerm"),
    @NamedQuery(name = "AcyearPostgradeCourseAssignation.findBySecondTerm", query = "SELECT a FROM AcyearPostgradeCourseAssignation a WHERE a.secondTerm = :secondTerm")})
public class AcyearPostgradeCourseAssignation implements Serializable {
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
    private PgSupervisor teacherId;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstPostgradeCourse courseId;
    @JoinColumn(name = "acyear_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstAcademicYear acyearId;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;

    public AcyearPostgradeCourseAssignation() {
    }

    public AcyearPostgradeCourseAssignation(Integer id) {
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

    public PgSupervisor getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(PgSupervisor teacherId) {
        this.teacherId = teacherId;
    }

    public InstPostgradeCourse getCourseId() {
        return courseId;
    }

    public void setCourseId(InstPostgradeCourse courseId) {
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
        if (!(object instanceof AcyearPostgradeCourseAssignation)) {
            return false;
        }
        AcyearPostgradeCourseAssignation other = (AcyearPostgradeCourseAssignation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.AcyearPostgradeCourseAssignation[ id=" + id + " ]";
    }
    
}
