package com.patience.onlineshopping.Controller;

import com.patience.onlineshopping.DTO.UserDTO;
import com.patience.onlineshopping.Entity.User;
import com.patience.onlineshopping.Service.RoleService;
import com.patience.onlineshopping.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UserController {
    public static String uploadDir=System.getProperty("user.dir") + "/src/main/resources/static/UserImages";
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/admin/users")
    public String getusers(Model model){
        model.addAttribute("users",userService.getAllUser());
        return "User/ViewUsers";
    }
    @GetMapping("/admin/user/add")
    public String addUser(Model model){
        model.addAttribute("UserDTO",new UserDTO());
        model.addAttribute("roles",roleService.getAllRolls());
        return "User/AddUser";
    }

    @PostMapping("/admin/users/add")
    public String PostaddUser(@ModelAttribute("UserDTO") UserDTO userDTO,
                              @RequestParam("userImage")MultipartFile file,
                              @RequestParam("imgName")String imgName) throws IOException {

       User user=new User();
            user.setUserId(userDTO.getUserId());
            user.setFirstname(userDTO.getFirstname());
            user.setLastname(userDTO.getLastname());
            user.setEmail(userDTO.getEmail());
            user.setGender(userDTO.getGender());
            user.setPhone(userDTO.getPhone());
        user.setRoleId(roleService.updateRoleById(userDTO.getRoleId()).get());
            user.setPassword(userDTO.getPassword());

            String imageUUID;
            if(!file.isEmpty()){
                imageUUID= file.getOriginalFilename();
                Path fileNameAndPath= Paths.get(uploadDir,imageUUID);
                Files.write(fileNameAndPath,file.getBytes());

            }else{
                imageUUID=imgName;
            }
            user.setImageName(imageUUID);
            userService.saveuser(user);
            return "redirect:/admin/users";

    }

}
