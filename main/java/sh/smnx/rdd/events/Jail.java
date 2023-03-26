package sh.smnx.rdd.events;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class Jail extends  Event {
    Material _material;
    int _sizeX;
    int _sizeY;
    int _sizeZ;

    public Jail(String name, Material material, int sizeX, int sizeY, int sizeZ){
        super(name);
        _material = material;
        _sizeX = sizeX;
        _sizeY = sizeY;
        _sizeZ = sizeZ;
    }


    @Override
    public void apply(Player target) {
        World world = target.getWorld();
        int x = target.getLocation().getBlockX();
        int y = target.getLocation().getBlockY();
        int z = target.getLocation().getBlockZ();

        for (int i = 0; i < _sizeX; i++) {
            for (int j = 0; j < _sizeY; j++) {
                for (int k = 0; k < _sizeZ; k++) {
                    if (i == 0 || i == _sizeX - 1 || j == 0 || j == _sizeY - 1 || k == 0 || k == _sizeZ - 1)
                        world.getBlockAt(x + i - _sizeX / 2, y + j - 1, z + k - _sizeZ / 2).setType(_material);
                }
            }
        }
    }
}
