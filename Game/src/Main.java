import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    }


    private class MyTeam implements Team{

        @Override
        public boolean alive() {
            return false;
        }

        @Override
        public Hero turn() {
            return null;
        }
    }

}
