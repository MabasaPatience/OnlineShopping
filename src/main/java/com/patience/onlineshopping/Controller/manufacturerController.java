package com.patience.onlineshopping.Controller;

import com.patience.onlineshopping.DTO.ManufacturerDTO;
import com.patience.onlineshopping.Entity.Manufacturer;
import com.patience.onlineshopping.Service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.util.Optional;

@Controller
public class manufacturerController {

    @Autowired
    public ManufacturerService manufacturerService;

    @GetMapping("/admin/manufacturer")
    public String getAllManufacturer(Model model){
        model.addAttribute("manufacturers",manufacturerService.getAllManufacturer());
        return "Manufacturer/ViewManufacturer";
    }
    @GetMapping("/admin/addManufacturer")
    public String addManufacturer(Model model){
        model.addAttribute("manufacturerDTO", new ManufacturerDTO());
        return "Manufacturer/AddManufacturer";
    }
    @PostMapping("/admin/addManufacturer")
    public String PostAddManufacturer(@ModelAttribute ManufacturerDTO manufacturerDTO)throws IOException {
        Manufacturer manufacturer=new Manufacturer();
        manufacturer.setManufacturerId(manufacturerDTO.getManufacturerId());
        manufacturer.setName(manufacturerDTO.getName());
        manufacturer.setEmail(manufacturerDTO.getEmail());
        manufacturer.setPhone(manufacturerDTO.getPhone());
        manufacturer.setAddressline1(manufacturerDTO.getAddressline1());
        manufacturer.setAddressline2(manufacturerDTO.getAddressline2());
        manufacturer.setCity(manufacturerDTO.getCity());
        manufacturer.setState(manufacturerDTO.getState());
        manufacturer.setRep(manufacturerDTO.getZip());
        manufacturer.setZip(manufacturerDTO.getZip());


        manufacturerService.save(manufacturer);

        return "redirect:admin/Manufacturer";
    }

    @GetMapping("/admin/deleteManufacturer/{id}")
    public String DeleteManufacturer(@PathVariable int id,Model model){
       manufacturerService.removeManufacturerById(id);
        return "redirect:admin/Manufacturer";
    }

    @GetMapping("/admin/updateManufacturer/{id}")
    public String getAllManufacturer(@PathVariable int id ,Model model){
        Optional<Manufacturer> manufacturer=manufacturerService.findManufacturerById(id);

        ManufacturerDTO manufacturerDTO=new ManufacturerDTO(manufacturer.get().getManufacturerId(),
                manufacturer.get().getName(), manufacturer.get().getAddressline1(),manufacturer.get().getAddressline2(),
                manufacturer.get().getCity(),manufacturer.get().getState(),manufacturer.get().getZip(),manufacturer.get().getPhone()
        ,manufacturer.get().getEmail(),manufacturer.get().getRep(),manufacturer.get().getProvince());

        model.addAttribute("manufacturerDTO",manufacturerDTO);
        return "Manufacturer/AddManufacturer";
    }

}
