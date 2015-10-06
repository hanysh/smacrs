/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smacrs.mse2015.common.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author alaa
 */
@Entity
@Table(name = "common_message_thread")
@NamedQueries({
    @NamedQuery(name = "CommonMessageThread.findAll", query = "SELECT c FROM CommonMessageThread c"),
    @NamedQuery(name = "CommonMessageThread.findById", query = "SELECT c FROM CommonMessageThread c WHERE c.id = :id"),
    @NamedQuery(name = "CommonMessageThread.findByStartDate", query = "SELECT c FROM CommonMessageThread c WHERE c.startDate = :startDate"),
    @NamedQuery(name = "CommonMessageThread.findByLastReplyDate", query = "SELECT c FROM CommonMessageThread c WHERE c.lastReplyDate = :lastReplyDate"),
    @NamedQuery(name = "CommonMessageThread.findByArchived", query = "SELECT c FROM CommonMessageThread c WHERE c.archived = :archived"),
    @NamedQuery(name = "CommonMessageThread.findByDeleted", query = "SELECT c FROM CommonMessageThread c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "CommonMessageThread.findByStatus", query = "SELECT c FROM CommonMessageThread c WHERE c.status = :status")})
public class CommonMessageThread implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @Column(name = "last_reply_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastReplyDate;
    @Column(name = "archived")
    private Boolean archived;
    @Column(name = "deleted")
    private Boolean deleted;
    @Column(name = "status")
    private Integer status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageThreadId")
    private List<CommonMessage> commonMessageList;
    @JoinColumn(name = "originator_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CommonUserLogin originatorUserId;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;

    public CommonMessageThread() {
    }

    public CommonMessageThread(Integer id) {
        this.id = id;
    }

    public CommonMessageThread(Integer id, Date startDate) {
        this.id = id;
        this.startDate = startDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getLastReplyDate() {
        return lastReplyDate;
    }

    public void setLastReplyDate(Date lastReplyDate) {
        this.lastReplyDate = lastReplyDate;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<CommonMessage> getCommonMessageList() {
        return commonMessageList;
    }

    public void setCommonMessageList(List<CommonMessage> commonMessageList) {
        this.commonMessageList = commonMessageList;
    }

    public CommonUserLogin getOriginatorUserId() {
        return originatorUserId;
    }

    public void setOriginatorUserId(CommonUserLogin originatorUserId) {
        this.originatorUserId = originatorUserId;
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
        if (!(object instanceof CommonMessageThread)) {
            return false;
        }
        CommonMessageThread other = (CommonMessageThread) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.CommonMessageThread[ id=" + id + " ]";
    }
    
}
