package net.evgenru22.MushroomFight.ui;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

public class Fonts {
    public final static BitmapFont ITIM;

    static {
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("itim.ttf"));

        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.size = 48;
        parameter.characters = FreeTypeFontGenerator.DEFAULT_CHARS;

        ITIM = generator.generateFont(parameter);
        generator.dispose();
    }

    public static void dispose() {
        ITIM.dispose();
    }
}
