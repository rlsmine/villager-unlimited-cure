package br.com.rillis.villagerunlimitedcure;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class VillagerRespawnEvent implements Listener {
    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (event.getEntityType() == EntityType.VILLAGER && event.getSpawnReason() == CreatureSpawnEvent.SpawnReason.CURED) {
            Entity e = event.getEntity();
            VillagerCureConfig.addVillagerCured(e, 1);
            UnlimitedCure.refreshVillager(e);
        }
    }
}
