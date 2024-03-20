package mx.utng.session26.model.dao;

import mx.utng.session26.model.entity.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ExamDaoImpl implements IExamDao {

    @PersistenceContext
    private EntityManager em;

    @SuppressWarnings("unchecked")
    @Override
    public List<Exam> list() {
        return em.createQuery("from Exam").getResultList();
    }

    @Override
    public void save(Exam exam) {
        if (exam.getId() != null && exam.getId() > 0) {
            em.merge(exam);
        } else {
            em.persist(exam);
        }
    }

    @Override
    public Exam getById(Long id) {
        return em.find(Exam.class, id);
    }

    @Override
    public void delete(Long id) {
        Exam exam = getById(id);
        em.remove(exam);
    }
}


