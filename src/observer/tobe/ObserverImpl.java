package observer.tobe;

import observer.tobe.Subject.ScoreRecord;

import java.util.Collections;
import java.util.List;

public class ObserverImpl{
    public static class DataSheetView implements Observer {
        private ScoreRecord scoreRecord;
        private int viewCount;

        public DataSheetView(ScoreRecord scoreRecord, int viewCount) {
            this.scoreRecord = scoreRecord;
            this.viewCount = viewCount;
        }

        @Override
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

    public static class MinMaxView implements Observer {
        private ScoreRecord scoreRecord;

        public MinMaxView(ScoreRecord scoreRecord) {
            this.scoreRecord = scoreRecord;
        }

        @Override
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
