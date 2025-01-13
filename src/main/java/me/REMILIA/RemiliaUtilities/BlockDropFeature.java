package me.REMILIA.RemiliaUtilities;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

import java.util.Objects;
import java.util.Random;

public class BlockDropFeature implements Listener {

    private final JavaPlugin plugin;
    private final Random random;
    private SlimefunItemStack jadeStack;
    private SlimefunItemStack moonstoneStack;
    private SlimefunItemStack onyxStack;
    private SlimefunItemStack rhodoniteStack;
    private SlimefunItemStack amethystStack;
    private SlimefunItemStack tanzaniteStack;
    private SlimefunItemStack sapphireStack;
    private SlimefunItemStack kyaniteStack;
    private SlimefunItemStack turquoiseStack;
    private SlimefunItemStack emeraldStack;
    private SlimefunItemStack peridotStack;
    private SlimefunItemStack topazStack;
    private SlimefunItemStack citrineStack;
    private SlimefunItemStack garnetStack;

    public BlockDropFeature(JavaPlugin plugin) {
        this.plugin = plugin;
        this.random = new Random();
        createItemStacks(); // Call the method to create item stacks
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Player player = event.getPlayer();

        // Check if the broken block is stone or deepslate
        if (block.getType() == Material.STONE || block.getType() == Material.DEEPSLATE) {
            // Generate a random number between 0 and 11
            int randomNumber1 = random.nextInt(12); {
                if (randomNumber1 == 0) {

                    // Generate a random number between 0 and 13
                    int randomNumber2 = random.nextInt(14);

                    // Check the random number to determine which gem to drop
                    switch (randomNumber2) {
                        case 0:
                            // Drop Jade
                            dropItem(block.getLocation(), jadeStack);
                            break;
                        case 1:
                            // Drop Moonstone
                            dropItem(block.getLocation(), moonstoneStack);
                            break;
                        case 2:
                            // Drop Onyx
                            dropItem(block.getLocation(), onyxStack);
                            break;
                        case 3:
                            // Drop Rhodonite
                            dropItem(block.getLocation(), rhodoniteStack);
                            break;
                        case 4:
                            // Drop Amethyst
                            dropItem(block.getLocation(), amethystStack);
                            break;
                        case 5:
                            // Drop Tanzanite
                            dropItem(block.getLocation(), tanzaniteStack);
                            break;
                        case 6:
                            // Drop Sapphire
                            dropItem(block.getLocation(), sapphireStack);
                            break;
                        case 7:
                            // Drop Kyanite
                            dropItem(block.getLocation(), kyaniteStack);
                            break;
                        case 8:
                            // Drop Turquoise
                            dropItem(block.getLocation(), turquoiseStack);
                            break;
                        case 9:
                            // Drop Emerald
                            dropItem(block.getLocation(), emeraldStack);
                            break;
                        case 10:
                            // Drop Peridot
                            dropItem(block.getLocation(), peridotStack);
                            break;
                        case 11:
                            // Drop Topaz
                            dropItem(block.getLocation(), topazStack);
                            break;
                        case 12:
                            // Drop Citrine
                            dropItem(block.getLocation(), citrineStack);
                            break;
                        case 13:
                            // Drop Garnet
                            dropItem(block.getLocation(), garnetStack);
                            break;
                    }

                }
            }

        }
    }
    private void createItemStacks() {
        // Initialize the SlimefunItemStack objects for each gem
        // Modify the parameters according to your needs
        jadeStack = new SlimefunItemStack(
                "JADE",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYTM0ZjAwZWNiOTY3NzAyODBjOGQ2NTNjMTg5MGU4N2FiNWIxMjVmODUyOGU3YWQ0ZmVjMWQzMWViZDEyMjg3YiJ9fX0=",
                "&a玉", // Display name
                "&7一颗漂亮的绿色宝石", // Description
                "&7可在地球深处发现" // Additional lore
        );
        moonstoneStack = new SlimefunItemStack(
                "MOONSTONE",
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvOWQ5M2VkOTJiMWE5YTI0YWQwNzJhY2Y2ZThmY2NmY2VkZTFiOGMyNzEzNmEyYjQyNTc2ZWU4NWRmN2RjMTE0YiJ9fX0=",
                "&7月光石", // Display name
                "&f来自月球的神秘宝石", // Description
                "&7据说拥有神奇的特性" // Additional lore
        );
        onyxStack = new SlimefunItemStack(
                "ONYX", // Item ID
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMmUwY2JjMThhYTgzODk2Zjk4NGI1MmIyMWU1MmYyN2ViOGE3MmUyNmM0NzE3OWZkNzkzMjk3ZjNiN2M2ZmJiZSJ9fX0=", // Material (example, change as needed)
                "&8缟玛瑙", // Display name
                "&7一种黑色光滑的宝石", // Description
                "&7因其保佑的特性而闻名" // Additional lore
        );
        rhodoniteStack = new SlimefunItemStack(
                "RHODONITE", // Item ID
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzA2N2ZjM2U4MWQ2NDU5MmY3NTEzYWVlYTc3M2U2MTYzNDMzYmY0MTg3YzRiZjcyYTc5MDM4Y2ZjNWVkYzE1ZCJ9fX0=", // Material (example, change as needed)
                "&d蔷薇辉石", // Display name
                "&7一种带有黑色纹理的粉色宝石", // Description
                "&7被认为能促进爱情和情感愈合" // Additional lore
        );
        amethystStack = new SlimefunItemStack(
                "AMETHYST", // Item ID
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYzFkN2VlZjMzNzE1MzUxY2Y3MjJlYTM2M2FhOTkxNGExNmQ2NDExODFmNjc0ZGQ1OTJhODM2OGUyMWQ0M2I2YiJ9fX0=", // Material (example, change as needed)
                "&5紫水晶", // Display name
                "&7一种紫色宝石，具有舒缓的能量", // Description
                "&7与清晰和直觉相关联" // Additional lore
        );
        tanzaniteStack = new SlimefunItemStack(
                "TANZANITE", // Item ID
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNWY4ZDYzZTkwN2JkZmYyNTJhMDRlMGVhZWM5OGI1MmE4Nzk1OGQ3MzdkOGU0OGQ0MzE5ZmE1OTFjMzFkMGUzMSJ9fX0=", // Material (example, change as needed)
                "&b坦桑石", // Display name
                "&7一种罕见的蓝紫色宝石", // Description
                "&7仅能在坦桑尼亚发现" // Additional lore
        );
        sapphireStack = new SlimefunItemStack(
                "SAPPHIRE", // Item ID
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzllZjMzYTNlNzUzY2JhMjliNmMxMzRhMWJkNjc0MzhmNmQ2NjlmNmM0Yzc1NjI5MmNjMjBjMzEyMDkxMDUyOCJ9fX0=", // Material (example, change as needed)
                "&9蓝宝石", // Display name
                "&7一颗珍贵的蓝色宝石", // Description
                "&7与智慧和王权相关联" // Additional lore
        );
        kyaniteStack = new SlimefunItemStack(
                "KYANITE", // Item ID
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZTkxZWE0N2QwYTkxMmYwMjc2ODUyOGE4M2FlZTNmZTU3OTE3ODMyODgwOThiOTBlOWMwOGExZTBmN2VlNjY3OSJ9fX0=", // Material (example, change as needed)
                "&3蓝晶石", // Display name
                "&7一种蓝色矿物，常用于珠宝", // Description
                "&7因其镇静和平衡的特性而闻名" // Additional lore
        );
        turquoiseStack = new SlimefunItemStack(
                "TURQUOISE", // Item ID
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDhlYWNkYjA2OTRlZTEwYmEwYTk4NjZlZTQ5NTA5MDJmNGEzZGVkZTA3ODIwMWRlMDU3NjJkM2ZkZjI2M2NlMSJ9fX0=", // Material (example, change as needed)
                "&b绿松石", // Display name
                "&7因其颜色而珍贵的蓝绿色宝石", // Description
                "&7被认为能带来保护和好运" // Additional lore
        );
        emeraldStack = new SlimefunItemStack(
                "EMERALD", // Item ID
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYjczNTRiODc4ODQzYzcxZWE1MzA2ZmViM2RjOGI3NjdmNzY4Y2U2MDM5ZmEwZTViYjZmMjNhZDk4ZGFmNmM2ZiJ9fX0=", // Material (example, change as needed)
                "&a祖母绿", // Display name
                "&7一种罕见的绿色宝石", // Description
                "&7因其美丽和稀有而闻名" // Additional lore
        );
        peridotStack = new SlimefunItemStack(
                "PERIDOT", // Item ID
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZWUxZDRlOWNlMWYxNjg0Nzg2OTI3ZTEwZjU5Zjk2ZDNhNTZjNzkyZThhOWIzYzVjNmE3NDU2OGU1Mjk3YjU2NSJ9fX0=", // Material (example, change as needed)
                "&a橄榄石", // Display name
                "&7一种绿色宝石，通常在火山地区发现", // Description
                "&7象征着力量和保护" // Additional lore
        );
        topazStack = new SlimefunItemStack(
                "TOPAZ", // Item ID
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTU2NTJmMzcxNmQzOGQ4OTkxZTI4N2E4Y2JmN2YwNmU5ODI3OWE1MWFmODAwNTAzMDE4YmVjNzI1NDJkNjBjMyJ9fX0=", // Material (example, change as needed)
                "&e黄玉", // Display name
                "&7一种与积极相关的黄色宝石", // Description
                "&7象征着创造力和快乐" // Additional lore
        );
        citrineStack = new SlimefunItemStack(
                "CITRINE", // Item ID
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvYWFjNzIxMjhmMDcxMmFiYzM1ODgyNjg1ZjVkMDgxZTQ2YTRhZjNhYWJjNTMyYjMzNTQyODMwODBkZWU1OTA1ZCJ9fX0=", // Material (example, change as needed)
                "&6黄水晶", // Display name
                "&7一种与富足联系在一起的橙黄色宝石", // Description
                "&7被认为能吸引财富和成功" // Additional lore
        );
        garnetStack = new SlimefunItemStack(
                "GARNET", // Item ID
                "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMzcxZDcwOTY5NWJlNWM3ZTQ0ZDAyZTg2NDE2M2I2MTg1YzE0YmM5YjdiOGNiNWM0ODMwOWQzNjE3NWIxYjc1OCJ9fX0=", // Material (example, change as needed)
                "&c石榴石", // Display name
                "&7象征爱情和激情的深红色宝石", // Description
                "&7与力量和能量有关" // Additional lore
        );
        // Repeat the process for the other gemstones...
    }

    private void dropItem(Location location, ItemStack itemStack) {
        // Drop the item at the specified location
        Objects.requireNonNull(location.getWorld()).dropItem(location, itemStack);
    }
}
