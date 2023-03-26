package sh.smnx.rdd.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MlgChallenge extends Event {

    public MlgChallenge(String name) {
        super(name);
    }

    @Override
    public void apply(Player target) {
        Location tp = target.getLocation();
        tp.setY(255);
        target.teleport(tp);
        tp.setY(254);
        target.getWorld().getBlockAt(tp).setType(Material.GLASS);
        target.getInventory().addItem(new ItemStack(Material.WATER_BUCKET));
    }
}
