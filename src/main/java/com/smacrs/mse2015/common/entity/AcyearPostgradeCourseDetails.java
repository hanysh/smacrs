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
import javax.validation.constraints.NotNull;

/**
 *
 * @author alaa
 */
@Entity
@Table(name = "acyear_postgrade_course_details")
@NamedQueries({
    @NamedQuery(name = "AcyearPostgradeCourseDetails.findAll", query = "SELECT a FROM AcyearPostgradeCourseDetails a"),
    @NamedQuery(name = "AcyearPostgradeCourseDetails.findById", query = "SELECT a FROM AcyearPostgradeCourseDetails a WHERE a.id = :id"),
    @NamedQuery(name = "AcyearPostgradeCourseDetails.findByFirstTerm", query = "SELECT a FROM AcyearPostgradeCourseDetails a WHERE a.firstTerm = :firstTerm"),
    @NamedQuery(name = "AcyearPostgradeCourseDetails.findBySecondTerm", query = "SELECT a FROM AcyearPostgradeCourseDetails a WHERE a.secondTerm = :secondTerm"),
    @NamedQuery(name = "AcyearPostgradeCourseDetails.findBySessionsNo", query = "SELECT a FROM AcyearPostgradeCourseDetails a WHERE a.sessionsNo = :sessionsNo"),
    @NamedQuery(name = "AcyearPostgradeCourseDetails.findByHoursNo", query = "SELECT a FROM AcyearPostgradeCourseDetails a WHERE a.hoursNo = :hoursNo"),
    @NamedQuery(name = "AcyearPostgradeCourseDetails.findByClassworkDegree", query = "SELECT a FROM AcyearPostgradeCourseDetails a WHERE a.classworkDegree = :classworkDegree"),
    @NamedQuery(name = "AcyearPostgradeCourseDetails.findByMidtermDegree", query = "SELECT a FROM AcyearPostgradeCourseDetails a WHERE a.midtermDegree = :midtermDegree"),
    @NamedQuery(name = "AcyearPostgradeCourseDetails.findByTermDegree", query = "SELECT a FROM AcyearPostgradeCourseDetails a WHERE a.termDegree = :termDegree"),
    @NamedQuery(name = "AcyearPostgradeCourseDetails.findByTotalDegree", query = "SELECT a FROM AcyearPostgradeCourseDetails a WHERE a.totalDegree = :totalDegree")})
public class AcyearPostgradeCourseDetails implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "sessions_no")
    private int sessionsNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hours_no")
    private float hoursNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "classwork_degree")
    private Float classworkDegree;
    @Column(name = "midterm_degree")
    private Float midtermDegree;
    @Basic(optional = false)
    @NotNull
    @Column(name = "term_degree")
    private float termDegree;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_degree")
    private float totalDegree;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;
    @JoinColumn(name = "course_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstPostgradeCourse courseId;
    @JoinColumn(name = "acyear_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstAcademicYear acyearId;

    public AcyearPostgradeCourseDetails() {
    }

    public AcyearPostgradeCourseDetails(Integer id) {
        this.id = id;
    }

    public AcyearPostgradeCourseDetails(Integer id, int sessionsNo, float hoursNo, float termDegree, float totalDegree) {
        this.id = id;
        this.sessionsNo = sessionsNo;
        this.hoursNo = hoursNo;
        this.termDegree = termDegree;
        this.totalDegree = totalDegree;
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

    public int getSessionsNo() {
        return sessionsNo;
    }

    public void setSessionsNo(int sessionsNo) {
        this.sessionsNo = sessionsNo;
    }

    public float getHoursNo() {
        return hoursNo;
    }

    public void setHoursNo(float hoursNo) {
        this.hoursNo = hoursNo;
    }

    public Float getClassworkDegree() {
        return classworkDegree;
    }

    public void setClassworkDegree(Float classworkDegree) {
        this.classworkDegree = classworkDegree;
    }

    public Float getMidtermDegree() {
        return midtermDegree;
    }

    public void setMidtermDegree(Float midtermDegree) {
        this.midtermDegree = midtermDegree;
    }

    public float getTermDegree() {
        return termDegree;
    }

    public void setTermDegree(float termDegree) {
        this.termDegree = termDegree;
    }

    public float getTotalDegree() {
        return totalDegree;
    }

    public void setTotalDegree(float totalDegree) {
        this.totalDegree = totalDegree;
    }

    public Institution getInstId() {
        return instId;
    }

    public void setInstId(Institution instId) {
        this.instId = instId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AcyearPostgradeCourseDetails)) {
            return false;
        }
        AcyearPostgradeCourseDetails other = (AcyearPostgradeCourseDetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.AcyearPostgradeCourseDetails[ id=" + id + " ]";
    }
    
}
