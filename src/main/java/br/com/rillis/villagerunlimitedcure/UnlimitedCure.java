package br.com.rillis.villagerunlimitedcure;

import de.tr7zw.nbtapi.NBT;
import de.tr7zw.nbtapi.iface.ReadWriteNBTCompoundList;
import de.tr7zw.nbtapi.iface.ReadableNBT;
import org.bukkit.entity.Entity;

public class UnlimitedCure {
    public static void refreshVillager(Entity e){
        String uuid = VillagerRegisterConfig.getUUID(e);
        if(uuid.equals("unregistred")) return;
        NBT.modify(e, nbt -> {
            ReadWriteNBTCompoundList x = nbt.getCompoundList("Gossips");
            for (int i = 0; i < x.size(); i++) {
                ReadableNBT gossip = x.get(i);
                String type_str = gossip.getString("Type");
                if (type_str.equals("major_positive")) {
                    x.get(i).setInteger("Value", Math.min(VillagerCureConfig.getVillagerCuredAmount(e)*20, 100));
                }
                if (type_str.equals("minor_positive")) {
                    x.get(i).setInteger("Value", Math.min(VillagerCureConfig.getVillagerCuredAmount(e)*25, 100));
                }
            }
        });
    }


}
