package io.pivotal.pal.tracker;

import java.sql.Time;
import java.util.*;

public class InMemoryTimeEntryRepository implements TimeEntryRepository{
    private Map<Long, TimeEntry> store = new HashMap<Long, TimeEntry>();

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        long id =  store.size()+1;
        timeEntry.setId(id);
        store.put(id, timeEntry);
        return timeEntry;
    }

    @Override
    public TimeEntry find(Long id) {
        if (store.containsKey(id)) {
            return store.get(id);
        }
        return null;
    }

    @Override
    public List<TimeEntry> list() {
        return new ArrayList<TimeEntry>(store.values());
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        if (store.containsKey(id)){
            store.put(id, timeEntry);
            timeEntry.setId(id);
            return timeEntry;
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (store.containsKey(id)){
            store.remove(id);
        }
    }
}
