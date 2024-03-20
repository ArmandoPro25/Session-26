package mx.utng.session26.controller;

import mx.utng.session26.model.entity.Advisory;
import mx.utng.session26.model.service.IAdvisoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/advisory")
public class AdvisoryController {

    @Autowired
    private IAdvisoryService advisoryService;

    @GetMapping("/list")
    public String listAdvisories(Model model) {
        List<Advisory> advisories = advisoryService.list();
        model.addAttribute("advisories", advisories);
        model.addAttribute("title", "Lista de Asesorías");
        return "advisory-list";
    }

    @GetMapping("/form")
    public String createAdvisoryForm(Model model) {
        Advisory advisory = new Advisory();
        model.addAttribute("advisory", advisory);
        model.addAttribute("title", "Crear Asesoría");
        return "advisory-form";
    }

    @PostMapping("/save")
    public String saveAdvisory(@ModelAttribute("advisory") Advisory advisory) {
        advisoryService.save(advisory);
        return "redirect:/advisory/list";
    }

    @GetMapping("/edit/{id}")
    public String editAdvisoryForm(@PathVariable Long id, Model model) {
        Advisory advisory = advisoryService.getById(id);
        model.addAttribute("advisory", advisory);
        model.addAttribute("title", "Editar Asesoría");
        return "advisory-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteAdvisory(@PathVariable Long id) {
        advisoryService.delete(id);
        return "redirect:/advisory/list";
    }
}