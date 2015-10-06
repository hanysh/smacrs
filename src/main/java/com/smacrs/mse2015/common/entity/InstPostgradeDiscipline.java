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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alaa
 */
@Entity
@Table(name = "inst_postgrade_discipline")
@NamedQueries({
    @NamedQuery(name = "InstPostgradeDiscipline.findAll", query = "SELECT i FROM InstPostgradeDiscipline i"),
    @NamedQuery(name = "InstPostgradeDiscipline.findById", query = "SELECT i FROM InstPostgradeDiscipline i WHERE i.id = :id"),
    @NamedQuery(name = "InstPostgradeDiscipline.findByName", query = "SELECT i FROM InstPostgradeDiscipline i WHERE i.name = :name"),
    @NamedQuery(name = "InstPostgradeDiscipline.findByDescription", query = "SELECT i FROM InstPostgradeDiscipline i WHERE i.description = :description"),
    @NamedQuery(name = "InstPostgradeDiscipline.findByActive", query = "SELECT i FROM InstPostgradeDiscipline i WHERE i.active = :active")})
public class InstPostgradeDiscipline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "name")
    private String name;
    @Size(max = 200)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "instPostgradeDiscipline")
    private InstPostgradeCourse instPostgradeCourse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgDisciplineId")
    private List<PgStudentDiscipline> pgStudentDisciplineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pgDisciplineId")
    private List<PgSupervisorDiscipline> pgSupervisorDisciplineList;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;

    public InstPostgradeDiscipline() {
    }

    public InstPostgradeDiscipline(Integer id) {
        this.id = id;
    }

    public InstPostgradeDiscipline(Integer id, String name) {
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

    public InstPostgradeCourse getInstPostgradeCourse() {
        return instPostgradeCourse;
    }

    public void setInstPostgradeCourse(InstPostgradeCourse instPostgradeCourse) {
        this.instPostgradeCourse = instPostgradeCourse;
    }

    public List<PgStudentDiscipline> getPgStudentDisciplineList() {
        return pgStudentDisciplineList;
    }

    public void setPgStudentDisciplineList(List<PgStudentDiscipline> pgStudentDisciplineList) {
        this.pgStudentDisciplineList = pgStudentDisciplineList;
    }

    public List<PgSupervisorDiscipline> getPgSupervisorDisciplineList() {
        return pgSupervisorDisciplineList;
    }

    public void setPgSupervisorDisciplineList(List<PgSupervisorDiscipline> pgSupervisorDisciplineList) {
        this.pgSupervisorDisciplineList = pgSupervisorDisciplineList;
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
        if (!(object instanceof InstPostgradeDiscipline)) {
            return false;
        }
        InstPostgradeDiscipline other = (InstPostgradeDiscipline) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.InstPostgradeDiscipline[ id=" + id + " ]";
    }
    
}
