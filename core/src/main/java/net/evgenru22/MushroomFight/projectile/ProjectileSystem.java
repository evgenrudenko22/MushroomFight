package net.evgenru22.MushroomFight.projectile;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.Iterator;

public class ProjectileSystem {
    private static Array<Projectile> projectiles = new Array<>();

    public static void spawnProjectile(Vector2 position, Vector2 velocity, ProjectileTypes type) {
        projectiles.add(new Projectile(position, velocity, type));
    }

    public static void update(float deltaTime) {
        for (Iterator<Projectile> iterator = projectiles.iterator(); iterator.hasNext();) {
            Projectile projectile = iterator.next();
            projectile.update(deltaTime);
            if (projectile.getPos().x > Gdx.graphics.getWidth() + 20 || projectile.getPos().x < -20 ||
                projectile.getPos().y > Gdx.graphics.getHeight() + 20 || projectile.getPos().y < -20) {
                    iterator.remove();
            }
        }
    }

    public static void render(SpriteBatch batch) {
        for (Projectile projectile : projectiles) {
            projectile.render(batch);
        }
    }
}
