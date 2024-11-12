package net.evgenru22.MushroomFight.projectile;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Projectile {
    private Vector2 position;
    private Vector2 velocity;
    private ProjectileTypes type;

    public Projectile(Vector2 position, Vector2 velocity, ProjectileTypes type) {
        this.position = position;
        this.velocity = velocity;
        this.type = type;
    }

    public void update(float deltaTime) {
        position.x += velocity.x * deltaTime;
    }

    public void render(SpriteBatch batch) {
        batch.draw(type.getTexture(), position.x, position.y, 32, 32);
    }

    public Vector2 getPos() {
        return position;
    }
}
