package net.onebeastchris.extension.magicmenu.util;

import org.geysermc.geyser.api.connection.GeyserConnection;

public class PlaceHolder {
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static String parsePlaceHolders(GeyserConnection connection, String message) {
        // safety check
        if (message.startsWith("/")) {
            message.replaceFirst("/", "");
        }

        return message
                .replace("%username%", connection.javaUsername())
                .replace("%xuid%", connection.xuid())
                .replace("%uuid%", connection.javaUuid().toString())
                .replace("%bedrockusername%", connection.bedrockUsername())
                .replace("%version%", connection.version())
                .replace("%device%", connection.inputMode().name())
                .replace("%lang%", connection.languageCode())
                .replace("%x%", String.valueOf(connection.playerEntity().position().getX()))
                .replace("%y%", String.valueOf(connection.playerEntity().position().getY()))
                .replace("%z%", String.valueOf(connection.playerEntity().position().getZ()))
                .replace("%position%", Math.floor(connection.playerEntity().position().getX())
                        + " " + Math.floor(connection.playerEntity().position().getY())
                        + " " + Math.floor(connection.playerEntity().position().getZ()));
    }
}
