package sh.smnx.rdd;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.PluginCommand;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.FallingBlock;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import sh.smnx.rdd.events.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public final class Rdd extends JavaPlugin implements Listener {

    private final List<Event> _events = new ArrayList<>();

    public void addEvent(Event event) {
        _events.add(event);
    }


    public void triggerEvent(Player target) {
        triggerEvent(target, new Random().nextInt(_events.size()));
    }

    public void triggerEvent(Player target, int id) {
        Event e = _events.get(id);
        Bukkit.broadcastMessage("La roue du destin a choisi " + Utils.colored(ChatColor.RED, "\"" + e.getName() + "\"") + " pour " + Utils.colored(ChatColor.GOLD, target.getName()));
        e.apply(target);
    }

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);

        addEvent(new Dummy("Faut relancer, non???"));
        addEvent(new Dummy("Bug du plugin"));
        addEvent(new Dummy("/op <player>"));

        addEvent(new SwapPlayer("The Swapper"));

        addEvent(new SwapInventory("Oops c'est pas a moi"));

        addEvent(new EffectGiveaway("I'm god", new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 60, 0)));

        addEvent(new Giveaway("Mineur de charbon")
                .withStack(new ItemStack(Material.COAL_BLOCK, 5)));

        addEvent(new Giveaway("Mineur de diamant")
                .withStack(new ItemStack(Material.DIAMOND_BLOCK, 5)));

        addEvent(new XpGiveaway("69 levels, nice.", 69));

        addEvent(new SpawnMob("Explosion", EntityType.CREEPER, 3, 5));

        addEvent(new Giveaway("Mineur de fer")
                .withStack(new ItemStack(Material.IRON_BLOCK, 5)));

        addEvent(new Giveaway("Mineur de redstone")
                .withStack(new ItemStack(Material.REDSTONE_BLOCK, 5)));


        addEvent(new Giveaway("Mineur de lapis")
                .withStack(new ItemStack(Material.LAPIS_BLOCK, 5)));


        addEvent(new Giveaway("Mineur d'or")
                .withStack(new ItemStack(Material.GOLD_BLOCK, 5)));

        addEvent(new Giveaway("Bibliotécaire")
                .withStack(new ItemStack(Material.BOOKSHELF, 64)));

        addEvent(new Giveaway("Bouge de là")
                .withStack(new ItemStack(Material.STICK))
                .withEnchant(Enchantment.KNOCKBACK, 2));

        addEvent(new Giveaway("Barre toi de là")
                .withStack(new ItemStack(Material.WOOD_SWORD))
                .withEnchant(Enchantment.KNOCKBACK, 5)
                .withDurability(20));

        addEvent(new Giveaway("Aventurier")
                .withStack(new ItemStack(Material.WOOD_SWORD))
                .withEnchant(Enchantment.DAMAGE_ALL, 5));

        addEvent(new ClearInventory("Famine", Utils::isNonMagicFood));

        addEvent(new ClearInventory("Pouf l'inventaire", m -> !m.name().endsWith("PICKAXE")));

        addEvent(new Giveaway("Do you love explosion?")
                .withStack(new ItemStack(Material.TNT, 16))
                .withStack(new ItemStack(Material.FLINT_AND_STEEL)));

        addEvent(new SpawnMob("Splosh Splosh", EntityType.SLIME, 4, 5));

        addEvent(new Giveaway("Tu es un sorcier Harry")
                .withStack(new ItemStack(Material.BREWING_STAND_ITEM))
                .withStack(new ItemStack(Material.NETHER_STALK, 4)));

        addEvent(new Giveaway("Roi Artur")
                .withStack(new ItemStack(Material.GOLD_SWORD))
                .withEnchant(Enchantment.DAMAGE_ALL, 5)
                .withEnchant(Enchantment.FIRE_ASPECT, 2));

        addEvent(new SpawnMob("Mage Noir", EntityType.WITCH, 4, 5));

        addEvent(new EffectGiveaway("League of Legend", new PotionEffect(PotionEffectType.POISON, 600, 0)));

        addEvent(new SpawnMob("C'est Chauuud", EntityType.BLAZE, 3, 5));

        addEvent(new AggroPlayer("Bonjour"));

        addEvent(new EffectGiveaway("Final Heal", new PotionEffect(PotionEffectType.REGENERATION, 20, 255)));

        addEvent(new Giveaway("La Pomme!")
                .withStack(new ItemStack(Material.GOLDEN_APPLE)));

        addEvent(new Giveaway("La Pomme !")
                .withStack(new ItemStack(Material.GOLDEN_APPLE))
                .withSubid(1));

        addEvent(new Giveaway("Chanceux")
                .withStack(new ItemStack(Material.GOLDEN_APPLE, 10)));

        addEvent(new Giveaway("Veinard")
                .withStack(new ItemStack(Material.GOLDEN_APPLE, 32)));

        addEvent(new Giveaway("Jackpot")
                .withStack(new ItemStack(Material.GOLDEN_APPLE, 64)));

        addEvent(new EffectGiveaway("Comme une taupe", new PotionEffect(PotionEffectType.BLINDNESS, 2400, 0)));

        addEvent(new EffectGiveaway("Alcoolique", new PotionEffect(PotionEffectType.CONFUSION, 2400, 1)));

        addEvent(new Giveaway("Mineur expérimenté")
                .withStack(new ItemStack(Material.DIAMOND_PICKAXE))
                .withEnchant(Enchantment.DIG_SPEED, 3)
                .withEnchant(Enchantment.LOOT_BONUS_BLOCKS, 1));

        addEvent(new Giveaway("Dieu de la mine")
                .withStack(new ItemStack(Material.DIAMOND_PICKAXE))
                .withEnchant(Enchantment.DIG_SPEED, 5)
                .withEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3));

        addEvent(new EffectGiveaway("Pied cassé", new PotionEffect(PotionEffectType.SLOW, 24000, 0)));

        addEvent(new Giveaway("Chevalier")
                .withStack(new ItemStack(Material.STONE_SWORD))
                .withEnchant(Enchantment.DAMAGE_ALL, 5));

        addEvent(new Giveaway("Paladin")
                .withStack(new ItemStack(Material.IRON_SWORD))
                .withEnchant(Enchantment.DAMAGE_ALL, 5));

        addEvent(new Giveaway("Excalibur")
                .withStack(new ItemStack(Material.DIAMOND_SWORD))
                .withEnchant(Enchantment.DAMAGE_ALL, 5));

        addEvent(new Giveaway("Excaliburn")
                .withStack(new ItemStack(Material.GOLD_SWORD))
                .withEnchant(Enchantment.DAMAGE_ALL, 4)
                .withEnchant(Enchantment.FIRE_ASPECT, 1));

        addEvent(new Giveaway("Excalibure")
                .withStack(new ItemStack(Material.DIAMOND_SWORD))
                .withEnchant(Enchantment.DAMAGE_ARTHROPODS, 5));

        addEvent(new EffectGiveaway("Beep Beep", new PotionEffect(PotionEffectType.SPEED, 1200, 4)));

        addEvent(new Giveaway("Maitre Archer")
                .withStack(new ItemStack(Material.BOW))
                .withStack(new ItemStack(Material.ARROW, 128))
                .withEnchant(Enchantment.ARROW_DAMAGE, 5)
                .withEnchant(Enchantment.ARROW_FIRE));

        addEvent(new Giveaway("Archer")
                .withStack(new ItemStack(Material.BOW))
                .withStack(new ItemStack(Material.ARROW, 1))
                .withEnchant(Enchantment.ARROW_DAMAGE, 3)
                .withEnchant(Enchantment.ARROW_INFINITE));

        addEvent(new Giveaway("Archère")
                .withStack(new ItemStack(Material.BOW))
                .withStack(new ItemStack(Material.ARROW, 64))
                .withEnchant(Enchantment.ARROW_DAMAGE, 3));

        addEvent(new Giveaway("Maitre Archier")
                .withStack(new ItemStack(Material.BOW))
                .withEnchant(Enchantment.ARROW_DAMAGE, 1)
                .withStack(new ItemStack(Material.ARROW, 16))
        );

        addEvent(new EffectGiveaway("Comme L'orange(Préssée)", new PotionEffect(PotionEffectType.SPEED, 12000, 0)));

        addEvent(new EffectGiveaway("Speedy Gonzalez", new PotionEffect(PotionEffectType.SPEED, 6000, 2)));

        addEvent(new EffectGiveaway("Ninja", new PotionEffect(PotionEffectType.INVISIBILITY, 12000, 0)));

        addEvent(new EffectGiveaway("Bénédiction", new PotionEffect(PotionEffectType.HEALTH_BOOST, 120000, 0)));

        addEvent(new EffectGiveaway("Absorbe Moi ça", new PotionEffect(PotionEffectType.ABSORPTION, 1200, 4)));

        addEvent(new Giveaway("L'artisanat")
                .withStack(new ItemStack(Material.WORKBENCH, 64)));

        addEvent(new SpawnMob("Venu de l'outre monde", EntityType.ZOMBIE, 10, 10));

        addEvent(new SpawnMob("Venu de l'outre tombe", EntityType.SKELETON, 10, 10));

        addEvent(Event.combined("Armée des morts",
                new SpawnMob("", EntityType.ZOMBIE, 10, 10),
                new SpawnMob("", EntityType.SKELETON, 10, 10)
        ));

        addEvent(new SpawnMob("Survoleté", EntityType.CREEPER, 1, 10, e -> ((Creeper) e).setPowered(true)));

        addEvent(new SpawnMob("Bien éclairé", EntityType.LIGHTNING, 10, 10));

        addEvent(new Jail("En celule", Material.OBSIDIAN, 3, 4, 3));

        addEvent(new Jail("En celule dorée", Material.GOLD_ORE, 3, 4, 3));

        addEvent(Event.combined("Well shit",
                new Jail("", Material.IRON_FENCE, 3, 4, 3),
                new SpawnBlock("", Material.LAVA, 0, 4, 0)
        ));

        addEvent(new Jail("Hello, friends!", Material.MONSTER_EGGS, 4, 4, 4));

        addEvent(new EffectGiveaway("Manque de musculation", new PotionEffect(PotionEffectType.SLOW_DIGGING, 600, 0)));

        addEvent(new GotoCoordinates("Bienvenue au centre"));

        addEvent(new MlgChallenge("Sky high"));

        addEvent(new Ladders("Echelle du destin").withGiveaway(new Giveaway("").withStack(new ItemStack(Material.BONE))));
        addEvent(new Ladders("Echelle du destin")
                .withGiveaway(
                        new Giveaway("")
                                .withStack(new ItemStack(Material.DIAMOND_HELMET))
                                .withEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
                                .withStack(new ItemStack(Material.DIAMOND_CHESTPLATE))
                                .withEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
                                .withStack(new ItemStack(Material.DIAMOND_LEGGINGS))
                                .withEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
                                .withStack(new ItemStack(Material.DIAMOND_BOOTS))
                                .withEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 2)
                                .withStack(new ItemStack(Material.DIAMOND_SWORD))
                                .withEnchant(Enchantment.DAMAGE_ALL, 3)
                                .withStack(new ItemStack(Material.GOLDEN_APPLE, 10))));

        PluginCommand rddCommand = getCommand("rdd");
        rddCommand.setExecutor((commandSender, command, s, args) -> {
            if (args.length != 1 && args.length != 2) {
                commandSender.sendMessage(command.getUsage());
                return false;
            }

            Player target = Objects.equals(args[0], "random") ? Utils.randomPlayer() : Bukkit.getPlayer(args[0]);
            if (target == null) {
                commandSender.sendMessage("Le joueur " + Utils.colored(ChatColor.GOLD, args[0]) + " n'a pas été trouvé!");
                return false;
            }

            if (args.length == 2) {
                try {
                    int id = Integer.parseInt(args[1]);
                    if (id < 0 || id >= _events.size()) {
                        commandSender.sendMessage("L'event " + Utils.colored(ChatColor.GOLD, args[1]) + " n'existe pas!");
                        return false;
                    }

                    triggerEvent(target, id);
                } catch (NumberFormatException e) {
                    commandSender.sendMessage("L'event " + Utils.colored(ChatColor.GOLD, args[1]) + " n'existe pas!");
                    return false;
                }
            } else {
                triggerEvent(target);
            }

            return true;
        });

        PluginCommand rddListCommand = getCommand("rdd-list");
        rddListCommand.setExecutor((commandSender, command, s, args) -> {
            commandSender.sendMessage("Roue du destin:");
            int index = 0;
            for (Event e : _events) {
                commandSender.sendMessage(" - [" + index + "] " + e.getName());
                index++;
            }
            return true;
        });
    }

    @Override
    public void onDisable() {
        _events.clear();
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        if (block.getType() == Material.YELLOW_FLOWER ||
                block.getType() == Material.RED_ROSE) {
            event.setCancelled(true);
            block.setType(Material.AIR);

            ItemStack item = new ItemStack(getRandMaterial(), 1);
            block.getWorld().dropItemNaturally(block.getLocation(), item);
        }
    }

    public Material getRandMaterial() {
        Material[] materials = Material.values();
        return materials[new Random().nextInt(materials.length)];
    }
}
