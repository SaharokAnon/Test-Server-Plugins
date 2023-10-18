package test.testplagin.GUI;

import dev.triumphteam.gui.builder.item.ItemBuilder;
import dev.triumphteam.gui.components.GuiType;
import dev.triumphteam.gui.components.ScrollType;
import dev.triumphteam.gui.guis.Gui;
import dev.triumphteam.gui.guis.GuiItem;
import dev.triumphteam.gui.guis.ScrollingGui;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import test.testplagin.Testplagin;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class guiRendeer {
    static List<String> myList = new ArrayList<String>(Arrays.asList(Testplagin.getInstance().getConfig().getString("items").split(", ")));
    static Gui applygui = Gui.gui().title(Component.text("Купишь?")).type(GuiType.HOPPER).create();
    public static void mainshop(Player player){
        myList.replaceAll(s -> s.replaceAll("\\[|\\{|\\]|\\}", ""));
        ScrollingGui ShopGUI = Gui.scrolling().title(Component.text("DiamondPLS").color(TextColor.fromHexString("#35de08"))).rows(6).pageSize(45).scrollType(ScrollType.VERTICAL).create();

        ShopGUI.disableAllInteractions();
        ShopGUI.setItem(6, 1,ItemBuilder.from(Material.PAPER).name(Component.text("ВВЕРХ").color(TextColor.fromHexString("#8080ff"))).asGuiItem(Event -> ShopGUI.next()));
        ShopGUI.setItem(6, 9,ItemBuilder.from(Material.PAPER).name(Component.text("вниз").color(TextColor.fromHexString("#846844"))).asGuiItem(Event -> ShopGUI.previous()));
        ShopGUI.setItem(6, 5,ItemBuilder.from(Material.OAK_DOOR).name(Component.text("Свалить").color(TextColor.fromHexString("#ff8080"))).asGuiItem(Event -> ShopGUI.close(player)));
        for(int i=0; i< myList.size();i++){
            if(i % 3 == 0){
                GuiItem item = ItemBuilder.from(Material.valueOf(myList.get(i).substring(9))).name(Component.text(myList.get(i).substring(9) + " - Алмазиков " + myList.get(i+1).substring(6)).color(TextColor.fromHexString("#00ffc4"))).asGuiItem(event -> {
                    event.setCancelled(true);
                    applyguiwork(event, player, ShopGUI);
                    applygui.open(player);
                });
                ShopGUI.addItem(item);
            }
        }
        ShopGUI.open(player);
    }


    public static void applyguiwork(InventoryClickEvent rootEvent, Player player, ScrollingGui gui){
        int price = Integer.valueOf(myList.get(rootEvent.getSlot()*3+1).substring(6));
        int count = Integer.valueOf(myList.get(rootEvent.getSlot()*3+2).substring(6));
        GuiItem buttonshop = ItemBuilder.from(Material.GREEN_WOOL).name(Component.text("ПОКУПАЮ").color(TextColor.fromHexString("#20cc20"))).asGuiItem(event -> {
            event.setCancelled(true);
            if (!(player.getInventory().contains(Material.DIAMOND,price))){
                return;
            }
            player.getInventory().addItem(rootEvent.getCurrentItem());
            player.getInventory().removeItem(new ItemStack(Material.DIAMOND, price));
        });
        applygui.setItem(1,1, buttonshop);
        applygui.setItem(1,2, buttonshop);
        buttonshop = ItemBuilder.from(rootEvent.getCurrentItem()).amount(count).asGuiItem(event -> event.setCancelled(true));
        applygui.setItem(1,3, buttonshop);
        buttonshop = ItemBuilder.from(Material.RED_WOOL).name(Component.text("Отмена♂").color(TextColor.fromHexString("#ff8080"))).asGuiItem(event -> {
            event.setCancelled(true);
            applygui.close(player);
        });
        applygui.setItem(1,4, buttonshop);
        applygui.setItem(1,5, buttonshop);
    }
}
