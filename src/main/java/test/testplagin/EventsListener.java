package test.testplagin;

import org.bukkit.event.Listener;
import com.destroystokyo.paper.event.player.PlayerJumpEvent;
import org.bukkit.event.EventHandler;
public class EventsListener implements Listener {
    @EventHandler
    public void onPlayerJump(PlayerJumpEvent event){
        event.getPlayer().sendMessage("Molodez");
    }
}
