package observer.asis;

import java.util.ArrayList;
import java.util.List;

public class DataSheetClient {
    public static void main(String[] args) {
        ScoreRecord scoreRecord = new ScoreRecord();

        // 3개 까지의 점수만 출력
        DataSheetView dataSheetView = new DataSheetView(scoreRecord, 3);
        scoreRecord.setDataSheetView(dataSheetView);

        for(int idx = 1; idx <= 5; idx++) {
            int score = idx*10;
            System.out.printf("Adding %d \n", score);

            scoreRecord.addScore(score);
        }

    }

    public static class ScoreRecord {
        private List<Integer> scores = new ArrayList<>();
        private DataSheetView dataSheetView;

        public void setDataSheetView(DataSheetView dataSheetView) {
            this.dataSheetView = dataSheetView;
        }

        public void addScore(int score) {
            this.scores.add(score);
            this.dataSheetView.update();
        }

        public List<Integer> getScoreRecord() {
            return this.scores;
        }
    }

    public static class DataSheetView {
        private ScoreRecord scoreRecord;
        private int viewCount;

        public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
            this.scoreRecord = scoreRecord;
            this.viewCount = viewCount;
        }

        public void update() {
            List<Integer> record = scoreRecord.getScoreRecord();
            displayScores(record, viewCount);
        }

        private void displayScores(List<Integer> record, int viewCount) {
            System.out.printf("List of %d entries: ");
            for(int i=0; i < viewCount && i < record.size(); i++) {
                System.out.printf("%d ", record.get(i));
            }
            System.out.println();
        }
    }
}
