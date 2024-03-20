package mx.utng.session26.model.dao;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;
import mx.utng.session26.model.entity.Advisory;

@Repository
public class AdvisoryDaoImpl implements IAdvisoryDao {

    @Autowired
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Advisory> list() {
        return em.createQuery("from Advisory").getResultList();
    }

    @Override
    public void save(Advisory advisory) {
        if (advisory.getId() != null && advisory.getId() > 0) {
            em.merge(advisory);
        } else {
            em.persist(advisory);
        }
    }

    @Override
    public Advisory getById(Long id) {
        return em.find(Advisory.class, id);
    }

    @Override
    public void delete(Long id) {
        Advisory advisory = getById(id);
        em.remove(advisory);
    }
}