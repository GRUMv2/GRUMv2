package grymV2.game.server;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import grymV2.game.server.Event;
import grymV2.game.server.events.RishiSunak;

class EventHandler {
    private static final Logger logger = LogManager.getLogger(EventHandler.class);
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
                logger.info("Moved event " + e.getClass().getName() + " to the pool (starttime)");
            }
        }

        Iterator<Event> removeIterator = eventPool.iterator();
        while (removeIterator.hasNext()) {
            Event e = removeIterator.next();

            boolean result = e.tick(time);

            // remove event if it returns false
            if (!result) {
                removeIterator.remove();
                logger.info("Removed event " + e.getClass().getName() + " from the pool (returned false)");
            }
        }
    }

    public void EventHandler() {
        eventQueue = new ArrayList<Event>();

        // Add all events
        eventQueue.add(new RishiSunak());
    }
}
