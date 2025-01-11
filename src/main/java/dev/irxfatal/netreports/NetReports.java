package dev.irxfatal.netreports;

import dev.irxfatal.netreports.gui.AdminGui;
import dev.irxfatal.netreports.storage.ApiStorageHandler;
import dev.irxfatal.netreports.storage.LocalStorageHandler;
import dev.irxfatal.netreports.storage.StorageHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class NetReports extends JavaPlugin {

    private StorageHandler storageHandler;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        boolean useApi = getConfig().getBoolean("use-api", false);
        if (useApi) {
            String apiEndpoint = getConfig().getString("api-endpoint");
            storageHandler = new ApiStorageHandler(apiEndpoint);
        } else {
            storageHandler = new LocalStorageHandler(getDataFolder().getAbsolutePath());
        }

        getCommand("adminreports").setExecutor((sender, command, label, args) -> {
            if (sender instanceof org.bukkit.entity.Player) {
                AdminGui.openAdminGui((org.bukkit.entity.Player) sender, storageHandler);
            }
            return true;
        });

        getLogger().info("NetReports Plugin Enabled");
    }

    @Override
    public void onDisable() {
        storageHandler.close();
        getLogger().info("NetReports Plugin Disabled");
    }

    public StorageHandler getStorageHandler() {
        return storageHandler;
    }
}
