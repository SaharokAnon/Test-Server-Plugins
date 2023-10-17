package test.testplagin.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.ArrayList;

@CommandAlias("bow")
@CommandPermission("TPBow.command")
public class Commands extends BaseCommand {
    @Default
    public void BowCom(CommandSender sender) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Ты человек?");
        } else {
            ItemStack bow =new ItemStack(Material.BOW,1);
            ItemMeta meta = bow.getItemMeta();
            meta.setDisplayName("Лукапорт");
            ArrayList<String> lor = new ArrayList<>();
            lor.add("Лукапорт3000");
            meta.setLore(lor);
            bow.setItemMeta(meta);
            player.getInventory().addItem(bow);

        }
    }

}