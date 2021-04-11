package model.action.actions;

import model.action.Action;
import model.hero.Hero;

//Проклятие - снимает улучшение с персонажа.
public class Damnation implements Action {

    //Величина коэффициента (сбрасывается до 1)
    private final float IMPROVEMENT_RATE = 1f;

    private String name;

    public Damnation(String name) {
        this.name = name;
    }

    @Override
    public float getImprovementRate() {
        return IMPROVEMENT_RATE;
    }

    //Признак, является ли действие изменением характеристик персонажа
    @Override
    public boolean isActionChangesState() {
        return true;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void execute(Hero hero) {
        hero.setImprovement(this);
    }

}