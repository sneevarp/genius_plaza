package com.project.android.genius_plaza;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.UsersViewHolder>{
    Context mCtx;
    List<Users> userList;

    public UsersAdapter(Context mCtx, List<Users> userList) {
        this.mCtx = mCtx;
        this.userList = userList;
    }

    @NonNull
    @Override
    public UsersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.list, parent, false);
        return new UsersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsersViewHolder holder, int position) {
        Users user = userList.get(position);

        Glide.with(mCtx)
                .load(user.getAvatar())
                .apply(RequestOptions.circleCropTransform())
                .into(holder.avatar);

        holder.fname.setText(user.getFirstname());
        holder.lname.setText(user.getLastname());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class UsersViewHolder extends RecyclerView.ViewHolder {

        ImageView avatar;
        TextView fname,lname;

        public UsersViewHolder(View itemView) {
            super(itemView);

            avatar = itemView.findViewById(R.id.avatar);
            fname = itemView.findViewById(R.id.fname);
            lname = itemView.findViewById(R.id.lname);
        }
    }
}
