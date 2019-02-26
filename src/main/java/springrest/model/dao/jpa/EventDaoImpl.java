package springrest.model.dao.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import springrest.model.Event;
import springrest.model.dao.EventDao;

@Repository
public class EventDaoImpl implements EventDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Event> getEvents()
    {
        return entityManager.createQuery( "from Event order by id", Event.class )
            .getResultList();
    }


}