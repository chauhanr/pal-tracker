package io.pivotal.pal.tracker;

import org.springframework.data.repository.CrudRepository;

public interface JpaRepository extends CrudRepository<TimeEntry,Long> {

}
