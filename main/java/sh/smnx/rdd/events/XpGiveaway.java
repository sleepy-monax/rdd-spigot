package sh.smnx.rdd.events;

import org.bukkit.entity.Player;

public class XpGiveaway extends Event {
    private final int _levels;

    public XpGiveaway(String name, int levels) {
        super(name);
        _levels = levels;
    }

    @Override
    public void apply(Player target) {
        target.giveExpLevels(_levels);
    }
}
