package model.race;

import model.race.descriptions.Elves;
import model.race.descriptions.Humans;
import model.race.descriptions.Orcs;


public enum RaceType {
    ALL(new Race[]{new Elves(), new Humans(), new Orcs()});

    Race[] races;

    RaceType(Race[] races) {
        this.races = races;
    }

    public Race[] getRaces() {
        return races;
    }
}