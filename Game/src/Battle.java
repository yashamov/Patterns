public class Battle {

    private Team one;
    private Team two;

    public Battle(Team one, Team two){
        this.one = one;
        this.two = two;
    }

    public void fight(){
        boolean turn = true;

        do{
            Hero master = turn ? one.turn() : two.turn();
            if (master.focusOfAction()){
                Hero ally = turn ? one.turn() : two.turn();
                master.upgrade(ally);
            }else{
                Hero victim = !turn ? one.turn() : two.turn();
                master.removeHP(victim);
            }
            turn = !turn;
        }
        while(this.one.alive() && this.two.alive());
    }

}
