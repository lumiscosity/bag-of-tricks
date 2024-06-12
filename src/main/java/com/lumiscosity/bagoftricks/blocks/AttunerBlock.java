package com.lumiscosity.bagoftricks.blocks;

import com.lumiscosity.bagoftricks.Attunement;
import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import static com.lumiscosity.bagoftricks.items.RegisterItems.BAG_OF_TRICKS;

public class AttunerBlock extends BlockWithEntity {



    public static final MapCodec<AttunerBlock> CODEC = AttunerBlock.createCodec(AttunerBlock::new);
    public static final Attunement.AttunementTypes ATTUNER_TYPE = Attunement.AttunementTypes.NONE;
    public static final int ATTUNER_LEVEL = 0;

    public AttunerBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient) {
            player.sendMessage(Text.literal("UI GOES HERE"), false);
        }

        return ActionResult.SUCCESS;
    }

    @Override
    protected boolean hasComparatorOutput(BlockState state) {
        return true;
    }

    @Override
    protected int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return ATTUNER_LEVEL / 10;
    }

    @Override
    public ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.isOf(BAG_OF_TRICKS)) {
            return ItemActionResult.SKIP_DEFAULT_BLOCK_INTERACTION;
        }
        return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new AttunerBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
