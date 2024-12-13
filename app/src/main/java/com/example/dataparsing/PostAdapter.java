package com.example.dataparsing;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> postList;
    private Context context;
    private OnPostClickListener listener;

    public PostAdapter(List<Post> postList, Context context, OnPostClickListener listener) {
        this.postList = postList;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostViewHolder holder, int position) {
        Post post = postList.get(position);

        // Set the post ID, title, and body
        holder.postId.setText("Post ID: " + post.getId());
        holder.title.setText(post.getTitle());
        holder.body.setText(post.getBody());

        // Set button click listeners
        holder.deleteButton.setOnClickListener(v -> listener.onDeleteClicked(post.getId()));
        holder.commentsButton.setOnClickListener(v -> listener.onCommentsClicked(post.getId()));
        holder.updateButton.setOnClickListener(v -> listener.onUpdateClicked(post));
    }


    @Override
    public int getItemCount() {
        return postList.size();
    }

    public interface OnPostClickListener {
        void onDeleteClicked(int postId);
        void onCommentsClicked(int postId);
        void onUpdateClicked(Post post);
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder {
        TextView postId, title, body;
        Button deleteButton, commentsButton, updateButton;

        public PostViewHolder(View itemView) {
            super(itemView);
            // Initialize all views by finding them by their IDs
            postId = itemView.findViewById(R.id.postid);  // Reference for Post ID
            title = itemView.findViewById(R.id.postTitle);
            body = itemView.findViewById(R.id.postBody);
            deleteButton = itemView.findViewById(R.id.deleteButton);
            commentsButton = itemView.findViewById(R.id.commentsButton);
            updateButton = itemView.findViewById(R.id.updateButton);
        }
    }

}
