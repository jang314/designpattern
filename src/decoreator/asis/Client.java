package decoreator.asis;

public class Client {
    public static void main(String[] args) {
        RoadDisplay road = new RoadDisplay();
        road.draw(); // 기본 도로만 표시

        RoadDisplay roadWithLane = new RoadDisplayWithLane();
        roadWithLane.draw();
    }

    // 기본 도로 표시 클래스
    private static class RoadDisplay {
        public void draw() {
            System.out.println("기본 도로 표시");
        }
    }

    private static class RoadDisplayWithLane extends RoadDisplay { // 기본 도로 표시 + 차선 표시

        public void draw() {
            super.draw();
            drawLane();
        }

        private void drawLane() {
            System.out.println("차선 표시");
        }
    }

    private static class RoadDisPlayWithTraffic extends RoadDisplay {
        public void draw() {
            super.draw();
            drawTraffic();
        }

        private void drawTraffic() {
            System.out.println("교통량 표시");
        }
    }
}
