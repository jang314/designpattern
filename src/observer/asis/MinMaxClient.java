package observer.asis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinMaxClient {
    public static void main(String[] args) {
        ScoreRecord scoreRecord = new ScoreRecord();

        // 3개 까지의 점수만 출력
        MinMaxView minMaxView = new MinMaxView(scoreRecord);

        scoreRecord.setMinMaxView(minMaxView);
        for(int idx = 1; idx <= 5; idx++) {
            int score = idx*10;
            System.out.printf("Adding %d \n", score);

            scoreRecord.addScore(score);
        }

    }

    public static class ScoreRecord {
        private List<Integer> scores = new ArrayList<>();
        private MinMaxView minMaxView ;

        public void setMinMaxView(MinMaxView minMaxView) {
            this.minMaxView = minMaxView;
        }

        public void addScore(int score) {
            this.scores.add(score);
            this.minMaxView.update();
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

    public static class MinMaxView {
        private ScoreRecord scoreRecord;

        public MinMaxView(ScoreRecord scoreRecord) {
            this.scoreRecord = scoreRecord;
        }

        public void update() {
            List<Integer> record = scoreRecord.getScoreRecord();
            displayMinMax(record);
        }

        private void displayMinMax(List<Integer> record) {
            int min = Collections.min(record);
            int max = Collections.max(record);
            System.out.printf("Min: %d, Max : %d \n", min, max);

        }
    }
}
