package com.new_project.demo.controllers;
import com.new_project.demo.vmm.DBLoader;
import com.new_project.demo.vmm.*;
import jakarta.servlet.http.HttpSession;
import java.io.FileOutputStream;
import org.springframework.web.bind.annotation.*;
import java.sql.ResultSet;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class AdminRestController 
{
       @PostMapping("/checkAdminLogin")
       public String checkAdminLogin(@RequestParam String a_email, @RequestParam String a_password, HttpSession session)
       {
                ResultSet rs=DBLoader.executeSQL("select * from admin where admin_email='"+a_email+"' and password='"+a_password+"' ");
               try
               {    
                     if(rs.next())
                     {
                            session.setAttribute("admin_email", a_email);
                            
                            return "success";
                     }
                     else
                     {
                              return "fail";
                     }
               }
               catch(Exception ex)
               {
                     return ex.toString();
               }
       }
       
        @PostMapping("/CheckAdminManageCities")
        public String CheckAdminManageCities(@RequestParam String cname, @RequestParam String cdesc, @RequestParam MultipartFile cphoto)
        {
                 ResultSet rs=DBLoader.executeSQL("select * from city where cityname='"+cname+"' ");
                 String ans="";
                 try 
                 {
                         if(rs.next())
                         {
                                ans="fail";
                         }
                         else
                         {          
                          String oname=cphoto.getOriginalFilename();
                          byte b[]= cphoto.getBytes();
                                
                          String photo_path= "src/main/resources/static/myphotos1/";   
                           
                          FileOutputStream fs=new FileOutputStream(photo_path+oname);
                          fs.write(b);
                             
                          rs.moveToInsertRow();
                          rs.updateString("cityname", cname);
                          rs.updateString("citydesc", cdesc);
                          rs.updateString("cityphoto","myphotos1/"+oname);

                          ans="success";
                         
                           rs.insertRow();
                   }
                         return ans;
                 }
                 catch(Exception ex)
                 {
                      return ex.toString();
                 }    
        }
        
        @GetMapping("/ViewAdminManageCities")
        public String ViewAdminManageCities()
        {
              RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
              String ans=rdbms.generateJSON("select * from city");
              
               return ans;
        }
        
         @PostMapping("/DeleteAdminCity")
         public String DeleteAdminCity(@RequestParam Integer id_del)
         {
                  ResultSet rs=DBLoader.executeSQL("select * from city where cityid='"+id_del+"' ");
                  try
                  {
                       if(rs.next())
                       {
                            rs.deleteRow();
                            return "success";
                       }
                       else
                       {
                              return "fail";
                       }
                  }
                  catch(Exception ex)
                  {
                         return ex.toString();
                  }
         }
         
        @GetMapping("/AddCityDropDown")
        public String AddCityDropDown()
        {
              RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
              String ans=rdbms.generateJSON("select * from city");
              
               return ans;
        }
        
        
        @GetMapping("/CheckAdminManageOwners")
        public String CheckAdminManageOwners()
        {
              RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
              String ans=rdbms.generateJSON("select * from owner_table");
              
               return ans;
        }
        
         @PostMapping("/CheckAdminApproval")
        public String CheckAdminApproval(@RequestParam String ownerid1)
        {
                   int ownerid2=Integer.parseInt(ownerid1);
                   ResultSet rs=DBLoader.executeSQL("select * from owner_table where ownerid="+ownerid2); 
                   try
                   {
                          if(rs.next())
                          {
                            System.out.println("Ownerid "+ownerid1);
                            String owner_status=rs.getString("status");
                            if(owner_status.equals("Pending"))
                            {
                                   rs.updateString("status","Approved");
                                   rs.updateRow();
                                  
                            }
                            else
                            {
                                   rs.updateString("status","Pending");
                                   rs.updateRow();       
                            }
                             return "success";
                          }
                          else
                          {
                               return "failed";
                          }

                   }
                   catch(Exception ex)
                   {
     
                           return ex.toString();
                   }
        }   
}

