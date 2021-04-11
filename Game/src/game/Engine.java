package game;

import model.Squad;
import model.race.Race;
import model.race.RaceType;
import model.hero.Hero;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;
import java.util.stream.Collectors;

//Игровой движок.
public class Engine {
    //private static final Logger LOG = LoggerFactory.getLogger(Engine.class);
    private final Random random = new Random();

    //Количество отрядов
    public static final int SQUADS_NUMBER = 2;


    //Порядок ходов в игре
    private final Deque<Squad> stack = new ArrayDeque<>();

    //Выбранные атакующие отряды
    private final Squad[] activeSquads = new Squad[2];


    public Engine() {
        defineSquads();
    }

    public boolean isAllHeroesDead() {
        return stack.isEmpty();
    }

    //Создаёт отряды участники и инициализирует стек
    private void defineSquads() {
        RaceType raceType;
        for (int i = 0; i < SQUADS_NUMBER; i++) {
            raceType = random.nextBoolean() ? RaceType.ALL : RaceType.ALL;

            Squad squad = new Squad(getRandomRace(raceType));
            stack.push(squad);
        }
    }

    //Получает атакующий и атакуемый отряды
    private void prepareSquads() {
        activeSquads[0] = stack.pop();
        activeSquads[1] = stack.pop();
        System.out.println("Играют " + activeSquads[0].getRaceName() + " против " + activeSquads[1].getRaceNameGenitive());
    }

    //Выводит отряды играющих рас
    public void printSquadsRaces() {
        System.out.println("Играют отряды: " + stack.stream().map(Squad::getRaceName).collect(Collectors.joining(", ")));
    }

    //Возвращает случайно выбранную расу
    private Race getRandomRace(RaceType raceType) {
        Race[] races = raceType.getRaces();
        return races[random.nextInt(3)];
    }


    //Выполняет игровой ход
    int turnNumber = 1;
    public void makeTurn() {
        prepareSquads();
        System.out.println("Ход № " + turnNumber + " -----------------------------------------------------------------");
        turnNumber++;
        doAttack();
        postProcessSquads();

    }

    //Инициализирует атакующего и атакуемого героя, после чего выполняет атаку
    protected void doAttack() {
        Hero comrade, enemy;

        int src = (int) Math.random();
        comrade = activeSquads[src].getActiveHero();

        boolean isImprovement = comrade.getCurrentAction().isActionChangesState();

        //Выбор отряда назначения действия. Своя раса, если выбрано улучшение, иначе - раса противника
        int dst = isImprovement ? src : src ^ 1;
        enemy = activeSquads[dst].getRandomHero();

        if (isImprovement) {
            System.out.println("Раса " + activeSquads[src].getRaceName() + " применила улучшение");
        } else {
            System.out.println(activeSquads[src].getRaceName() + " атакуют" + activeSquads[dst].getRaceNameGenitive());
        }
        comrade.executeAction(enemy);
    }

    //Удаляет мёртвых героев из отряда
    private void postProcessSquads() {
        for (int i = 0; i < activeSquads.length; i++) {
            Squad activeSquad = activeSquads[i];
            activeSquad.removeDeadHeroes();

            if (activeSquad.getHeroes().size() > 0) {
                stack.push(activeSquad);
            }
        }

    }
}