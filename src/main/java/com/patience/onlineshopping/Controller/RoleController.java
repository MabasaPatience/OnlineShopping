package com.patience.onlineshopping.Controller;

import com.patience.onlineshopping.Entity.Role;
import com.patience.onlineshopping.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/admin/role")
    public String viewRoles(Model model){
        model.addAttribute("listRoles",roleService.getAllRolls());
                return "Role";
    }
    @GetMapping("/admin/role/add")
    public String getAddRoles(Model model){
        model.addAttribute("role",new Role());
        return "Role/AddRole";
    }

    @PostMapping("/admin/role/add")
    public String PostAddRole(@ModelAttribute("role") Role role){
        roleService.addRole(role);
        return "redirect:/admin/role";
    }

    @GetMapping("admin/role/delete/{id}")
    public String deleteRole(@PathVariable int id){
        roleService.removeRoleById(id);
        return "redirect:/admin/role";
    }

    @GetMapping("admin/role/update/{id}")
    public String UpdateRole(@PathVariable int id, Model model){
        Optional<Role> role=roleService.updateRoleById(id);
        if(role.isPresent()){
            model.addAttribute("role",role.get());
            return "Role/AddRole";
        }else {
            return "404";
        }
    }
}
