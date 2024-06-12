package com.lumiscosity.bagoftricks;

import java.util.Map;

import static java.util.Map.entry;

public class Attunement {
    public enum AttunementTypes {
        NONE,
        WATER,
        EARTH,
        FIRE,
        AIR,
        SPIRIT
    }

    private static final Map<AttunementTypes, String> ATTUNEMENT_TRANSLATABLE = Map.ofEntries(
            entry(AttunementTypes.NONE, "bagofholding.attunement.none"),
            entry(AttunementTypes.WATER, "bagofholding.attunement.water"),
            entry(AttunementTypes.EARTH, "bagofholding.attunement.earth"),
            entry(AttunementTypes.FIRE, "bagofholding.attunement.fire"),
            entry(AttunementTypes.AIR, "bagofholding.attunement.air"),
            entry(AttunementTypes.SPIRIT, "bagofholding.attunement.spirit")
            );

    public String getAttunementTranslatable(AttunementTypes attunement) {
        return ATTUNEMENT_TRANSLATABLE.get(attunement);
    }
}