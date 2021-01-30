package day11.task1;

public class Picker implements Worker {
    private int salary;
    private boolean isPayed;
    private Warehouse warehouse;

    public Picker(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public int getSalary() {
        return salary;
    }

    public boolean isPayed() {
        return isPayed;
    }

    @Override
    public String toString() {
        return "Сборщик: " +
                "зарплата: " + salary +
                ", количество собранных заказов: " + warehouse.getCountPickedOrders();
    }

    @Override
    public void doWork() {
        salary += 80;
        warehouse.setCountPickedOrders(warehouse.getCountPickedOrders() + 1);
    }

    @Override
    public void bonus() {
        if (warehouse.getCountPickedOrders() < 10000) {
            System.out.println("Бонус пока не доступен");
        } else {
            if (isPayed) {
                System.out.println("Бонус уже был выплачен");
            } else {
                salary += 70000;
                isPayed = true;
            }
        }
    }
}
