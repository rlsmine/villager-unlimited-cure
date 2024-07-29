package br.com.rillis.villagerunlimitedcure;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Configuration {
    private File file;
    private FileConfiguration cfg;
    JavaPlugin plugin;

    public Configuration(String file_name, JavaPlugin plugin){
        this.plugin = plugin;
        this.file = new File(plugin.getDataFolder(), file_name);
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            plugin.saveResource(file_name, false);
        }
        this.cfg = YamlConfiguration.loadConfiguration(file);
    }

    private void save() {
        try {
            cfg.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void refresh(){
        cfg = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), file.getName()));
    }

    public void set(String key, Object value){
        cfg.set(key, value);
        save();
    }

    public String getString(String key, boolean refresh){
        if(refresh) refresh();
        return cfg.getString(key);
    }

    public int getInt(String key, boolean refresh){
        if(refresh) refresh();
        return cfg.getInt(key);
    }

    public boolean getBoolean(String key, boolean refresh){
        if(refresh) refresh();
        return cfg.getBoolean(key);
    }

    public double getDouble(String key, boolean refresh){
        if(refresh) refresh();
        return cfg.getDouble(key);
    }

    public Object get(String key, boolean refresh){
        if(refresh) refresh();
        return cfg.get(key);
    }

}
