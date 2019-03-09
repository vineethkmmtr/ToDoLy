package com.vineeth.domain;

public enum TaskStatus {
    ACTIVE("To do"), COMPLETE("Done");

    private String description;

    TaskStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
