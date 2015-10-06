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
@Table(name = "pg_student_discipline")
@NamedQueries({
    @NamedQuery(name = "PgStudentDiscipline.findAll", query = "SELECT p FROM PgStudentDiscipline p"),
    @NamedQuery(name = "PgStudentDiscipline.findById", query = "SELECT p FROM PgStudentDiscipline p WHERE p.id = :id")})
public class PgStudentDiscipline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "pg_student_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private PgStudent pgStudentId;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;
    @JoinColumn(name = "pg_discipline_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstPostgradeDiscipline pgDisciplineId;

    public PgStudentDiscipline() {
    }

    public PgStudentDiscipline(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PgStudent getPgStudentId() {
        return pgStudentId;
    }

    public void setPgStudentId(PgStudent pgStudentId) {
        this.pgStudentId = pgStudentId;
    }

    public Institution getInstId() {
        return instId;
    }

    public void setInstId(Institution instId) {
        this.instId = instId;
    }

    public InstPostgradeDiscipline getPgDisciplineId() {
        return pgDisciplineId;
    }

    public void setPgDisciplineId(InstPostgradeDiscipline pgDisciplineId) {
        this.pgDisciplineId = pgDisciplineId;
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
        if (!(object instanceof PgStudentDiscipline)) {
            return false;
        }
        PgStudentDiscipline other = (PgStudentDiscipline) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.PgStudentDiscipline[ id=" + id + " ]";
    }
    
}
