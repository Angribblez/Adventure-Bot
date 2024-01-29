package main.housing;

import main.player.Player;
import main.map.Map;
import main.tile.HouseTile;
import main.tile.Ocean;

public class ClaimHouse {
    private final boolean success;
    public ClaimHouse(Player player, Map map){
        int x = player.getPlayerX(), y = player.getPlayerY();
        int width = 5, height = 3;
        House house = new House(player, x, y, width, height);
        //check claim area for invalid tiles(example: water)
        for (int tileY = 0; tileY < height; tileY++){
            for (int tileX = 0; tileX < width; tileX++){
                int shiftedX = tileX + x, shiftedY = tileY + y;
                if (map.getTileAtLocation(shiftedX, shiftedY) instanceof Ocean){
                    this.success = false;
                    return;
                }
            }
        }

        //claim
        for (int tileY = 0; tileY < height; tileY++){
            for (int tileX = 0; tileX < width; tileX++){
                int shiftedX = tileX + x, shiftedY = tileY + y;
                map.setTileAtLocation(shiftedX, shiftedY, new HouseTile(shiftedX, shiftedY, house));
            }
        }
        this.success = true;
    }

    public boolean isSuccess() {
        return success;
    }
}
