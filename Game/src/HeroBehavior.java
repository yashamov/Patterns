public class HeroBehavior implements Hero{

    private int hp;
    private int hit;
    private boolean privileged = false;

    public HeroBehavior(int hp, int hit){
        this.hp = hp;
        this.hit = hit;
    }

    @Override
    public boolean alive() {
        return this.hp > 0;
    }

    @Override
    public boolean focusOfAction() {
        return false;
    }

    @Override
    public void damage(int value) {
        this.hp -= value;
    }

    @Override
    public void removeHP(Hero enemy) {
        enemy.damage(this.privileged ? (10 + this.hit) : this.hit);
    }

    @Override
    public void upgrade(Hero ally) {
        ally.skills(true);
    }

    @Override
    public void skills(boolean up) {
        this.privileged = up;
    }
}
