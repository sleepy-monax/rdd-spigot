package sh.smnx.rdd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Utils {
    public static Player randomPlayer(){
        List<Player> players =
        Bukkit.getServer()
                .getOnlinePlayers()
                .stream()
                .filter(p -> p.getGameMode() == GameMode.SURVIVAL)
                .collect(Collectors.toList());

        int index = new Random().nextInt(players.size());
        return players.get(index);
    }

    public static String colored(ChatColor color, String message){
        return color + message + ChatColor.RESET;
    }

    public static boolean isNonMagicFood(Material m) {
        switch (m) {
            case APPLE:
            case MUSHROOM_SOUP:
            case BREAD:
            case PORK:
            case GRILLED_PORK:
            case RAW_FISH:
            case COOKED_FISH:
            case COOKIE:
            case MELON:
            case RAW_BEEF:
            case COOKED_BEEF:
            case RAW_CHICKEN:
            case COOKED_CHICKEN:
            case ROTTEN_FLESH:
            case SPIDER_EYE:
            case CARROT_ITEM:
            case POTATO_ITEM:
            case BAKED_POTATO:
            case POISONOUS_POTATO:
            case GOLDEN_CARROT:
            case PUMPKIN_PIE:
            case RABBIT:
            case COOKED_RABBIT:
            case RABBIT_STEW:
            case MUTTON:
            case COOKED_MUTTON:
                return true;
            default:
                return false;
        }
    }
}
