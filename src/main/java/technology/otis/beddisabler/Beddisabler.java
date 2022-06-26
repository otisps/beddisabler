package technology.otis.beddisabler;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Beddisabler extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onInspectEvent(PlayerInteractEvent event){
        if(event.getAction().equals(Action.LEFT_CLICK_BLOCK)
        || event.getAction().equals(Action.LEFT_CLICK_AIR)
        || event.getAction().equals(Action.RIGHT_CLICK_AIR)){
            return;
        }

        if(event.getPlayer().getWorld().getTime() > 12541
        && event.getPlayer().getWorld().getTime() < 23458){
            event.getPlayer().sendMessage(event.getPlayer().getWorld().getTime() + "");
            return;
        }

        if(!(event.getPlayer().getWorld().getClearWeatherDuration() > 0)){
            return;
        }
        if(event.getClickedBlock() == null) {
            return;
        }
        Material block = event.getClickedBlock().getType();
        switch (block) {
            case BLACK_BED:
            case BLUE_BED:
            case BROWN_BED:
            case CYAN_BED:
            case GRAY_BED:
            case GREEN_BED:
            case LIGHT_BLUE_BED:
            case LIGHT_GRAY_BED:
            case LIME_BED:
            case MAGENTA_BED:
            case ORANGE_BED:
            case PINK_BED:
            case PURPLE_BED:
            case RED_BED:
            case WHITE_BED:
            case YELLOW_BED:
                event.setCancelled(true);
                return;
        }
    }
}
