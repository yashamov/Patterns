public interface Hero {

    boolean alive();
    boolean focusOfAction();

    void damage(int value);
    void removeHP(Hero enemy);
    void upgrade(Hero ally);
    void skills(boolean up);

}