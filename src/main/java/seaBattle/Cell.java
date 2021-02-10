package seaBattle;

public enum Cell {
    SHIP("\u2693"),
    HALATION ("\uD83D\uDD38"),
    DAMAGE("\u274C"),
    EMPTY("\u2B1C");

    String symbol;

    Cell(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
