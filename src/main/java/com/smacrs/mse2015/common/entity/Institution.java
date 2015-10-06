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
@Table(name = "institution")
@NamedQueries({
    @NamedQuery(name = "Institution.findAll", query = "SELECT i FROM Institution i"),
    @NamedQuery(name = "Institution.findById", query = "SELECT i FROM Institution i WHERE i.id = :id"),
    @NamedQuery(name = "Institution.findByName", query = "SELECT i FROM Institution i WHERE i.name = :name"),
    @NamedQuery(name = "Institution.findByOwnerOrganizationName", query = "SELECT i FROM Institution i WHERE i.ownerOrganizationName = :ownerOrganizationName"),
    @NamedQuery(name = "Institution.findByAddress", query = "SELECT i FROM Institution i WHERE i.address = :address"),
    @NamedQuery(name = "Institution.findByLogoUrl", query = "SELECT i FROM Institution i WHERE i.logoUrl = :logoUrl"),
    @NamedQuery(name = "Institution.findByStatus", query = "SELECT i FROM Institution i WHERE i.status = :status")})
public class Institution implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "owner_organization_name")
    private String ownerOrganizationName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "logo_url")
    private String logoUrl;
    @Column(name = "status")
    private Boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<InstDepartmentYear> instDepartmentYearList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<CommonMessageRecipient> commonMessageRecipientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<UgStudent> ugStudentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<InstPostgradeCourse> instPostgradeCourseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<InstUndergradeCourse> instUndergradeCourseList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<AcyearGroup> acyearGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<AcyearPostgradeCourseDetails> acyearPostgradeCourseDetailsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<PgStudentDiscipline> pgStudentDisciplineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<InstAcademicYear> instAcademicYearList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<CommonMessage> commonMessageList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<PgStudent> pgStudentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<Employee> employeeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<PgSupervisorDiscipline> pgSupervisorDisciplineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<StaffMemberDiscipline> staffMemberDisciplineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<CommonUserLogin> commonUserLoginList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<InstUndergradeDiscipline> instUndergradeDisciplineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<InstPostgradeDiscipline> instPostgradeDisciplineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<AcyearPostgradeCourseAssignation> acyearPostgradeCourseAssignationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<AcyearUndergradeCourseAssignation> acyearUndergradeCourseAssignationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<StaffMember> staffMemberList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<CommonMessageThread> commonMessageThreadList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<PgSupervisor> pgSupervisorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<AcyearSection> acyearSectionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<InstDepartment> instDepartmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "instId")
    private List<AcyearUndergradeCourseDetails> acyearUndergradeCourseDetailsList;

    public Institution() {
    }

    public Institution(Integer id) {
        this.id = id;
    }

    public Institution(Integer id, String name, String ownerOrganizationName, String address, String logoUrl) {
        this.id = id;
        this.name = name;
        this.ownerOrganizationName = ownerOrganizationName;
        this.address = address;
        this.logoUrl = logoUrl;
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

    public String getOwnerOrganizationName() {
        return ownerOrganizationName;
    }

    public void setOwnerOrganizationName(String ownerOrganizationName) {
        this.ownerOrganizationName = ownerOrganizationName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<InstDepartmentYear> getInstDepartmentYearList() {
        return instDepartmentYearList;
    }

    public void setInstDepartmentYearList(List<InstDepartmentYear> instDepartmentYearList) {
        this.instDepartmentYearList = instDepartmentYearList;
    }

    public List<CommonMessageRecipient> getCommonMessageRecipientList() {
        return commonMessageRecipientList;
    }

    public void setCommonMessageRecipientList(List<CommonMessageRecipient> commonMessageRecipientList) {
        this.commonMessageRecipientList = commonMessageRecipientList;
    }

    public List<UgStudent> getUgStudentList() {
        return ugStudentList;
    }

    public void setUgStudentList(List<UgStudent> ugStudentList) {
        this.ugStudentList = ugStudentList;
    }

    public List<InstPostgradeCourse> getInstPostgradeCourseList() {
        return instPostgradeCourseList;
    }

    public void setInstPostgradeCourseList(List<InstPostgradeCourse> instPostgradeCourseList) {
        this.instPostgradeCourseList = instPostgradeCourseList;
    }

    public List<InstUndergradeCourse> getInstUndergradeCourseList() {
        return instUndergradeCourseList;
    }

    public void setInstUndergradeCourseList(List<InstUndergradeCourse> instUndergradeCourseList) {
        this.instUndergradeCourseList = instUndergradeCourseList;
    }

    public List<AcyearGroup> getAcyearGroupList() {
        return acyearGroupList;
    }

    public void setAcyearGroupList(List<AcyearGroup> acyearGroupList) {
        this.acyearGroupList = acyearGroupList;
    }

    public List<AcyearPostgradeCourseDetails> getAcyearPostgradeCourseDetailsList() {
        return acyearPostgradeCourseDetailsList;
    }

    public void setAcyearPostgradeCourseDetailsList(List<AcyearPostgradeCourseDetails> acyearPostgradeCourseDetailsList) {
        this.acyearPostgradeCourseDetailsList = acyearPostgradeCourseDetailsList;
    }

    public List<PgStudentDiscipline> getPgStudentDisciplineList() {
        return pgStudentDisciplineList;
    }

    public void setPgStudentDisciplineList(List<PgStudentDiscipline> pgStudentDisciplineList) {
        this.pgStudentDisciplineList = pgStudentDisciplineList;
    }

    public List<InstAcademicYear> getInstAcademicYearList() {
        return instAcademicYearList;
    }

    public void setInstAcademicYearList(List<InstAcademicYear> instAcademicYearList) {
        this.instAcademicYearList = instAcademicYearList;
    }

    public List<CommonMessage> getCommonMessageList() {
        return commonMessageList;
    }

    public void setCommonMessageList(List<CommonMessage> commonMessageList) {
        this.commonMessageList = commonMessageList;
    }

    public List<PgStudent> getPgStudentList() {
        return pgStudentList;
    }

    public void setPgStudentList(List<PgStudent> pgStudentList) {
        this.pgStudentList = pgStudentList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<PgSupervisorDiscipline> getPgSupervisorDisciplineList() {
        return pgSupervisorDisciplineList;
    }

    public void setPgSupervisorDisciplineList(List<PgSupervisorDiscipline> pgSupervisorDisciplineList) {
        this.pgSupervisorDisciplineList = pgSupervisorDisciplineList;
    }

    public List<StaffMemberDiscipline> getStaffMemberDisciplineList() {
        return staffMemberDisciplineList;
    }

    public void setStaffMemberDisciplineList(List<StaffMemberDiscipline> staffMemberDisciplineList) {
        this.staffMemberDisciplineList = staffMemberDisciplineList;
    }

    public List<CommonUserLogin> getCommonUserLoginList() {
        return commonUserLoginList;
    }

    public void setCommonUserLoginList(List<CommonUserLogin> commonUserLoginList) {
        this.commonUserLoginList = commonUserLoginList;
    }

    public List<InstUndergradeDiscipline> getInstUndergradeDisciplineList() {
        return instUndergradeDisciplineList;
    }

    public void setInstUndergradeDisciplineList(List<InstUndergradeDiscipline> instUndergradeDisciplineList) {
        this.instUndergradeDisciplineList = instUndergradeDisciplineList;
    }

    public List<InstPostgradeDiscipline> getInstPostgradeDisciplineList() {
        return instPostgradeDisciplineList;
    }

    public void setInstPostgradeDisciplineList(List<InstPostgradeDiscipline> instPostgradeDisciplineList) {
        this.instPostgradeDisciplineList = instPostgradeDisciplineList;
    }

    public List<AcyearPostgradeCourseAssignation> getAcyearPostgradeCourseAssignationList() {
        return acyearPostgradeCourseAssignationList;
    }

    public void setAcyearPostgradeCourseAssignationList(List<AcyearPostgradeCourseAssignation> acyearPostgradeCourseAssignationList) {
        this.acyearPostgradeCourseAssignationList = acyearPostgradeCourseAssignationList;
    }

    public List<AcyearUndergradeCourseAssignation> getAcyearUndergradeCourseAssignationList() {
        return acyearUndergradeCourseAssignationList;
    }

    public void setAcyearUndergradeCourseAssignationList(List<AcyearUndergradeCourseAssignation> acyearUndergradeCourseAssignationList) {
        this.acyearUndergradeCourseAssignationList = acyearUndergradeCourseAssignationList;
    }

    public List<StaffMember> getStaffMemberList() {
        return staffMemberList;
    }

    public void setStaffMemberList(List<StaffMember> staffMemberList) {
        this.staffMemberList = staffMemberList;
    }

    public List<CommonMessageThread> getCommonMessageThreadList() {
        return commonMessageThreadList;
    }

    public void setCommonMessageThreadList(List<CommonMessageThread> commonMessageThreadList) {
        this.commonMessageThreadList = commonMessageThreadList;
    }

    public List<PgSupervisor> getPgSupervisorList() {
        return pgSupervisorList;
    }

    public void setPgSupervisorList(List<PgSupervisor> pgSupervisorList) {
        this.pgSupervisorList = pgSupervisorList;
    }

    public List<AcyearSection> getAcyearSectionList() {
        return acyearSectionList;
    }

    public void setAcyearSectionList(List<AcyearSection> acyearSectionList) {
        this.acyearSectionList = acyearSectionList;
    }

    public List<InstDepartment> getInstDepartmentList() {
        return instDepartmentList;
    }

    public void setInstDepartmentList(List<InstDepartment> instDepartmentList) {
        this.instDepartmentList = instDepartmentList;
    }

    public List<AcyearUndergradeCourseDetails> getAcyearUndergradeCourseDetailsList() {
        return acyearUndergradeCourseDetailsList;
    }

    public void setAcyearUndergradeCourseDetailsList(List<AcyearUndergradeCourseDetails> acyearUndergradeCourseDetailsList) {
        this.acyearUndergradeCourseDetailsList = acyearUndergradeCourseDetailsList;
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
        if (!(object instanceof Institution)) {
            return false;
        }
        Institution other = (Institution) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.smacrs.mse2015.common.dao.Institution[ id=" + id + " ]";
    }
    
}
