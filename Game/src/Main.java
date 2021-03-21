import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Да начнётся игра!");
        System.out.println("Выберите фракцию: \n Люди  - напишите 1 \n Эльфы - напишите 2");

        String fraction = "";
        String unit = "";
        while (!fraction.equals("1") || !fraction.equals("2")) {
            fraction = scanner.nextLine();
            if (fraction.equals("1") || fraction.equals("2")) {
                break;
            } else System.out.println("Введите число, не нужно пытаться сломать программу");
        }


        if (fraction.equals("1")) {
            System.out.println("Выберите тип воина: \n Воин (с мечом)  - напишите 1 \n Арбалетчик - напишите 2 \n Волшебник - напишите 3");
            while (!unit.equals("1") || !unit.equals("2") || !unit.equals("3")) {
                unit = scanner.nextLine();
                if (unit.equals("1")) {
                    Hero hero = new HumansFactory().createHumans(HumanType.WARRIOR);
                    ArrayList<Hero> humans = new ArrayList<Hero>();
                    humans.add(hero);
                    break;
                } else if (unit.equals("2")) {
                    Hero hero = new HumansFactory().createHumans(HumanType.ARBALESTER);
                    ArrayList<Hero> humans = new ArrayList<Hero>();
                    humans.add(hero);
                    break;
                } else if (unit.equals("3")) {
                    Hero hero = new HumansFactory().createHumans(HumanType.MAGICIAN);
                    ArrayList<Hero> humans = new ArrayList<Hero>();
                    humans.add(hero);
                    break;
                } else System.out.println("Введите число, не нужно пытаться сломать программу");
            }

        } else if (fraction.equals("2")) {
            System.out.println("Выберите тип воина: \n Хоббит (с мечом)  - напишите 1 \n Лучник - напишите 2 \n Маг - напишите 3");
            while (!unit.equals("1") || !unit.equals("2") || !unit.equals("3")) {
                unit = scanner.nextLine();
                if (unit.equals("1")) {
                    Hero hero = new ElvesFactory().createElves(ElvesType.HOBBIT);
                    ArrayList<Hero> elves = new ArrayList<Hero>();
                    elves.add(hero);
                    break;
                } else if (unit.equals("2")) {
                    Hero hero = new ElvesFactory().createElves(ElvesType.ARCHER);
                    ArrayList<Hero> elves = new ArrayList<Hero>();
                    elves.add(hero);
                    break;
                } else if (unit.equals("3")) {
                    Hero hero = new ElvesFactory().createElves(ElvesType.WIZARD);
                    ArrayList<Hero> elves = new ArrayList<Hero>();
                    elves.add(hero);
                    break;

                } else System.out.println("Введите число, не нужно пытаться сломать программу");
                //потом для этого следует реализовать отдельный класс, но пока что так
            }
        }

        System.out.println();
        System.out.println("Поздравляем с выбором бойца, уже в следущей версии игры вы сможете драться (возможно)");


    }

}

    /*private class MyTeam implements Team{
        private Hero hero;
        private MyTeam(Hero hero){
            this.hero = hero;
        }

        @Override
        public boolean alive() {
            return this.hero.alive();
        }

        @Override
        public Hero turn() {
            return this.hero;
        }
    }
    задел на будущее
     */
