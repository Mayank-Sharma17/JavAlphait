public class OOPS_interfaces {
    public static void main(String args[]) {
        Queen q = new Queen();
        q.moves();

    }    
}

interface ChessPlayer {
    void moves();
}
class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right, diagonal(in all 4 dirn)");
    }
}
class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right");
    }
}
class King implements ChessPlayer {
    public void moves() {
        System.out.println("up, down, left, right, diagonal-(by 1-step)");
    }
}
