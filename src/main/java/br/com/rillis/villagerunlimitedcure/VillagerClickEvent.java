package br.com.rillis.villagerunlimitedcure;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class VillagerClickEvent implements Listener {
    @EventHandler
    public void onRightClickVillager(PlayerInteractAtEntityEvent event) {
        if(event.getRightClicked().getType().equals(EntityType.VILLAGER)){
            Entity entity = event.getRightClicked();
            VillagerRegisterConfig.markUUID(entity);
            UnlimitedCure.refreshVillager(entity);
        }
    }
}
