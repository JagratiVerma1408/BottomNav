package com.example.bottomnav.Model;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.bottomnav.Model.Model.NameModel;
import com.example.bottomnav.Model.ViewModel.NameViewModel;
import com.example.bottomnav.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity  implements OnDataAdded{
    private UserAdapter userAdapter;
    private RecyclerView recyclerView;
    private UserAdapter user;
    private ArrayList<NameModel> arrayList=new ArrayList<>();
    private NameViewModel nameViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recylerview12);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        nameViewModel= ViewModelProviders.of(MainActivity.this).get(NameViewModel.class);
        nameViewModel.init(MainActivity.this);
        userAdapter=new UserAdapter(nameViewModel.getNameModeldata().getValue(),MainActivity.this);
        recyclerView.setAdapter(userAdapter);

    }


    @Override
    public void added() {
        userAdapter.notifyDataSetChanged();


    }
}