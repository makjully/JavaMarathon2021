package seaBattle;

import java.util.ArrayList;
import java.util.List;

public class Gamer {
    private GameBoard board;
    private String name;
    private Gamer opponent;
    private List<Integer[]> inputCoordinates;

    public Gamer(String name, GameBoard board) {
        this.name = name;
        this.board = board;
        inputCoordinates = new ArrayList<>();
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
                    opponent.getBoard().getShowed()[x][y] = Cell.DAMAGE;
                    ship.getCoordinates().remove(j);
                    isHit = true;
                    damagedShip = ship;
                    break;
                }
            }
        }

        if (!isHit) {
            if (!inputCoordinates.isEmpty()) {
                for (int i = 0; i < inputCoordinates.size(); i++) {
                    if (inputCoordinates.get(i)[0] == x && inputCoordinates.get(i)[1] == y) {
                        return "Повтор!";
                    }
                }
            }
            result = "Мимо!";
            if (opponent.getBoard().getShowed()[x][y] == Cell.EMPTY) {
                opponent.getBoard().getShowed()[x][y] = Cell.HALATION;
            }
        } else {
            if (damagedShip.getCoordinates().isEmpty()) {
                result = "Утопил!";
                opponent.getBoard().getShips().remove(damagedShip);
            } else {
                result = "Попадание!";
            }
        }

        if (opponent.getBoard().getShips().isEmpty()) {
            opponent.getBoard().print(opponent.getBoard().getCells());
            return "Игра окончена!";
        }

        opponent.getBoard().print(opponent.getBoard().getShowed());

        inputCoordinates.add(new Integer[]{x, y});

        return result;
    }

    public void printOpponentBoard() {
        opponent.getBoard().print(opponent.getBoard().getShowed());
    }
}