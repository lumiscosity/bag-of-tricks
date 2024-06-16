package com.lumiscosity.bagoftricks.items;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.dynamic.Codecs;

public record BagChargeComponent(int charge, int max_charge) {

    public static final Codec<BagChargeComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codecs.NONNEGATIVE_INT.fieldOf("charge").forGetter(BagChargeComponent::charge),
            Codecs.NONNEGATIVE_INT.fieldOf("max_charge").forGetter(BagChargeComponent::max_charge)
    ).apply(instance, BagChargeComponent::new));

    public static final PacketCodec<RegistryByteBuf, BagChargeComponent> PACKET_CODEC = PacketCodec.tuple(PacketCodecs.VAR_INT, BagChargeComponent::charge, PacketCodecs.VAR_INT, BagChargeComponent::max_charge, BagChargeComponent::new);

}

