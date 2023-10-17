package test.testplagin.Event;

import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.ArrayList;

public class Eent implements Listener{
    @EventHandler
    public void tparrow(ProjectileHitEvent event){

        if (!(event.getEntity() instanceof Arrow)) {
            return;
        }
        Arrow arrow = (Arrow) event.getEntity();
        ArrayList<String> lor = new ArrayList<>();
        lor.add("Лукапорт3000");
            Player player = (Player) event.getEntity().getShooter();
        if (arrow.getShooter() instanceof Player & player.getInventory().getItemInMainHand().getItemMeta().getLore().equals(lor)){
                    player.teleport(arrow.getLocation().setDirection(player.getLocation().getDirection()));
                    arrow.remove();
                    arrow.getWorld().spawnParticle(Particle.DRAGON_BREATH, arrow.getLocation(), 50, 3, 3, 3, 0);
            }
        }
    }
