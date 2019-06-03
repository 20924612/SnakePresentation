
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author alu20924612v
 */
public class Config implements Serializable {

    public static final int NUM_ROWS = 30;
    public static final int NUM_COLS = 40;
    private int level;

    private static Config instance = null;

    private Config() {
        level = 0;
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getDeltaTime() {
        switch (level) {
            case 0:
                return 500;
            case 1:
                return 200;
            case 2:
                return 100;
            case 3:
                return 50;
        }
        return 500;
    }

}
