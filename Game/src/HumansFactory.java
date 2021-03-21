public class HumansFactory {

    public Hero createHumans(HumanType type){
        Hero human = null;

        switch (type){
            case WARRIOR:
                human = new Arbalester(new HeroBehavior(100,5));
                break;
            case ARBALESTER:
                human = new Warrior(new HeroBehavior(100,18));
                break;
            case MAGICIAN:
                human = new Magician(new HeroBehavior(100,4));
                break;
        }
        return human;
    }

}