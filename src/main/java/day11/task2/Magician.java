package day11.task2;

public class Magician extends Hero implements PhysAttack, MagicAttack {
    private int physAtt;
    private int magicAtt;

    public Magician() {
        physAtt = 5;
        magicAtt = 20;
        setHealth(100);
        setPhysDef(0.0);
        setMagicDef(0.8);
    }

    @Override
    public String toString() {
        return "Magician{" +
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
