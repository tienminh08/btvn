package com.example.btvn.Controller;

import com.example.btvn.Model.Staff;
import com.example.btvn.Service.ServiceStaff;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Home {
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("Slist", ServiceStaff.staffList);
        return "home";
    }

    @GetMapping("/Crate")
    public String ShowC() {
        return "/Create";
    }

    @PostMapping("/Crate")
    public String home(Staff staff) {
        ServiceStaff.staffList.add(staff);
        return "redirect:/home";
    }

    @GetMapping("/show/{employeeCode}")
    public String showone(Model model, @PathVariable String employeeCode) {
        int index = ServiceStaff.findbyid(employeeCode);
        if (index >= 0) {
            model.addAttribute("S1", ServiceStaff.staffList.get(index));
            return "show";
        }
        return "redirect:/home";
    }

    @GetMapping("/update/{employeeCode}")

    public String update(Model model, @PathVariable String employeeCode) {
        int index = ServiceStaff.findbyid(employeeCode);
        if (index >= 0) {
            model.addAttribute("S1", ServiceStaff.staffList.get(index));
            return "Update";
        }
        return "redirect:/home";
    }
    @PostMapping ("/update/{employeeCode}")

    public String update1(Staff staff, @PathVariable String employeeCode) {
        int index = ServiceStaff.findbyid(employeeCode);
        ServiceStaff.staffList.set(index,staff);
        return "redirect:/home";

    }


//    @GetMapping("/delete/{employeeCode}")
//    public String daiolog( Model model,@PathVariable String employeeCode){
//        int index= ServiceStaff.findbyid(employeeCode);
//        Staff staff= new Staff()
//       model.addAttribute("index", );
//       return "";
//
//
//
//
//    }


}
