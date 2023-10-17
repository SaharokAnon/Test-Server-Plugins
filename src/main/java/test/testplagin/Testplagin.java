package test.testplagin;
import org.bukkit.plugin.java.JavaPlugin;
import test.testplagin.Commands.Commands;

import java.util.logging.Logger;
import co.aikar.commands.BukkitCommandManager;
import test.testplagin.Commands.Commands2;
import test.testplagin.Event.Eent;


public final class Testplagin extends JavaPlugin {
    private static Testplagin instance;
    @Override
    public void onEnable() {
        Logger log = getLogger();
        log.info("CAXAPOK");
        instance = this;
        BukkitCommandManager manager = new BukkitCommandManager(this);
        manager.registerCommand(new Commands());
        manager.registerCommand(new Commands2());
        getServer().getPluginManager().registerEvents(new Eent(), this);

    }
    public static Testplagin getInstance() {
        return instance;
    }
}
