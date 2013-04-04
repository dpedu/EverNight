package me.dpedu.evernight;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class EverNight extends JavaPlugin {
	public void onEnable() {
		new SetNight(this).runTaskTimer(this, 1, 20); 
	}
	
	public class SetNight extends BukkitRunnable {
		// Helper class for performing time updates
		private final JavaPlugin plugin;
	    public SetNight(JavaPlugin plugin) {
	        this.plugin = plugin;
	    }
	    public void run() {
	    	long curtime = plugin.getServer().getWorld("world").getFullTime();
	    	long dayTime = curtime%24000;
	    	if(dayTime>21000) {
	    		curtime = curtime-dayTime+39000;
	    		plugin.getServer().getWorld("world").setFullTime(curtime);
	    		System.out.println("Updated time to: "+curtime%24000);
	    	} else if(dayTime<15000) {
	    		curtime = curtime-dayTime+39000;
	    		plugin.getServer().getWorld("world").setFullTime(curtime);
	    	}
	    }
	}
}
