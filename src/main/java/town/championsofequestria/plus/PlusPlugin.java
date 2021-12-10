package town.championsofequestria.plus;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class PlusPlugin extends JavaPlugin {

    private Brigadier brigadier;

    /**
     * {@inheritDoc}
     */
    @Override
    public void onEnable() {
        registerCommands();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    private void registerCommands() {
        brigadier = new Brigadier(this);
        if(!brigadier.isAvailable())
            return;
        brigadier.register(getCommand("alicorn"));
        brigadier.register(getCommand("dealicorn"));
        brigadier.register(getCommand("artist"));
        brigadier.register(getCommand("hub"));
        brigadier.register(getCommand("factionsspawn"));
        brigadier.register(getCommand("survivalspawn"));
        brigadier.register(getCommand("playerhead"));
        brigadier.register(getCommand("notify"));
        brigadier.register(getCommand("noble"));
        brigadier.register(getCommand("crystal"));
        brigadier.register(getCommand("a"));
        brigadier.register(getCommand("l"));
        brigadier.register(getCommand("g"));
        brigadier.register(getCommand("lookup"));
        brigadier.register(getCommand("lookup2"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        return false;
    }
}
