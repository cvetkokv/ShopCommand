package org.minecraft.plugin.shopcommand;

import org.bukkit.plugin.java.JavaPlugin;
import org.minecraft.plugin.shopcommand.commands.*;

import java.util.*;

public final class ShopCommand extends JavaPlugin {

    @Override
    public void onEnable() {

        this.saveDefaultConfig();
        Objects.requireNonNull(this.getCommand("shop"))
                .setExecutor(new Command(this));
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
