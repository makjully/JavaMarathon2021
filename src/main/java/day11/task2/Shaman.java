package day11.task2;

public class Shaman extends Hero implements Healer, PhysAttack, MagicAttack {
    private int physAtt;
    private int magicAtt;

    public Shaman() {
        physAtt = 10;
        magicAtt = 15;
        setHealth(100);
        setPhysDef(0.2);
        setMagicDef(0.2);
    }

    @Override
    public String toString() {
        return "Shaman{" +
                "health=" + getHealth() +
                '}';
    }

    @Override
    public void healHimself() {
        if ((getHealth() + 50) >= 100) {
            setHealth(100);
        } else {
            setHealth(getHealth() + 50);
        }
    }

    @Override
    public void healTeammate(Hero hero) {
        if ((hero.getHealth() + 30) >= 100) {
            hero.setHealth(100);
        } else {
            hero.setHealth(hero.getHealth() + 30);
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

    @Override
    public void magicalAttack(Hero hero) {
        int damage = (int) (magicAtt - magicAtt * hero.getMagicDef());
        int enemyHealth = hero.getHealth();

        if (enemyHealth - damage > 0) {
            hero.setHealth(enemyHealth - damage);
        } else
            hero.setHealth(0);
    }
}
