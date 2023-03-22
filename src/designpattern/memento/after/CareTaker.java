package designpattern.memento.after;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    private List<GameSave> gameSaves = new ArrayList<>();

    public void add(GameSave gameSave) {
        gameSaves.add(gameSave);
    }

    public GameSave get(int index) {
        return gameSaves.get(index);
    }
}
