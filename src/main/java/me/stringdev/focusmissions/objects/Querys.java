package me.stringdev.focusmissions.objects;

import me.stringdev.focusmissions.apis.MySQL;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Querys {

    private String player;

    public Querys(String player){
        this.player = player;
    }

    public void updateReward1(boolean value){
        PreparedStatement stm = null;
        try{
            stm = MySQL.con.prepareStatement("UPDATE `fcmissions_rewards` SET `reward1` = ? WHERE `Player` = ?");
            stm.setInt(1, value ? 1 : 0);
            stm.setString(2, player);
            stm.executeUpdate();
        }catch (SQLException e) {
        }
    }

    public void updateReward2(boolean value){
        PreparedStatement stm = null;
        try{
            stm = MySQL.con.prepareStatement("UPDATE `fcmissions_rewards` SET `reward2` = ? WHERE `Player` = ?");
            stm.setInt(1, value ? 1 : 0);
            stm.setString(2, player);
            stm.executeUpdate();
        }catch (SQLException e) {
        }
    }

    public void updateReward3(boolean value){
        PreparedStatement stm = null;
        try{
            stm = MySQL.con.prepareStatement("UPDATE `fcmissions_rewards` SET `reward3` = ? WHERE `Player` = ?");
            stm.setInt(1, value ? 1 : 0);
            stm.setString(2, player);
            stm.executeUpdate();
        }catch (SQLException e) {
        }
    }

    public void updateReward4(boolean value){
        PreparedStatement stm = null;
        try{
            stm = MySQL.con.prepareStatement("UPDATE `fcmissions_rewards` SET `reward4` = ? WHERE `Player` = ?");
            stm.setInt(1, value ? 1 : 0);
            stm.setString(2, player);
            stm.executeUpdate();
        }catch (SQLException e) {
        }
    }

    public void updateReward5(boolean value){
        PreparedStatement stm = null;
        try{
            stm = MySQL.con.prepareStatement("UPDATE `fcmissions_rewards` SET `reward5` = ? WHERE `Player` = ?");
            stm.setInt(1, value ? 1 : 0);
            stm.setString(2, player);
            stm.executeUpdate();
        }catch (SQLException e) {
        }
    }

    public void updateReward6(boolean value){
        PreparedStatement stm = null;
        try{
            stm = MySQL.con.prepareStatement("UPDATE `fcmissions_rewards` SET `reward6` = ? WHERE `Player` = ?");
            stm.setInt(1, value ? 1 : 0);
            stm.setString(2, player);
            stm.executeUpdate();
        }catch (SQLException e) {
        }
    }

    public void updateReward7(boolean value){
        PreparedStatement stm = null;
        try{
            stm = MySQL.con.prepareStatement("UPDATE `fcmissions_rewards` SET `reward7` = ? WHERE `Player` = ?");
            stm.setInt(1, value ? 1 : 0);
            stm.setString(2, player);
            stm.executeUpdate();
        }catch (SQLException e) {
        }
    }

    public void updateReward8(boolean value){
        PreparedStatement stm = null;
        try{
            stm = MySQL.con.prepareStatement("UPDATE `fcmissions_rewards` SET `reward8` = ? WHERE `Player` = ?");
            stm.setInt(1, value ? 1 : 0);
            stm.setString(2, player);
            stm.executeUpdate();
        }catch (SQLException e) {
        }
    }

    public void updateReward9(boolean value){
        PreparedStatement stm = null;
        try{
            stm = MySQL.con.prepareStatement("UPDATE `fcmissions_rewards` SET `reward9` = ? WHERE `Player` = ?");
            stm.setInt(1, value ? 1 : 0);
            stm.setString(2, player);
            stm.executeUpdate();
        }catch (SQLException e) {
        }
    }

    public void updateReward10(boolean value){
        PreparedStatement stm = null;
        try{
            stm = MySQL.con.prepareStatement("UPDATE `fcmissions_rewards` SET `reward10` = ? WHERE `Player` = ?");
            stm.setInt(1, value ? 1 : 0);
            stm.setString(2, player);
            stm.executeUpdate();
        }catch (SQLException e) {
        }
    }

    public void create(RewardAPI rewardAPI){
        PreparedStatement stm = null;
        try{
            stm = MySQL.con.prepareStatement("INSERT INTO `fcmissions_rewards` (`Player`, `reward1`, `reward2`, `reward3`, `reward4`, `reward5`, `reward6`, `reward7`, `reward8`, `reward9`, `reward10`) VALUES (?, '0', '0', '0', '0', '0', '0', '0', '0', '0', '0');");
            stm.setString(1, player);
            stm.executeUpdate();
        }catch (SQLException e) {
        }
    }
}
