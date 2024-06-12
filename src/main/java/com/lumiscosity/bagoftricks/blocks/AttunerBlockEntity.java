package com.lumiscosity.bagoftricks.blocks;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;

import static com.lumiscosity.bagoftricks.blocks.RegisterBlocks.ATTUNER_BLOCK_ENTITY;

public class AttunerBlockEntity extends BlockEntity {
    public AttunerBlockEntity(BlockPos pos, BlockState state) {
        super(ATTUNER_BLOCK_ENTITY, pos, state);
    }

}
