package net.evgenru22.MushroomFight.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.evgenru22.MushroomFight.map.build.Builder;

public class Map {
    private final Texture map_t;
    private final Texture grid_t;
    private int width;
    private int height;
    private Builder builder;

    public Map() {
        map_t = new Texture("map.png");
        grid_t = new Texture("grid.png");
        width = 640;
        height = 400;

        builder = new Builder(width, height, width - 7 * 64, height - 5 * 64);
    }

    public void render(SpriteBatch batch) {
        batch.draw(map_t, 0, 0, width, height);
        batch.draw(grid_t, width - 7 * 64, 0);
        builder.update();
        builder.render(batch);
    }

    public void resize(int w, int h) {
        width = w;
        height = h;
    }

    public void dispose() {
        map_t.dispose();
        grid_t.dispose();
        builder.dispose();
    }

    public Builder getBuilder() {
        return builder;
    }
}
