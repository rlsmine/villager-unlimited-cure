package br.com.rillis.villagerunlimitedcure;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class VillagerRegisterConfig {
    private static FileConfiguration config = null;
    private static final String file_name = "villagers.yml";

    private static JavaPlugin plugin;

    private static String prefix;

    public static void init(JavaPlugin active_plugin, String prefix_cfg){
        prefix = prefix_cfg;
        plugin = active_plugin;
        File config_file = new File(plugin.getDataFolder(), file_name);
        if (!config_file.exists()) {
            config_file.getParentFile().mkdirs();
            plugin.saveResource(file_name, false);
        }
        config = YamlConfiguration.loadConfiguration(config_file);
    }

    public static void markUUID(Entity e) {
        if(e.getCustomName() == null || e.getCustomName().isEmpty()){
            e.setCustomName(register(e));
            e.setCustomNameVisible(false);
        }
    }

    public static String getUUID(Entity e) {
        if(e.getCustomName() == null || e.getCustomName().isEmpty()){
            return "unregistred";
        }
        return e.getCustomName();
    }

    public static void refresh(){
        config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), file_name));
    }

    public static void saveConfig() {
        try {
            config.save(new File(plugin.getDataFolder(), file_name));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int getLast(){
        return config.getInt("last");
    }

    public static String register(Entity e){
        refresh();
        config.set("last", getLast()+1);
        String name = prefix.replace("{id}", String.valueOf(getLast()));
        config.set(name, e.getUniqueId().toString());
        saveConfig();
        return name;
    }
}
