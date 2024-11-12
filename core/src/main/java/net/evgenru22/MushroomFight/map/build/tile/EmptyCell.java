package net.evgenru22.MushroomFight.map.build.tile;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import net.evgenru22.MushroomFight.uttil.Cloneable;

public class EmptyCell extends Cloneable implements IMushroom {

    public EmptyCell() {
        super();
    }

    public EmptyCell(Cloneable other) {
        super(other);
    }

    @Override
    public Texture getTexture() {
        return new Texture(new Pixmap(64, 64, Pixmap.Format.Alpha));
    }

    @Override
    public int getCost() {
        return 0;
    }

    @Override
    public void update(Vector2 position) {

    }
}
