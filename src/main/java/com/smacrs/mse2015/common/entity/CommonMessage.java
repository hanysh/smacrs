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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author alaa
 */
@Entity
@Table(name = "common_message")
@NamedQueries({
    @NamedQuery(name = "CommonMessage.findAll", query = "SELECT c FROM CommonMessage c"),
    @NamedQuery(name = "CommonMessage.findById", query = "SELECT c FROM CommonMessage c WHERE c.id = :id"),
    @NamedQuery(name = "CommonMessage.findBySubject", query = "SELECT c FROM CommonMessage c WHERE c.subject = :subject"),
    @NamedQuery(name = "CommonMessage.findByAttachements", query = "SELECT c FROM CommonMessage c WHERE c.attachements = :attachements"),
    @NamedQuery(name = "CommonMessage.findBySentDate", query = "SELECT c FROM CommonMessage c WHERE c.sentDate = :sentDate"),
    @NamedQuery(name = "CommonMessage.findByUnread", query = "SELECT c FROM CommonMessage c WHERE c.unread = :unread"),
    @NamedQuery(name = "CommonMessage.findByDeleted", query = "SELECT c FROM CommonMessage c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "CommonMessage.findByArchived", query = "SELECT c FROM CommonMessage c WHERE c.archived = :archived")})
public class CommonMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "subject")
    private String subject;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "body")
    private String body;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000)
    @Column(name = "attachements")
    private String attachements;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sent_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date sentDate;
    @Column(name = "unread")
    private Boolean unread;
    @Column(name = "deleted")
    private Boolean deleted;
    @Column(name = "archived")
    private Boolean archived;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageId")
    private List<CommonMessageRecipient> commonMessageRecipientList;
    @JoinColumn(name = "message_thread_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CommonMessageThread messageThreadId;
    @JoinColumn(name = "status", referencedColumnName = "id")
    @ManyToOne
    private LutMessageStatus status;
    @JoinColumn(name = "sender_user_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private CommonUserLogin senderUserId;
    @JoinColumn(name = "inst_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Institution instId;

    public CommonMessage() {
    }

    public CommonMessage(Integer id) {
        this.id = id;
    }

    public CommonMessage(Integer id, String subject, String body, String attachements, Date sentDate) {
        this.id = id;
        this.subject = subject;
        this.body = body;
        this.attachements = attachements;
        this.sentDate = sentDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAttachements() {
        return attachements;
    }

    public void setAttachements(String attachements) {
        this.attachements = attachements;
    }

    public Date getSentDate() {
        return sentDate;
    }

    public void setSentDate(Date sentDate) {
        this.sentDate = sentDate;
    }

    public Boolean getUnread() {
        return unread;
    }

    public void setUnread(Boolean unread) {
        this.unread = unread;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Boolean getArchived() {
        return archived;
    }

    public void setArchived(Boolean archived) {
        this.archived = archived;
    }

    public List<CommonMessageRecipient> getCommonMessageRecipientList() {
        return commonMessageRecipientList;
    }

    public void setCommonMessageRecipientList(List<CommonMessageRecipient> commonMessageRecipientList) {
        this.commonMessageRecipientList = commonMessageRecipientList;
    }

    public CommonMessageThread getMessageThreadId() {
        return messageThreadId;
    }

    public void setMessageThreadId(CommonMessageThread messageThreadId) {
        this.messageThreadId = messageThreadId;
    }

    public LutMessageStatus getStatus() {
        return status;
    }

    public void setStatus(LutMessageStatus status) {
        this.status = status;
    }

    public CommonUserLogin getSenderUserId() {
        return senderUserId;
    }

    public void setSenderUserId(CommonUserLogin senderUserId) {
        this.senderUserId = senderUserId;
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
        if (!(object instanceof CommonMessage)) {
            return false;
        }
        CommonMessage other = (CommonMessage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.CommonMessage[ id=" + id + " ]";
    }
    
}
