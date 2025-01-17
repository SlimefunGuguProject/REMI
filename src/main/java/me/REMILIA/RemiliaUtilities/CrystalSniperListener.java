package me.REMILIA.RemiliaUtilities;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class CrystalSniperListener implements Listener {

    private final JavaPlugin plugin;
    private final HashMap<Player, Long> cooldowns = new HashMap<>();

    public CrystalSniperListener(RemiliaUtilities plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();

        // Check if the player is holding the crystal blaster
        if (isValidCrystalSniper(item)) {
            // Check if the player is trying to left-click (fire)
            if (event.getAction().toString().contains("LEFT")) {
                // Fire the crystal blaster
                fireCrystalSniper(player);
            }
        }
    }

    private void fireCrystalSniper(Player player) {
        // 6 seconds in milliseconds
        long COOLDOWN_TIME = 6 * 1000;
        if (!cooldowns.containsKey(player) || System.currentTimeMillis() - cooldowns.get(player) >= COOLDOWN_TIME) {
            if (hasCrystalAmmo(player)) {
                consumeCrystalAmmo(player);
                Location spawnLoc = getSpawnLocation(player);

                // Play the sound effect
                Objects.requireNonNull(spawnLoc.getWorld()).playSound(spawnLoc, Sound.BLOCK_ANVIL_LAND, 0.5f, 1.0f);

                BukkitRunnable crystalProjectileTask = new BukkitRunnable() {
                    int ticks = 0;

                    @Override
                    public void run() {
                        if (ticks >= 240) { // 12 seconds at 20 ticks per second
                            cancel();
                            return;
                        }

                        if (spawnLoc.getWorld() != null) {
                            for (Entity nearbyEntity : spawnLoc.getWorld().getNearbyEntities(spawnLoc, 0.5, 0.5, 0.5)) {
                                if (nearbyEntity instanceof LivingEntity livingEntity) {
                                    if (!livingEntity.equals(player)) {
                                        double damage = 20.0; // Apply 8 hearts of damage to all living entities within range
                                        livingEntity.damage(damage);
                                        livingEntity.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 100, 0)); // Glowing for 5 seconds

                                        cancel(); // Stop the task when colliding with a living entity
                                        return;
                                    }
                                }
                            }
                        }

                        Block block = spawnLoc.getBlock();
                        Material blockType = block.getType();

                        // Check if the block is solid or transparent (non-solid)
                        if (!blockType.isSolid() || blockType.isTransparent()) {
                            Objects.requireNonNull(spawnLoc.getWorld()).spawnParticle(Particle.BLOCK_CRACK, spawnLoc, 10, 0.1, 0.1, 0.1, 0, Material.GLOWSTONE.createBlockData());
                            spawnLoc.add(spawnLoc.getDirection().normalize().multiply(4)); // Multiply velocity by 1.4x
                        } else {
                            cancel(); // Stop the task only when colliding with a solid block
                        }

                        ticks++;
                    }
                };

                crystalProjectileTask.runTaskTimer(plugin, 0L, 1L); // Run the task every tick

                // Set cooldown
                cooldowns.put(player, System.currentTimeMillis());
            } else {
                player.sendMessage("你需要水晶!");
            }
        } else {
            long timeLeft = (cooldowns.get(player) + COOLDOWN_TIME - System.currentTimeMillis()) / 1000;
            player.sendMessage("水晶狙击枪正在冷却。 剩余: " + timeLeft + " 秒");
        }
    }

    private boolean isValidCrystalSniper(ItemStack item) {
        return item != null && item.getItemMeta() != null && item.getItemMeta().hasLore() && item.getItemMeta().getLore() != null && item.getItemMeta().getLore().contains("这不是像素枪!");
    }

    private boolean hasCrystalAmmo(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (isValidCrystal(item)) {
                return true;
            }
        }
        return false;
    }

    private boolean isValidCrystal(ItemStack item) {
        if (item == null || !item.hasItemMeta() || !Objects.requireNonNull(item.getItemMeta()).hasLore()) {
            return false;
        }

        ItemMeta meta = item.getItemMeta();
        List<String> lore = meta.getLore();
        String displayName = ChatColor.stripColor(meta.getDisplayName()); // Get the stripped display name

        // Check if the lore contains "它在闪闪发光" and if the display name contains specific crystal names
        return lore != null && lore.contains("它在闪闪发光") && (
                displayName.contains("玉水晶") ||
                        displayName.contains("月光石水晶") ||
                        displayName.contains("缟玛瑙水晶") ||
                        displayName.contains("蔷薇辉石水晶") ||
                        displayName.contains("纯紫水晶") ||
                        displayName.contains("坦桑石水晶") ||
                        displayName.contains("蓝宝石水晶") ||
                        displayName.contains("蓝晶石水晶") ||
                        displayName.contains("绿松石水晶") ||
                        displayName.contains("祖母绿水晶") ||
                        displayName.contains("橄榄石水晶") ||
                        displayName.contains("黄玉水晶") ||
                        displayName.contains("纯黄水晶") ||
                        displayName.contains("石榴石水晶")
        );
    }

    private void consumeCrystalAmmo(Player player) {
        for (ItemStack item : player.getInventory().getContents()) {
            if (isValidCrystal(item)) {
                if (item.getAmount() > 1) {
                    item.setAmount(item.getAmount() - 1); // Decrease stack size by one
                } else {
                    player.getInventory().removeItem(item); // Remove the item if it's the last one in the stack
                }
                return;
            }
        }
    }

    private Location getSpawnLocation(Player player) {
        Location eyeLoc = player.getEyeLocation();
        return eyeLoc.add(eyeLoc.getDirection().normalize());
    }
}
