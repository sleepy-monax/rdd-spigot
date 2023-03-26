package sh.smnx.rdd.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import sh.smnx.rdd.Utils;


public class AggroPlayer extends Event {
    public AggroPlayer(String name) {
        super(name);
    }

    @Override
    public void apply(Player target) {
        Player randomPlayer = Utils.randomPlayer();
        Location rndLoc = randomPlayer.getLocation();
        Bukkit.broadcastMessage("Aggro par " + Utils.colored(ChatColor.GOLD, target.getName()) + " vers " + Utils.colored(ChatColor.GOLD, randomPlayer.getName()));
        target.teleport(rndLoc);
        randomPlayer.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 3));
        target.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 3));
    }
}
