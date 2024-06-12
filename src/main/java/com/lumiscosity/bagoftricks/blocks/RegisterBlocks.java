package com.lumiscosity.bagoftricks.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class RegisterBlocks {
    public static final Block ATTUNER = new AttunerBlock(Block.Settings.create().strength(1200.0f).hardness(5.0f).requiresTool().pistonBehavior(PistonBehavior.IGNORE));
    public static final BlockEntityType<AttunerBlockEntity> ATTUNER_BLOCK_ENTITY = Registry.register(
            Registries.BLOCK_ENTITY_TYPE,
            Identifier.of("bagoftricks", "attuner"),
            BlockEntityType.Builder.create(AttunerBlockEntity::new, ATTUNER).build()
            );
    public static final BlockItem ATTUNER_ITEM = new BlockItem(ATTUNER, new Item.Settings());

    public static void initBlocks() {
        Registry.register(Registries.BLOCK, Identifier.of("bagoftricks", "attuner"), ATTUNER);
        Registry.register(Registries.ITEM, Identifier.of("bagoftricks", "attuner"), ATTUNER_ITEM);
    }
}
