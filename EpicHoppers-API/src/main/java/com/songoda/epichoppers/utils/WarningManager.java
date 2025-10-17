package com.songoda.epichoppers.utils;

public class WarningManager {
    public enum WarningType {
        PARTICLE_WARNING,
        OTHER_WARNING
    }
    
    private static boolean hasShownParticleWarning = false;
    private static boolean hasShownOtherWarning = false;
    
    public static void warnOnce(org.bukkit.plugin.java.JavaPlugin plugin, WarningType type, String warningMessage) {
        switch (type) {
            case PARTICLE_WARNING:
                if (!hasShownParticleWarning) {
                    hasShownParticleWarning = true;
                    plugin.getLogger().warning(warningMessage);
                }
                break;
            case OTHER_WARNING:
                if (!hasShownOtherWarning) {
                    hasShownOtherWarning = true;
                    plugin.getLogger().warning(warningMessage);
                }
                break;
        }
    }
    
    public static void clearWarnings() {
        hasShownParticleWarning = false;
        hasShownOtherWarning = false;
    }
    
    // For backward compatibility
    @Deprecated
    public static void warnOnce(org.bukkit.plugin.java.JavaPlugin plugin, String warningKey, String warningMessage) {
        warnOnce(plugin, WarningType.OTHER_WARNING, warningMessage);
    }
}
