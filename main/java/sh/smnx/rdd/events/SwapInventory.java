package sh.smnx.rdd.events;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import sh.smnx.rdd.Utils;

public class SwapInventory extends Event{
    public SwapInventory(String name) {
        super(name);
    }

    @Override
    public void apply(Player target) {
        Player randomPlayer = Utils.randomPlayer();
        PlayerInventory rndInv = randomPlayer.getInventory();
        PlayerInventory targetInv = target.getInventory();

        for (int i = 0; i < rndInv.getSize(); i++) {
            ItemStack tmp = rndInv.getItem(i);
            rndInv.setItem(i, targetInv.getItem(i));
            targetInv.setItem(i, tmp);
        }
    }
}
