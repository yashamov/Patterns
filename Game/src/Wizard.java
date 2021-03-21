public class Wizard implements Hero{
    //Маги Эльфы
    private HeroBehavior base;

    public Wizard(HeroBehavior base){
        this.base  = base;

    }


    @Override
    public boolean alive() {
        return this.base.alive();
    }

    @Override
    public boolean focusOfAction() {
        return false;
    }

    @Override
    public void damage(int value) {
        this.base.damage(value);
    }

    @Override
    public void removeHP(Hero enemy) {
        this.base.removeHP(enemy);
    }

    @Override
    public void upgrade(Hero ally) {
        this.base.upgrade(ally);
    }

    @Override
    public void skills(boolean up) {
        this.base.skills(up);
    }

}