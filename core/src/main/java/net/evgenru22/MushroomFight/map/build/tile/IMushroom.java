package net.evgenru22.MushroomFight.map.build.tile;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public interface IMushroom {

    Texture getTexture();
    int getCost();
    void update(Vector2 position);
}
