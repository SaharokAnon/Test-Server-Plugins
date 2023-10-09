package test.testplagin.Commands;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import net.md_5.bungee.api.chat.hover.content.Item;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

@CommandAlias("bow")
@CommandPermission("TPBow.command")
public class Commands extends BaseCommand {
    @Default
    public void FoodCom(CommandSender sender) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Ты человек?");
        } else {
            ItemStack bow =new ItemStack(Material.BOW,1);
            ItemMeta meta = bow.getItemMeta();
            meta.setDisplayName("§2Лукапорт");
            ArrayList<String> lor = new ArrayList<>();
            lor.add("Лукапорт3000");
            meta.setLore(lor);
            bow.setItemMeta(meta);
            player.getInventory().addItem(bow);
        }
    }

}
