package com.patience.onlineshopping.Controller;

import com.patience.onlineshopping.DTO.ProductDTO;
import com.patience.onlineshopping.Entity.Category;
import com.patience.onlineshopping.Entity.Manufacturer;
import com.patience.onlineshopping.Entity.Product;
import com.patience.onlineshopping.Entity.ProductCode;
import com.patience.onlineshopping.Service.CategoryService;
import com.patience.onlineshopping.Service.ManufacturerService;
import com.patience.onlineshopping.Service.ProductCodeService;
import com.patience.onlineshopping.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    public ProductService productService;
    @Autowired
    public ManufacturerService manufacturerService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    public ProductCodeService productCodeService ;
    @GetMapping("/admin/product")
    public String getAllProduct(Model model){
        model.addAttribute("product" ,productService.getAllProduct());
        return "Product/product";
    }

    @GetMapping("/admin/product/add")
    public String getProduct(Model model){
        model.addAttribute("productDTO" , new ProductDTO());
        return "Product/addProduct";
    }
    @PostMapping("/admin/product/add")
    public String postProduct(@ModelAttribute("productDTO") ProductDTO productDTO){
        Product product=new Product();
        Optional<Manufacturer> manufacturer=manufacturerService.findManufacturerById(productDTO.getManufacturerId());
        Optional<Category> category= categoryService.findCategoryById(productDTO.getCategoryId());
        Optional<ProductCode> productCode=productCodeService.findProductCodeById(productDTO.getProductCodeId());
        product.setProductId(productDTO.getProductId());
        product.setDescription(productDTO.getDescription());
        product.setPurchaseCost(productDTO.getPurchaseCost());
        product.setMarkup(productDTO.getMarkup());
        product.setQuantityOnHand(productDTO.getQuantityOnHand());
        product.setAvailable(product.getAvailable());
        product.setManufacturerId(manufacturer.get());
        product.setProductCodeId(productCode.get());
        product.setCategoryId(category.get());
        product.setImageName(productDTO.getImageName());

        productService.save(product);
        return "Product/addProduct";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String deleteProduct(@PathVariable  Integer id ){
        productService.removeProductById(id);
        return "redirect:/admin/products";
    }

    @GetMapping("/admin/product/update/{id}")
    public String UpdateProduct(@PathVariable  Integer id , Model model){
        Optional<Product> product=productService.findProductById(id);

        ProductDTO productDTO=new ProductDTO(product.get().getProductId(),product.get().getPurchaseCost(),
                product.get().getQuantityOnHand(),product.get().getMarkup(),product.get().getAvailable(),
                product.get().getDescription(),product.get().getManufacturerId().getManufacturerId(),
                product.get().getCategoryId().getCategoryId(), product.get().getProductCodeId().getProdCodeId(),product.get().getImageName());

        model.addAttribute("productDTO" , productDTO);


        return "redirect:/admin/addproducts";
    }
}
