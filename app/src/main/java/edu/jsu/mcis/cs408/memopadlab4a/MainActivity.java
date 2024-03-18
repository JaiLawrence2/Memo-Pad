package edu.jsu.mcis.cs408.memopadlab4a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

import edu.jsu.mcis.cs408.memopadlab4a.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AbstractView {

    private ActivityMainBinding binding;
    MemoPadController controller;
    public static final String TAG = "MainActivity";
    private final MemoPadItemClickHandler itemClick = new MemoPadItemClickHandler();
    private int id = -1;
    private final ButtonClick clickbutton = new ButtonClick();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        controller = new MemoPadController(new MemoPadModel(this));

        controller.addView(this);

        binding.AddButton.setOnClickListener(clickbutton);
        binding.DeleteButton.setOnClickListener(clickbutton);

        //Initial Database Contents
        controller.getAllMemos();
    }
    private class ButtonClick implements View.OnClickListener{
        @Override
        public void onClick(View view) {

            String tag = view.getTag().toString();

            switch (tag) {

                case "AddButton": {
                    String newMemo = binding.memoText.getText().toString();
                    Log.i(TAG, "Memo is: "+ newMemo);
                    controller.addMemo(newMemo);
                    break;
                }
                case "DeleteButton": {
                    controller.deleteMemo(id);
                    break;
                }
            }
        }
    }

    public MemoPadItemClickHandler getItemClick() { return itemClick; }
    @Override
    public void modelPropertyChange(final PropertyChangeEvent evt) {

        String propertyName = evt.getPropertyName();

        if ( propertyName.equals(MemoPadController.MEMO_LIST) ) {

            List<Memo> memoList = (List)evt.getNewValue();

            Log.i(TAG, "Number of Memos: " + memoList.size());
            Log.i(TAG, "Database: " + memoList);
            MemoAdapter adapter = new MemoAdapter(this, memoList);
            binding.output.setHasFixedSize(true);
            binding.output.setLayoutManager(new LinearLayoutManager(this));
            binding.output.setAdapter(adapter);

        }

    }
    private class MemoPadItemClickHandler implements View.OnClickListener {
        public void onClick(View v) {
            int position = binding.output.getChildLayoutPosition(v);
            MemoAdapter adapter = (MemoAdapter) binding.output.getAdapter();
            if (adapter != null) {
                Memo memo = adapter.getItem(position);
                id = memo.getId();
                Toast.makeText(v.getContext(), String.valueOf(id), Toast.LENGTH_SHORT).show();
            }
        }
    }

}
