package observer.tobe;


import observer.tobe.ObserverImpl.DataSheetView;
import observer.tobe.ObserverImpl.MinMaxView;

public class Client {
    public static void main(String[] args) {
        Subject.ScoreRecord scoreRecord = new Subject.ScoreRecord();

        DataSheetView dataSheetView3 = new DataSheetView(scoreRecord, 3);
        DataSheetView dataSheetView5 = new DataSheetView(scoreRecord, 5);
        MinMaxView minMaxView = new MinMaxView(scoreRecord);

        scoreRecord.attach(dataSheetView3);
        scoreRecord.attach(dataSheetView5);
        scoreRecord.attach(minMaxView);

        for(int idx = 1; idx <= 5; idx++) {
            int score = idx*10;
            System.out.printf("Adding %d \n", score);

            scoreRecord.addScore(score);
        }
    }
}
