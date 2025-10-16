package com.songoda.epichoppers.utils;

import java.util.HashSet;
import java.util.Set;

public class WarningManager {
    private static final Set<String> shownWarnings = new HashSet<>();
    
    public static void warnOnce(org.bukkit.plugin.java.JavaPlugin plugin, String warningKey, String warningMessage) {
        if (!shownWarnings.contains(warningKey)) {
            shownWarnings.add(warningKey);
            plugin.getLogger().warning(warningMessage);
        }
    }
    
    public static void clearWarnings() {
        shownWarnings.clear();
    }
}
