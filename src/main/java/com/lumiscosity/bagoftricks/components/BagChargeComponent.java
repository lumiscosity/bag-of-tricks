package com.lumiscosity.bagoftricks.components;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.util.dynamic.Codecs;

public record BagChargeComponent(int charge, int max_charge) {
    
    public static final Codec<BagChargeComponent> CODEC = RecordCodecBuilder.create(instance -> instance.group(((MapCodec)Codecs.NONNEGATIVE_INT.fieldOf("charge")).forGetter(BagChargeComponent::getCharge), ((MapCodec)Codecs.NONNEGATIVE_INT.fieldOf("saturation")).forGetter(BagChargeComponent::getMaxCharge), BagChargeComponent::new));

    public static final PacketCodec<RegistryByteBuf, BagChargeComponent> PACKET_CODEC = PacketCodec.tuple(PacketCodecs.VAR_INT, BagChargeComponent::charge, PacketCodecs.VAR_INT, BagChargeComponent::max_charge, BagChargeComponent::new);

    public static class Builder {
        private int charge;
        private int max_charge;

        public BagChargeComponent.Builder charge(int charge) {
            this.charge = charge;
            return this;
        }

        public BagChargeComponent.Builder saturationModifier(int max_charge) {
            this.max_charge = max_charge;
            return this;
        }

        public BagChargeComponent build() {
            return new BagChargeComponent(this.charge, this.max_charge);
        }
    }
}

