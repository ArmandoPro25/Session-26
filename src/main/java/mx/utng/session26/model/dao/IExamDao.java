package mx.utng.session26.model.dao;

import mx.utng.session26.model.entity.Exam;

import java.util.List;

public interface IExamDao {
    List<Exam> list();
    void save(Exam exam);
    Exam getById(Long id);
    void delete(Long id);
}
