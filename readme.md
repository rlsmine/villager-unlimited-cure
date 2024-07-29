# villager-unlimited-cure

Spigot plugin that allows villagers to be cured an unlimited amount of times to get discounts.<br>
<br>
Workaround to [Minecraft 1.20.2 patch](https://minecraft.fandom.com/wiki/Java_Edition_1.20.2#Mobs):
> The discount for curing a villager is no longer multiplied if the villager is reinfected and cured again.

Note: This method renames the villager to `Villager {ID}` to register the discounts. The UUID of a villager is changed when it is cured, so the discounts are lost. This prefix can be changed in the config file.
<br>*Renaming a villager (either by name tag or other plugins) while using this plugin is **HIGHLY NOT** recommended.*

Compatible with villager-global-price ([github](https://github.com/rlsmine/villager-global-price))

### Dependencies
- NBTAPI ([**spigotmc**](https://www.spigotmc.org/resources/nbt-api.7939/))

### Configuration
```yaml
prefix: "Villager {id}"
```

### Disclaimer
At this time, we **don't** have plans to update it to newer or older versions. Feel free to [fork](https://github.com/rlsmine/villager-unlimited-cure/fork) and update it.
<br>
<br>
Check our other plugins [**here**](https://github.com/orgs/rlsmine/repositories).<bR>
Made by [**rillis**](https://github.com/rillis).
