package me.stringdev.focusmissions;

import me.stringdev.focusmissions.apis.Config;
import me.stringdev.focusmissions.apis.MySQL;
import me.stringdev.focusmissions.command.MissionsCommand;
import me.stringdev.focusmissions.listeners.ClickInventory;
import me.stringdev.focusmissions.listeners.OnJoin;
import me.stringdev.focusmissions.listeners.OnLeave;
import me.stringdev.focusmissions.objects.Querys;
import me.stringdev.focusmissions.objects.RewardAPI;
import me.stringdev.focusmissions.objects.RewardObject;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    public static ArrayList<String> firstDb = new ArrayList<String>();
    public static ArrayList<String> db = new ArrayList<String>();
    public static Main instance;
    public static Config config;

    @Override
    public void onEnable() {
        instance = this;

        config = new Config("config.yml");
        if(!config.exists()){
            config.saveDefaultConfig();
        }

        MySQL.openConnection();
        new RewardObject("").loadAll();
        getCommand("missoes").setExecutor(new MissionsCommand());
        Bukkit.getPluginManager().registerEvents(new OnJoin(), this);
        Bukkit.getPluginManager().registerEvents(new OnLeave(), this);
        Bukkit.getPluginManager().registerEvents(new ClickInventory(), this);
    }

    @Override
    public void onDisable() {
        for(RewardAPI rewardAPI : RewardObject.rewardAPIS.values()){
            String p = rewardAPI.getPlayer();
            RewardObject rewardObject = new RewardObject(p);
            Querys q = new Querys(p);
            if (rewardObject.getApis().isReward1()) {
                if (firstDb.contains(p)) {
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
                }
            }
        }
    }
}