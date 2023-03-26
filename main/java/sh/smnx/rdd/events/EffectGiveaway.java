package sh.smnx.rdd.events;

import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class EffectGiveaway extends Event {
    PotionEffect _effect;

    public EffectGiveaway(String name, PotionEffect effect) {
        super(name);
        _effect = effect;
    }

    @Override
    public void apply(Player target) {
        target.addPotionEffect(_effect);
    }
}
