package me.stringdev.focusmissions.command;

import com.massivecraft.factions.entity.MPlayer;
import me.stringdev.focusmissions.inventory.Inv;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MissionsCommand implements CommandExecutor {

    public boolean onCommand(CommandSender s, Command cmd, String lbl, String[] args) {
        if(!(s instanceof Player)){
            s.sendMessage("§cApenas jogadores podem fazer isto!");
            return true;
        }
        Player p = (Player)s;
        Inv.open(p);
        return true;
    }
}
