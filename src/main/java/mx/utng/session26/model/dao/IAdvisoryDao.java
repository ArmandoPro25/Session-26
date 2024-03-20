package mx.utng.session26.model.dao;

import java.util.List;
import mx.utng.session26.model.entity.Advisory;

public interface IAdvisoryDao {
    List<Advisory> list();
    void save(Advisory advisory);
    Advisory getById(Long id);
    void delete(Long id);
} 