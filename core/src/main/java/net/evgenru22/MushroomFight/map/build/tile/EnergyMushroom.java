package net.evgenru22.MushroomFight.map.build.tile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import net.evgenru22.MushroomFight.map.build.Builder;
import net.evgenru22.MushroomFight.uttil.Cloneable;

import java.sql.Time;

public class EnergyMushroom extends Cloneable implements IMushroom{
    private boolean isTimerRunning;
    private float delay;
    private float time;
    public Texture t;

    public EnergyMushroom() {
        super();
        t = new Texture("energy_mushroom.png");
        isTimerRunning = false;
        delay = 0;
        time = 0;
    }

    public EnergyMushroom(Cloneable other) {
        super(other);
        isTimerRunning = false;
        t = ((EnergyMushroom)other).t;
    }

    @Override
    public Texture getTexture() {
        return t;
    }

    @Override
    public int getCost() {
        return 50;
    }

    @Override
    public void update(Vector2 position) {
        delay = Gdx.graphics.getDeltaTime();
        time += delay;
        if (time >= 13) {
            t = new Texture("energy_mushroom_activate.png");
            Builder.energy += 25;
            time = 0;
        }
        if (time >= 0.6) {
            t = new Texture("energy_mushroom.png");
        }
    }
}
