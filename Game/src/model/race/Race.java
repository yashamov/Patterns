package model.race;

import model.hero.Hero;
import model.hero.HeroType;

//Описывает расу
//Раса включает в себя лучника, мага и воина

public class Race {

    //имя расы
    private String name;

    //имя расы в родительном падеже
    private String nameGenitive;

    //раса
    protected final Hero mage = new Hero(HeroType.MAGE);
    //лучник
    protected final Hero shooter = new Hero(HeroType.SHOOTER);
    //воин
    protected final Hero warrior = new Hero(HeroType.WARRIOR);

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setNameGenitive(String nameGenitive) {
        this.nameGenitive = nameGenitive;
    }

    public String getNameGenitive() {
        return nameGenitive;
    }

    public Hero getMage() {
        return mage;
    }

    public Hero getShooter() {
        return shooter;
    }

    public Hero getWarrior() {
        return warrior;
    }

    @Override
    public String toString() {
        return "Race{" + "name='" + name + '\'' + '}';
    }
}