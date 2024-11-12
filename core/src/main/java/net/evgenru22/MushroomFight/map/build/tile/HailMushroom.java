package net.evgenru22.MushroomFight.map.build.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Timer;
import net.evgenru22.MushroomFight.projectile.ProjectileSystem;
import net.evgenru22.MushroomFight.projectile.ProjectileTypes;
import net.evgenru22.MushroomFight.uttil.Cloneable;

public class HailMushroom extends Cloneable implements IMushroom {
    private boolean isTimerRunning;

    public HailMushroom() {
        super();
        isTimerRunning = false;
    }

    public HailMushroom(Cloneable other) {
        super(other);
        isTimerRunning = false;
    }

    @Override
    public Texture getTexture() {
        return new Texture("hail_mushroom.png");
    }

    @Override
    public int getCost() {
        return 75;
    }

    @Override
    public void update(Vector2 position) {
        if (!isTimerRunning) {
            Timer.schedule(new Timer.Task() {
                @Override
                public void run() {
                    ProjectileSystem.spawnProjectile(position.cpy().sub(-20, 65), new Vector2(54.2f, 0), ProjectileTypes.Spore);
                    System.out.println("Shoot!");
                }
            }, 0, 1.6f);
            isTimerRunning = true;
        }
    }
}
