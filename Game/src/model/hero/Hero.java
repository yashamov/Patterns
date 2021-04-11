package model.hero;

import model.action.Action;
import model.action.ActionProxy;
import model.action.actions.Improvement;

import java.util.*;


public class Hero{
    //Тип персонажа (маг, лучник, воин)
    private HeroType heroType;

    //имя
    private String name;

    //имя в родительном падеже
    private String nameGenitive;

    //здоровье
    private float hp = 100;

    //список действий
    private List<Action> actions = new ArrayList<>();

    //Текущее действие
    private Action currentAction;

    //Улучшение персонажа
    private Action skills;

    //Прошлое улучшение
    private Action prevImprovement;

    //Устанавливает улучшение, запоминая старое
    public void setImprovement(Action action) {
        if (this.getSkills() != null) {
            prevImprovement = this.getSkills();
        }
        this.setSkills(action);
    }

    /**
     * Восстанавливает ранее снятое улучшение.
     */
    public void restoreSkills() {
        this.setSkills(prevImprovement);
    }

    public HeroType getHeroType() {
        return heroType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getNameGenitive() {
        return nameGenitive;
    }

    public void setNameGenitive(String nameGenitive) {
        this.nameGenitive = nameGenitive;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public Action getSkills() {
        return skills;
    }

    public void setSkills(Action skills) {
        this.skills = skills;
    }

    public List<Action> getActions() {
        return actions;
    }

    public Hero(HeroType heroType) {
        this.heroType = heroType;
    }

    //Конструктор персонажа
    public Hero(Hero hero) {
        this.heroType = hero.heroType;
        this.name = hero.name;
        this.nameGenitive = hero.nameGenitive;
        this.actions = hero.getActions();
    }

    //Заполнение списка действий персонажа
    public void setActions(Action... actions) {
        Collections.addAll(this.actions, actions);
    }

    public void setCurrentAction(Action currentAction) {
        this.currentAction = currentAction;
    }

    public Action getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction() {
        this.currentAction = actions.get(new Random().nextInt(actions.size()));
    }

    //Запуск действия по отношению к заданному персонажу
    public void executeAction(Hero hero) {
        if (currentAction == null) {
            setCurrentAction();
        }
        new ActionProxy(currentAction, this, hero).execute();
    }

    //Прооверяет, находится ли юнит в привелегированной группе
    public boolean isPrivileged() {
        return skills != null && skills.getClass() == Improvement.class;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Hero hero = (Hero) o;
        return heroType == hero.heroType && name.equals(hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroType, name);
    }
}