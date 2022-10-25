package com.finndog.moogsmobs.entity.variant;

import java.util.Arrays;
import java.util.Comparator;

public enum DwarfMinerVariant {
    BRUNETTE(0, "brunette"),
    BLONDE(1, "blonde"),
    GINGER(2, "ginger");

    private static final DwarfMinerVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(DwarfMinerVariant::getId)).toArray(DwarfMinerVariant[]::new);

    private final int id;
    private final String name;

    DwarfMinerVariant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public static DwarfMinerVariant byId(int id) {
        return BY_ID[id % BY_ID.length];
    }
}
