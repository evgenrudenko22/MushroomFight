package net.evgenru22.MushroomFight.ui.menu;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import net.evgenru22.MushroomFight.ui.Fonts;

public class MenuSkin {
    public final static Skin menuSkin;

    static {
        menuSkin = new Skin();
        menuSkin.add("default", Fonts.ITIM);

        TextButton.TextButtonStyle style = new TextButton.TextButtonStyle();
        style.font = menuSkin.getFont("default");
        style.fontColor = Color.WHITE;
        style.overFontColor = Color.GREEN;
        menuSkin.add("default", style);
    }


    public static void dispose() {
        menuSkin.dispose();
    }
}
