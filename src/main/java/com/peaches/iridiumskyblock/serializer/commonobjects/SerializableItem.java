package com.peaches.iridiumskyblock.serializer.commonobjects;


import com.peaches.iridiumskyblock.MultiversionMaterials;

import java.util.List;

public class SerializableItem {

    private MultiversionMaterials material;
    private String name;
    private List<String> lore;
    private int amt;

    public SerializableItem(MultiversionMaterials material, String name, List<String> lore, int amount) {
        this.material = material;
        this.name = name;
        this.lore = lore;
        this.amt = amount;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultiversionMaterials getMaterial() {
        return material;
    }

    public void setMaterial(MultiversionMaterials material) {
        this.material = material;
    }

    public List<String> getLore() {
        return lore;
    }

    public void setLore(List<String> lore) {
        this.lore = lore;
    }

    public int getAmt() {
        return amt;
    }

    public void setAmt(int amt) {
        this.amt = amt;
    }
}
