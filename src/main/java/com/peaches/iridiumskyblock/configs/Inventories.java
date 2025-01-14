package com.peaches.iridiumskyblock.configs;

import com.peaches.iridiumskyblock.IridiumSkyblock;
import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Inventories {

    //Boosters
    public Item spawner = new Item(Material.MOB_SPAWNER, 1, 0, "&b&lIncreased Mobs", new ArrayList<>(Arrays.asList("&7Are your spawners too slow? Buy this", "&7booster and increase spawner rates x2.", "", "&b&lInformation:", "&b&l * &7Time Remaining: &b{spawnerbooster}s", "&b&l * &7Booster Cost: &b" + IridiumSkyblock.getBoosters().spawnerBooster.getCost() + " Crystals", "", "&b&l[!] &bRight Click to Purchase this Booster.")));
    public Item farming = new Item(Material.WHEAT, 1, 0, "&b&lIncreased Crops", new ArrayList<>(Arrays.asList("&7Are your crops too slow? Buy this", "&7booster and increase crop growth rates x2.", "", "&b&lInformation:", "&b&l * &7Time Remaining: &b{farmingbooster}s", "&b&l * &7Booster Cost: &b" + IridiumSkyblock.getBoosters().farmingBooster.getCost() + " Crystals", "", "&b&l[!] &bRight Click to Purchase this Booster.")));
    public Item exp = new Item(Material.EXP_BOTTLE, 1, 0, "&b&lIncreased Experience", new ArrayList<>(Arrays.asList("&7Takes too long to get exp? Buy this", "&7booster and exp rates x2.", "", "&b&lInformation:", "&b&l * &7Time Remaining: &b{expbooster}s", "&b&l * &7Booster Cost: &b" + IridiumSkyblock.getBoosters().experianceBooster.getCost() + "Crystals", "", "&b&l[!] &bRight Click to Purchase this Booster.")));
    public Item flight = new Item(Material.FEATHER, 1, 0, "&b&lIncreased Flight", new ArrayList<>(Arrays.asList("&7Tired of falling off your island? Buy this", "&7booster and allow all members to fly.", "", "&b&lInformation:", "&b&l * &7Time Remaining: &b{flightbooster}s", "&b&l * &7Booster Cost: &b" + IridiumSkyblock.getBoosters().flightBooster.getCost() + " Crystals", "", "&b&l[!] &bRight Click to Purchase this Booster.")));

    //Missions
    public Item treasureHunter = new Item(Material.EXP_BOTTLE, 1, 0, "&b&lTreasure Hunter", new ArrayList<>(Arrays.asList("&7Complete island missions to gain crystals", "&7that can be spent on Boosters and Upgrades.", "", "&b&lInformation:", "&b&l * &7Objective: &bCollect " + IridiumSkyblock.getMissions().treasureHunter.getAmount() + " Experience", "&b&l * &7Current Status: &b{treasurehunterstatus}", "&b&l * &7Reward: &b" + IridiumSkyblock.getMissions().treasureHunter.getReward() + " Island Crystals", "", "&b&l[!] &bComplete this mission for rewards.")));
    public Item competitor = new Item(Material.GOLD_INGOT, 1, 0, "&b&lCompetitor", new ArrayList<>(Arrays.asList("&7Complete island missions to gain crystals", "&7that can be spent on Boosters and Upgrades.", "", "&b&lInformation:", "&b&l * &7Objective: &bGain " + IridiumSkyblock.getMissions().competitor.getAmount() + " Island Value", "&b&l * &7Current Status: &b{competitorstatus}", "&b&l * &7Reward: &b" + IridiumSkyblock.getMissions().competitor.getReward() + " Island Crystals", "", "&b&l[!] &bComplete this mission for rewards.")));
    public Item miner = new Item(Material.DIAMOND_ORE, 1, 0, "&b&lMiner", new ArrayList<>(Arrays.asList("&7Complete island missions to gain crystals", "&7that can be spent on Boosters and Upgrades.", "", "&b&lInformation:", "&b&l * &7Objective: &bDestroy " + IridiumSkyblock.getMissions().miner.getAmount() + " Ores", "&b&l * &7Current Status: &b", "&b&l * &7Reward: &b{minerstatus}" + IridiumSkyblock.getMissions().miner.getReward() + " Island Crystals", "", "&b&l[!] &bComplete this mission for rewards.")));
    public Item farmer = new Item(Material.SUGAR_CANE, 1, 0, "&b&lFarmer", new ArrayList<>(Arrays.asList("&7Complete island missions to gain crystals", "&7that can be spent on Boosters and Upgrades.", "", "&b&lInformation:", "&b&l * &7Objective: &bHarvest " + IridiumSkyblock.getMissions().farmer.getAmount() + " Crops", "&b&l * &7Current Status: &b", "&b&l * &7Reward: &b{farmerstatus}" + IridiumSkyblock.getMissions().farmer.getReward() + " Island Crystals", "", "&b&l[!] &bComplete this mission for rewards.")));
    public Item hunter = new Item(Material.BLAZE_POWDER, 1, 0, "&b&lHunter", new ArrayList<>(Arrays.asList("&7Complete island missions to gain crystals", "&7that can be spent on Boosters and Upgrades.", "", "&b&lInformation:", "&b&l * &7Objective: &bKill " + IridiumSkyblock.getMissions().hunter.getAmount() + " Mobs", "&b&l * &7Current Status: &b", "&b&l * &7Reward: &b{hunterstatus}" + IridiumSkyblock.getMissions().hunter.getReward() + " Island Crystals", "", "&b&l[!] &bComplete this mission for rewards.")));
    public Item fisherman = new Item(Material.FISHING_ROD, 1, 0, "&b&lFisherman", new ArrayList<>(Arrays.asList("&7Complete island missions to gain crystals", "&7that can be spent on Boosters and Upgrades.", "", "&b&lInformation:", "&b&l * &7Objective: &bCatch " + IridiumSkyblock.getMissions().fisherman.getAmount() + " Fish", "&b&l * &7Current Status: &b", "&b&l * &7Reward: &b{fishermanstatus}" + IridiumSkyblock.getMissions().fisherman.getReward() + " Island Crystals", "", "&b&l[!] &bComplete this mission for rewards.")));
    public Item builder = new Item(Material.COBBLESTONE, 1, 0, "&b&lBuilder", new ArrayList<>(Arrays.asList("&7Complete island missions to gain crystals", "&7that can be spent on Boosters and Upgrades.", "", "&b&lInformation:", "&b&l * &7Objective: &bPlace " + IridiumSkyblock.getMissions().builder.getAmount() + " Blocks", "&b&l * &7Current Status: &b", "&b&l * &7Reward: &b{builderstatus}" + IridiumSkyblock.getMissions().builder.getReward() + " Island Crystals", "", "&b&l[!] &bComplete this mission for rewards.")));


    public static class Item {

        private Material material;
        private int amount;
        private int type;
        private String title;
        private List<String> lore;

        public Item(Material material, int amount, int type, String title, List<String> lore) {
            this.material = material;
            this.amount = amount;
            this.type = type;
            this.lore = lore;
            this.title = title;
        }

        public Material getMaterial() {
            return material;
        }

        public int getAmount() {
            return amount;
        }

        public int getType() {
            return type;
        }

        public List<String> getLore() {
            return lore;
        }

        public String getTitle() {
            return title;
        }
    }
}
