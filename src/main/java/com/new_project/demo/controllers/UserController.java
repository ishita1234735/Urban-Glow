package com.new_project.demo.controllers;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController 
{
      @GetMapping("/")
      public String data1()
      {   
             return "/index";
      } 
      
      @GetMapping("/UserSignup")
      public String UserSignup()
      {
             return "/UserSignup";
      }
      
      @GetMapping("/UserLogin")
      public String UserLogin()
      {
             return "/UserLogin";
      }
      
       @GetMapping("/UserLogout")
         public String UserLogout(HttpSession session)
         {
                 session.removeAttribute("uemail");
                 session.removeAttribute("user_id");
                 session.removeAttribute("user_name");
                 return "redirect:/UserLogin";
         }
         
      @GetMapping("/OwnerSalon")
      public String OwnerSalon(HttpSession session,RedirectAttributes ra)
      {
              Integer user_id=(Integer)session.getAttribute("user_id");
              if(user_id == null || user_id==0)
              {
                    ra.addFlashAttribute("msg","Please login first");
                   return "redirect:/UserLogin";
              }
              return "/OwnerSalon";
      }
      
      @GetMapping("/UserSalonDetail")
      public String UserSalonDetail(HttpSession session,RedirectAttributes ra)
      {
              Integer user_id=(Integer)session.getAttribute("user_id");
              if(user_id == null || user_id==0)
              {
                    ra.addFlashAttribute("msg","Please login first");
                   return "redirect:/UserLogin";
              }
            return "/UserSalonDetail";
      }
      
      @GetMapping("/UserShowPackageService")
      public String UserShowPackageService(HttpSession session,RedirectAttributes ra)
      {
            Integer user_id=(Integer)session.getAttribute("user_id");
              if(user_id == null || user_id==0)
              {
                    ra.addFlashAttribute("msg","Please login first");
                   return "redirect:/UserLogin";
              }
             return "/UserShowPackageService";
      }
      
       @GetMapping("/UserBooking")
      public String UserBooking(HttpSession session,RedirectAttributes ra)
      {
           Integer user_id=(Integer)session.getAttribute("user_id");
              if(user_id == null || user_id==0)
              {
                    ra.addFlashAttribute("msg","Please login first");
                   return "redirect:/UserLogin";
              }
             return "/UserBooking";
      }
      
      @GetMapping("/UserBookingHistory")
      public String UserBookingHistory(HttpSession session,RedirectAttributes ra)
      {
               Integer user_id=(Integer)session.getAttribute("user_id");
              if(user_id == null || user_id==0)
              {
                     ra.addFlashAttribute("msg","Please login first");
                   return "redirect:/UserLogin";
              }
             return "/UserBookingHistory";
      }
      
}

