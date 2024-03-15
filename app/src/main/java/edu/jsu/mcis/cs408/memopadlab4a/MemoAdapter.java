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

import edu.jsu.mcis.cs408.memopadlab4a.databinding.MemoItemBinding;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.MemoViewHolder> {

    private final List<MemoPadModel> memoList;
    private final MainActivity activity;
    //private OnItemClickListener itemClickListener;

    /*public interface OnItemClickListener {
        void onItemClick(int position);
    }*/

    public MemoAdapter(MainActivity activity,List<MemoPadModel> memoList) {
        super();
        this.activity = activity;
        this.memoList = memoList;
    }

    /*public void setOnItemClickListener(OnItemClickListener listener) {
        this.itemClickListener = listener;
    }*/

    @NonNull
    @Override
    public MemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MemoItemBinding binding = MemoItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new MemoViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull MemoViewHolder holder, int position) {
        holder.setMemo(memoList.get(position));
        holder.bindData();
    }

    @Override
    public int getItemCount() {
        return memoList.size();
    }

    public static class MemoViewHolder extends RecyclerView.ViewHolder {
        private MemoPadModel memo;

        public MemoViewHolder(View itemView) {
            super(itemView);}

        public void bindData() {

            TextView MemoLabel = itemView.findViewById(R.id.memoText);

            MemoLabel.setText(memo.getMemo());

        }

        public void setMemo(MemoPadModel memo) {this.memo = memo;}
    }
}


