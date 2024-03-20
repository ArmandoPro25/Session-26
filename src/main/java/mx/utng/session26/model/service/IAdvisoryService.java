package mx.utng.session26.model.service;

import mx.utng.session26.model.entity.Advisory;
import java.util.List;

public interface IAdvisoryService {
    List<Advisory> list();
    void save(Advisory advisory);
    Advisory getById(Long id);
    void delete(Long id);
}