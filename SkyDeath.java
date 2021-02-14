package me.sircherry.skydeath;

import me.sircherry.skydeath.events.SkyDeathEvents;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class SkyDeath extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new SkyDeathEvents(),this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN+"[SkyDeath]: Plugin is enabled");
    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED+"[SkyDeath]: Plugin is disabled");
    }
}
