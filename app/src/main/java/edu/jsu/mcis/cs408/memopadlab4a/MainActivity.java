package edu.jsu.mcis.cs408.memopadlab4a;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;

import edu.jsu.mcis.cs408.memopadlab4a.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AbstractView, View.OnClickListener {

    private ActivityMainBinding binding;
    private DatabaseHandler db;
    MemoPadController controller;
    MemoPadModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        model = new MemoPadModel();
        controller = new MemoPadController(model);

        controller.addView(this);

        db = new DatabaseHandler(this, null, null, 1);

        binding.AddButton.setOnClickListener(this);
        binding.DeleteButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        int id = View.generateViewId();

        String tag = view.getTag().toString();

        switch (tag) {

            case "AddButton": {
                String newMemo = binding.memoText.getText().toString();
                db.addMemo(new Memo(newMemo));
                //binding.output.sethasFixedSize();
                updateRecyclerView();
                Toast.makeText(this,"Memo added Successfully",Toast.LENGTH_SHORT).show();
                break;
            }
            case "DeleteButton": {
                String result = db.deleteAllMemos();
                //binding.output.setText(result);
                break;
            }
            default:
                throw new IllegalStateException("Unexpected value: " + tag);
        }

    }
    private void updateRecyclerView() {

        ArrayList<Memo> adapter = new RecyclerView();
        adapter = db.getAllMemos();
        binding.output.setHasFixedSize(true);
        binding.output.setLayoutManager(new LinearLayoutManager(this));
        binding.output.setAdapter(adapter.get());

    }

    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        String propertyValue = evt.getNewValue().toString();
    }
}
