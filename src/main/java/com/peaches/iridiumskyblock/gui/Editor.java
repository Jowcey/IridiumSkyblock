package com.peaches.iridiumskyblock.gui;

import com.peaches.iridiumskyblock.IridiumSkyblock;
import com.peaches.iridiumskyblock.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Editor implements Listener {

    //TODO middle click to enter int value in

    private Inventory inventory;

    private ConfigGUI config;
    private ConfigGUI messages;
    private ConfigGUI boosters;
    private ConfigGUI upgrades;
    private ConfigGUI missions;

    private ItemStack Config;
    private ItemStack Messages;
    private ItemStack Boosters;
    private ItemStack Upgrades;
    private ItemStack Missions;

    public Editor() {

        inventory = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', "&b&lEpicSkyblock Editor"));

        try {
            config = new ConfigGUI(com.peaches.iridiumskyblock.configs.Config.class, IridiumSkyblock.class.getField("configuration"), "getInstance");
            messages = new ConfigGUI(com.peaches.iridiumskyblock.configs.Messages.class, IridiumSkyblock.class.getField("messages"), "getInstance");
            boosters = new ConfigGUI(com.peaches.iridiumskyblock.configs.Boosters.class, IridiumSkyblock.class.getField("boosters"), "getInstance");
            upgrades = new ConfigGUI(com.peaches.iridiumskyblock.configs.Upgrades.class, IridiumSkyblock.class.getField("upgrades"), "getInstance");
            missions = new ConfigGUI(com.peaches.iridiumskyblock.configs.Missions.class, IridiumSkyblock.class.getField("missions"), "getInstance");
        } catch (Exception e) {
            e.printStackTrace();
        }
        IridiumSkyblock.getInstance().registerListeners(this);

        addItems();
    }

    private void addItems() {
        for (int i = 0; i < inventory.getSize(); i++) {
            inventory.setItem(i, Utils.makeItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
        }
        Config = Utils.makeItem(Material.PAPER, 1, 0, "&b&lConfig");
        Messages = Utils.makeItem(Material.PAPER, 1, 0, "&b&lMessages");
        Boosters = Utils.makeItem(Material.PAPER, 1, 0, "&b&lBoosters");
        Upgrades = Utils.makeItem(Material.PAPER, 1, 0, "&b&lUpgrades");
        Missions = Utils.makeItem(Material.PAPER, 1, 0, "&b&lMissions");

        inventory.setItem(11, Config);
        inventory.setItem(12, Messages);
        inventory.setItem(13, Boosters);
        inventory.setItem(14, Upgrades);
        inventory.setItem(15, Missions);
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ConfigGUI getConfig() {
        return config;
    }

    public ConfigGUI getMessages() {
        return messages;
    }

    @EventHandler
    public void onclick(InventoryClickEvent e) {
        if (e.getInventory().equals(inventory)) {
            e.setCancelled(true);
            if (e.getCurrentItem() != null) {
                if (e.getCurrentItem().equals(Config)) {
                    if (config.pages.isEmpty()) {
                        e.getWhoClicked().openInventory(config.getInventory());
                    } else {
                        e.getWhoClicked().openInventory(config.pages.get(1).getInventory());
                    }
                }
                if (e.getCurrentItem().equals(Messages)) {

                    if (messages.pages.isEmpty()) {
                        e.getWhoClicked().openInventory(messages.getInventory());
                    } else {
                        e.getWhoClicked().openInventory(messages.pages.get(1).getInventory());
                    }
                }
                if (e.getCurrentItem().equals(Boosters)) {

                    if (boosters.pages.isEmpty()) {
                        e.getWhoClicked().openInventory(boosters.getInventory());
                    } else {
                        e.getWhoClicked().openInventory(boosters.pages.get(1).getInventory());
                    }
                }
                if (e.getCurrentItem().equals(Upgrades)) {

                    if (upgrades.pages.isEmpty()) {
                        e.getWhoClicked().openInventory(upgrades.getInventory());
                    } else {
                        e.getWhoClicked().openInventory(upgrades.pages.get(1).getInventory());
                    }
                }
                if (e.getCurrentItem().equals(Missions)) {

                    if (missions.pages.isEmpty()) {
                        e.getWhoClicked().openInventory(missions.getInventory());
                    } else {
                        e.getWhoClicked().openInventory(missions.pages.get(1).getInventory());
                    }
                }
            }
        }
    }
}
