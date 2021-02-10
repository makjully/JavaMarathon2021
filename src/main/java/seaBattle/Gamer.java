package seaBattle;

public class Gamer {
    private GameBoard board;
    private String name;
    private Gamer opponent;

    public Gamer(String name, GameBoard board) {
        this.name = name;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public GameBoard getBoard() {
        return board;
    }

    public Gamer getOpponent() {
        return opponent;
    }

    public void setOpponent(Gamer opponent) {
        this.opponent = opponent;
    }

    @Override
    public String toString() {
        return name;
    }

    public String move(int x, int y) {
        boolean isHit = false;
        String result = "";
        Ship damagedShip = null;

        for (int i = 0; i < opponent.getBoard().getShips().size(); i++) {
            Ship ship = opponent.getBoard().getShips().get(i);
            for (int j = 0; j < ship.getCoordinates().size(); j++) {
                if (ship.getCoordinates().get(j)[0] == x && ship.getCoordinates().get(j)[1] == y) {
                    opponent.getBoard().getCells()[x][y] = Cell.DAMAGE;
                    ship.getCoordinates().remove(j);
                    isHit = true;
                    damagedShip = ship;
                    break;
                }
            }
        }

        if (!isHit) {
            result = "Мимо!";
        } else {
            if (damagedShip.getCoordinates().isEmpty()) {
                result = "Утопил!";
                opponent.getBoard().getShips().remove(damagedShip);
            } else {
                result = "Попадание!";
            }
            opponent.getBoard().print();
        }

        if (opponent.getBoard().getShips().isEmpty()) {
            result = "Игра окончена!";
            opponent.getBoard().print();
        }

        return result;
    }
}
