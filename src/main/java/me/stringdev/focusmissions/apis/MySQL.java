package me.stringdev.focusmissions.apis;

import java.io.File;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import me.stringdev.focusmissions.Main;
import org.bukkit.Bukkit;

public class MySQL {

	public static Connection con = null;

	public static void openConnection() {
		String url = "jdbc:mysql://" + Main.config.getString("MySQL.Host") + "/" + Main.config.getString("MySQL.Database") + "?characterEncoding=utf8&useUnicode=true&sessionVariables=storage_engine%3DInnoDB&interactiveClient=true";
		String user = Main.config.getString("MySQL.Usuario");
		String password = Main.config.getString("MySQL.Senha");

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			criarTabela();
		} catch (Exception err) {
			Bukkit.getConsoleSender().sendMessage("[FocusMissions] §cFalha ao conectar ao MySql, iniciando SQLLite!");
		}
	}

	public static void criarTabela() {
		if (con != null) {
			PreparedStatement stm = null;
			try {
				stm = con.prepareStatement("CREATE TABLE IF NOT EXISTS `fcmissions_rewards` (" +
						"`Player` TEXT," +
						"`reward1` INT NOT NULL DEFAULT 0," +
						"`reward2` INT NOT NULL DEFAULT 0," +
						"`reward3` INT NOT NULL DEFAULT 0," +
						"`reward4` INT NOT NULL DEFAULT 0," +
						"`reward5` INT NOT NULL DEFAULT 0," +
						"`reward6` INT NOT NULL DEFAULT 0," +
						"`reward7` INT NOT NULL DEFAULT 0," +
						"`reward8` INT NOT NULL DEFAULT 0," +
						"`reward9` INT NOT NULL DEFAULT 0," +
						"`reward10` INT NOT NULL DEFAULT 0)");

				stm.executeUpdate();
			} catch (SQLException err) {
				Bukkit.getConsoleSender().sendMessage("[FocusMissions] §cNao foi carregar a tabela!");
				err.printStackTrace();
			}
		}
	}

}