package button.map;

import main.map.Map;
import main.player.Player;
import main.tile.Tile;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.utils.FileUpload;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ButtonDisplayMap {
    public ButtonDisplayMap(ButtonInteractionEvent event, Player player, Map map) {
        int playerX = player.getPlayerX();
        int playerY = player.getPlayerY();
        int tileSizePx = 15;
        int widthPx = 960;
        int heightPx = 540;
        int width = widthPx / tileSizePx;
        int height = heightPx / tileSizePx;
        int horizontalShift = (width - 1) / 2 - playerX;
        int verticalShift = height / 2 - 1 - playerY;
        BufferedImage canvas = new BufferedImage(widthPx, heightPx, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = canvas.createGraphics();
        for (int y = height - 1; y > -1; y--) {
            for (int x = 0; x < width; x++) {
                int tileX = x - horizontalShift, tileY = y - verticalShift;
                Tile currentTile = map.getTileAtLocation(tileX, tileY);
                g.setColor(currentTile.getTileColor());
                if (x - horizontalShift == playerX && y - verticalShift == playerY) {
                    //special case, player is on tile, draw circle instead of square
                    g.fillOval(x * tileSizePx, (height - y - 1) * tileSizePx, tileSizePx, tileSizePx);
                    continue;
                }
                g.fillRect(x * tileSizePx, (height - y - 1) * tileSizePx, tileSizePx, tileSizePx);
            }
        }
        try {
            String filePath = String.format("outputs/%s-map.png", event.getMember().getId());
            ImageIO.write(canvas, "png", new File(filePath));
            event.editMessageAttachments(FileUpload.fromData(new File(filePath))).queue();
        } catch(IOException e){
            event.reply("Error grabbing image").queue();
        }
    }
}
