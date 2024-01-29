package button.battle.action;

import button.battle.ButtonBattleRender;
import main.battle.Abilities.Attack;
import main.battle.entities.allies.Ally;
import main.battle.entities.enemies.Enemy;
import main.player.Player;
import net.dv8tion.jda.api.events.interaction.component.ButtonInteractionEvent;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.File;

public class ButtonAttack {
    public ButtonAttack(ButtonInteractionEvent event, Player player){
        //player attack
        player.getBattle().AllyAttack();

        //enemy attack
        player.getBattle().EnemyAttack();

        //create arrays
        Ally[] allies = new Ally[1];
        allies[0] = player.getBattlePlayer();
        Enemy[] enemies = new Enemy[1];
        enemies[0] = player.getBattle().getEnemy();

        //refresh battle
        ButtonBattleRender buttonBattleRenderInstance = new ButtonBattleRender(event, allies, enemies, 0, 0);
        if (buttonBattleRenderInstance.isImageSuccess()){
            String filePath = String.format("outputs/%s-battle.png", event.getMember().getId());
            event.editMessageAttachments(FileUpload.fromData(new File(filePath))).queue();
        } else{
            event.reply("Error image refresh").setEphemeral(true).queue();
        }
    }
}
