package test.testplagin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


import static test.testplagin.gui.guiRendeer.mainshop;


@CommandAlias("shop")
public class shopcom extends BaseCommand {
    @Default
    public void shop(CommandSender sender) {
        if (!(sender instanceof Player player)) {
            return;
        }

        mainshop(player);

    }

}