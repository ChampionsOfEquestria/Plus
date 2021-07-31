package town.championsofequestria.plus;

import java.io.File;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class JailInterceptor extends Module {

    private File saveFile;
    private HashMap<UUID, String> groupMap;

    public JailInterceptor(PlusPlugin plugin, String... commands) {
        super(plugin, commands);
        this.saveFile = new File(plugin.getDataFolder(), "jail.yml");
        this.groupMap = new HashMap<UUID, String>(0);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }

    public class JailInterceptorListener implements Listener {

        @EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
        public void onHeroChatMessage(final PlayerCommandPreprocessEvent event) {
            if(event.getPlayer())
            String command = event.getMessage();
            if(command.startsWith("/")) {
                
            }
        }
        
        private void handle(String message) {
            String[] parts = message.split(" ");
            switch(parts[0].toLowerCase()) {
                case "jail": {
                    Player ply = Bukkit.getPlayer(parts[1]);
                    Bukkit.dispatchCommand(Bukkit.getConsole, commandLine)
                    return;
                }
                case "unjail": {
                    return;
                }
            }
        }
    }

    @Override
    protected void loadSettings() {
        try {
            YamlConfiguration yaml = new YamlConfiguration().loadConfiguration(saveFile);
            ConfigurationSection section = yaml.getConfigurationSection("uuid");
            for (String uuidString : section.getKeys(false)) {
                UUID uuid = UUID.fromString(uuidString);
                String oldGroup = yaml.getString("uuid." + uuidString);
                groupMap.put(uuid, oldGroup);
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    protected Optional<Listener> createListener() {
        return Optional.of(new JailInterceptorListener());
    }

    @Override
    protected void saveSettings() {
        try {
            YamlConfiguration yaml = new YamlConfiguration().loadConfiguration(saveFile);
            for (Entry<UUID, String> entry : groupMap.entrySet()) {
                yaml.set("uuid." + entry.getKey().toString(), entry.getValue());
            }
            yaml.save(saveFile);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
