package test.testplagin.Util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ItemUtil {

    public static ItemStack create(Material material, int amount, byte data, String displayName){
        ItemStack itemStack = new ItemStack(material, amount, data);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(displayName);
        itemStack.setItemMeta(meta);

        return itemStack;
    }

    public static ItemStack create(Material material, int amount,String displayName){

        return create(material,amount, (byte)0,displayName);
    }

}
