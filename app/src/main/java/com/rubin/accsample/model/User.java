package com.rubin.accsample.model;

import android.arch.lifecycle.LiveData;

public class User extends LiveData {

    public String name;
    public int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
