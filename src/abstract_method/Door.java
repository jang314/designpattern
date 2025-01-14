package abstract_method;

import static abstract_method.DoorStatus.CLOSED;
import static abstract_method.DoorStatus.OPENED;

public abstract class Door {
    private DoorStatus doorStatus;

    public Door() {
        doorStatus = CLOSED;
    }

    public DoorStatus getDoorStatus() {
        return this.doorStatus;
    }

    /**
     * 1. 이미 문이 열려있으면 무시한다.
     * 2. 문을 연다.
     * 3. 문의 상태를 '열림'으로 설정한다.
     * */
    public void open() {
        if(doorStatus == OPENED) {
            return;
        }

        doOpen();
        doorStatus = OPENED;
    }
    public void close() { // 템플릿 메소드
        if(doorStatus == CLOSED) {
            return;
        }

        doClose();
        doorStatus = CLOSED;
    }

    protected abstract void doOpen();
    protected abstract void doClose();

    public static class LGDoor extends Door {

        @Override
        protected void doOpen() {
            System.out.println("open LG Door");
        }

        @Override
        protected void doClose() {
            System.out.println("close LG Door");
        }
    }

    public static class HyundaiDoor extends Door {

        @Override
        protected void doOpen() {
            System.out.println("open Hyundai Door");
        }

        @Override
        protected void doClose() {
            System.out.println("close Hyundai Door");
        }
    }

    public static class SamsungDoor extends Door {

        @Override
        protected void doOpen() {

        }

        @Override
        protected void doClose() {

        }
    }
}
