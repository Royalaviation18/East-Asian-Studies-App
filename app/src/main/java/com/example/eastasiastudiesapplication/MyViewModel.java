package com.example.eastasiastudiesapplication;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    private MutableLiveData<String> myData = new MutableLiveData<>();

    public void setData(String data) {
        myData.setValue(data);
    }

    public LiveData<String> getData() {
        return myData;
    }

    public void setMyData(String data) {
        myData.setValue(data);
    }

    public LiveData<String> getMyData() {
        return myData;
    }




}

