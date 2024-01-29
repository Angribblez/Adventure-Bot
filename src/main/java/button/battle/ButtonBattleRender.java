package button.battle;

import main.battle.Abilities.magic.Magic;
import main.battle.entities.allies.Ally;
import main.battle.entities.enemies.Enemy;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.utils.FileUpload;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ButtonBattleRender {
    private boolean imageSuccess;
    private String titleString;
    private String[] allyHealths;
    public ButtonBattleRender(ButtonInteractionEvent event, Ally[] allies, Enemy[] enemies, int activeAlly, int cycle){
        //battle display setup
        //title setup
        this.titleString = "Title error";
        this.titleString = enemies.length == 1 ? String.format("%s's battle with %s", allies[0].getName(), enemies[0].getName()) : this.titleString;
        this.titleString = enemies.length == 2 ? String.format("%s's battle with %s, and %s", allies[0].getName(), enemies[0].getName(), enemies[1].getName()) : this.titleString;
        this.titleString = enemies.length == 3 ? String.format("%s's battle with %s, %s, and %s", allies[0].getName(), enemies[0].getName(), enemies[1].getName(), enemies[2].getName()) : this.titleString;

        //ally health side setup
        this.allyHealths = new String[3];
        this.allyHealths[0] = allies.length >= 1 ? String.format("%s HP: %s", allies[0].getName(), allies[0].getHp()) : "Player Error";
        this.allyHealths[1] = allies.length >= 2 ? String.format("%s HP: %s", allies[1].getName(), allies[1].getHp()) : "";
        this.allyHealths[2] = allies.length >= 3 ? String.format("%s HP: %s", allies[2].getName(), allies[2].getHp()) : "";

        //battle render setup
        int width = 630;
        int height = 480;
        int cellWidth = 210;
        int cellHeight = 120;
        BufferedImage canvas = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = canvas.createGraphics();

        //render background
        g.setColor(Color.white);
        g.fillRect(0, 0, width, height);

        //render enemy boxes(in place of enemy sprites)
        for (int ally = 0; ally < allies.length; ally++){
            g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
            g.fillRect(0, cellHeight*ally, cellWidth, cellHeight);
        }
        //render enemy boxes(in place of enemy sprites)
        for (int enemy = 0; enemy < enemies.length; enemy++){
            g.setColor(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));
            g.fillRect(width-cellWidth, cellHeight*enemy, cellWidth, cellHeight);
        }

        //render combat box background
        g.setColor(new Color(88, 101, 242));
        g.fillRect(0, 3*cellHeight, width, cellHeight);

        //render combat box content setup
        g.setColor(Color.white);
        g.setFont(new Font("Monospaced", Font.BOLD, 20));

        //render HP text
        for (int i = 0; i < allies.length; i++){
            if (i == activeAlly){
                g.setColor(Color.white);
                g.fillRect(cellWidth/20, (51+5*i)*cellHeight/16-g.getFontMetrics().getAscent(), 19*cellWidth/20, cellHeight/8);
                g.setColor(Color.black);
                g.drawString(allyHealths[i], cellWidth/20, (51+5*i)*cellHeight/16);
                g.setColor(Color.white);
                continue;
            }
            g.drawString(allyHealths[i], cellWidth/20, (51+5*i)*cellHeight/16);
        }

        //HP bar backgrounds
        g.setColor(new Color(0, 0, 0));
        int barWidth = 18*cellWidth/20;
        int barHeight = g.getFontMetrics().getAscent();
        for (int i = 0; i < allies.length; i++){
            g.fillRect(cellWidth/20, (207+20*i)*cellHeight/64, barWidth, cellHeight/8);
        }

        //HP bars
        g.setColor(Color.white);
        for (int i = 0; i < allies.length; i++){
            int healthWidth = barWidth*allies[i].getHp()/allies[i].getMaxHp();
            g.fillRect(cellWidth/20, (207+20*i)*cellHeight/64, healthWidth, cellHeight/8);
        }

        //render command list
        ArrayList<Magic> magics = allies[0].getMagics();
        g.drawString(String.format("Magic: %s-%s\n", 1, magics.get(0).getMagicName()), (51)*cellWidth/20 - g.getFontMetrics().stringWidth("Magic: "), (51)*cellHeight/16);
        g.drawString(String.format("%s-%s\n", 2, magics.get(1).getMagicName()), (51)*cellWidth/20, (56)*cellHeight/16);
        g.drawString(String.format("%s-%s\n", 3, magics.get(2).getMagicName()), (51)*cellWidth/20, (61)*cellHeight/16);

        //render output
        String filePath = String.format("outputs/%s-battle.png", event.getMember().getId());
        try {
            ImageIO.write(canvas, "png", new File(filePath));
            this.imageSuccess = true;
        }catch(IOException e) {
            this.imageSuccess = false;
        }
    }

    public boolean isImageSuccess() {
        return this.imageSuccess;
    }

    public String getTitleString() {
        return this.titleString;
    }
}
