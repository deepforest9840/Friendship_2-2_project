package com.example.myfirst_project;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    ArrayList<User> list;

    public MyAdapter(Context context, ArrayList<User> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = list.get(position);
        holder.nname.setText(user.getUname());

        Glide.with(context)
                .load(user.getUimage())
                .into(holder.iimage);

        // Get the recipient's user ID
        final String recipientUserID = user.getUname(); // Assuming you have a method to get the user ID

        // Add a click listener for the "Message" button
        holder.messageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle the "Message" button click
                Intent chatIntent = new Intent(context, ChatActivity.class);
                chatIntent.putExtra("recipientUserID", recipientUserID);
                context.startActivity(chatIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nname;
        ImageView iimage;
        // Add a reference to the "Message" button
        Button messageButton;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nname = itemView.findViewById(R.id.name);
            iimage = itemView.findViewById(R.id.picture);
            // Initialize the "Message" button
            messageButton = itemView.findViewById(R.id.messageButton);
        }
    }
}
