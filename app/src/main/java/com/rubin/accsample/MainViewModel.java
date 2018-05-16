package com.rubin.accsample;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.rubin.accsample.model.User;

public class MainViewModel extends ViewModel {

    private MutableLiveData<User> user;

    public MainViewModel() {
        user = new MutableLiveData<>();
    }

    public LiveData<User> getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user.setValue(user);
    }
}
