package com.example.crud;

public class student {
    String fullname;
    int enroll;
    boolean status;

    public student(){

    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getEnroll() {
        return enroll;
    }

    public void setEnroll(int enroll) {
        this.enroll = enroll;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public student(int enroll, String fullname, boolean status){
        this.enroll=enroll;
        this.fullname=fullname;
        this.status=status;
    }

}