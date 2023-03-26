package sh.smnx.rdd.events;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

import java.util.Random;
import java.util.function.Consumer;

public class SpawnMob extends Event {
    private final EntityType _type;
    private final int _amount;
    private final int _radius;

    private int _yOffset = 0;

    private final Consumer<Entity> _modifier;

    public SpawnMob(String name, EntityType type, int amount, int radius, Consumer<Entity> modifier) {
        super(name);
        _type = type;
        _amount = amount;
        _radius = radius;
        _modifier = modifier;
    }

    public SpawnMob(String name, EntityType type, int amount, int radius) {
        this(name, type, amount, radius, e -> {});
    }

    @Override
    public void apply(Player target) {
        for (int i = 0; i < _amount; i++) {
            _modifier.accept(target.getWorld().spawnEntity(target.getLocation().add(
                    new Random().nextInt(_radius*2) - _radius,
                    _yOffset,
                    new Random().nextInt(_radius * 2) - _radius), _type));
        }
    }

    public SpawnMob withYOffset(int o) {
        _yOffset = o;
        return this;
    }
}
