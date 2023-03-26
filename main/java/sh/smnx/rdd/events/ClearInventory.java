package sh.smnx.rdd.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.function.Predicate;

public class ClearInventory extends Event{
    Predicate<Material> _predicate;

    public ClearInventory(String name, Predicate<Material> predicate) {
        super(name);
        _predicate = predicate;
    }

    @Override
    public void apply(Player target) {
        for (int i = 0; i < target.getInventory().getSize(); i++) {
            ItemStack item = target.getInventory().getItem(i);
            if (item != null && _predicate.test(item.getType())) {
                target.getInventory().setItem(i, null);
            }
        }
    }
}
