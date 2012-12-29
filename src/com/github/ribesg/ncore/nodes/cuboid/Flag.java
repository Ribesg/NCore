package com.github.ribesg.ncore.nodes.cuboid;

import java.util.EnumMap;

public enum Flag {
    BOOSTER, BUILD, CHAT, CHEST, CLOSED, CREATIVE, DROP, ENDERMANGRIEF, EXPLOSION, FARM, FEED, FIRE, GOD, HEAL, HIDDEN, INVISIBLE, JAIL, MOB, PASS, PERMANENT, PVP, SNOW, TELEPORT, USE, WARPGATE;

    public static EnumMap<Flag, Boolean> getDefaultFlagMap() {
        final EnumMap<Flag, Boolean> defaultFlagMap = new EnumMap<Flag, Boolean>(Flag.class);
        // Hardcoded default values
        // TODO Make this configurable
        defaultFlagMap.put(BOOSTER, false);
        defaultFlagMap.put(BUILD, true);
        defaultFlagMap.put(CHAT, false);
        defaultFlagMap.put(CHEST, true);
        defaultFlagMap.put(CLOSED, false);
        defaultFlagMap.put(CREATIVE, false);
        defaultFlagMap.put(DROP, false);
        defaultFlagMap.put(ENDERMANGRIEF, true);
        defaultFlagMap.put(EXPLOSION, true);
        defaultFlagMap.put(FARM, true);
        defaultFlagMap.put(FEED, false);
        defaultFlagMap.put(FIRE, true);
        defaultFlagMap.put(GOD, false);
        defaultFlagMap.put(HEAL, false);
        defaultFlagMap.put(HIDDEN, false);
        defaultFlagMap.put(INVISIBLE, false);
        defaultFlagMap.put(JAIL, false);
        defaultFlagMap.put(MOB, false);
        defaultFlagMap.put(PASS, false);
        defaultFlagMap.put(PERMANENT, false);
        defaultFlagMap.put(PVP, true);
        defaultFlagMap.put(SNOW, false);
        defaultFlagMap.put(TELEPORT, false);
        defaultFlagMap.put(USE, true);
        defaultFlagMap.put(WARPGATE, false);
        return defaultFlagMap;
    }

    public static Flag get(final String val) {
        final String in = val.toUpperCase();
        Flag f = null;
        try {
            f = Flag.valueOf(in);
        } catch (final IllegalArgumentException e) {
            if (in.equals("BOOST")) {
                f = BOOSTER;
            } else if (in.equals("SPEAK")) {
                f = CHAT;
            } else if (in.equals("EXP")) {
                f = EXPLOSION;
            } else if (in.equals("ENDERMAN")) {
                f = ENDERMANGRIEF;
            } else if (in.equals("HIDE")) {
                f = HIDDEN;
            } else if (in.equals("PERM")) {
                f = PERMANENT;
            } else if (in.equals("TEL")) {
                f = TELEPORT;
            } else if (in.equals("WARP")) {
                f = WARPGATE;
            }
        }
        return f;
    }
}
