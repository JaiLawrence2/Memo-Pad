package edu.jsu.mcis.cs408.memopadlab4a;

import androidx.annotation.NonNull;

public class MemoPadModel extends AbstractModel {
    private int id;
    private String memo;

    public MemoPadModel(int memoId, String memo) {
        this.memo = memo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("#").append(id).append(" Memo: ").append(memo).append("\n");
        return s.toString();
    }

}

