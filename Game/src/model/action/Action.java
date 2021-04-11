package model.action;

import model.hero.Hero;

//общий шаблон всех действий
public interface Action {

    //запуск действий
    void execute(Hero hero);

    String getName();

    //Возвращает коэффициент для изменения величины урона при наложении улучшения
    float getImprovementRate();

    //Возвращает признак, является ли действие изменением характеристик персонажа
    boolean isActionChangesState();
}