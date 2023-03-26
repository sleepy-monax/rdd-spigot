package sh.smnx.rdd.events;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.stream.Collectors;

public class GotoCoordinates extends Event {
    public GotoCoordinates(String name) {
        super(name);
    }

    @Override
    public void apply(Player target) {
        Location loc = target.getWorld().getHighestBlockAt(0, 0).getLocation();
        target.teleport(loc);
    }
}
