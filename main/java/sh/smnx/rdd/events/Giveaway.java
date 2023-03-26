package sh.smnx.rdd.events;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Giveaway extends Event {
    private final List<ItemStack> _stacks = new ArrayList<>();

    public ItemStack last() {
        return _stacks.get(_stacks.size() - 1);
    }

    public Giveaway(String name) {
        super(name);
    }

    @Override
    public void apply(Player target) {
        apply(target.getInventory());
    }

    public void apply(Inventory inv){
        _stacks.stream().forEach(s -> inv.addItem(s));
    }

    public Giveaway withStack(ItemStack stack) {
        _stacks.add(stack);
        return this;
    }

    public Giveaway withEnchant(Enchantment enchantment, int level) {
        last().addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public Giveaway withEnchant(Enchantment enchantment) {
        return withEnchant(enchantment, 1);
    }


    public Giveaway withDurability(int durability) {
        last().setDurability((short) (last().getType().getMaxDurability() - durability));
        return this;
    }

    public Giveaway withSubid(int id) {
        last().setDurability((short) id);
        return this;
    }
}
