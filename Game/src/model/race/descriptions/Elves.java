package model.race.descriptions;


import model.action.actions.Attack;
import model.action.actions.Improvement;
import model.race.Race;

//раса эльфов
public class Elves extends Race {
    public Elves() {
        this.setName("Эльфы");
        this.setNameGenitive("Эльфов");

        mage.setName("Маг");
        mage.setNameGenitive("Мага");
        mage.setActions(new Attack("нанес урон магией ", 10), new Improvement("улучшение"));

        shooter.setName("Лучник");
        shooter.setNameGenitive("лучника");
        shooter.setActions(new Attack("выстрелил из лука в", 8), new Attack("атаковал", 4));

        warrior.setName("Воин");
        warrior.setNameGenitive("Воина");
        warrior.setActions(new Attack("ударил мечом", 14));
    }
}