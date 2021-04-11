package model;

import model.race.Race;
import model.hero.Hero;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Описываем отряд
public class Squad {

    //Список героев в отряде
    private final List<Hero> heroes = new ArrayList<>();

    //количество магов
    public final int MAGE_COUNT = 1;

    //Количество лучников
    public final int SHOOTER_COUNT = 3;

    //Количество воинов
    public final int WARRIOR_COUNT = 4;

    //Раса отряда
    private final Race race;

    public List<Hero> getHeroes() {
        return heroes;
    }

    public Race getRace() {
        return race;
    }

    public Squad(Race race) {
        this.race = race;

        IntStream.rangeClosed(1, MAGE_COUNT).forEach(i -> heroes.add(new Hero(race.getMage())));
        IntStream.rangeClosed(1, SHOOTER_COUNT).forEach(i -> heroes.add(new Hero(race.getShooter())));
        IntStream.rangeClosed(1, WARRIOR_COUNT).forEach(i -> heroes.add(new Hero(race.getWarrior())));
    }

    //Случайным образом выбирает атакующего героя
    public Hero getActiveHero() {
        Hero hero = getRandomHero();
        hero.setCurrentAction();
        return hero;
    }

    //Удаляет мертвых героев
    public void removeDeadHeroes() {
        heroes.removeIf(hero -> hero.getHp() <= 0);
    }

    //Случайно выбирается герой в отряде
    //У превилегированных героев приоритет выбора
    public Hero getRandomHero() {
        List<Hero> privileged = heroes.stream().filter(Hero::isPrivileged).collect(Collectors.toList());
        boolean isPrivilegedEmpty = privileged.isEmpty();

        Random random = new Random();
        int i = isPrivilegedEmpty ? random.nextInt(heroes.size()) : random.nextInt(privileged.size());
        return isPrivilegedEmpty ? heroes.get(i) : privileged.get(i);
    }

    //Возвращает расу отряда
    public String getRaceName() {
        return this.race.getName();
    }

    //Геттер имени расы в родительном падеже
    public String getRaceNameGenitive() {
        return this.getRace().getNameGenitive();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Squad squad = (Squad) o;
        return heroes.equals(squad.heroes)
                && race.equals(squad.race);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroes, race);
    }

    @Override
    public String toString() {
        return "Squad{"
                + ", MAGE_COUNT=" + MAGE_COUNT
                + ", SHOOTER_COUNT=" + SHOOTER_COUNT
                + ", WARRIOR_COUNT=" + WARRIOR_COUNT
                + ", race=" + race
                + '}';
    }
}