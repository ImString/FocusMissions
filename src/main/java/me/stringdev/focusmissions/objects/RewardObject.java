package me.stringdev.focusmissions.objects;

import me.stringdev.focusmissions.Main;
import me.stringdev.focusmissions.apis.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class RewardObject {

    private String player;
    public static HashMap<String, RewardAPI> rewardAPIS = new HashMap<String, RewardAPI>();

    public RewardObject(String player) {
        this.player = player;
    }

    public RewardObject(Player player) {
        this.player = player.getName();
    }

    public void loadAll() {
        PreparedStatement stm = null;
        try {
            stm = MySQL.con.prepareStatement("SELECT * FROM `fcmissions_rewards`");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String player = rs.getString("Player");

                Main.firstDb.add(player);
                Main.db.add(player);
            }
        } catch (SQLException e) {
            Bukkit.getConsoleSender().sendMessage("[FocusMissions] Erro ao pegar os parametros do player: " + player);
        }
    }

    public void load() {
        if (Main.db.contains(player)) {
            PreparedStatement stm = null;
            try {
                stm = MySQL.con.prepareStatement("SELECT * FROM `fcmissions_rewards`");
                ResultSet rs = stm.executeQuery();
                while (rs.next()) {
                    String player = rs.getString("Player");
                    int reward1 = rs.getInt("reward1");
                    int reward2 = rs.getInt("reward2");
                    int reward3 = rs.getInt("reward3");
                    int reward4 = rs.getInt("reward4");
                    int reward5 = rs.getInt("reward5");
                    int reward6 = rs.getInt("reward6");
                    int reward7 = rs.getInt("reward7");
                    int reward8 = rs.getInt("reward8");
                    int reward9 = rs.getInt("reward9");
                    int reward10 = rs.getInt("reward10");

                    rewardAPIS.put(player, new RewardAPI(player, reward1, reward2, reward3, reward4, reward5, reward6, reward7, reward8, reward9, reward10));
                }
            } catch (SQLException er) {
                Bukkit.getConsoleSender().sendMessage("[FocusMissions] Erro ao pegar os parametros do player: " + player);
            }
        } else {
            rewardAPIS.put(player, new RewardAPI(player, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
            Main.db.add(player);
        }
    }

    public RewardAPI getApis() {
        return rewardAPIS.get(player);
    }

    public boolean exist() {
        return Main.db.contains(player);
    }
}
