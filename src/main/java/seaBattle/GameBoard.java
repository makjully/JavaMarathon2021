package seaBattle;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private Cell[][] cells;
    private List<Ship> ships;
    private Cell[][] showed;

    public GameBoard() {
        this.cells = fillBoard();
        this.showed = fillBoard();
        ships = new ArrayList<>();
    }

    public void print(Cell[][] cells) {
        System.out.println("Игровое поле:");
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                System.out.print(cells[i][j]);
            }
            System.out.println();
        }
    }

    private Cell[][] fillBoard() {
        Cell[][] cells = new Cell[10][10];

        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = Cell.EMPTY;
            }
        }

        return cells;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public Cell[][] getCells() {
        return cells;
    }

    public Cell[][] getShowed() {
        return showed;
    }

    public void addShip(List<Integer[]> coordinates) throws InvalidInputException {
        int x1 = coordinates.get(0)[0];
        int y1 = coordinates.get(0)[1];
        int x2 = coordinates.get(coordinates.size() - 1)[0];
        int y2 = coordinates.get(coordinates.size() - 1)[1];

        List<Integer[]> halations = new ArrayList<>();

        boolean isShip = false;

        if (x1 != 0 && y1 != 0 && x2 != cells.length - 1 && y2 != cells.length - 1) {
            for (int i = x1 - 1; i <= x2 + 1; i++) {
                for (int j = y1 - 1; j <= y2 + 1; j++) {
                    if (cells[i][j].equals(Cell.EMPTY)) {
                        halations.add(new Integer[]{i, j});
                    } else if (cells[i][j].equals(Cell.SHIP)) {
                        isShip = true;
                        break;
                    }
                }
            }
        } else if (x1 == 0) {
            if (y1 == 0) {
                for (int i = x1; i <= x2 + 1; i++) {
                    for (int j = y1; j <= y2 + 1; j++) {
                        if (cells[i][j].equals(Cell.EMPTY)) {
                            halations.add(new Integer[]{i, j});
                        } else if (cells[i][j].equals(Cell.SHIP)) {
                            isShip = true;
                            break;
                        }
                    }
                }
            } else if (y2 == cells.length - 1) {
                for (int i = x1; i <= x2 + 1; i++) {
                    for (int j = y1 - 1; j <= y2; j++) {
                        if (cells[i][j].equals(Cell.EMPTY)) {
                            halations.add(new Integer[]{i, j});
                        } else if (cells[i][j].equals(Cell.SHIP)) {
                            isShip = true;
                            break;
                        }
                    }
                }
            } else {
                for (int i = x1; i <= x2 + 1; i++) {
                    for (int j = y1 - 1; j <= y2 + 1; j++) {
                        if (cells[i][j].equals(Cell.EMPTY)) {
                            halations.add(new Integer[]{i, j});
                        } else if (cells[i][j].equals(Cell.SHIP)) {
                            isShip = true;
                            break;
                        }
                    }
                }
            }
        } else if (x2 == cells.length - 1) {
            if (y1 == 0) {
                for (int i = x1 - 1; i <= x2; i++) {
                    for (int j = y1; j <= y2 + 1; j++) {
                        if (cells[i][j].equals(Cell.EMPTY)) {
                            halations.add(new Integer[]{i, j});
                        } else if (cells[i][j].equals(Cell.SHIP)) {
                            isShip = true;
                            break;
                        }
                    }
                }
            } else if (y2 == cells.length - 1) {
                for (int i = x1 - 1; i <= x2; i++) {
                    for (int j = y1 - 1; j <= y2; j++) {
                        if (cells[i][j].equals(Cell.EMPTY)) {
                            halations.add(new Integer[]{i, j});
                        } else if (cells[i][j].equals(Cell.SHIP)) {
                            isShip = true;
                            break;
                        }
                    }
                }
            } else {
                for (int i = x1 - 1; i <= x2; i++) {
                    for (int j = y1 - 1; j <= y2 + 1; j++) {
                        if (cells[i][j].equals(Cell.EMPTY)) {
                            halations.add(new Integer[]{i, j});
                        } else if (cells[i][j].equals(Cell.SHIP)) {
                            isShip = true;
                            break;
                        }
                    }
                }
            }
        } else if (x2 != cells.length - 1 && y1 == 0) {
            for (int i = x1 - 1; i <= x2 + 1; i++) {
                for (int j = y1; j <= y2 + 1; j++) {
                    if (cells[i][j].equals(Cell.EMPTY)) {
                        halations.add(new Integer[]{i, j});
                    } else if (cells[i][j].equals(Cell.SHIP)) {
                        isShip = true;
                        break;
                    }
                }
            }
        } else if (x2 != cells.length - 1 && y2 == cells.length - 1) {
            for (int i = x1 - 1; i <= x2 + 1; i++) {
                for (int j = y1 - 1; j <= y2; j++) {
                    if (cells[i][j].equals(Cell.EMPTY)) {
                        halations.add(new Integer[]{i, j});
                    } else if (cells[i][j].equals(Cell.SHIP)) {
                        isShip = true;
                        break;
                    }
                }
            }
        }

        if (isShip) {
            throw new InvalidInputException("Вокруг корабля должна быть область шириной в одну клетку, " +
                    "в которой не может быть других кораблей (ореол корабля)");
        }

        halations.forEach(coordinatesH -> cells[coordinatesH[0]][coordinatesH[1]] = Cell.HALATION);

        coordinates.forEach(coordinatesS -> cells[coordinatesS[0]][coordinatesS[1]] = Cell.SHIP);

        ships.add(new Ship(coordinates));
    }
}