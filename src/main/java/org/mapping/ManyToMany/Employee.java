package org.mapping.ManyToMany;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Employee {
    @Id
    private int employeeId;
    private String employeeName;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable
            (
                    name = "employees_and_projects",
                    joinColumns = {@JoinColumn(name = "employees")},
                    inverseJoinColumns = {@JoinColumn(name = "projects")}
            )
    private List<Project> projectList;

    // constructors
    public Employee() {
    }

    public Employee(int employeeId, String employeeName, List<Project> projectList) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.projectList = projectList;
    }

    // getters and setters
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public List<Project> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<Project> projectList) {
        this.projectList = projectList;
    }
}
