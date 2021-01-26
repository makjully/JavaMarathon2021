package day7;

public class Player {
    private int stamina;
    public static final int MIN_STAMINA = 0;
    private static int countPlayers;
    public static final int MAX_COUNT = 6;

    public Player(int stamina) {
        this.stamina = stamina;
        if (countPlayers < MAX_COUNT)
            countPlayers++;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public static int getCountPlayers() {
        return countPlayers;
    }

    public static void setСountPlayers(int count) {
        Player.countPlayers = count;
    }

    public void run() {
        if (stamina > MIN_STAMINA) {
            if (stamina == 1) {
                countPlayers--;
            }
            stamina--;
        }
    }

    public static void info() {
        int freePlaces = MAX_COUNT - countPlayers;

        if (freePlaces > 2) {
            System.out.printf("Команды неполные. На поле еще есть %d свободных мест\n", freePlaces);
        } else if (freePlaces == 1) {
            System.out.println("Команды неполные. На поле еще есть 1 свободное место");
        } else if (freePlaces == 2) {
            System.out.println("Команды неполные. На поле еще есть 2 свободных места");
        } else if (freePlaces == 0) {
            System.out.println("На поле нет свободных мест");
        }
    }
}
