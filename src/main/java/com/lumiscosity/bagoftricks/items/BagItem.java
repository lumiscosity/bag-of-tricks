package com.lumiscosity.bagoftricks.items;

import com.lumiscosity.bagoftricks.Attunement;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import java.util.List;
import java.util.Map;

public class BagItem extends Item {

    public static final Attunement.AttunementTypes ACTIVE_ATTUNEMENT = Attunement.AttunementTypes.NONE;

    public BagItem(Settings settings) {
        super(settings);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (user.isSneaking()) {
            user.playSound(SoundEvents.ITEM_BUNDLE_DROP_CONTENTS, 1.0F, 1.0F);
        } else {
            user.playSound(SoundEvents.ITEM_BUNDLE_INSERT, 1.0F, 1.0F);
        }
        return TypedActionResult.success(user.getStackInHand(hand));
    }
}
