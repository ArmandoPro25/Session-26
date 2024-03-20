package mx.utng.session26.model.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mx.utng.session26.model.dao.IAdvisoryDao;
import mx.utng.session26.model.entity.Advisory;

@Service
public class AdvisoryServiceImpl implements IAdvisoryService {

    @Autowired
    private IAdvisoryDao dao;

    @Transactional(readOnly = true)
    @Override
    public List<Advisory> list() {
        return dao.list();
    }

    @Transactional
    @Override
    public void save(Advisory advisory) {
        dao.save(advisory);
    }

    @Transactional(readOnly = true)
    @Override
    public Advisory getById(Long id) {
        return dao.getById(id);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        dao.delete(id);
    }
}