package me.stringdev.focusmissions.listeners;

import com.iresett.economy.api.EconomyAPI;
import me.stringdev.focusmissions.Main;
import me.stringdev.focusmissions.apis.ItemBuilder;
import me.stringdev.focusmissions.objects.MissionsAPI;
import me.stringdev.focusmissions.objects.RewardObject;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryAction;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ClickInventory implements Listener {

    @EventHandler
    public void onClickInventoryEvent(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player) {
            if (e.getInventory().getTitle().contains(" ")) {
                if (e.getInventory().getTitle().split(" ")[0].equalsIgnoreCase("Missões") &&
                        e.getInventory().getTitle().split(" ")[1].equalsIgnoreCase("de")) {
                    if (e.isRightClick()) {
                        Player p = (Player) e.getWhoClicked();
                        if (e.getCurrentItem() == null) {
                            return;
                        }

                        if (e.getCurrentItem().getType() == Material.AIR) {
                            return;
                        }

                        if(e.getCurrentItem().getType() == Material.BARRIER){
                            return;
                        }

                        MissionsAPI missionsAPI = new MissionsAPI(p);
                        RewardObject rewardObject = new RewardObject(p);
                        switch (e.getSlot()) {
                            case 10:
                                if (rewardObject.getApis().isReward1()) {
                                    return;
                                }

                                if (!missionsAPI.hasItem(Material.DIAMOND, 64)) {
                                    p.sendMessage("§cVocê não tem os requisitos suficientes para completar esta missão.");
                                    return;
                                }

                                rewardObject.getApis().setReward1(true);
                                p.closeInventory();
                                p.sendMessage("§eYaa! Você acabou de completar a missão de número §71.");
                                p.sendMessage("§aVocê recebeu uma picareta de diamante.");
                                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.DIAMOND, 64)});
                                p.updateInventory();
                                p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_PICKAXE).setLore("", "§eItem exclusivo de Missões").addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.DIG_SPEED, 5).addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3).build());
                                break;
                            case 11:
                                if (rewardObject.getApis().isReward2()) {
                                    return;
                                }

                                if (missionsAPI.getKills() < 30) {
                                    p.sendMessage("§cVocê não tem os requisitos suficientes para completar esta missão.");
                                    p.sendMessage("§cVocê possui apenas §4" + missionsAPI.getKills() + " §cabates.");
                                    return;
                                }

                                rewardObject.getApis().setReward2(true);
                                p.closeInventory();
                                p.sendMessage("§eYaa! Você acabou de completar a missão de número §72.");
                                p.sendMessage("§aVocê recebeu um item para resetar seu KDR.");
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.config.getString("Commands.KDR").replace("${player}", p.getName()));
                                break;
                            case 12:
                                if (rewardObject.getApis().isReward3()) {
                                    return;
                                }

                                if (missionsAPI.getExcavation() < 100) {
                                    p.sendMessage("§cVocê não tem os requisitos suficientes para completar esta missão.");
                                    p.sendMessage("§cVocê possui apenas §4" + missionsAPI.getExcavation() + " §cleveis.");
                                    return;
                                }

                                rewardObject.getApis().setReward3(true);
                                p.closeInventory();
                                p.sendMessage("§eYaa! Você acabou de completar a missão de número §73.");
                                p.sendMessage("§aVocê recebeu um booster.");
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.config.getString("Commands.Booster").replace("${player}", p.getName()));
                                break;
                            case 13:
                                if (rewardObject.getApis().isReward4()) {
                                    return;
                                }

                                if (!missionsAPI.hasItem(Material.CARROT_ITEM, 100)) {
                                    p.sendMessage("§cVocê não tem os requisitos suficientes para completar esta missão.");
                                    return;
                                }

                                rewardObject.getApis().setReward4(true);
                                p.closeInventory();
                                p.sendMessage("§eYaa! Você acabou de completar a missão de número §74.");
                                p.sendMessage("§aVocê recebeu §2$250.000 §amil moedas.");
                                EconomyAPI.giveMoney(p.getName(), 250000);
                                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.CARROT_ITEM, 100)});
                                p.updateInventory();
                                break;
                            case 14:
                                if (rewardObject.getApis().isReward5()) {
                                    return;
                                }

                                if (missionsAPI.getXp() < 150) {
                                    p.sendMessage("§cVocê não tem os requisitos suficientes para completar esta missão.");
                                    p.sendMessage("§cVocê possui apenas §4" + missionsAPI.getXp() + " §cxp.");
                                    return;
                                }

                                rewardObject.getApis().setReward5(true);
                                p.closeInventory();
                                p.sendMessage("§eYaa! Você acabou de completar a missão de número §75§e.");
                                p.sendMessage("§aVocê recebeu mais x100 níveis de XP.");
                                p.setTotalExperience(p.getLevel() + 100);
                                break;
                            case 15:
                                if (rewardObject.getApis().isReward6()) {
                                    return;
                                }

                                if (missionsAPI.getKDR() < 10) {
                                    p.sendMessage("§cVocê não tem os requisitos suficientes para completar esta missão.");
                                    p.sendMessage("§cVocê possui apenas §4" + missionsAPI.getKDR() + " §cde KDR.");
                                    return;
                                }

                                rewardObject.getApis().setReward6(true);
                                p.closeInventory();
                                p.sendMessage("§eYaa! Você acabou de completar a missão de número §76§e.");
                                p.sendMessage("§aVocê recebeu uma espada de Diamante.");
                                p.getInventory().addItem(new ItemBuilder(Material.DIAMOND_SWORD).setLore("", "§eItem exclusivo de Missões", "").addEnchant(Enchantment.DAMAGE_ALL, 6).addEnchant(Enchantment.DURABILITY, 3).addEnchant(Enchantment.FIRE_ASPECT, 2).build());
                                break;
                            case 16:
                                if (rewardObject.getApis().isReward7()) {
                                    return;
                                }

                                if (!missionsAPI.hasItem(Material.BEACON, 1)) {
                                    p.sendMessage("§cVocê não tem os requisitos suficientes para completar esta missão.");
                                    return;
                                }

                                rewardObject.getApis().setReward7(true);
                                p.closeInventory();
                                p.sendMessage("§eYaa! Você acabou de completar a missão de número §77§e.");
                                p.sendMessage("§aVocê recebeu 100k de cash.");
                                p.getInventory().removeItem(new ItemStack[]{new ItemStack(Material.BEACON, 1)});
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.config.getString("Commands.Cash").replace("${player}", p.getName()));
                                break;
                            case 19:
                                if (rewardObject.getApis().isReward8()) {
                                    return;
                                }

                                if (!missionsAPI.isMoneyTop()) {
                                    p.sendMessage("§cVocê não tem os requisitos suficientes para completar esta missão.");
                                    return;
                                }

                                rewardObject.getApis().setReward8(true);
                                p.closeInventory();
                                p.sendMessage("§eYaa! Você acabou de completar a missão de número §78§e.");
                                p.sendMessage("§aVocê recebeu mais x20 lançadores.");
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.config.getString("Commands.Lancador").replace("${player}", p.getName()));
                                break;
                            case 20:
                                if (rewardObject.getApis().isReward9()) {
                                    return;
                                }

                                if (missionsAPI.getPowerMax() == missionsAPI.getPower()) {
                                    p.sendMessage("§cVocê não tem os requisitos suficientes para completar esta missão.");
                                    p.sendMessage("§cVocê possui apenas §4" + missionsAPI.getPower() + " §cde Poder.");
                                    return;
                                }

                                rewardObject.getApis().setReward9(true);
                                p.closeInventory();
                                p.sendMessage("§eYaa! Você acabou de completar a missão de número §79§e.");
                                p.sendMessage("§aVocê recebeu mais x15 armadilhas.");
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.config.getString("Commands.Armadilha").replace("${player}", p.getName()));
                                break;
                            case 21:
                                if (rewardObject.getApis().isReward10()) {
                                    return;
                                }

                                if (missionsAPI.getTotalHability() < 1000) {
                                    p.sendMessage("§cVocê não tem os requisitos suficientes para completar esta missão.");
                                    p.sendMessage("§cVocê possui apenas §4" + missionsAPI.getTotalHability() + " §cde total de Habilidades.");
                                    return;
                                }

                                rewardObject.getApis().setReward10(true);
                                p.closeInventory();
                                p.sendMessage("§eYaa! Você acabou de completar a missão de número §710§e.");
                                p.sendMessage("§aVocê recebeu um VIP Nobre.");
                                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), Main.config.getString("Commands.VIP").replace("${player}", p.getName()));
                                break;
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onClickInventoryEvent2(InventoryClickEvent e) {
        if (e.getWhoClicked() instanceof Player) {
            Player p = (Player) e.getWhoClicked();

            if (e.getInventory().getTitle().contains(" ")) {
                if (e.getInventory().getTitle().split(" ")[0].equalsIgnoreCase("Missões") &&
                        e.getInventory().getTitle().split(" ")[1].equalsIgnoreCase("de")) {
                    if (e.getCurrentItem() == null) {
                        return;
                    }

                    if (e.getCurrentItem().getType() == Material.AIR) {
                        return;
                    }

                    e.setCancelled(true);
                }
            }
        }
    }
}
