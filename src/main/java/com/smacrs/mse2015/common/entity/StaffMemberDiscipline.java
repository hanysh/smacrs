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
@Table(name = "staff_member_discipline")
@NamedQueries({
    @NamedQuery(name = "StaffMemberDiscipline.findAll", query = "SELECT s FROM StaffMemberDiscipline s"),
    @NamedQuery(name = "StaffMemberDiscipline.findById", query = "SELECT s FROM StaffMemberDiscipline s WHERE s.id = :id")})
public class StaffMemberDiscipline implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "staff_member_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private StaffMember staffMemberId;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;
    @JoinColumn(name = "ug_discipline_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private InstUndergradeDiscipline ugDisciplineId;

    public StaffMemberDiscipline() {
    }

    public StaffMemberDiscipline(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public StaffMember getStaffMemberId() {
        return staffMemberId;
    }

    public void setStaffMemberId(StaffMember staffMemberId) {
        this.staffMemberId = staffMemberId;
    }

    public Institution getInstId() {
        return instId;
    }

    public void setInstId(Institution instId) {
        this.instId = instId;
    }

    public InstUndergradeDiscipline getUgDisciplineId() {
        return ugDisciplineId;
    }

    public void setUgDisciplineId(InstUndergradeDiscipline ugDisciplineId) {
        this.ugDisciplineId = ugDisciplineId;
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
        if (!(object instanceof StaffMemberDiscipline)) {
            return false;
        }
        StaffMemberDiscipline other = (StaffMemberDiscipline) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.StaffMemberDiscipline[ id=" + id + " ]";
    }
    
}
