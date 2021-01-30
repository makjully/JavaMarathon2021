package day11.task2;

public class Warrior extends Hero implements PhysAttack {
    private int physAtt;

    public Warrior() {
        physAtt = 30;
        setHealth(100);
        setPhysDef(0.8);
        setMagicDef(0.0);
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "health=" + getHealth() +
                '}';
    }

    @Override
    public void physicalAttack(Hero hero) {
        int damage = (int) (physAtt - physAtt * hero.getPhysDef());
        int enemyHealth = hero.getHealth();

        if (enemyHealth - damage > 0) {
            hero.setHealth(enemyHealth - damage);
        } else
            hero.setHealth(0);
    }
}
