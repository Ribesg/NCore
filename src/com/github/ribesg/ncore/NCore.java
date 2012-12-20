package com.github.ribesg.ncore;

import lombok.Getter;
import lombok.Setter;

import org.bukkit.plugin.java.JavaPlugin;

import com.github.ribesg.ncore.nodes.cuboid.CuboidNode;
import com.github.ribesg.ncore.nodes.punisher.PunisherNode;

public class NCore extends JavaPlugin {

	@Getter
	@Setter
	private CuboidNode cuboidNode;

	@Getter
	@Setter
	private PunisherNode punisherNode;

	@Override
	public void onEnable() {
		// Nothing yet
	}

	@Override
	public void onDisable() {
		// Nothing yet
	}
}
