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
@Table(name = "lut_pg_study_type")
@NamedQueries({
    @NamedQuery(name = "LutPgStudyType.findAll", query = "SELECT l FROM LutPgStudyType l"),
    @NamedQuery(name = "LutPgStudyType.findById", query = "SELECT l FROM LutPgStudyType l WHERE l.id = :id"),
    @NamedQuery(name = "LutPgStudyType.findByName", query = "SELECT l FROM LutPgStudyType l WHERE l.name = :name"),
    @NamedQuery(name = "LutPgStudyType.findByDescription", query = "SELECT l FROM LutPgStudyType l WHERE l.description = :description"),
    @NamedQuery(name = "LutPgStudyType.findByActive", query = "SELECT l FROM LutPgStudyType l WHERE l.active = :active")})
public class LutPgStudyType implements Serializable {
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
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @Column(name = "active")
    private Boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "studyTypeId")
    private List<PgStudent> pgStudentList;

    public LutPgStudyType() {
    }

    public LutPgStudyType(Integer id) {
        this.id = id;
    }

    public LutPgStudyType(Integer id, String name) {
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

    public List<PgStudent> getPgStudentList() {
        return pgStudentList;
    }

    public void setPgStudentList(List<PgStudent> pgStudentList) {
        this.pgStudentList = pgStudentList;
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
        if (!(object instanceof LutPgStudyType)) {
            return false;
        }
        LutPgStudyType other = (LutPgStudyType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.LutPgStudyType[ id=" + id + " ]";
    }
    
}
