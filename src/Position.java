import java.util.ArrayList;

public class Position {
    /*
    Byte[][] stores the current chess position. Correspondence of number to piece:
    0 - empty
    1 - white pawn
    2 - white knight
    3 - white bishop
    4 - white rook
    5 - white queen
    6 - white king
    7 - black pawn
    8 - black knight
    9 - black bishop
    10 - black rook
    11 - black queen
    12 - black king
    True - Black
    False - White

    Board is stored as x,y with top left being 0,0
     */
    byte[][] position; //indexed 0 to 7
    boolean blackToMove;

    public Position() { // initializes starting position
        position = new byte[8][8];
        inputStartingPieces();
        blackToMove = false;
    }
    public Position(Position p) {
        position = new byte[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                position[i][j] = p.position[i][j];
            }
        }
        blackToMove = p.blackToMove;
    }
    public ArrayList getAllLegalMoves() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (position[i][j] != 0) {

                }
            }
        }
    }

    private int findNumberOfMovesForPiece(int xPos, int yPos) {
        byte pieceNum = position[xPos][yPos];
        if (pieceNum == 1) {
            return numMovesWhitePawn(xPos, yPos);
        } else if (pieceNum == 2) {
            return numMovesWhiteKnight(xPos, yPos);
        } else if (pieceNum == 3) {
            return numMovesWhiteBishop(xPos, yPos);
        } else if (pieceNum == 4) {
            return numMovesWhiteRook(xPos, yPos);
        } else if (pieceNum == 5) {
            return numMovesWhiteQueen(xPos, yPos);
        } else if (pieceNum == 6) {
            return numMovesWhiteKing(xPos, yPos);
        } else if (pieceNum == 7) {
            return numMovesBlackPawn(xPos, yPos);
        } else if (pieceNum == 8) {
            return numMovesBlackKnight(xPos, yPos);
        } else if (pieceNum == 9) {
            return numMovesBlackBishop(xPos, yPos);
        } else if (pieceNum == 10) {
            return numMovesBlackRook(xPos, yPos);
        } else if (pieceNum == 11) {
            return numMovesBlackQueen(xPos, yPos);
        } else if (pieceNum == 12) {
            return numMovesBlackKing(xPos, yPos);
        }
    }

    private int numMovesWhitePawn(int xPos, int yPos) { // todo add empasant
        int movesPossible = 0;
        if (position[xPos][yPos - 1] == 0) { // move forward 1
            movesPossible++;
        }
        if (yPos == 6 && position[xPos][yPos - 1] == 0 && position[xPos][yPos - 2] == 0) { // moving forward by 2
            movesPossible++;
        }
        if (xPos != 7 && position[xPos + 1][yPos - 1] >= 7) { // one capture
            movesPossible++;
        }
        if (xPos != 0 && position[xPos - 1][yPos - 1] >= 7) {
            movesPossible++;
        }
        return movesPossible;
    }

    private int numMovesWhiteKnight(int xPos, int yPos) {
        int movesPossible = 0;
        if (xPos >= 2 && yPos != 0 && (position[xPos - 2][yPos - 1]  == 0 || position[xPos - 2][yPos - 1] >= 7)) { // x - 2, y - 1
            movesPossible++;
        }
        if (xPos >= 2 && yPos != 7 && (position[xPos - 2][yPos + 1]  == 0 || position[xPos - 2][yPos + 1] >= 7)) { // x - 2, y + 1
            movesPossible++;
        }
        if (xPos != 0 && yPos >= 2 && (position[xPos - 1][yPos - 2]  == 0 || position[xPos - 1][yPos - 2] >= 7)) { // x - 1, y - 2
            movesPossible++;
        }
        if (xPos != 0 && yPos <= 5 && (position[xPos - 1][yPos + 2]  == 0 || position[xPos - 1][yPos + 2] >= 7)) { // x - 1, y + 2
            movesPossible++;
        }
        // todo finish
        return movesPossible;
    }
    private int numMovesWhiteBishop(int xPos, int yPos) {

    }
    private int numMovesWhiteRook(int xPos, int yPos) {

    }
    private int numMovesWhiteQueen(int xPos, int yPos) {

    }
    private int numMovesWhiteKing(int xPos, int yPos) {

    }
    private int numMovesBlackPawn(int xPos, int yPos) {

    }
    private int numMovesBlackKnight(int xPos, int yPos) {

    }
    private int numMovesBlackBishop(int xPos, int yPos) {

    }
    private int numMovesBlackRook(int xPos, int yPos) {

    }
    private int numMovesBlackQueen(int xPos, int yPos) {

    }
    private int numMovesBlackKing(int xPos, int yPos) {

    }


    private void inputStartingPieces() {
        position[0][0] = 10; // back row
        position[1][0] = 8;
        position[2][0] = 9;
        position[3][0] = 11;
        position[4][0] = 12;
        position[5][0] = 9;
        position[6][0] = 8;
        position[7][0] = 10;

        position[0][1] = 7; // black pawns
        position[1][1] = 7;
        position[2][1] = 7;
        position[3][1] = 7;
        position[4][1] = 7;
        position[5][1] = 7;
        position[6][1] = 7;
        position[7][1] = 7;

        position[0][6] = 1; // white pawns
        position[1][6] = 1;
        position[2][6] = 1;
        position[3][6] = 1;
        position[4][6] = 1;
        position[5][6] = 1;
        position[6][6] = 1;
        position[7][6] = 1;

        position[0][7] = 4; // front row
        position[1][7] = 2;
        position[2][7] = 3;
        position[3][7] = 6;
        position[4][7] = 5;
        position[5][7] = 3;
        position[6][7] = 2;
        position[7][7] = 4;
    }
}
