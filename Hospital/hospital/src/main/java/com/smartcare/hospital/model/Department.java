package com.smartcare.hospital.model;

import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer departmentId;
    private String departmentName;
    private String buildingBlock;

    public Department() {}

    public Integer getDepartmentId() { return departmentId; }
    public void setDepartmentId(Integer departmentId) { this.departmentId = departmentId; }
    public String getDepartmentName() { return departmentName; }
    public void setDepartmentName(String departmentName) { this.departmentName = departmentName; }
    public String getBuildingBlock() { return buildingBlock; }
    public void setBuildingBlock(String buildingBlock) { this.buildingBlock = buildingBlock; }
}