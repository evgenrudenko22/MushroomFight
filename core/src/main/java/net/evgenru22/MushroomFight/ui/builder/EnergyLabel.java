package net.evgenru22.MushroomFight.ui.builder;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import net.evgenru22.MushroomFight.map.build.Builder;
import net.evgenru22.MushroomFight.ui.Fonts;

public class EnergyLabel {

    private static CharSequence str;

    public static void render(SpriteBatch batch) {
        str = String.valueOf(Builder.energy);
        Fonts.ITIM.draw(batch, str, 40, Gdx.graphics.getHeight() - 20);
    }
}
