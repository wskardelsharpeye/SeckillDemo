package com.example.security;

public enum ApplicationUserPermission {
    STUDENT_READ("student_read"),
    STUDENT_WRITE("student_write"),
    COURSE_READ("course_read"),
    COURSE_WRITE("course_write"),
    USER_WRITE("user_write"),
    USER_READ("user_read");

    private final String permission;

    ApplicationUserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
