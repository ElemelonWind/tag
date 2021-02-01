package me.melonnootfound.tag;

import org.bukkit.plugin.java.JavaPlugin;

import me.melonnootfound.tag.models.Game;

public class Tag extends JavaPlugin {

	public Game game;
	
	@Override
	public void onEnable() {
		this.game = new Game();
		
		this.getServer().getPluginManager().registerEvents(new TaggedEvent(this), this);
		
		this.getCommand("tag").setExecutor(new TagCommand(this));
	}

	@Override
	public void onDisable() {
		if(game.isPlaying())
			game.end();
	}
}
