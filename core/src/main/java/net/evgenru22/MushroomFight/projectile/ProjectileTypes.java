package net.evgenru22.MushroomFight.projectile;

import com.badlogic.gdx.graphics.Texture;

public enum ProjectileTypes {
    Spore(new Texture("spore.png")),
    ;

    ProjectileTypes(Texture t) {
        this.t = t;
    }

    public Texture getTexture() {
        return t;
    }

    private final Texture t;
}
