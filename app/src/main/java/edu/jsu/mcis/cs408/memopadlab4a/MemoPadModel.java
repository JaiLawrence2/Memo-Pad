package edu.jsu.mcis.cs408.memopadlab4a;

import android.util.Log;

import androidx.annotation.NonNull;

import java.util.List;

public class MemoPadModel extends AbstractModel {
   private DatabaseHandler db;

    public MemoPadModel(MainActivity activity) {
        db = new DatabaseHandler(activity, null, null, 1);
    }

    public void addMemo(String newText) {
        Memo m = new Memo(newText);
        db.addMemo(m);
        firePropertyChange(MemoPadController.MEMO_LIST, null, db.getAllMemos());
    }
    public void deleteMemo(int id) {
        db.deleteMemo(id);
        firePropertyChange(MemoPadController.MEMO_LIST, null, db.getAllMemos());
    }
    public void getAllMemos(){
        firePropertyChange(MemoPadController.MEMO_LIST, null, db.getAllMemos());
    }

}

