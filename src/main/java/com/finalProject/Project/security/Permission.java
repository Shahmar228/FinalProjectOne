package com.finalProject.Project.security;

public enum Permission{
    DATA_READ("can read data"),
    DATA_WRITE("cand read and edit data");


    private final String permission_info;


    Permission(String permission_info){
        this.permission_info = permission_info;
    }

    public String getPermission_info(){
        return permission_info;
    }
}
