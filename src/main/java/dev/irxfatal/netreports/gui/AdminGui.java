package dev.irxfatal.netreports.gui;

import dev.irxfatal.netreports.storage.StorageHandler;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AdminGui {

    public static void openAdminGui(Player admin, StorageHandler storageHandler) {
        Map<String, List<String>> groupedReports = storageHandler.getGroupedReports();

        Inventory gui = Bukkit.createInventory(null, 54, "Reported Players");

        int slot = 0;
        for (Map.Entry<String, List<String>> entry : groupedReports.entrySet()) {
            if (slot >= gui.getSize()) break;

            String targetPlayer = entry.getKey();
            List<String> reports = entry.getValue();

            ItemStack playerStack = new ItemStack(Material.PLAYER_HEAD);
            ItemMeta meta = playerStack.getItemMeta();
            if (meta != null) {
                meta.setDisplayName("§cPlayer: " + targetPlayer);
                meta.setLore(Arrays.asList(
                        "§eReports: " + reports.size(),
                        "§7Last reported by: " + reports.get(reports.size() - 1),
                        "§7Time: " + storageHandler.getLastReportTime(targetPlayer)
                ));
                playerStack.setItemMeta(meta);
            }

            gui.setItem(slot++, playerStack);
        }

        admin.openInventory(gui);
    }
}
