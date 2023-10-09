package test.testplagin.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

@CommandAlias("food")
public class Commands extends BaseCommand {
    private final JavaPlugin plugin;

    public Commands(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @Default
    public void FoodCom(CommandSender sender, String[] arg) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Ты человек?");
        } else {
            if (arg.length > 0){
                plugin.getConfig().set("food", String.join(" ", arg));
                player.sendMessage("Eда изменина на " + plugin.getConfig().get("food"));
            } else {
                player.sendMessage("Еда: " + plugin.getConfig().get("food"));
            }
        }
    }

}
