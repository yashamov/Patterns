package model.action.actions;

import model.action.Action;
import model.hero.Hero;

//Делает персонаж привилегированным
public class Improvement implements Action {

    //Урон увеличивается в 1.5 раза
    private final float IMPROVEMENT_RATE = 1.5f;

    private String name;

    public Improvement(String name) {
        this.name = name;
    }

    @Override
    public float getImprovementRate() {
        return IMPROVEMENT_RATE;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean isActionChangesState() {
        return true;
    }

    @Override
    public void execute(Hero hero) {
        hero.setImprovement(this);
    }

}