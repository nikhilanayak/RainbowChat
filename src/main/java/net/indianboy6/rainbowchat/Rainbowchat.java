package net.indianboy6.rainbowchat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Rainbowchat extends JavaPlugin implements Listener {

    ChatColor[] colors = new ChatColor[]{
            ChatColor.RED,
            ChatColor.GOLD,
            ChatColor.YELLOW,
            ChatColor.GREEN,
            ChatColor.DARK_GREEN,
            ChatColor.AQUA,
            ChatColor.DARK_AQUA,
            ChatColor.BLUE,
            ChatColor.LIGHT_PURPLE,
            ChatColor.DARK_PURPLE
    };

    @Override
    public void onEnable() {



        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        StringBuilder builder = new StringBuilder();
        builder.append(rainbowifyText(event.getPlayer().getDisplayName()));
        builder.append(ChatColor.WHITE);
        builder.append(": ");
        builder.append(event.getMessage());

        Bukkit.broadcastMessage(builder.toString());

//            Bukkit.broadcastMessage(rainbowifyText(event.getPlayer().getDisplayName()) + ChatColor.WHITE + ", " + event.getMessage());

        event.setCancelled(true);
    }

    public String rainbowifyText(String text){
        int rand = (int)(Math.random() * colors.length);
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < text.length(); i++){
            builder.append(colors[(rand + i) % colors.length]);
            builder.append(text.charAt(i));
        }

        return String.valueOf(builder.toString());
    }

}
