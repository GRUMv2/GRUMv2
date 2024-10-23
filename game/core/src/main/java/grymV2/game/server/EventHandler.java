package grymV2.game;

import java.util.ArrayList;
import java.util.Iterator;

import grymV2.game.Event;
import grymV2.game.RishiSunac;

class EventHandler {
    private ArrayList<Event> eventQue;
    private ArrayList<Event> eventPool;

    public void tick(int time) {
        // move events to the pool if the time is right
        Iterator<Event> addIterator = eventQue.iterator();
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

    public void EventHndler() {
        eventQue = new ArrayList<Event>();

        // Add all events
        eventQue.add(new RishiSunac());
    }
}
