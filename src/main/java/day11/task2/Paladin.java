package day11.task2;

public class Paladin extends Hero implements Healer, PhysAttack {
    private int physAtt;

    public Paladin() {
        physAtt = 15;
        setHealth(100);
        setPhysDef(0.5);
        setMagicDef(0.2);
    }

    @Override
    public String toString() {
        return "Paladin{" +
                "health=" + getHealth() +
                '}';
    }

    @Override
    public void healHimself() {
        if ((getHealth() + 25) >= 100) {
            setHealth(100);
        } else {
            setHealth(getHealth() + 25);
        }
    }

    @Override
    public void healTeammate(Hero hero) {
        if ((hero.getHealth() + 10) >= 100) {
            hero.setHealth(100);
        } else {
            hero.setHealth(hero.getHealth() + 10);
        }
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
