package me.stringdev.focusmissions.apis;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {

	private ItemStack is;

	public ItemBuilder(Material m) {
		this(m, 1);
	}

	public ItemBuilder(ItemStack is) {
		this.is = is;
	}

	public ItemBuilder(Material m, int quantia) {
		is = new ItemStack(m, quantia);
	}

	public ItemBuilder(Material m, int quantia, byte durabilidade) {
		is = new ItemStack(m, quantia, durabilidade);
	}

	public ItemBuilder(Material m, int quantia, int durabilidade) {
		is = new ItemStack(m, quantia, (short) durabilidade);
	}

	@SuppressWarnings("deprecation")
	public ItemBuilder(int id, int quantia, int durabilidade) {
		is = new ItemStack(id, quantia, (short) durabilidade);
	}

	public ItemBuilder setAmount(int amount) {
		is.setAmount(amount);
		ItemMeta im = is.getItemMeta();
		im.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
		is.setItemMeta(im);
		return this;
	}

	public ItemBuilder setName(String nome) {
		ItemMeta im = is.getItemMeta();
		im.setDisplayName(nome);
		is.setItemMeta(im);
		return this;
	}

	public ItemBuilder setSkullOwner(String dono) {
		try {
			SkullMeta im = (SkullMeta) is.getItemMeta();
			im.setOwner(dono);
			is.setItemMeta(im);
		} catch (Throwable expected) {
		}
		return this;
	}

	public ItemBuilder addItemFlag(ItemFlag flag) {
		ItemMeta im = is.getItemMeta();
		im.addItemFlags(flag);
		is.setItemMeta(im);
		return this;
	}

	public ItemBuilder removeAttributes() {
		final ItemMeta meta = this.is.getItemMeta();
		meta.addItemFlags(ItemFlag.values());
		this.is.setItemMeta(meta);
		return this;
	}

	public ItemBuilder unsafeEnchantment(final Enchantment ench, final int level) {
		this.is.addUnsafeEnchantment(ench, level);
		return this;
	}

	public ItemBuilder enchant(final Enchantment ench, final int level) {
		final ItemMeta im = this.is.getItemMeta();
		im.addEnchant(ench, level, true);
		this.is.setItemMeta(im);
		return this;
	}

	public ItemBuilder removeEnchantment(final Enchantment ench) {
		this.is.removeEnchantment(ench);
		return this;
	}

	public ItemBuilder glow() {
		final ItemMeta im = this.is.getItemMeta();
		im.addEnchant(Enchantment.DURABILITY, 1, true);
		im.addItemFlags(ItemFlag.values());
		this.is.setItemMeta(im);
		return this;
	}

	public ItemBuilder addEnchant(Enchantment enchantment, int level){
		ItemMeta im = this.is.getItemMeta();
		im.addEnchant(enchantment, level, true);
		this.is.setItemMeta(im);
		return this;
	}

	public ItemBuilder infinityDurabilty() {
		this.is.setDurability((short) 32767);
		return this;
	}

	public ItemBuilder setLore(String... lore) {
		ItemMeta im = is.getItemMeta();
		im.setLore(Arrays.asList(lore));
		is.setItemMeta(im);
		return this;
	}

	public ItemBuilder setLore(String string1, String string2, String string3, String string4, String string5,
			String string6, String string7, String top, String string8, String string9, List<String> lista1,
			String string10, String string11, String string12, String string13, String string14, List<String> lista2) {
		ItemMeta im = is.getItemMeta();
		List<String> l = new ArrayList<String>();
		l.add(string1);
		l.add(string2);
		l.add(string3);
		l.add(string4);
		l.add(string5);
		l.add(string6);
		l.add(string7);
		l.add(top);
		l.add(string8);
		l.add(string9);
		l.addAll(lista1);
		l.add(string10);
		l.add(string11);
		l.add(string12);
		l.add(string13);
		l.add(string14);
		l.addAll(lista2);
		im.setLore(l);
		is.setItemMeta(im);
		return this;
	}

	public ItemBuilder setLeatherArmorColor(Color cor) {
		try {
			LeatherArmorMeta im = (LeatherArmorMeta) is.getItemMeta();
			im.setColor(cor);
			is.setItemMeta(im);
		} catch (Throwable expected) {
		}
		return this;
	}

	@SuppressWarnings("deprecation")
	public ItemBuilder woolColor(final DyeColor color) {
		if (!this.is.getType().equals((Object) Material.WOOL)) {
			return this;
		}
		this.is.setDurability((short) color.getDyeData());
		return this;
	}

	public ItemStack build() {
		return is;
	}

	public ItemBuilder setLore(String string, String string2, String string3, String string4, String string5,
			String string6, String top, String string7, String string8, List<String> fplayers, String string9,
			String string10, String string11) {
		ItemMeta im = is.getItemMeta();
		List<String> l = new ArrayList<String>();
		l.add(string);
		l.add(string2);
		l.add(string3);
		l.add(string4);
		l.add(string5);
		l.add(string6);
		l.add(top);
		l.add(string7);
		l.add(string8);
		l.addAll(fplayers);
		l.add(string9);
		l.add(string10);
		l.add(string11);
		im.setLore(l);
		is.setItemMeta(im);
		return this;
	}
}