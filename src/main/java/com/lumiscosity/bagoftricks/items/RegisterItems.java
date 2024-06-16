package com.lumiscosity.bagoftricks.items;

import net.minecraft.component.ComponentType;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import net.minecraft.util.Rarity;

public class RegisterItems {

    public static final Item BAG_OF_TRICKS = new BagItem(new Item.Settings().fireproof().maxCount(1).rarity(Rarity.RARE).component();

    public static void initItems() {
        Registry.register(Registries.ITEM, Identifier.of("bagoftricks", "bag_of_tricks"), BAG_OF_TRICKS);
    }
}