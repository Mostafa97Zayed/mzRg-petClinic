package mostafa.springframework.mzRgpetClinic.controller;

import mostafa.springframework.mzRgpetClinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwenrController {
    private final OwnerService ownerService;

    public OwenrController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @RequestMapping({"/index",""})
    public String index(Model model){
        model.addAttribute("owners",ownerService.findAll());
        return "owners/index";}
}
