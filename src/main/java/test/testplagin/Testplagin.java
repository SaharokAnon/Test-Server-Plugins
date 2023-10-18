package test.testplagin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;
import co.aikar.commands.BukkitCommandManager;
import test.testplagin.commands.shopcom;


public final class Testplagin extends JavaPlugin {
    private static Testplagin instance;
    @Override
    public void onEnable() {
        Logger log = getLogger();
        log.info("CAXAPOK");
        instance = this;
        BukkitCommandManager manager = new BukkitCommandManager(this);
        manager.registerCommand(new shopcom());
    }
    public static Testplagin getInstance() {
        return instance;
    }
}
