package sh.smnx.rdd.events;

import org.bukkit.entity.Player;

public abstract class Event {
    private final String _name;

    public String getName() {
        return _name;
    }

    public Event(String name) {
        _name = name;
    }

    public abstract void apply(Player target);

    public static Event combined(String name, Event... events){
        return new Event(name) {
            @Override
            public void apply(Player target) {
                for (Event e : events){
                    e.apply(target);
                }
            }
        };
    }
}
