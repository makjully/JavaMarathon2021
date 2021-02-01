package day13;

public class Task1 {
    public static void main(String[] args) {
        User user1 = new User("Jonny");
        User user2 = new User("Bob");
        User user3 = new User("Amy");

        // Отправить 2 сообщения от пользователя 1 пользователю 2
        user1.sendMessage(user2, "Привет!");
        user1.sendMessage(user2, "Погнали в бар вечером!");

        // Отправить 3 сообщения от пользователя 2 пользователю 1
        user2.sendMessage(user1, "Привет :)");
        user2.sendMessage(user1, "Не могу, на работе завал...");
        user2.sendMessage(user1, "Но спасибо за приглашение, бро");

        // Отправить 3 сообщения от пользователя 3 пользователю 1
        user3.sendMessage(user1, "Привет");
        user3.sendMessage(user1, "Ты сегодня занят?");
        user3.sendMessage(user1, "Пойдем в кино! Там новый мульт офигенный вышел");

        // Отправить 3 сообщения от пользователя 1 пользователю 3
        user1.sendMessage(user3, "Хай)");
        user1.sendMessage(user3, "Не, не могу. Извини. Дел много");
        user1.sendMessage(user3, "Я вчера в кино был");

        // Отправить 1 сообщение от пользователя 3 пользователю 1
        user3.sendMessage(user1, "Ну, лан... :(");

        MessageDatabase.showDialog(user1, user3);
    }
}
