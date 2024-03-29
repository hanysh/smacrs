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
@Table(name = "lut_user_type")
@NamedQueries({
    @NamedQuery(name = "LutUserType.findAll", query = "SELECT l FROM LutUserType l"),
    @NamedQuery(name = "LutUserType.findById", query = "SELECT l FROM LutUserType l WHERE l.id = :id"),
    @NamedQuery(name = "LutUserType.findByName", query = "SELECT l FROM LutUserType l WHERE l.name = :name"),
    @NamedQuery(name = "LutUserType.findByDescription", query = "SELECT l FROM LutUserType l WHERE l.description = :description")})
public class LutUserType implements Serializable {
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userTypeId")
    private List<CommonUserLogin> commonUserLoginList;

    public LutUserType() {
    }

    public LutUserType(Integer id) {
        this.id = id;
    }

    public LutUserType(Integer id, String name) {
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

    public List<CommonUserLogin> getCommonUserLoginList() {
        return commonUserLoginList;
    }

    public void setCommonUserLoginList(List<CommonUserLogin> commonUserLoginList) {
        this.commonUserLoginList = commonUserLoginList;
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
        if (!(object instanceof LutUserType)) {
            return false;
        }
        LutUserType other = (LutUserType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.LutUserType[ id=" + id + " ]";
    }
    
}
