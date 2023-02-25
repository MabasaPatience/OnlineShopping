package com.patience.onlineshopping.Controller;


import com.patience.onlineshopping.DTO.ProductCodeDTO;
import com.patience.onlineshopping.Entity.ProductCode;
import com.patience.onlineshopping.Service.ProductCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductCodeController {
    @Autowired
    public ProductCodeService productCodeService ;

    @GetMapping("/admin/productCodes")
    public String getProductCode(Model model){
        model.addAttribute("productCode" ,productCodeService.getAllProductCode());
        return "ProductCode/productCode";
    }

    @GetMapping("/admin/addProfuctCode")
    public String getAllProductCode(Model model){
        model.addAttribute("productCodeDTO" ,new ProductCodeDTO());
        return "ProductCode/addProductCode";
    }
    @PostMapping("/admin/addProductCode")
    public String postProductCode(@PathVariable("productCode") ProductCodeDTO productcodeDTO){

        ProductCode productCode=new ProductCode();
        productCode.setProdCodeId(productcodeDTO.getProdCodeId());
        productCode.setProdCode(productcodeDTO.getProdCode());
        productCode.setDescription(productcodeDTO.getDescription());
        return "redirect:/admin/productCodes";
    }
}
