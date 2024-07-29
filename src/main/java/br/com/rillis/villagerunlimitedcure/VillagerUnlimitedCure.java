package br.com.rillis.villagerunlimitedcure;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class VillagerUnlimitedCure extends JavaPlugin {

    public static JavaPlugin plugin;

    @Override
    public void onEnable() {
        System.out.println("[VillagerUnlimitedCure] Starting");
        plugin = this;

        Configuration config = new Configuration("config.yml", this);

        VillagerRegisterConfig.init(this, config.getString("prefix", false));
        VillagerCureConfig.init(this);

        registerEvents(new VillagerClickEvent(), new VillagerRespawnEvent());
    }

    @Override
    public void onDisable() {
        System.out.println("[VillagerUnlimitedCure] Shutdown");
    }

    private void registerEvents(Listener... listeners) {
        for (Listener listener : listeners) {
            getServer().getPluginManager().registerEvents(listener, this);
        }
    }
}
