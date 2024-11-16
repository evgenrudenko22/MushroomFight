package net.evgenru22.MushroomFight.map.build;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import net.evgenru22.MushroomFight.map.build.tile.EmptyCell;
import net.evgenru22.MushroomFight.map.build.tile.EnergyMushroom;
import net.evgenru22.MushroomFight.map.build.tile.HailMushroom;
import net.evgenru22.MushroomFight.map.build.tile.IMushroom;
import net.evgenru22.MushroomFight.uttil.Cloneable;

public class Builder {
    public IMushroom[][] map;
    private final int width;
    private final int height;
    private final int cellCountX;
    private final int cellCountY;

    private final int xOffset;
    private final int yOffset;

    public static int energy = 1000;
    public static IMushroom selectedCard;

    public final static EnergyMushroom ENERGY_MUSHROOM = new EnergyMushroom();
    public final static HailMushroom HAIL_MUSHROOM = new HailMushroom();
    public final static EmptyCell EMPTY_CELL = new EmptyCell();

    public Builder(int width, int height, int xOffset, int yOffset) {
        this.width = width - xOffset;
        this.height = height - yOffset;
        this.xOffset = xOffset;
        this.yOffset = yOffset;

        cellCountX = width / 64;
        cellCountY = height / 64;
        map = new IMushroom[cellCountX][cellCountY];

        for (int x = 0; x < cellCountX; x++) {
            for (int y = 0; y < cellCountY; y++) {
                map[x][y] = new EmptyCell(EMPTY_CELL);
            }
        }

        selectedCard = ENERGY_MUSHROOM;
    }

    public void changeCard(IMushroom newSelectedCard) {
        selectedCard = newSelectedCard;
    }

    public void onClick(int x, int y) {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        float gridWidth = screenWidth - xOffset;
        float gridHeight = screenHeight - yOffset;

        float cellWidth = gridWidth / 7;
        float cellHeight = gridHeight / 5;

        float tableX = x - xOffset;
        float tableY = y - yOffset;
        System.out.println(tableX + ", " + tableY);

        if (tableX >= 0 && tableX <= gridWidth &&
            tableY >= 0 && tableY <= gridHeight) {
            int cellIndexX = (int)(tableX / cellWidth);
            int cellIndexY = (int)(tableY / cellHeight);
            System.out.println(cellIndexX + ", " + cellIndexY);

            if (map[cellIndexX][cellIndexY] instanceof EmptyCell) {
                if (energy >= selectedCard.getCost()) {
                    if (selectedCard instanceof EnergyMushroom) {
                        map[cellIndexX][cellIndexY] = new EnergyMushroom(ENERGY_MUSHROOM);
                    } else if (selectedCard instanceof HailMushroom) {
                        map[cellIndexX][cellIndexY] = new HailMushroom(HAIL_MUSHROOM);
                    }
                    energy -= selectedCard.getCost();
                    System.out.println("Placed!!!");
                }
                System.out.println("This cell is empty");
            }
        }
    }

    public void update() {
        for (int x = 0; x < cellCountX; x++) {
            for (int y = 0; y < cellCountY; y++) {
                if (map[x][y] instanceof EmptyCell) continue;
                map[x][y].update(new Vector2(x * 64 + xOffset, y * 64 + yOffset));
            }
        }
    }

    public void render(SpriteBatch batch) {
        for (int x = 0; x < cellCountX; x++) {
            for (int y = 0; y < cellCountY; y++) {
                if (map[x][y] instanceof EmptyCell) continue;
                IMushroom tile = map[x][y];
                batch.draw(tile.getTexture(), xOffset + x * 64, height - (y * 64) - 64 /* + yOffset */, 64, 64);
            }
        }
    }

    public void dispose() {
        for (int x = 0; x < cellCountX; x++) {
            for (int y = 0; y < cellCountY; y++) {
                if (map[x][y] instanceof EmptyCell) continue;
                IMushroom tile = map[x][y];
                tile.getTexture().dispose();
            }
        }
    }
}
