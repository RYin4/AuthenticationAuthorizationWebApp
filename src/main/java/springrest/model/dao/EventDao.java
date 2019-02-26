package springrest.model.dao;

import java.util.List;

import springrest.model.Event;

public interface EventDao {

    List<Event> getEvents();

}