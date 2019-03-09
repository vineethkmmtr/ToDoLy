package com.vineeth.domain;

public class Task {

    private String title;

    private String dueDate;

    private String status;

    private String project;

    public Task(String title, String dueDate, String status, String project){
        this.title = title;
        this.dueDate = dueDate;
        this.status = status;
        this.project = project;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    @Override
    public String toString() {
        return "Task{" +
                " title='" + title + '\'' +
                ", dueDate='" + dueDate + '\'' +
                ", taskStatus=" + status +
                ", project='" + project + '\'' +
                '}';
    }
}
