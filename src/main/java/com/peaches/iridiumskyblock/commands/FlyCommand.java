package com.peaches.iridiumskyblock.commands;

import com.peaches.iridiumskyblock.IridiumSkyblock;
import com.peaches.iridiumskyblock.User;
import com.peaches.iridiumskyblock.Utils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class FlyCommand extends Command {

    public FlyCommand() {
        super(Arrays.asList("fly", "flight"), "Toggle your ability to fly", "", true);
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        Player p = (Player) sender;
        User user = User.getUser(p);
        if (user.getIsland() != null) {
            if (user.getIsland().getFlightBooster() != 0 || p.hasPermission("EpicSkyblock.Fly")) {
                if (p.getAllowFlight()) {
                    p.setAllowFlight(false);
                    p.setFlying(false);
                    p.sendMessage(Utils.color(IridiumSkyblock.getMessages().flightDisabled.replace("%prefix%", IridiumSkyblock.getConfiguration().prefix)));
                } else {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    p.sendMessage(Utils.color(IridiumSkyblock.getMessages().flightEnabled.replace("%prefix%", IridiumSkyblock.getConfiguration().prefix)));
                }
            } else {
                p.sendMessage(Utils.color(IridiumSkyblock.getMessages().flightBoosterNotActive.replace("%prefix%", IridiumSkyblock.getConfiguration().prefix)));
            }
        } else {
            IridiumSkyblock.getIslandManager().createIsland(p);
        }
    }

    @Override
    public List<String> TabComplete(CommandSender cs, org.bukkit.command.Command cmd, String s, String[] args) {
        return null;
    }
}
