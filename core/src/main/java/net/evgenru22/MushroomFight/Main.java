package net.evgenru22.MushroomFight;

import com.badlogic.gdx.Game;
import net.evgenru22.MushroomFight.ui.Fonts;
import net.evgenru22.MushroomFight.ui.menu.MenuScreen;
import net.evgenru22.MushroomFight.ui.menu.MenuSkin;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends Game {
    @Override
    public void create() {
        setScreen(new MenuScreen(this));
    }

    @Override
    public void dispose() {
        Fonts.dispose();
        MenuSkin.dispose();
    }
}
