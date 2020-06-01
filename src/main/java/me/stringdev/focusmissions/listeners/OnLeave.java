package me.stringdev.focusmissions.listeners;

import me.stringdev.focusmissions.Main;
import me.stringdev.focusmissions.objects.Querys;
import me.stringdev.focusmissions.objects.RewardObject;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class OnLeave implements Listener {

    @EventHandler
    public void onQuitEvent(PlayerQuitEvent e) {
        Player p = (Player) e.getPlayer();
        RewardObject rewardObject = new RewardObject(p);
        Querys q = new Querys(p.getName());

        if (rewardObject.getApis().isReward1()) {
            if (Main.firstDb.contains(p.getName())) {
                q.updateReward1(rewardObject.getApis().isReward1());
                q.updateReward2(rewardObject.getApis().isReward2());
                q.updateReward3(rewardObject.getApis().isReward3());
                q.updateReward4(rewardObject.getApis().isReward4());
                q.updateReward5(rewardObject.getApis().isReward5());
                q.updateReward6(rewardObject.getApis().isReward6());
                q.updateReward7(rewardObject.getApis().isReward7());
                q.updateReward8(rewardObject.getApis().isReward8());
                q.updateReward9(rewardObject.getApis().isReward9());
                q.updateReward10(rewardObject.getApis().isReward10());
            } else {
                q.create(rewardObject.getApis());
                q.updateReward1(rewardObject.getApis().isReward1());
                q.updateReward2(rewardObject.getApis().isReward2());
                q.updateReward3(rewardObject.getApis().isReward3());
                q.updateReward4(rewardObject.getApis().isReward4());
                q.updateReward5(rewardObject.getApis().isReward5());
                q.updateReward6(rewardObject.getApis().isReward6());
                q.updateReward7(rewardObject.getApis().isReward7());
                q.updateReward8(rewardObject.getApis().isReward8());
                q.updateReward9(rewardObject.getApis().isReward9());
                q.updateReward10(rewardObject.getApis().isReward10());
                Main.firstDb.add(p.getName());
            }
        }
    }
}