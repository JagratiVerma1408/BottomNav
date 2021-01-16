package com.example.bottomnav.Model.ViewModel;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.bottomnav.Model.Model.NameModel;
import com.example.bottomnav.Model.Respitory.Repo;

import java.util.ArrayList;

public class NameViewModel extends ViewModel {
    MutableLiveData<ArrayList<NameModel>> liveData;
    public void init (Context context){
        if (liveData!=null){
            return;
        }
        liveData= Repo.getInstance(context).getNameModeldata();
    }
    public LiveData<ArrayList<NameModel>> getNameModeldata(){
        return liveData;
    }
}
