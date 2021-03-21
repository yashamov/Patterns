public class ElvesFactory {

    public Hero createElves(ElvesType type){
        Hero elf = null;

        switch (type){
            case WIZARD:
                elf = new Wizard(new HeroBehavior(100,10));
                break;
            case ARCHER:
                elf = new Archer(new HeroBehavior(100,7));
                break;
            case HOBBIT:
                elf = new Hobbit(new HeroBehavior(100,15));
                break;
        }
        return elf;
    }

}