package mx.utng.session26.controller;

import mx.utng.session26.model.entity.Exam;
import mx.utng.session26.model.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.InitBinder;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/exam")
public class ExamController {

    @Autowired
    private IExamService examService;

    @GetMapping("/list")
    public String listExams(Model model) {
        List<Exam> exams = examService.list();
        model.addAttribute("exams", exams);
        model.addAttribute("title", "Lista de Exámenes");
        return "exam-list";
    }

    @GetMapping("/form")
    public String createExamForm(Model model) {
        Exam exam = new Exam();
        model.addAttribute("exam", exam);
        model.addAttribute("title", "Crear Examen");
        return "exam-form";
    }

    @PostMapping("/save")
    public String saveExam(@ModelAttribute("exam") Exam exam) {
        examService.save(exam);
        return "redirect:/exam/list";
    }

    @GetMapping("/edit/{id}")
    public String editExamForm(@PathVariable Long id, Model model) {
        Exam exam = examService.getById(id);
        model.addAttribute("exam", exam);
        model.addAttribute("title", "Editar Examen");
        return "exam-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteExam(@PathVariable Long id) {
        examService.delete(id);
        return "redirect:/exam/list";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    Date date = dateFormat.parse(text);
                    setValue(date);
                } catch (ParseException e) {
                    setValue(null);
                }
            }
        });
    }
}
