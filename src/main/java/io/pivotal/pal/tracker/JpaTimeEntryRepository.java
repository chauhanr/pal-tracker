package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class JpaTimeEntryRepository implements TimeEntryRepository {
    @Autowired
     private JpaRepository jpaTimeEntry;

    @Override
    public TimeEntry create(TimeEntry timeEntry) {
        TimeEntry entry = jpaTimeEntry.save(timeEntry);
        return entry;
    }

    @Override
    public TimeEntry find(Long id) {
        TimeEntry timeEntry = jpaTimeEntry.findOne(id);
        return timeEntry;
    }

    @Override
    public List<TimeEntry> list() {
        Iterable<TimeEntry> entires = jpaTimeEntry.findAll();
        List<TimeEntry> timeEntries = new ArrayList<TimeEntry>();

        for(TimeEntry entry : entires){
            timeEntries.add(entry);
        }
        return timeEntries;
    }

    @Override
    public TimeEntry update(Long id, TimeEntry timeEntry) {
        TimeEntry oldOne = jpaTimeEntry.findOne(id);
        timeEntry.setId(id);
        TimeEntry newOne = jpaTimeEntry.save(timeEntry);
        return newOne;
    }

    @Override
    public void delete(Long id) {
        jpaTimeEntry.delete(id);
    }
}
