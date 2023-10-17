package test.testplagin.Commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.Default;
import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import test.testplagin.Testplagin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@CommandAlias("shop")
public class Commands2 extends BaseCommand {

    List<String> myList = new ArrayList<String>(Arrays.asList(Testplagin.getInstance().getConfig().getString("item").split(",")));






    @Default
    public void shop(CommandSender sender) {
        if (!(sender instanceof Player player)) {
            return;
        }
        Gui gui = Gui.gui().title(Component.text("CUMShop")).rows(6).create();
        for(int i=0; i< myList.size();i++){
            if(i % 3 == 0){
                gui.addItem(ItemBuilder.from(Material.valueOf(myList.get(i).substring(11))).asGuiItem(event -> {
                    event.setCancelled(true);
                    ItemStack predmet = new ItemStack(Material.DIAMOND, 6);
                    player.getInventory().addItem(predmet);
                }));
            }
        }
        gui.open(player);
    }

}