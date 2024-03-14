package edu.jsu.mcis.cs408.memopadlab4a;

public class MemoPadController extends AbstractController {
    public class MemoController {

        private MainActivity activity;
        private MemoPadModel model;

        public MemoController(MainActivity activity, MemoPadModel model) {
            this.activity = activity;
            this.model = model;
        }

        public void addMemo(String content) {
            DatabaseHandler.addMemo(content);
            loadMemos();
        }

        public void deleteMemo(int position) {
            model.deleteMemo(position);
            loadMemos();
        }

        public void loadMemos() {
            List<MemoPadModel> memoList = model.getAllMemos();
            view.displayMemos(memoList);
        }
    }

    private void addModel(MemoPadModel model) {
        model.getMemo();
    }
}
