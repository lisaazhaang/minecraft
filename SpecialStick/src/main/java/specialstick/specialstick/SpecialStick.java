package specialstick.specialstick;
// Created 12/04 - Only set up the interact events. Seems to work on right click - Lisa Zhang
// Last updated 12/05 - Set up the switch statements and their respective effect/event that follows- Lisa Zhang
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.EntityType;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.Random;
import org.bukkit.event.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionEffect;
import java.util.Set;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;

// Many of the specific commands/methods/classes I referenced are from here: https://hub.spigotmc.org/javadocs/bukkit/
public final class SpecialStick extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        // Plugin startup logic. It tells you if it is enabled or not
        getLogger().info("HELLO! SpecialStick Plugin has been enabled");
        getCommand("specsword").setExecutor(this);
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {


        Player player = event.getPlayer();
        Action action = event.getAction();
        Location playerlocation = player.getLocation();
        Random rand = new Random();

        // If the player is holding a wooden sword
        if (player.getInventory().getItemInMainHand().getType().equals(Material.WOODEN_SWORD)) {
            // if the player is left clicking the air or a block
            if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)){
                player.sendMessage("You activated the special sword");
                int numb = rand.nextInt(20);
                World w = player.getWorld();

                switch (numb+1){
                    // It causes a lightning strike
                    // Source of code: https://bukkit.fandom.com/wiki/Plugin_Tutorial_(Eclipse) USED: player.getWorld().strikeLightning(player.getTargetBlock((Set<Material>) null, 200).getLocation());
                    //Changed distance
                    case 1: player.getWorld().strikeLightning(player.getTargetBlock((Set<Material>) null, 100).getLocation());
                        player.sendMessage("Lightning");
                    break;
                        //it kills the player
                    case 2:  player.setHealth(0.0D);
                        player.sendMessage("Dead");
                        break;
                        //it causes the player to catch on fire
                    case 3:  player.setFireTicks(2000);
                        player.sendMessage("Fire");
                        break;
                        // it creates an explosion
                    case 4: w.createExplosion(player.getLocation(), 5);
                        player.sendMessage("BOOM");
                        break;
                        //it spawns a pig
                    case 5: player.getWorld().spawnEntity(player.getLocation(), EntityType.PIG);
                        player.sendMessage("PIG");
                        break;
                        //it causes a Fire Resistance potion effect on the player
                    case 6: player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 600, 1));
                        player.sendMessage("Fire Resist Potion");
                        break;
                        //It adds an egg to the inventory
                    case 7: player.getInventory().addItem(new ItemStack(Material.EGG));
                        player.sendMessage("Egg");
                        break;
                        //It sends a message to the chat
                    case 8: player.sendMessage("HELLO!");
                        break;
                        //It teleports a player 50 blocks
                    case 9:
                        Location playerloc = player.getLocation();
                        Location loc = playerloc.add(50, 0, 0);
                        player.teleport(loc);
                        player.sendMessage("Teleport");
                        break;
                        //It gives the player exp levels
                    case 10: player.giveExp(20);
                        player.sendMessage("EXP");
                        break;
                        //Sets player's health to 10 (5 hearts)
                    case 11: player.setHealth(10);
                        player.sendMessage("5 health");
                        break;
                        //Spawns a diamond block above them
                    case 12:

                        playerlocation = playerlocation.add(1, 2, 0);
                        player.getWorld().getBlockAt(playerlocation).setType(Material.DIAMOND_BLOCK);
                        player.sendMessage("DIAMOND");
                        break;
                        //Spawns a zombie at player's location
                    case 13: player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                        player.sendMessage("Zombie");
                        break;
                        //Poison effect to Player
                    case 14:
                        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 1));
                        player.sendMessage("Poison");
                        break;
                        //Gives player super speed
                    case 15: player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600, 1));
                        player.sendMessage("Super speed");
                    break;
                        //Sets player's health to only half a heart
                    case 16: player.setHealth(1);
                        player.sendMessage("Half a heart");
                        break;
                        //Spawns a wolf
                    case 17: player.getWorld().spawnEntity(player.getLocation(), EntityType.WOLF);
                        player.sendMessage("Wolf");
                        break;
                        //Gives the player a wither skull in their inventory
                    case 18: player.getInventory().addItem(new ItemStack(Material.WITHER_SKELETON_SKULL));
                        player.sendMessage("Wither Skull");
                        break;
                        //Spawns a cake below the player
                    case 19:
                        player.getWorld().getBlockAt(playerlocation).setType(Material.CAKE);
                        player.sendMessage("Cake");
                        break;
                        // Spawns the player very high in the air
                    case 20:
                        playerlocation = playerlocation.add(0, 1000, 0);
                        player.teleport(playerlocation);
                        player.sendMessage("Hello up there!");
                        break;



                }
            }
        }



    }}
