package grymV2.game.server;

import java.util.ArrayList;
import java.util.Iterator;

import grymV2.game.server.Event;
import grymV2.game.server.events.RishiSunak;

class EventHandler {
    private ArrayList<Event> eventQueue;
    private ArrayList<Event> eventPool;

    public void tick(float time) {
        // move events to the pool if the time is right
        Iterator<Event> addIterator = eventQueue.iterator();
        while (addIterator.hasNext()) {
            Event e = addIterator.next();

            if (e.getStartTime() >= time) {
                eventPool.add(e);
                addIterator.remove();
                System.out.println("Moved event " + e.getClass().getName() + " to the pool (starttime)");
            }
        } // aww thats poetic

        Iterator<Event> removeIterator = eventPool.iterator();
        while (removeIterator.hasNext()) {
            Event e = removeIterator.next();

            boolean result = e.tick(time);

            // remove event if it returns false
            if (!result) {
                removeIterator.remove();
                System.out.println("Removed event " + e.getClass().getName() + " from the pool (returned false)");
            }
        }
    }

    public void EventHandler() {
        eventQueue = new ArrayList<Event>();

        // Add all events
        eventQueue.add(new RishiSunak());
    }
}
