package sh.smnx.rdd.events;

import org.bukkit.entity.Player;

public class Dummy extends Event{
    public Dummy(String name) {
        super(name);
    }

    @Override
    public void apply(Player target) {

    }
}
