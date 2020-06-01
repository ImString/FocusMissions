package me.stringdev.focusmissions.inventory;

import com.massivecraft.factions.entity.MConf;
import me.stringdev.focusmissions.apis.ItemBuilder;
import me.stringdev.focusmissions.objects.RewardObject;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Inv {

    public static void open(Player p) {
        Inventory inv = Bukkit.createInventory(null, 9 * 4, "Missões de " + p.getName());

        inv.setItem(10, new ItemBuilder(Material.DIAMOND).setName("Missão").setLore("", " §7Missão: #1", "", "§fDesafio:", " §7Nesta missão você deve possuir os requisitos:", "§7 • x64 Diamantes.", "", " §7Clique com o botão esquerdo para finalizar.").build());

        if (!new RewardObject(p).getApis().isReward1()) {
            inv.setItem(11, new ItemBuilder(Material.BARRIER).setName("Missão").setLore("", " §7Finalize as missões anteriores").build());
        } else {
            inv.setItem(11, new ItemBuilder(Material.DIAMOND_AXE).setName("Missão").setLore("", " §7Missão: #2", "", "§fDesafio:", " §7Nesta missão você deve possuir os requisitos:", "§7 • Abata 30x jogadores.", "", " §7Clique com o botão esquerdo para finalizar.").build());
        }

        if (!new RewardObject(p).getApis().isReward2()) {
            inv.setItem(12, new ItemBuilder(Material.BARRIER).setName("Missão").setLore("", " §7Finalize as missões anteriores").build());
        } else {
            inv.setItem(12, new ItemBuilder(Material.DIAMOND_BARDING).setName("Missão").setLore("", " §7Missão: #3", "", "§fDesafio:", " §7Nesta missão você deve possuir os requisitos:", "§7 • Upe 100 níveis de escavação.", "", " §7Clique com o botão esquerdo para finalizar.").build());
        }

        if (!new RewardObject(p).getApis().isReward3()) {
            inv.setItem(13, new ItemBuilder(Material.BARRIER).setName("Missão").setLore("", " §7Finalize as missões anteriores").build());
        } else {
            inv.setItem(13, new ItemBuilder(Material.CARROT_ITEM).setName("Missão").setLore("", " §7Missão: #4", "", "§fDesafio:", " §7Nesta missão você deve possuir os requisitos:", "§7 • 100x Cenouras.", "", " §7Clique com o botão esquerdo para finalizar.").build());
        }

        if (!new RewardObject(p).getApis().isReward4()) {
            inv.setItem(14, new ItemBuilder(Material.BARRIER).setName("Missão").setLore("", " §7Finalize as missões anteriores").build());
        } else {
            inv.setItem(14, new ItemBuilder(Material.EXP_BOTTLE).setName("Missão").setLore("", " §7Missão: #5", "", "§fDesafio:", " §7Nesta missão você deve possuir os requisitos:", "§7 • Junte 150x níveis de XP.", "", " §7Clique com o botão esquerdo para finalizar.").build());
        }

        if (!new RewardObject(p).getApis().isReward5()) {
            inv.setItem(15, new ItemBuilder(Material.BARRIER).setName("Missão").setLore("", " §7Finalize as missões anteriores").build());
        } else {
            inv.setItem(15, new ItemBuilder(Material.DIAMOND_SWORD).setName("Missão").setLore("", " §7Missão: #6", "", "§fDesafio:", " §7Nesta missão você deve possuir os requisitos:", "§7 • Tenha um KDR acima de 10.0!", "", " §7Clique com o botão esquerdo para finalizar.").build());
        }

        if (!new RewardObject(p).getApis().isReward6()) {
            inv.setItem(16, new ItemBuilder(Material.BARRIER).setName("Missão").setLore("", " §7Finalize as missões anteriores").build());
        } else {
            inv.setItem(16, new ItemBuilder(Material.BEACON).setName("Missão").setLore("", " §7Missão: #7", "", "§fDesafio:", " §7Nesta missão você deve possuir os requisitos:", "§7 • Entregue um Beacon.", "", " §7Clique com o botão esquerdo para finalizar.").build());
        }

        if (!new RewardObject(p).getApis().isReward7()) {
            inv.setItem(19, new ItemBuilder(Material.BARRIER).setName("Missão").setLore("", " §7Finalize as missões anteriores").build());
        } else {
            inv.setItem(19, new ItemBuilder(Material.EMERALD).setName("Missão").setLore("", " §7Missão: #8", "", "§fDesafio:", " §7Nesta missão você deve possuir os requisitos:", "§7 • Esteja entre os 10 money top.", "", " §7Clique com o botão esquerdo para finalizar.").build());
        }

        if (!new RewardObject(p).getApis().isReward8()) {
            inv.setItem(20, new ItemBuilder(Material.BARRIER).setName("Missão").setLore("", " §7Finalize as missões anteriores").build());
        } else {
            inv.setItem(20, new ItemBuilder(Material.NETHER_STAR).setName("Missão").setLore("", " §7Missão: #9", "", "§fDesafio:", " §7Nesta missão você deve possuir os requisitos:", "§7 • Chegue ao maximo de poder (" + MConf.get().powerMax + ").", "", " §7Clique com o botão esquerdo para finalizar.").build());
        }

        if (!new RewardObject(p).getApis().isReward9()) {
            inv.setItem(21, new ItemBuilder(Material.BARRIER).setName("Missão").setLore("", " §7Finalize as missões anteriores").build());
        } else {
            inv.setItem(21, new ItemBuilder(Material.GOLDEN_APPLE).setName("Missão").setLore("", " §7Missão: #10", "", "§fDesafio:", " §7Nesta missão você deve possuir os requisitos:", "§7 • Consiga um total de 1000 leveis em skills.", "", " §7Clique com o botão esquerdo para finalizar.").build());
        }

        p.openInventory(inv);
    }
}
