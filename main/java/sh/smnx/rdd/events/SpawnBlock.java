package sh.smnx.rdd.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;

public class SpawnBlock extends Event {
    Material _material;
    int _offsetX;
    int _offsetY;
    int _offsetZ;

    public SpawnBlock(String name, Material material, int offsetX, int offsetY, int offsetZ){
        super(name);
        _material = material;
        _offsetX = offsetX;
        _offsetY = offsetY;
        _offsetZ = offsetZ;
    }


    @Override
    public void apply(Player target) {
        target.getWorld().getBlockAt(target.getLocation().getBlockX() + _offsetX, target.getLocation().getBlockY() + _offsetY, target.getLocation().getBlockZ() + _offsetZ).setType(_material);
    }
}
