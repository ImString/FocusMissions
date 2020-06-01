package me.stringdev.focusmissions.objects;

import com.gmail.nossr50.api.ExperienceAPI;
import com.gmail.nossr50.datatypes.skills.SkillType;
import com.iresett.economy.Main;
import com.iresett.economy.api.EconomyAPI;
import com.massivecraft.factions.entity.MConf;
import com.massivecraft.factions.entity.MPlayer;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class MissionsAPI {

    private Player player;

    public MissionsAPI(Player player) {
        this.player = player;
    }

    public int getKills() {
        return player.getStatistic(Statistic.PLAYER_KILLS);
    }

    public float getXp() {
        return player.getLevel();
    }

    public int getExcavation() {
        return ExperienceAPI.getLevel(player, SkillType.EXCAVATION.getName());
    }

    public int getTotalHability() {
        return ExperienceAPI.getPowerLevel(player);
    }

    public double getKDR() {
        MPlayer mp = MPlayer.get(player);
        return mp.getKdr();
    }

    public boolean hasItem(Material item) {
        boolean val = false;
        for (ItemStack inv : player.getInventory().getContents()) {
            if (inv != null) {
                if (inv.getType() == item) {
                    val = true;
                    break;
                }
            }
        }
        return val;
    }

    public boolean hasItem(Material item, int amount) {
        boolean val = false;
        for (ItemStack inv : player.getInventory().getContents()) {
            if (inv != null) {
                if (player.getInventory().containsAtLeast(new ItemStack(item), amount)) {
                    if (inv.getType() == item) {
                        val = true;
                        break;
                    }
                }
            }
        }
        return val;
    }

    public boolean isMoneyTop() {
        boolean val = false;
        for(int i = 0; i <= 10; i++) {
            if(Main.getMoneyCore().getTopList().get(i).getPlayer().equalsIgnoreCase(player.getName())){
                val = true;
                break;
            }
        }
        return val;
    }

    public double getPower(){
        return MPlayer.get(player).getPower();
    }

    public double getPowerMax(){
        return MConf.get().powerMax;
    }
}
