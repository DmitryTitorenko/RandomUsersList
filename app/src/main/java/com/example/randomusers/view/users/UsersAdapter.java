package com.example.randomusers.view.users;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.randomusers.R;
import com.example.randomusers.model.ResponseUserList;
import com.example.randomusers.model.ResultsItem;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {
    private ResponseUserList list;
    private IOnclickListener onclick;

    public interface IOnclickListener {
        void onclick(ResultsItem item);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView image;

        public ViewHolder(View v) {
            super(v);
            textView = v.findViewById(R.id.tvUserTitle);
            image = v.findViewById(R.id.userView);
        }
    }

    public UsersAdapter(ResponseUserList list, IOnclickListener onclick) {
        this.list = list;
        this.onclick = onclick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText((list.getResults().get(position).getName().getFirst()));
        Glide.with(holder.image)
                .load(list.getResults().get(position).getPicture().getLarge())
                .into(holder.image)
                .waitForLayout();

        holder.textView.setOnClickListener(view -> onclick.onclick(list.getResults().get(position)));
        holder.image.setOnClickListener(view -> onclick.onclick(list.getResults().get(position)));

    }

    @Override
    public int getItemCount() {
        return list.getResults().size();
    }
}
