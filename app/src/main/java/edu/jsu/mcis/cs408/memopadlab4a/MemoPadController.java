package edu.jsu.mcis.cs408.memopadlab4a;

import java.util.List;

public class MemoPadController extends AbstractController {
    public static final String MEMO_LIST = "Memo";
    private final MemoPadModel model;

        public MemoPadController(MemoPadModel model) {
            super();
            this.model = model;
            addModel(model);
        }

    public void addMemo(String newText) {
        model.addMemo(newText);
    }

    public void deleteMemo(int id) {
        model.deleteMemo(id);
    }

    public void getAllMemos() {
        model.getAllMemos();
    }
}

