# Aqua

Aqua is a lightweight tool meant to help in the process of developing
Spigot plugins by providing abstractions for boilerplate code.  
I use Aqua in most of my projects as it is a great helper when it comes to the
repetitive, boring tasks that come with plugin development.

### How to use
In order to use Aqua in your projects, you'll need to install the
maven repository locally on your machine.

1. Firstly, start by cloning the repository on your machine.
2. After the cloning is done, run ```mvn clean install```
3. Lastly, you can include the tool as a dependency in your projects.

```xml
<dependency>
    <groupId>dev.cristike</groupId>
    <artifactId>aqua</artifactId>
    <version>VERSION</version> 
    <scope>compile</scope>
</dependency>

<!-- The latest version is 1.4.1 -->
```

Keep in mind that you'll need to reinstall the repository when a
new version of Aqua is released.

### Examples

A first good example is a problem that I always encounter when
parsing locations from command arguments. You need to check that the
world is valid and the coordinates are actually numbers. Overall, it is a
tedious task that is always the same.  

Aqua provides a function that solves this problem in the ```AquaLocation.java``` class.
Let's say we need to parse the first four arguments of a command. The following code parses the 
arguments and returns an Optional that may contain a location if the inputs are valid.

```java
import dev.cristike.aqua.location.AquaLocation;
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
```

Another category in which Aqua is a great help is the Scheduler. It didn't happen just once that I got into the
situation in which I needed to run a task on the main thread, yet I didn't have instance of the plugin.
With Aqua, I can run tasks, sync or async, and timers easily using the functions provided in the
```AquaScheduler.java``` class.

In the following code example, we have the class ```Example```, which contains three methods: ```doSomething()```,
```doSomethingSync()```, which calls ```doSomething()``` on the main thread, and ```doSomethingAsync()``` which
calls ```doSomething()``` asynchronously.

```java
import dev.cristike.aqua.scheduler.AquaScheduler;

public class Example {

    private void doSomething() {
        /* Function body */
    }

    public void doSomethingSync() {
        AquaScheduler.runTask(() -> doSomething());
    }
    
    public void doSomethingAsync() {
        AquaScheduler.runTaskAsync(() -> doSomething());
    }
}
```

### Contact
If you have any questions regarding Aqua, feel free to contact me on discord:
```Cristike#2808```.
