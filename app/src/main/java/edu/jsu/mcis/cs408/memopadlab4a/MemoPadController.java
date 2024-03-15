package edu.jsu.mcis.cs408.memopadlab4a;

import java.util.List;

public class MemoPadController extends AbstractController {
        private MainActivity activity;
        private final MemoPadModel model;

        public MemoPadController(MemoPadModel model) {
            super();
            this.activity = activity;
            this.model = model;
            addModel(model);
        }

        public void loadMemos() {
            List<MemoPadModel> memoList = model.getAllMemos();
            activity.displayMemos(memoList);
        }
}

