import org.junit.Test;

public class BattleTest {

    private class SingleSoldier implements Team{
        private Hero hero;
        private SingleSoldier(Hero hero){
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

    private ElvesFactory elvesFactory;
    private HumansFactory humansFactory;
    public BattleTest(ElvesFactory elvesFactory, HumansFactory humansFactory){
        this.elvesFactory = elvesFactory;
        this.humansFactory = humansFactory;
    }

    public HeroBehavior makeHero(ElvesType type){
        Team elf = new SingleSoldier(elvesFactory.createElves(type));
        return (HeroBehavior) elf;
    }

}