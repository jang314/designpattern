package decoreator.tobe;

import decoreator.tobe.Client.DisplayDecorator.LaneDecorator;
import decoreator.tobe.Client.DisplayDecorator.TrafficDecorator;

public class Client {
    public static void main(String[] args) {
        Display road = new RoadDisplay();
        road.draw(); // 기본 도로 표시

        Display roadWithLane = new LaneDecorator(road);
        roadWithLane.draw();

        Display roadWithTraffic = new TrafficDecorator(road);
        roadWithTraffic.draw();

        Display roadWithLaneAndTraffic = new TrafficDecorator(new LaneDecorator(new RoadDisplay()));
        roadWithLaneAndTraffic.draw();
    }

    public static abstract class Display {
        public abstract void draw();
    }

    public static class RoadDisplay extends Display {

        @Override
        public void draw() {
            System.out.println("기본 도로 표시");
        }
    }

    public static abstract class DisplayDecorator extends Display {
        private Display decoratedDisplay;

        public DisplayDecorator(Display decoratedDisplay) {
            this.decoratedDisplay = decoratedDisplay;
        }

        public void draw() {
            decoratedDisplay.draw();
        }

        public static class LaneDecorator extends DisplayDecorator {

            public LaneDecorator(Display decoratedDisplay) {
                super(decoratedDisplay);
            }
            public void draw() {
                super.draw();
                drawLane();
            }

            private void drawLane() {
                System.out.println("\t 차선 표시");
            }
        }

        public static class TrafficDecorator extends DisplayDecorator {

            public TrafficDecorator(Display decoratedDisplay) {
                super(decoratedDisplay);
            }
            public void draw() {
                super.draw();
                drawTraffic();
            }

            private void drawTraffic() {
                System.out.println("\t 교통량 표시");
            }
        }
    }
}
