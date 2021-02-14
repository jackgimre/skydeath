package me.sircherry.skydeath.events;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class SkyDeathEvents implements Listener {
    @EventHandler
    public static void playerDropEvent(PlayerDropItemEvent e) {
        Player player = e.getPlayer();
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();
        for(int i=1;i<16;i++) {
            e.setCancelled(true);
            Material block = player.getWorld().getBlockAt(x, y - i, z).getType();
            if (block != Material.AIR) {
                e.setCancelled(false);
                return;
            }
        }
    }
    @EventHandler
    public void onKill(PlayerDeathEvent e)
    {
        Player killed = e.getEntity();
        Player killer = e.getEntity().getKiller();
        if(killer == null) {
            killed.getInventory().clear();
        }
        for(ItemStack is : killed.getInventory()) {
            if(is.getType() == Material.DIAMOND || is.getType() == Material.GOLD_INGOT || is.getType() == Material.IRON_INGOT || is.getType() == Material.BRICK || is.getType() == Material.EMERALD) {
                killer.getInventory().addItem(is);
            }
            killed.getInventory().removeItem(is);
        }
        killed.getInventory().clear();
    }
}
