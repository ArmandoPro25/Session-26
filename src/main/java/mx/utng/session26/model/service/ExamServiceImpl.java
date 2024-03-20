package mx.utng.session26.model.service;

import mx.utng.session26.model.dao.IExamDao;
import mx.utng.session26.model.entity.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ExamServiceImpl implements IExamService {

    @Autowired
    private IExamDao examDao;

    @Transactional(readOnly = true)
    @Override
    public List<Exam> list() {
        return examDao.list();
    }

    @Transactional
    @Override
    public void save(Exam exam) {
        examDao.save(exam);
    }

    @Transactional(readOnly = true)
    @Override
    public Exam getById(Long id) {
        return examDao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        examDao.delete(id);
    }
}



