import dev.cristike.aqua.location.AquaLocation;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Optional;

public class ExampleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Optional<Location> optional = AquaLocation.getLocation(args[0], args[1], args[2], args[3]);

        if (optional.isEmpty()) {
            sender.sendMessage("Invalid location.");
            return true;
        }
        Location location = optional.get();

        return true;
    }
}
