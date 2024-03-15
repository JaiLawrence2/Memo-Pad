package edu.jsu.mcis.cs408.memopadlab4a;

import androidx.annotation.NonNull;

public class Memo {
    private int id;
    private final String message;

    public Memo(int id, String message) {
        this.id = id;
        this.message = message;
    }

    public Memo(String message){
        this.message = message;
    }
    public String getMemo(){return message;}

    @NonNull
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("#").append(id).append(" ").append(message).append("\n");
        return s.toString();
    }
}
