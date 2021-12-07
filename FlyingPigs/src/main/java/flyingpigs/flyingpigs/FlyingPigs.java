package flyingpigs.flyingpigs;

// Created & Updated on 12/5, Created Flying pig, cow, sheep, rabbit - Lisa Zhang
// Updated on 12/6 - Added Comments to further explain the functions - Lisa Zhang
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.entity.Entity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.LivingEntity;

//For a general source of the methods/classes/events, i used: https://hub.spigotmc.org/javadocs/bukkit/index.html
public final class FlyingPigs extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //Message to show that the plugin has been enabled correctly
        getLogger().info("HELLO! FlyingPigs Plugin has been enabled");
        getCommand("flyingpig").setExecutor(this);
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
        World w = player.getWorld();

        // If player is holding a pig spawn egg
        if (player.getInventory().getItemInMainHand().getType().equals(Material.PIG_SPAWN_EGG)) {
            // if the player is left clicking the air or a block
            if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {

                player.sendMessage("OINK");


                // Source code: https://bukkit.org/threads/spawning-a-mob-riding-another-mob.285532/
                // Changed the code from bat riding invisible slime to pig riding invisible bat
                // This would create an illusion that the pig is flying when it is only riding an invisible bat

                //Spawning and creating a bat object at the player's location
                LivingEntity bat = (LivingEntity) w.spawnEntity(playerlocation, EntityType.BAT);

                //spawning and creating a pig object
                Entity pig = w.spawnEntity(playerlocation, EntityType.PIG);

                //Making the pig ride the bat as a passenger
                bat.addPassenger(pig);

                //Add invisibility to bat
                bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000000, 1));

            }  }

        //Flying cows: similar code to flying pigs
        if (player.getInventory().getItemInMainHand().getType().equals(Material.COW_SPAWN_EGG)) {
            // if the player is left clicking the air or a block
            if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {

                player.sendMessage("MOO");

                //Spawning and creating a bat object at the player's location
                LivingEntity bat = (LivingEntity) w.spawnEntity(playerlocation, EntityType.BAT);

                //spawning and creating a cow object
                Entity cow = w.spawnEntity(playerlocation, EntityType.COW);

                //Making the cow ride the bat as a passenger
                bat.addPassenger(cow);

                //Add invisibility to bat
                bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000000, 1));

            }  }
        if (player.getInventory().getItemInMainHand().getType().equals(Material.RABBIT_SPAWN_EGG)) {
            // if the player is left clicking the air or a block
            if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {

                player.sendMessage("HOP");


                //Spawning and creating a bat object at the player's location
                LivingEntity bat = (LivingEntity) w.spawnEntity(playerlocation, EntityType.BAT);

                //spawning and creating a rabbit object
                Entity rabbit = w.spawnEntity(playerlocation, EntityType.RABBIT);

                //Making the rabbit ride the bat as a passenger
                bat.addPassenger(rabbit);

                //Add invisibility to bat
                bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000000, 1));

            }  }
        if (player.getInventory().getItemInMainHand().getType().equals(Material.SHEEP_SPAWN_EGG)) {
            // if the player is left clicking the air or a block
            if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {

                player.sendMessage("BAA");

                //Spawning and creating a bat object at the player's location
                LivingEntity bat = (LivingEntity) w.spawnEntity(playerlocation, EntityType.BAT);

                //spawning and creating a sheep object
                Entity sheep = w.spawnEntity(playerlocation, EntityType.SHEEP);

                //Making the sheep ride the bat as a passenger
                bat.addPassenger(sheep);

                //Add invisibility to bat
                bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000000, 1));

            }  }
        if (player.getInventory().getItemInMainHand().getType().equals(Material.VILLAGER_SPAWN_EGG)) {
            // if the player is left clicking the air or a block
            if(event.getAction().equals(Action.LEFT_CLICK_AIR) || event.getAction().equals(Action.LEFT_CLICK_BLOCK)) {

                player.sendMessage("VILLAGER");

                //Spawning and creating a bat object at the player's location
                LivingEntity bat = (LivingEntity) w.spawnEntity(playerlocation, EntityType.BAT);

                //spawning and creating a villager object
                Entity villager = w.spawnEntity(playerlocation, EntityType.VILLAGER);

                //Making the villager ride the bat as a passenger
                bat.addPassenger(villager);

                //Add invisibility to bat
                bat.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 1000000000, 1));

            }  }



    }}


