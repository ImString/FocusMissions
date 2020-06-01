package me.stringdev.focusmissions.listeners;

import me.stringdev.focusmissions.objects.RewardObject;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent e){
        RewardObject rewardObject = new RewardObject(e.getPlayer());

        rewardObject.load();
    }
}
