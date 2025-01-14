package observer.asis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntergrateClient {
    public static void main(String[] args) {
        ScoreRecord scoreRecord = new ScoreRecord();

        DataSheetView dataSheetView3 = new DataSheetView(scoreRecord, 3);
        DataSheetView dataSheetView5 = new DataSheetView(scoreRecord, 5);
        MinMaxView minMaxView = new MinMaxView(scoreRecord);


        scoreRecord.addDataSheetview(dataSheetView3);
        scoreRecord.addDataSheetview(dataSheetView5);
        scoreRecord.setMinMaxView(minMaxView);

        for(int idx = 1; idx <= 5; idx++) {
            int score = idx*10;
            System.out.printf("Adding %d \n", score);

            scoreRecord.addScore(score);
        }
    }

    public static class ScoreRecord {
        private List<Integer> scores = new ArrayList<>();
        private List<DataSheetView> dataSheetViews=new ArrayList<>();
        private MinMaxView minMaxView ;

        public void setMinMaxView(MinMaxView minMaxView) {
            this.minMaxView = minMaxView;
        }

        public void addDataSheetview(DataSheetView dataSheetView) {
            this.dataSheetViews.add(dataSheetView);
        }
        public void addScore(int score) {
            this.scores.add(score);
            for(DataSheetView dataSheetView : dataSheetViews) {
                dataSheetView.update();
            }
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
