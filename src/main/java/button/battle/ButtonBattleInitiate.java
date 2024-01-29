package button.battle;

import main.battle.Battle;
import main.battle.entities.allies.Ally;
import main.battle.entities.enemies.Enemy;
import main.player.Player;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.interactions.components.ActionRow;
import net.dv8tion.jda.api.interactions.components.buttons.Button;
import net.dv8tion.jda.api.utils.FileUpload;

import javax.imageio.ImageIO;
import javax.print.event.PrintJobAttributeListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ButtonBattleInitiate {
    private Battle battle;
    private Player player;
    private Ally[] allies;
    private Enemy[] enemies;
    public ButtonBattleInitiate(ButtonInteractionEvent event, Player player, Ally[] allies, Enemy[] enemies){
        //temporarily assume only 1 enemy and 1 ally (including player)
        //setup player and battle
        this.player = player;
        this.battle = new Battle(allies[0], enemies[0]);

        //create battle
        this.player.setBattle(this.battle);

        //render battle
        ButtonBattleRender buttonBattleRenderInstance = new ButtonBattleRender(event, allies, enemies, 0, 0);

        //prep embed
        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle(buttonBattleRenderInstance.getTitleString());
        eb.setImage("https://i.ytimg.com/vi/HXh7nYUGcgE/hqdefault.jpg"); //480x360 image size
        //eb.setFooter(String.join(" ", buttonBattleRenderInstance.getAllyHealths()));

        //prep buttons
        Button attackButton = Button.primary(String.format("buttonAttack-%s",event.getMember().getId()), "⚔\uFE0F");
        Button cycleButton = Button.primary(String.format("buttonCycle-%s",event.getMember().getId()), "\uD83D\uDD01");
        Button fleeButton = Button.primary(String.format("buttonFlee-%s",event.getMember().getId()), "\uD83D\uDCA8");
        Button scrollUpButton = Button.primary(String.format("buttonScrollUp-%s",event.getMember().getId()), "⬆\uFE0F");
        Button scrollDownButton = Button.primary(String.format("buttonScrollDown-%s",event.getMember().getId()), "⬇\uFE0F");
        Button defendButton = Button.primary(String.format("buttonDefend-%s",event.getMember().getId()), "\uD83D\uDEE1\uFE0F");
        Button summonButton = Button.primary(String.format("buttonSummon-%s",event.getMember().getId()), "⛧\uFE0F");
        Button magicOneButton = Button.primary(String.format("buttonMagicOne-%s",event.getMember().getId()), "1\uFE0F");
        Button magicTwoButton = Button.primary(String.format("buttonMagicTwo-%s",event.getMember().getId()), "2\uFE0F");
        Button magicThreeButton = Button.primary(String.format("buttonMagicThree-%s",event.getMember().getId()), "3\uFE0F");

        //display render, attach buttons, and send
        if (buttonBattleRenderInstance.isImageSuccess()){
            String filePath = String.format("outputs/%s-battle.png", event.getMember().getId());
            eb.setImage("attachment://battle.png"); //480x360 image size
            event.getChannel()
                    .sendMessageEmbeds(eb.build())
                    .addFiles(FileUpload.fromData(new File(filePath), "battle.png"))
                    .addActionRow(attackButton, cycleButton, fleeButton, scrollUpButton, scrollDownButton)
                    .addActionRow(defendButton, summonButton, magicOneButton, magicTwoButton, magicThreeButton)
                    .queue();
        }else{
            eb.setImage("https://cdn.discordapp.com/avatars/409206596208689162/0ad380ea2de23edbdf490fa593659bbe.png?size=256");
            event.getChannel()
                    .sendMessageEmbeds(eb.build())
                    .queue();
        }
    }
}
