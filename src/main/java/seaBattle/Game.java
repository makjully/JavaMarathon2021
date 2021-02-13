package seaBattle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Game {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        GameBoard gb1 = new GameBoard();
        Gamer gamer1 = new Gamer("Player1", gb1);

        GameBoard gb2 = new GameBoard();
        Gamer gamer2 = new Gamer("Player2", gb2);

        gamer1.setOpponent(gamer2);
        gamer2.setOpponent(gamer1);

        System.out.printf("Начнем расставлять корабли на поле %s\n", gamer1);
        startDialog(gb1, reader);

        System.out.printf("Начнем расставлять корабли на поле %s\n", gamer2);
        startDialog(gb2, reader);

        play(random(gamer1, gamer2), reader);
    }

    public static void startDialog(GameBoard gb, BufferedReader reader) throws IOException {
        checkUserInput("Введи координаты четырехпалубного корабля (формат: x,y;x,y;x,y;x,y)",
                gb, reader, 4);

        checkUserInput("Введи координаты первого трехпалубного корабля (формат: x,y;x,y;x,y)",
                gb, reader, 3);

        checkUserInput("Введи координаты второго трехпалубного корабля (формат: x,y;x,y;x,y)",
                gb, reader, 3);

        checkUserInput("Введи координаты первого двухпалубного корабля (формат: x,y;x,y)",
                gb, reader, 2);

        checkUserInput("Введи координаты второго двухпалубного корабля (формат: x,y;x,y)",
                gb, reader, 2);

        checkUserInput("Введи координаты третьего двухпалубного корабля (формат: x,y;x,y)",
                gb, reader, 2);

        checkUserInput("Введи координаты первого однопалубного корабля (формат: x,y)",
                gb, reader, 1);

        checkUserInput("Введи координаты второго однопалубного корабля (формат: x,y)",
                gb, reader, 1);

        checkUserInput("Введи координаты третьего однопалубного корабля (формат: x,y)",
                gb, reader, 1);

        checkUserInput("Введи координаты четвертого однопалубного корабля (формат: x,y)",
                gb, reader, 1);

        gb.print();
    }

    public static void checkUserInput(String console, GameBoard gb, BufferedReader reader, int numberDecks) throws IOException {
        boolean isCorrect;

        do {
            System.out.println(console);
            try {
                isCorrect = isCorrect(reader.readLine(), gb, numberDecks);
            } catch (IllegalArgumentException e) {
                isCorrect = false;
                System.out.println(e.getMessage());
            }
        } while (!isCorrect);
    }

    public static boolean isCorrect(String userInput, GameBoard gb, int numberDecks) {
        boolean isCorrect = true;
        String[] cells = userInput.trim().split(";");

        if (userInput.equals("") || numberDecks != cells.length)
            throw new IllegalArgumentException("Некорректный ввод данных! Будь внимательнее.");

        List<Integer[]> list = new ArrayList<>();

        for (String element : cells) {
            String[] coordinatesString = element.split(",");
            Integer[] asNumber = {Integer.parseInt(coordinatesString[0]), Integer.parseInt(coordinatesString[1])};
            list.add(asNumber);
        }

        for (Integer[] numbers : list) {
            int x = numbers[0];
            int y = numbers[1];
            isCorrect = isCorrectPair(x, y);
            if (gb.getCells()[x][y] == Cell.SHIP) {
                throw new IllegalArgumentException("Ячейка занята другим кораблем. Координаты: " + x + "," + y);
            }
        }

        if (list.size() > 1) {
            isCorrect = isValidList(list);
            int horizontalCount = 0;
            int verticalCount = 0;
            int horizontal = list.get(0)[0];
            int vertical = list.get(0)[1];

            for (Integer[] element : list) {
                if (element[0] == horizontal) {
                    horizontalCount++;
                }
                if (element[1] == vertical) {
                    verticalCount++;
                }
            }

            if (horizontalCount != list.size() && verticalCount != list.size()) {
                throw new IllegalArgumentException("Непоследовательно идущие ячейки. Введи верные координаты");
            }
        }
        gb.addShip(list);

        return isCorrect;
    }

    public static void play(Gamer gamer, BufferedReader reader) throws IOException {
        boolean isCorrect;
        int x;
        int y;

        do {
            System.out.printf("%s, твой ход! Введи координаты ячейки (формат: x,y)\n", gamer);

            String[] cells = reader.readLine().trim().split(",");
            x = Integer.parseInt(cells[0]);
            y = Integer.parseInt(cells[1]);
            try {
                isCorrect = isCorrectPair(x, y);
            } catch (IllegalArgumentException e) {
                isCorrect = false;
                System.out.println(e.getMessage());
            }
        } while (!isCorrect);

        String result = gamer.move(x, y);
        System.out.println(result);

        if (result.equals("Мимо!")) {
            System.out.printf("%s, ты промахнулся :( Ход переходит к %s\n", gamer, gamer.getOpponent());
            play(gamer.getOpponent(), reader);
        } else if (result.equals("Попадание!") || result.equals("Утопил!")) {
            play(gamer, reader);
        } else if (result.equals("Игра окончена!")) {
            System.out.printf("Последний корабль %s был потоплен. Победу одерживает %s. Поздравляем!",
                    gamer.getOpponent(), gamer);
            return;
        }
    }

    public static boolean isCorrectPair(int x, int y) {
        if (x < 0 || y < 0 || x > 9 || y > 9) {
            throw new IllegalArgumentException("Координаты должны быть в диапазоне [0-9]");
        }
        return true;
    }

    public static Gamer random(Gamer gamer1, Gamer gamer2) {
        Random random = new Random();
        Gamer[] gamers = {gamer1, gamer2};

        int index = random.nextInt(2);

        return gamers[index];
    }

    public static boolean isValidList(List<Integer[]> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            for (int j = 1; j < i; j++) {
                if (list.get(i)[0] == list.get(j)[0] && list.get(i)[1] == list.get(j)[1]) {
                    throw new IllegalArgumentException("Совпадающие координаты");
                }
            }
        }
        return true;
    }
}