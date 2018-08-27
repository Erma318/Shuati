package lilunke.class16;

public class createRoom {
    public static class Room {
        // data fields
    }

    public static class OrdinaryRoom extends Room{
        //...
        public OrdinaryRoom(String name, int size) {
            //...
        }
    }

    public static class MagicRoom extends Room {
        //...
        public MagicRoom(String name, int size) {
            //...
        }
    }

    public static class MazeGame {
        public void createGame() {
            Room room1 = makeRoom();
            Room room2 = makeRoom();

            //...
        }

        protected Room makeRoom() {
            System.out.println("room created");
            return new OrdinaryRoom("room", 10);
        }
    }

    public static class MagicMazeGame extends MazeGame {
        protected Room makeRoom() {
            System.out.println("magic room created");
            return new MagicRoom("room", 10);
        }
    }

    public static void main(String[] args) {
        MazeGame game1 = new MazeGame();
        game1.createGame();
        MagicMazeGame game2 = new MagicMazeGame();
        game2.createGame();

    }

}