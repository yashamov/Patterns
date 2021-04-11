package model.action.actions;

import model.action.Action;
import model.hero.Hero;

//Атака
public class Attack implements Action {

    //Кол-во урона
    private int damage;

    //Коэфф урона
    private float improvementRate = 1;

    private final String name;

    public Attack(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setImprovementRate(float improvementRate) {
        this.improvementRate = improvementRate;
    }

    @Override
    public float getImprovementRate() {
        return improvementRate;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public boolean isActionChangesState() {
        return false;
    }

    @Override
    public void execute(Hero hero) {
        hero.setHp(hero.getHp() - (damage * improvementRate));
    }
}