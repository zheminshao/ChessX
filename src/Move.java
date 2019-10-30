public class Move {
    final int xInitial;
    final int xFinal;
    final int yInitial;
    final int yFinal;

    public Move(int xInitial, int yInitial, int xFinal, int yFinal) {
        this.xInitial = xInitial;
        this.xFinal = xFinal;
        this.yInitial = yInitial;
        this.yFinal = yFinal;
    }

    @Override
    public String toString() { // ASCII 'a' is 97
        StringBuilder standardNotation = new StringBuilder();
        standardNotation.append((char) (xInitial + 97));
        standardNotation.append(yInitial + 1);
        standardNotation.append(" to ");
        standardNotation.append((char) (xFinal + 97));
        standardNotation.append(yFinal + 1);
        return standardNotation.toString();
    }




}
