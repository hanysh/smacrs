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
@Table(name = "common_message_recipient")
@NamedQueries({
    @NamedQuery(name = "CommonMessageRecipient.findAll", query = "SELECT c FROM CommonMessageRecipient c"),
    @NamedQuery(name = "CommonMessageRecipient.findById", query = "SELECT c FROM CommonMessageRecipient c WHERE c.id = :id")})
public class CommonMessageRecipient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "recipient_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CommonUserLogin recipientUserId;
    @JoinColumn(name = "message_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CommonMessage messageId;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;

    public CommonMessageRecipient() {
    }

    public CommonMessageRecipient(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CommonUserLogin getRecipientUserId() {
        return recipientUserId;
    }

    public void setRecipientUserId(CommonUserLogin recipientUserId) {
        this.recipientUserId = recipientUserId;
    }

    public CommonMessage getMessageId() {
        return messageId;
    }

    public void setMessageId(CommonMessage messageId) {
        this.messageId = messageId;
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
        if (!(object instanceof CommonMessageRecipient)) {
            return false;
        }
        CommonMessageRecipient other = (CommonMessageRecipient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.CommonMessageRecipient[ id=" + id + " ]";
    }
    
}
