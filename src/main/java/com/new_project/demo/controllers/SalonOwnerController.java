package com.new_project.demo.controllers;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SalonOwnerController 
{
        @GetMapping("/OwnerSignup")
        public String OwnerSignup()
        {
                 return "/OwnerSignup";
        }
        
        @GetMapping("/OwnerHome")
        public String OwnerHome(HttpSession session,RedirectAttributes ra)
        {
                 Integer owner_id=(Integer)(session.getAttribute("owner_id"));
                 if(owner_id==null || owner_id==0)
                 {
                        ra.addFlashAttribute("msg","Please login first");
                      return "redirect:/OwnerLogin";
                 }
                 return "/OwnerHome";
        }
        
        @GetMapping("/OwnerLogin")
        public String OwnerLogin()
        {
               return "/OwnerLogin";
        }
        
        @GetMapping("/OwnerServiceDetails")
        public String OwnerServiceDetails(HttpSession session, RedirectAttributes ra)
        {
                Integer owner_id=(Integer)(session.getAttribute("owner_id"));
                if(owner_id==null || owner_id==0)
                {
                       ra.addFlashAttribute("msg","Please login first");
                       return "redirect:/OwnerLogin";
                }
               return "/OwnerServiceDetails";
        }
        
        @GetMapping("/OwnerPhotos")
        public String OwnerPhotos(HttpSession session, RedirectAttributes ra)
        {
                Integer owner_id=(Integer)(session.getAttribute("owner_id"));
                if(owner_id==null || owner_id==0)
                {
                       ra.addFlashAttribute("msg","Please login first");
                      return "redirect:/OwnerLogin";
                }
               return "/OwnerPhotos";
        }
         
         @GetMapping("/OwnerLogout")
         public String OwnerLogout(HttpSession session)
         {
                String ans=(String) session.getAttribute("owner_email");
                System.out.println(ans);
                
                session.removeAttribute("owner_email");
                session.removeAttribute("owner_id");
                session.removeAttribute("owner_name");
               
                String ans1=(String) session.getAttribute("owner_email");
                System.out.println(ans1);
                 
                 return "redirect:/OwnerLogin";
         }
         
      @GetMapping("/OwnerManageBooking")
      public String OwnerManageBooking(HttpSession session, RedirectAttributes ra)
      {
                Integer owner_id=(Integer)(session.getAttribute("owner_id"));
                if(owner_id==null || owner_id==0)
                {
                      ra.addFlashAttribute("msg","Please login first");
                      return "redirect:/OwnerLogin";
                }
            
             return "/OwnerManageBooking";
      }
}

