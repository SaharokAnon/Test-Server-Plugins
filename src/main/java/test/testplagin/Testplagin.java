package test.testplagin;

import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;


public final class Testplagin extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger log = getLogger();
        log.info("CAXAPOK");
        getServer().getPluginManager().registerEvents(new EventsListener(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
