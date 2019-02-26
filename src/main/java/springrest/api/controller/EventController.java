package springrest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springrest.model.Event;
import springrest.model.dao.EventDao;

@RestController
public class EventController {

    @Autowired
    private EventDao eventDao;

    @RequestMapping(value = "/events", method = RequestMethod.GET)
    public List<Event> getEvents()
    {
        return eventDao.getEvents();
    }

}