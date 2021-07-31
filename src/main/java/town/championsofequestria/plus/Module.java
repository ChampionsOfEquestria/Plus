package town.championsofequestria.plus;

import java.util.Optional;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class Module implements CommandExecutor {

    protected PlusPlugin plugin;

    public Module(final PlusPlugin plugin, final String... commands) {
        this.plugin = plugin;
        registerCommands(commands);
        final Optional<Listener> listener = createListener();
        if(listener.isPresent())
            registerEvents(listener.get(), plugin);
        this.loadSettings();
        
    }

    private void registerCommands(final String[] commands) {
        for (final String command : commands)
            plugin.getCommand(command).setExecutor(this);
    }

    private void registerEvents(final Listener listener, final JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(listener, plugin);
    }

    protected abstract Optional<Listener> createListener();
    
    
    protected abstract void loadSettings();
    
    protected abstract void saveSettings();

}
