package com.example.bottomnav.Model;



import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bottomnav.Model.Model.NameModel;
import com.example.bottomnav.R;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    LayoutInflater inflater;
    private Context context;
   private ArrayList<NameModel> userLists;



    public UserAdapter(ArrayList<NameModel> userLists, Context context){
        this.userLists=userLists;
        this.context=context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.resourse,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(userLists.get(position).getTitle());
        Log.e("Jagrati",userLists.get(position).getTitle());
        holder.body.setText(userLists.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return userLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView title,body,likes;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.titletext);
            body=itemView.findViewById(R.id.bodytext);
            likes=itemView.findViewById(R.id.likestexts);
            //this is shit

        }


        @Override
        public void onClick(View v) {

        }
    }
}
