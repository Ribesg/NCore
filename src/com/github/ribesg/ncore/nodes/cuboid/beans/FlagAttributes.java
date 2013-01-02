package com.github.ribesg.ncore.nodes.cuboid.beans;

import java.util.EnumMap;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class FlagAttributes {

    private EnumMap<FlagAtt, Object> atts;

    public FlagAttributes() {
        atts = null;
    }

    private void newMap() {
        atts = getDefaultFlagAttMap();
    }

    // Integers handling
    public Integer getInt(final FlagAtt f) {
        if (atts == null) {
            return null;
        } else if (isIntFlagAtt(f)) {
            return (Integer) atts.get(f);
        } else {
            new IllegalArgumentException(f.name()).printStackTrace();
            return null;
        }
    }

    public void setInt(final FlagAtt f, final Integer i) {
        if (atts == null) {
            newMap();
        }
        if (isIntFlagAtt(f)) {
            atts.put(f, i);
            checkIntCorrection();
        } else {
            new IllegalArgumentException(f.name()).printStackTrace();
        }
    }

    public void setIntNoCheck(final FlagAtt f, final Integer i) {
        atts.put(f, i);
    }

    private boolean isIntFlagAtt(final FlagAtt f) {
        switch (f) {
            case HEAL_AMOUNT:
            case HEAL_TIMER:
            case HEAL_MIN_HEALTH:
            case HEAL_MAX_HEALTH:
            case FEED_AMOUNT:
            case FEED_TIMER:
            case FEED_MIN_FOOD:
            case FEED_MAX_FOOD:
                return true;
            default:
                return false;
        }
    }

    private void checkIntCorrection() {
        if (getInt(FlagAtt.HEAL_TIMER) < 5) {
            setIntNoCheck(FlagAtt.HEAL_TIMER, 5);
        }
        if (getInt(FlagAtt.FEED_TIMER) < 5) {
            setIntNoCheck(FlagAtt.FEED_TIMER, 5);
        }
        if (getInt(FlagAtt.HEAL_AMOUNT) < -20) {
            setIntNoCheck(FlagAtt.HEAL_AMOUNT, -20);
        } else if (getInt(FlagAtt.HEAL_AMOUNT) > 20) {
            setIntNoCheck(FlagAtt.HEAL_AMOUNT, 20);
        }
        if (getInt(FlagAtt.FEED_AMOUNT) < -20) {
            setIntNoCheck(FlagAtt.FEED_AMOUNT, -20);
        } else if (getInt(FlagAtt.FEED_AMOUNT) > 20) {
            setIntNoCheck(FlagAtt.FEED_AMOUNT, 20);
        }
        for (final FlagAtt f : new FlagAtt[] { FlagAtt.HEAL_MIN_HEALTH, FlagAtt.HEAL_MAX_HEALTH, FlagAtt.FEED_MIN_FOOD, FlagAtt.FEED_MAX_FOOD }) {
            if (getInt(f) < 0) {
                setIntNoCheck(f, 0);
            } else if (getInt(f) > 20) {
                setIntNoCheck(f, 20);
            }
        }
    }

    // Locations handling
    public Location getLoc(final FlagAtt f) {
        if (atts == null) {
            return null;
        } else if (isLocFlagAtt(f)) {
            return (Location) atts.get(f);
        } else {
            new IllegalArgumentException(f.name()).printStackTrace();
            return null;
        }
    }

    public void setLoc(final FlagAtt f, final Location loc) {
        if (atts == null) {
            newMap();
        }
        if (isLocFlagAtt(f)) {
            atts.put(f, loc);
            checkLocCorrection();
        } else {
            new IllegalArgumentException(f.name()).printStackTrace();
        }
    }

    private boolean isLocFlagAtt(final FlagAtt f) {
        switch (f) {
            case WARP_POINT:
            case CLOSED_POINT:
                return true;
            default:
                return false;
        }
    }

    private void checkLocCorrection() {
        // Nothing to do yet
    }

    // Vectors handling
    public Vector getVect(final FlagAtt f) {
        if (atts == null) {
            return null;
        } else if (isVectFlagAtt(f)) {
            return (Vector) atts.get(f);
        } else {
            new IllegalArgumentException(f.name()).printStackTrace();
            return null;
        }
    }

    public void setVect(final FlagAtt f, final Vector v) {
        if (atts == null) {
            newMap();
        }
        if (isVectFlagAtt(f)) {
            atts.put(f, v);
            checkVectorCorrection();
        } else {
            new IllegalArgumentException(f.name()).printStackTrace();
        }
    }

    private boolean isVectFlagAtt(final FlagAtt f) {
        switch (f) {
            case BOOSTER_VECTOR:
                return true;
            default:
                return false;
        }
    }

    private void checkVectorCorrection() {
        if (getVect(FlagAtt.BOOSTER_VECTOR).lengthSquared() > 100) {
            // Bukkit does not allow > 10 m/s Velocity
            setVect(FlagAtt.BOOSTER_VECTOR, getVect(FlagAtt.BOOSTER_VECTOR).normalize().multiply(10));
        }
    }

    // Default map
    private static EnumMap<FlagAtt, Object> getDefaultFlagAttMap() {
        final EnumMap<FlagAtt, Object> defaultFlagMap = new EnumMap<FlagAtt, Object>(FlagAtt.class);

        // Integer
        defaultFlagMap.put(FlagAtt.HEAL_AMOUNT, null);
        defaultFlagMap.put(FlagAtt.HEAL_TIMER, null);
        defaultFlagMap.put(FlagAtt.HEAL_MIN_HEALTH, null);
        defaultFlagMap.put(FlagAtt.HEAL_MAX_HEALTH, null);
        defaultFlagMap.put(FlagAtt.FEED_AMOUNT, null);
        defaultFlagMap.put(FlagAtt.FEED_TIMER, null);
        defaultFlagMap.put(FlagAtt.FEED_MIN_FOOD, null);
        defaultFlagMap.put(FlagAtt.FEED_MAX_FOOD, null);

        // Location
        defaultFlagMap.put(FlagAtt.WARP_POINT, null);
        defaultFlagMap.put(FlagAtt.CLOSED_POINT, null);

        // Vector
        defaultFlagMap.put(FlagAtt.BOOSTER_VECTOR, null);
        return defaultFlagMap;
    }
}
