package net.evgenru22.MushroomFight.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import net.evgenru22.MushroomFight.map.build.Builder;

import java.nio.file.attribute.UserPrincipal;

public class Map {
    private final Texture map_t;
    private final TextureRegion map_r;
    private final Sprite map_s;
    private final Texture grid_t;
    private int width;
    private int height;
    private Builder builder;

    public Map() {
        map_t = new Texture("map.png");
        map_t.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        map_r = new TextureRegion(map_t, 0, 0, 640, 400);
        map_s = new Sprite(map_r);
        map_s.setSize(1f, map_s.getHeight() / map_s.getWidth());
        grid_t = new Texture("grid.png");
        width = 640;
        height = 400;

        builder = new Builder(width, height, width - 7 * 64, height - 5 * 64);
    }

    public void render(SpriteBatch batch) {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        // Grid drawing

        float xOffset = screenWidth * 0.30f;
        float yOffset = screenWidth * 0.20f;

        float gridWidth = screenWidth - xOffset;
        float gridHeight = screenHeight - yOffset;

        batch.draw(map_t, 0, 0, screenWidth, screenHeight);
        batch.draw(grid_t, screenWidth - gridWidth, 0, 448, 320);
        builder.update();
        builder.render(batch);
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
