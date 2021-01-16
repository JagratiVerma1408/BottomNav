package com.example.bottomnav.Model.Respitory;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.bottomnav.Model.Model.NameModel;
import com.example.bottomnav.Model.OnDataAdded;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Repo {
   private static final String TAG="jagrati";
   private static OnDataAdded onDataAdded;
   private  static Repo instance;
   private FirebaseFirestore db=FirebaseFirestore.getInstance();
    private ArrayList<NameModel> arrayList=new ArrayList<>( );

    public static Repo getInstance(Context context){

        if (instance==null)
        {
            instance=new Repo();
        }

      return instance;
    }
    public MutableLiveData<ArrayList<NameModel>> getNameModeldata(){

        loadNameModel();
        MutableLiveData<ArrayList<NameModel>> data=new MutableLiveData<>();
       data.setValue(arrayList);
       return data;
    }

    private void loadNameModel() {
        FirebaseFirestore db=FirebaseFirestore.getInstance();
        db.collection("posts").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if(!queryDocumentSnapshots.isEmpty()){
                    List<DocumentSnapshot> list=queryDocumentSnapshots.getDocuments();
                    for (DocumentSnapshot documentSnapshot:list){
                        arrayList.add(documentSnapshot.toObject(NameModel.class));
                    }
                }
                else{
                    Log.e(TAG,"Failed");
                }

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.e(TAG,"onFailure : " + e );
            }
        });
    }


}


