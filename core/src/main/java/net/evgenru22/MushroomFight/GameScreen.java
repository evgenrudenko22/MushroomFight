package net.evgenru22.MushroomFight;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import net.evgenru22.MushroomFight.map.Map;
import net.evgenru22.MushroomFight.map.build.BuildListener;
import net.evgenru22.MushroomFight.projectile.ProjectileSystem;
import net.evgenru22.MushroomFight.ui.builder.EnergyLabel;

public class GameScreen implements Screen {
    private SpriteBatch batch;
    private Map map;
    private BuildListener listener;

    @Override
    public void show() {
        batch = new SpriteBatch();
        map = new Map();

        listener = new BuildListener(map.getBuilder());
        Gdx.input.setInputProcessor(listener);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
        map.render(batch);
        ProjectileSystem.update(delta);
        ProjectileSystem.render(batch);
        EnergyLabel.render(batch);
        batch.end();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        batch.dispose();
        map.dispose();
    }
}
