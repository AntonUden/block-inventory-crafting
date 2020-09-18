package net.zeeraa.blockinventorycrafting;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockInventoryCrafting extends JavaPlugin implements Listener {
	@Override
	public void onEnable() {
		Bukkit.getPluginManager().registerEvents(this, this);
	}

	@Override
	public void onDisable() {
		HandlerList.unregisterAll((Plugin) this);
	}

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void onCraftItem(CraftItemEvent e) {
		if (e.getInventory().getType() == InventoryType.CRAFTING) {
			if (e.getWhoClicked().hasPermission("blockcrafting.blockinventorycrafing")) {
				e.setCancelled(true);
			}
		}
	}
}