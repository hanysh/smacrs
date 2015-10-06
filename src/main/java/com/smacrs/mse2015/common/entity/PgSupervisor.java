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
@Table(name = "pg_supervisor")
@NamedQueries({
    @NamedQuery(name = "PgSupervisor.findAll", query = "SELECT p FROM PgSupervisor p"),
    @NamedQuery(name = "PgSupervisor.findById", query = "SELECT p FROM PgSupervisor p WHERE p.id = :id"),
    @NamedQuery(name = "PgSupervisor.findByName", query = "SELECT p FROM PgSupervisor p WHERE p.name = :name")})
public class PgSupervisor implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgSupervisorId")
    private List<PgSupervisorDiscipline> pgSupervisorDisciplineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherId")
    private List<AcyearPostgradeCourseAssignation> acyearPostgradeCourseAssignationList;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;
    @JoinColumn(name = "degree_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private LutStaffMemberDegree degreeId;

    public PgSupervisor() {
    }

    public PgSupervisor(Integer id) {
        this.id = id;
    }

    public PgSupervisor(Integer id, String name) {
        this.id = id;
        this.name = name;
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

    public List<PgSupervisorDiscipline> getPgSupervisorDisciplineList() {
        return pgSupervisorDisciplineList;
    }

    public void setPgSupervisorDisciplineList(List<PgSupervisorDiscipline> pgSupervisorDisciplineList) {
        this.pgSupervisorDisciplineList = pgSupervisorDisciplineList;
    }

    public List<AcyearPostgradeCourseAssignation> getAcyearPostgradeCourseAssignationList() {
        return acyearPostgradeCourseAssignationList;
    }

    public void setAcyearPostgradeCourseAssignationList(List<AcyearPostgradeCourseAssignation> acyearPostgradeCourseAssignationList) {
        this.acyearPostgradeCourseAssignationList = acyearPostgradeCourseAssignationList;
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
        if (!(object instanceof PgSupervisor)) {
            return false;
        }
        PgSupervisor other = (PgSupervisor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.PgSupervisor[ id=" + id + " ]";
    }
    
}
