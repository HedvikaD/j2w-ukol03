package cz.czechitas.java2webapps.ukol3.controller;

import entity.Vizitka;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;

/**
 * Kontroler obsluhující zobrazování vizitek.
 */
@Controller
public class VizitkaController {
    private final List<Vizitka> seznamVizitek = List.of(
            new Vizitka("Lucie Nová", "Allianz", "Pod Vrchem 2792", "Mělnik 27601", "luciebaz@email.cz", "999888777", "www.allianz.cz"),
            new Vizitka("Irena Nová", "MKZ Litoměřice", "Pražská 88/2", "Litoměřice 41201", "fakeEmail@email.cz", "111222333", "www.mkz-ltm.cz"),
            new Vizitka("Pepa Nový", "Armada CR", "Štefánikova 120", "Brno 66210", null, "222333444", "www.acr.cz"),
            new Vizitka("Franta Nový", "SPSS Roosveltova", "Komenského 9", "Vyškov 68201", "fejkEmail@email.cz", "444555666", "www.spss.cz")
    );

    @GetMapping("/")
    public ModelAndView seznam() {
        ModelAndView modelAndView = new ModelAndView("seznam");
        modelAndView.addObject("vizitky", seznamVizitek);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("vizitka", seznamVizitek.get(id));
        return modelAndView;
    }

}
