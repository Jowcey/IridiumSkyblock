package com.peaches.iridiumskyblock.commands;

import com.peaches.iridiumskyblock.IridiumSkyblock;
import com.peaches.iridiumskyblock.User;
import com.peaches.iridiumskyblock.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CommandManager implements CommandExecutor, TabCompleter {
    private List<com.peaches.iridiumskyblock.commands.Command> commands = new ArrayList<>();

    public CommandManager(String command) {
        IridiumSkyblock.getInstance().getCommand(command).setExecutor(this);
        IridiumSkyblock.getInstance().getCommand(command).setTabCompleter(this);
    }

    public void registerCommands() {
        new CreateCommand();
        new HomeCommand();
        new DeleteCommand();
        new ReloadCommand();
        new RegenCommand();
        new InviteCommand();
        new JoinCommand();
        new MissionsCommand();
        new UpgradeCommand();
        new BoosterCommand();
        new CrystalsCommand();
        new GiveCrystalsCommand();
        new RemoveCrystalsCommand();
        new MembersCommand();
        new FlyCommand();
        new AboutCommand();
        new WarpsCommand();
        new SetWarpCommand();
        new ValueCommand();
        new TopCommand();
        new LeaveCommand();
        new WorldBorderCommand();
        new KickCommand();
        new VisitCommand();
        new PublicCommand();
        new PrivateCommand();
        new BypassCommand();
        new SetHomeCommand();
        new WorldsCommand();
    }

    public void registerCommand(com.peaches.iridiumskyblock.commands.Command command) {
        commands.add(command);
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String s, String[] args) {
        try {
            if (args.length != 0) {
                for (com.peaches.iridiumskyblock.commands.Command command : commands) {
                    if (command.getAliases().contains(args[0])) {
                        if (!command.isPlayer() || cs instanceof Player) {
            	    		if ((!(command instanceof WorldsCommand) && !IridiumSkyblock.getConfiguration().EnabledWorlds.contains(((Player) cs).getLocation().getWorld().getName()) && !IridiumSkyblock.getConfiguration().EnabledWorldsIsBlacklist)
            	    		 || (!(command instanceof WorldsCommand) && IridiumSkyblock.getConfiguration().EnabledWorlds.contains(((Player) cs).getLocation().getWorld().getName()) && IridiumSkyblock.getConfiguration().EnabledWorldsIsBlacklist)) {
                	    			
                                cs.sendMessage(Utils.color(IridiumSkyblock.getMessages().notInValidWorld.replace("%prefix%", IridiumSkyblock.getConfiguration().prefix)));
                	    		return true;
                	    	}
                            if (cs.hasPermission(command.getPermission()) || command.getPermission().isEmpty()) {
                                command.execute(cs, args);
                                return true;
                            } else {
                                // No permission
                                cs.sendMessage(Utils.color(IridiumSkyblock.getMessages().noPermission.replace("%prefix%", IridiumSkyblock.getConfiguration().prefix)));
                                return true;
                            }
                        } else {
                            // Must be a player
                            cs.sendMessage(Utils.color(IridiumSkyblock.getMessages().mustBeAPlayer.replace("%prefix%", IridiumSkyblock.getConfiguration().prefix)));
                            return true;
                        }
                    }
                }
            } else {
                if (cs instanceof Player) {
                    Player p = (Player) cs;
                    User u = User.getUser(p);
                    if (u.getIsland() != null) {
                        u.getIsland().teleportHome(p);
                        return true;
                    } else {
                        IridiumSkyblock.getIslandManager().createIsland(p);
                        return true;
                    }
                }
            }
            //Help Menu
            cs.sendMessage(Utils.color("&b&lEpicSkyblock: &bHelp"));
            for (com.peaches.iridiumskyblock.commands.Command c : commands) {
                if (cs.hasPermission(c.getPermission()) || c.getPermission().isEmpty()) {
                    cs.sendMessage(Utils.color("&b&l * &7" + c.getAliases().get(0) + ": &b" + c.getDescription()));
                }
            }
        } catch (Exception e) {
            IridiumSkyblock.getInstance().sendErrorMessage(e);
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender cs, Command cmd, String s, String[] args) {
        try {
            if (args.length == 1) {
                ArrayList<String> result = new ArrayList<>();
                for (com.peaches.iridiumskyblock.commands.Command command : commands) {
                    for (String alias : command.getAliases()) {
                        if (alias.toLowerCase().startsWith(args[0].toLowerCase())) {
                            result.add(alias);
                        }
                    }
                }
                return result;
            }
            for (com.peaches.iridiumskyblock.commands.Command command : commands) {
                if (command.getAliases().contains(args[0])) {
                    return command.TabComplete(cs, cmd, s, args);
                }
            }
        } catch (Exception e) {
            IridiumSkyblock.getInstance().sendErrorMessage(e);
        }
        return null;
    }
}
