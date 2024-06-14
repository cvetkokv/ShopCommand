package org.minecraft.plugin.shopcommand.commands;

import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.chat.hover.content.*;
import org.bukkit.command.*;
import org.bukkit.plugin.*;

public class Command implements CommandExecutor {

	private final Plugin plugin;

	public Command(Plugin plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("shop")) {
			if (args.length > 0 && args[0].equalsIgnoreCase("reload")) {
				if (sender.hasPermission("shop.admin")) {
					// Reload the configuration file
					plugin.reloadConfig();
					sender.sendMessage("§aShop configuration reloaded.");
				} else {
					sender.sendMessage("§cYou do not have permission to perform this command.");
				}
				return true;
			} else {
				String shopUrl = plugin.getConfig().getString("shop-url");
				TextComponent message = new TextComponent("§6§lURL §8§l» §f" + shopUrl);
				message.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, shopUrl));
				message.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("Click to visit our store")));

				// Send the message to the player
				sender.spigot().sendMessage(message);
				return true;
			}

		}
		return false;
	}
}
