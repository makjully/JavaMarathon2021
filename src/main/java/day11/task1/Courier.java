package day11.task1;

public class Courier implements Worker {
    private int salary;
    private boolean isPayed;
    private Warehouse warehouse;

    public Courier(Warehouse warehouse) {
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
        return "Курьер: " +
                "зарплата: " + salary +
                ", количество доставленных заказов: " + warehouse.getCountDeliveredOrders();
    }

    @Override
    public void doWork() {
        salary += 100;
        warehouse.setCountDeliveredOrders(warehouse.getCountDeliveredOrders() + 1);
    }

    @Override
    public void bonus() {
        if (warehouse.getCountDeliveredOrders() < 10000) {
            System.out.println("Бонус пока не доступен");
        } else {
            if (isPayed) {
                System.out.println("Бонус уже был выплачен");
            } else {
                salary += 50000;
                isPayed = true;
            }
        }
    }
}
