package edu.jsu.mcis.cs408.memopadlab4a;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.MemoViewHolder> {

    private List<MemoPadModel> memoList;
    private OnItemClickListener itemClickListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public MemoAdapter(List<MemoPadModel> memoList) {
        this.memoList = memoList;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public MemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
        return new MemoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemoViewHolder holder, int position) {
        MemoPadModel memoItem = memoList.get(position);
        holder.textViewContent.setText(MemoPadModel.getContent());
    }

    @Override
    public int getItemCount() {
        return memoList.size();
    }

    public void updateList(List<MemoPadModel> newList) {
        memoList = newList;
        notifyDataSetChanged();
    }

    public class MemoViewHolder extends RecyclerView.ViewHolder {
        TextView textViewContent;

        public MemoViewHolder(View itemView) {
            super(itemView);
            textViewContent = itemView.findViewById(R.id.memoText);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && itemClickListener != null) {
                        itemClickListener.onItemClick(position);
                    }
                }
            });
        }
    }
}

