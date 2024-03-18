package edu.jsu.mcis.cs408.memopadlab4a;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import android.view.View;
import android.widget.TextView;

import edu.jsu.mcis.cs408.memopadlab4a.databinding.MemoItemBinding;

public class MemoAdapter extends RecyclerView.Adapter<MemoAdapter.MemoViewHolder> {

    private final List<Memo> memoList;
    private final MainActivity activity;

    public MemoAdapter(MainActivity activity,List<Memo> memoList) {
        super();
        this.activity = activity;
        this.memoList = memoList;
    }

    @NonNull
    @Override
    public MemoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MemoItemBinding binding = MemoItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        binding.getRoot().setOnClickListener(activity.getItemClick()); //the click handler
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

    public Memo getItem(int position) {
        return memoList.get(position);
    }

    public static class MemoViewHolder extends RecyclerView.ViewHolder {
        private Memo memo;

        public MemoViewHolder(View itemView) {
            super(itemView);}

        public void bindData() {

            TextView MemoLabel = (TextView) itemView.findViewById(R.id.MemoLabel);
            MemoLabel.setText(memo.toString());

        }

        public void setMemo(Memo memo) {this.memo = memo;}
    }
}


