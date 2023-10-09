package test.testplagin.Event;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.ArrayList;

public class Eent implements Listener{
    @EventHandler
    public void tparrow(ProjectileHitEvent event){
        if (event.getEntity() instanceof Arrow arrow){
            if (arrow.getShooter() instanceof Player player){
                ArrayList<String> lor = new ArrayList<>();
                lor.add("Лукапорт3000");
                if (player.getInventory().getItemInMainHand().getItemMeta().getLore().equals(lor)){
                    player.teleport(arrow.getLocation());
                    arrow.remove();
                }
            }
        }
    }
}
