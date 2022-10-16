package com.finndog.moogsmobs.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum CaplingVariant {
    DEFAULT(0),
    PINK(1),
    RED(2),
    YELLOW(3);

    private static final CaplingVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(CaplingVariant::getId)).toArray(CaplingVariant[]::new);
    private final int id;

    CaplingVariant(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public static CaplingVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
