package sh.smnx.rdd.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import sh.smnx.rdd.Utils;


public class SwapPlayer extends Event {
    public SwapPlayer(String name) {
        super(name);
    }

    @Override
    public void apply(Player target) {
        Player randomPlayer = Utils.randomPlayer();
        Location rndLoc = randomPlayer.getLocation();
        Location targetLoc = target.getLocation();

        Bukkit.broadcastMessage("A swap " + Utils.colored(ChatColor.GOLD, target.getName()) + " et " + Utils.colored(ChatColor.GOLD, randomPlayer.getName()));

        target.teleport(rndLoc);
        randomPlayer.teleport(targetLoc);
    }
}
