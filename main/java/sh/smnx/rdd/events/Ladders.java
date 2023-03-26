package sh.smnx.rdd.events;

import org.bukkit.Location;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;

public class Ladders extends Event {
    private Giveaway _giveaway = null;

    public Ladders(String name) {
        super(name);
    }

    @Override
    public void apply(Player target) {
        // Create a ladder to y255 and put a chest on top with some items
        Location bottom = target.getLocation().clone();
        Location top = bottom.clone();
        top.setY(100);

        for (int y = bottom.getBlockY(); y < top.getBlockY(); y++) {
            Location ladder = bottom.clone();
            ladder.setY(y);
            ladder.getBlock().setType(org.bukkit.Material.LADDER);
            Location support = ladder.clone();
            support.setZ(support.getZ() + 1);
            support.getBlock().setType(org.bukkit.Material.COBBLESTONE);
        }

        top.setZ(top.getZ() + 1);
        top.getBlock().setType(org.bukkit.Material.CHEST);

        Chest chest = (Chest) top.getBlock().getState();
        if (_giveaway != null) {
            _giveaway.apply(chest.getInventory());
        }
    }

    public Ladders withGiveaway(Giveaway giveaway) {
        _giveaway = giveaway;
        return this;
    }
}
