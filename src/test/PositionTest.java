package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import data.Position;
import data.Move;


public class PositionTest {

    @org.junit.Test
    public void getAllLegalMoves() {
        Position initialBoard = new Position();
        ArrayList<Move> movesWhitePawnBoard = new ArrayList<>();
        System.out.println(initialBoard.getAllLegalMoves());
        System.out.println("Ran");
    }

}




