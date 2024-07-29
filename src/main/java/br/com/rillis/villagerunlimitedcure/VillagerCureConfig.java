package br.com.rillis.villagerunlimitedcure;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class VillagerCureConfig {
    private static FileConfiguration config = null;
    private static final String file_name = "villagers_cured.yml";

    private static JavaPlugin plugin;

    public static void init(JavaPlugin active_plugin){
        plugin = active_plugin;
        File config_file = new File(plugin.getDataFolder(), file_name);
        if (!config_file.exists()) {
            config_file.getParentFile().mkdirs();
            plugin.saveResource(file_name, false);
        }
        config = YamlConfiguration.loadConfiguration(config_file);
    }

    private static void saveConfig() {
        try {
            config.save(new File(plugin.getDataFolder(), file_name));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void refresh(){
        config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), file_name));
    }

    public static int getVillagerCuredAmount(Entity e){
        refresh();
        return config.getInt(VillagerRegisterConfig.getUUID(e));
    }

    public static void addVillagerCured(Entity e, int i){
        refresh();
        String uuid = VillagerRegisterConfig.getUUID(e);
        if(config.contains(uuid)){
            config.set(uuid, config.getInt(uuid)+i);
        }else{
            config.set(uuid, i);
        }
        saveConfig();
    }
}
