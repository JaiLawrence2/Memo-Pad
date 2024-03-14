package edu.jsu.mcis.cs408.memopadlab4a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.beans.PropertyChangeEvent;

import edu.jsu.mcis.cs408.memopadlab4a.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements AbstractView, View.OnClickListener {

    private ActivityMainBinding binding;
    private DatabaseHandler db;
    MemoPadController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        controller = new MemoPadController();
        //MemoPadModel model = new MemoPadModel();

        controller.addView(this);

        db = new DatabaseHandler(this, null, null, 1);

        binding.AddButton.setOnClickListener(this);
        binding.DeleteButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        String newMemo = binding.memoText.getText().toString();
        int id = View.generateViewId();

        String tag = view.getTag().toString();

        switch (tag) {

            case "AddButton": {
                db.addMemo(new MemoPadModel(memoId, binding.memoText.getText().toString()));
                String result = db.getAllMemos();

                controller.addModel(newMemo);
                //binding.output.sethasFixedSize();

                binding.output.setAdapter(result);
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

    @Override
    public void modelPropertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        String propertyValue = evt.getNewValue().toString();
    }
}
