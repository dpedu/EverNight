package me.dpedu.evernight;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class EverNight extends JavaPlugin {
	
	private BukkitTask _thread;
	
	public void onEnable() {
		//new SetNight(this).runTaskTimer(this, 1, 20);
		
		// Start the task to update player data
	    final EverNight plugin = this;
	    this._thread = this.getServer().getScheduler().runTaskTimerAsynchronously(this, new Runnable() {
	    	public void run() {plugin.setNightTime(); }
	    }, 10L, 7200L);
	}
	
	public void setNightTime() {
		final EverNight plugin = this;
		plugin.getServer().getWorld("world").setTime(14500);
	}
	
	public void onDisable()
	{
		_thread.cancel();
	}
}
