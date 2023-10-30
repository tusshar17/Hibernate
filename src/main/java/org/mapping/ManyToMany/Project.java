package org.mapping.ManyToMany;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.List;

@Entity
public class Project {
    @Id
    private int projectId;
    private String projectTitle;
    @ManyToMany(cascade = CascadeType.ALL)
    private List<Employee> employeeList;

    // constructors
    public Project() {
    }

    public Project(int projectId, String projectTitle, List<Employee> employeeList) {
        this.projectId = projectId;
        this.projectTitle = projectTitle;
        this.employeeList = employeeList;
    }

    // getters and setters
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
