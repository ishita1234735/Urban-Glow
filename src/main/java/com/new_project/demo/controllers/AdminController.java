package com.new_project.demo.controllers;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AdminController 
{
        @GetMapping("/AdminLogin")
        public String AdminLogin()
        {
               return "/AdminLogin";
        }
       
         @GetMapping("/AdminLogout")
         public String AdminLogout(HttpSession session)
         {
                String ans=(String) session.getAttribute("admin_email");
                System.out.println(ans);
                
                session.removeAttribute("admin_email");
                 
                String ans1=(String) session.getAttribute("admin_email");
                System.out.println(ans1);
                 
                 return "redirect:/AdminLogin";
         }
        
        @GetMapping("/AdminHome")
        public String AdminHome(HttpSession session,RedirectAttributes ra)
        {
                 String ans=(String) session.getAttribute("admin_email");
                 if(ans==null || ans.equals(""))
                 {
                       ra.addFlashAttribute("msg","Please login first");
                       return "redirect:/AdminLogin";
                 }

                      return "/AdminHome";
        }
        
         @GetMapping("/AdminManageCities")
        public String AdminManageCities(HttpSession session, RedirectAttributes ra)
        {
                 String ans=(String) session.getAttribute("admin_email");
                 if(ans==null || ans.equals(""))
                 {
                       ra.addFlashAttribute("msg","Please login first");
                       return "redirect:/AdminLogin";
                 }
                 else
                 {
                      return "/AdminManageCities";
                 }
        }
        
         @GetMapping("/AdminManageOwners")
        public String AdminManageOwners(HttpSession session, RedirectAttributes ra)
        {
                 String ans=(String) session.getAttribute("admin_email");
                 if(ans==null || ans.equals(""))
                 {
                        ra.addFlashAttribute("msg","Please login first");
                       return "redirect:/AdminLogin";
                 }
                 else
                 {
                      return "/AdminManageOwners";
                 }
        }
}
 