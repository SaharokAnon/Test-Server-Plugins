package test.testplagin;

import org.bukkit.plugin.java.JavaPlugin;
import test.testplagin.Commands.Commands;

import java.util.logging.Logger;
import co.aikar.commands.BukkitCommandManager;


public final class Testplagin extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger log = getLogger();
        log.info("CAXAPOK1");
        BukkitCommandManager manager = new BukkitCommandManager(this);
        manager.registerCommand(new Commands());

    }
}
