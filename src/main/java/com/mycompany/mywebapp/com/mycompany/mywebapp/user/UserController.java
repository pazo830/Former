package com.mycompany.mywebapp.com.mycompany.mywebapp.user;

import com.mycompany.mywebapp.com.mycompany.mywebapp.user.Services.UserService;
import com.mycompany.mywebapp.com.mycompany.mywebapp.user.dto.UserDto;
import com.mycompany.mywebapp.com.mycompany.mywebapp.user.model.Userss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.mail.javamail.JavaMailSender;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

  @Autowired private Userservices service;
    private UserService userService;
private JavaMailSender mailSender;

    public UserController(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping( "/users")

public String showUserList(Model model){

    List<User> listUsers = service.listAll();
    model.addAttribute("listUsers",listUsers);
    return "users";
}
@GetMapping("/user")
public String shownewFrom(Model model){

    model.addAttribute("user", new User());
    model.addAttribute("pageTitle" , "Make Request");
    return "user_form";
}
@PostMapping("/users/save")

    public String saveuser(User user , RedirectAttributes redirectAttributes ){
    service.save(user);
    RedirectAttributes message = redirectAttributes.addFlashAttribute("message", "the user has been saved successfully");
    return "redirect:/user";

}
@GetMapping("/users/edit/{id}")
public String showEditForm(@PathVariable("id") Integer id, Model model , RedirectAttributes redirectAttributes){
    try {
        User user =service.get(id);
        model.addAttribute("user",user);
        model.addAttribute("pageTitle" , "Edit user(ID: " + id +")");
                return "user_form";


    } catch (UserNotFoundException e) {
        RedirectAttributes message = redirectAttributes.addFlashAttribute("message", e.getMessage());
        return "redirect:/users";
    }

}
    @GetMapping( "/user1")

    public String showUserList1(Model model){

        List<User> listUsers = service.listAll();
        model.addAttribute("listUsers",listUsers);
        return "user";
    }



    @GetMapping("/Agronomy")
    public String shownewFrom1(Model model){

        model.addAttribute("user", new User());
        model.addAttribute("pageTitle" , "Make Request");
        return "Agronomy";
    }
    @GetMapping("/chat")
    public String shownewFrom4(Model model){

        model.addAttribute("user", new User());
        model.addAttribute("pageTitle" , "Make Request");
        return "chat";
    }
    @GetMapping("/home")
    public String shownewFrom7(Model model){

        model.addAttribute("user", new User());
        model.addAttribute("pageTitle" , "Make Request");
        return "home";
    } @GetMapping("/signout")
    public String shownewFrom5(Model model){

        model.addAttribute("user", new User());
        model.addAttribute("pageTitle" , "Make Request");
        return "index";
    } @GetMapping("/ad")
    public String shownewFrom8(Model model){

        model.addAttribute("user", new User());
        model.addAttribute("pageTitle" , "Make Request");
        return "ad";
    }
    @GetMapping("/email")
    public String shownewFrom2(Model model){

        model.addAttribute("user", new User());
        model.addAttribute("pageTitle" , "Make Request");
        return "email";
    }

    @GetMapping("/users/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id  , RedirectAttributes redirectAttributes){
        try {
           service.delete(id);

            redirectAttributes.addFlashAttribute("message" , "the user id"   +  id  +   "has been deleted");


        } catch (UserNotFoundException e) {
            RedirectAttributes message = redirectAttributes.addFlashAttribute("message", e.getMessage());

        }
        return "redirect:/users";
    }
@PostMapping("/send")
public String SendEmail(HttpServletRequest request) {
        String to= request.getParameter("to");
        String Subject= request.getParameter("Subject");
        String Message = request.getParameter("Message");

    SimpleMailMessage message = new SimpleMailMessage();
      message.setFrom("zainabseryu@gmail.com");
      message.setTo(to);
      message.setText(Message);
      message.setSubject(Subject);
      mailSender.send(message);
    return "redirect:/users";
}


    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "Register";
    }
    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("Userss") UserDto userDto,
                               BindingResult result,
                               Model model){
        Userss existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("Userss", userDto);
            return "/register";
        }

        userService.saveUser(userDto);
        return "redirect:/register?success";
    }

    @GetMapping("/login")
    public String login(){
        return "Login";
    }

    public UserController() {
    }
}
