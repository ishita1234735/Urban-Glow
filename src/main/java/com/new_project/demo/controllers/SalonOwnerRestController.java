package com.new_project.demo.controllers;
import com.new_project.demo.vmm.DBLoader;
import com.new_project.demo.vmm.RDBMS_TO_JSON;
import jakarta.servlet.http.HttpSession;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class SalonOwnerRestController
{
       @PostMapping("/AddOwnerSignup")
       public String AddOwnerSignup(@RequestParam String fname, @RequestParam String email, @RequestParam String pass, @RequestParam MultipartFile pphoto,@RequestParam String sname,@RequestParam String scity,@RequestParam String sdesc,@RequestParam MultipartFile sphoto,@RequestParam String otime,@RequestParam String ctime,@RequestParam String slatitude, @RequestParam String slongitude,@RequestParam String experience)
       {
               ResultSet rs=DBLoader.executeSQL("select * from owner_table");
               
               try
               {
                         int cid = Integer.parseInt(scity);
                   
                          String oname=pphoto.getOriginalFilename();
                          byte b[]= pphoto.getBytes();
                                
                          String photo_path1= "src/main/resources/static/owner_uploads/";   
                           
                          FileOutputStream fs=new FileOutputStream(photo_path1+oname);
                          fs.write(b);
                          
                          String oname1=sphoto.getOriginalFilename();
                          byte b1[]= sphoto.getBytes();
                                
                          String photo_path2= "src/main/resources/static/owner_uploads/";   
                           
                          FileOutputStream fs1=new FileOutputStream(photo_path2+oname1);
                          fs1.write(b1);
                             
                     rs.moveToInsertRow();
                     
                     rs.updateString("ownername",fname);
                     rs.updateString("owneremail",email);
                     rs.updateString("ownerpass",pass);
                     rs.updateString("ownerphoto","owner_uploads/"+oname);
                     rs.updateString("shopphoto","owner_uploads/"+oname1);
                     rs.updateString("shopname", sname);
                     rs.updateString("shopdesc",sdesc);
                     rs.updateInt("cityid", cid);
                     rs.updateString("latitude",slatitude);
                     rs.updateString("longitude",slongitude);
                     rs.updateString("starttime",otime);
                     rs.updateString("endtime",ctime);
                     rs.updateString("experience",experience);
                     
                     rs.insertRow();
                     return "success";
               }
               
               catch(Exception ex)
               {
                    return ex.toString();
               }
       } 
       
        @PostMapping("/CheckOwnerSignup")
        public String CheckOwnerSignup(@RequestParam String email, @RequestParam String pass, HttpSession session)
        {
                  
                  ResultSet rs=DBLoader.executeSQL("select * from owner_table where owneremail='"+email+"' and ownerpass='"+pass+"' ");
                  try
                  {
                        if(rs.next())
                        {
                                  session.setAttribute("owner_email", email);
                                  session.setAttribute("owner_id", rs.getInt("ownerid"));
                                  session.setAttribute("owner_name", rs.getString("ownername"));
                                  
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
        
         @PostMapping("/AddServiceDetails")
         public String AddServiceDetails(@RequestParam String servicename, @RequestParam String servicedesc, @RequestParam MultipartFile servicephoto, @RequestParam String serviceprice, @RequestParam String sofferprice, @RequestParam String stype, HttpSession session2)
        {
                  ResultSet rs=DBLoader.executeSQL("select * from packages");
                  try
                  {
                          int owner_id=(int) session2.getAttribute("owner_id");
                          System.out.println("Owner ID");
                          System.out.println(owner_id);
                          String oname=servicephoto.getOriginalFilename();
                          byte b[]= servicephoto.getBytes();
                           String photo_path1= "src/main/resources/static/owner_uploads/";   
                           FileOutputStream fs=new FileOutputStream(photo_path1+oname);
                           fs.write(b);
                          
                          rs.moveToInsertRow();
                          
                          rs.updateInt("ownerid", owner_id);
                          rs.updateString("packagename", servicename);
                          rs.updateString("packagedesc", servicedesc );
                          rs.updateString("packagephoto", "owner_uploads/"+oname  );
                          rs.updateString("price", serviceprice);
                          rs.updateString("offerprice", sofferprice);
                          rs.updateString("type", stype);
                          
                          rs.insertRow();
                          
                          return "success";              
                       
                  }
                  catch(Exception ex)
                  {
                      ex.printStackTrace();
                       return ex.toString();
                  }
        }
       
         @PostMapping("/ViewServiceDetails")
         public String ViewServiceDetails(HttpSession session)
         {
                 int owner_id=(int) session.getAttribute("owner_id");
                 RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
                 String ans=rdbms.generateJSON("select * from packages where ownerid="+owner_id);
                 return ans;
         }
         
         @PostMapping("/DeleteService")
         public String DeleteService(@RequestParam Integer id_del1)
         {
                  ResultSet rs=DBLoader.executeSQL("select * from packages where packageid='"+id_del1+"' ");
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
         
         @PostMapping("/AddOwnerPhoto")
         public String AddOwnerPhoto(@RequestParam MultipartFile ophoto,HttpSession session3)
         {
                  ResultSet rs=DBLoader.executeSQL("select * from shopphotos");
                  try
                  {
                           int owner_id=(int) session3.getAttribute("owner_id");
                            String oname=ophoto.getOriginalFilename();
                            byte b[]= ophoto.getBytes();
                            String photo_path1= "src/main/resources/static/owner_uploads/";   
                            FileOutputStream fs=new FileOutputStream(photo_path1+oname);
                            fs.write(b);
                           
                          rs.moveToInsertRow();
                         
                          rs.updateInt("ownerid", owner_id);
                          rs.updateString("photo","owner_uploads/"+oname);
                          
                          rs.insertRow();
                          
                           return "success";
                  }
                  
                  catch(Exception ex)
                  {
                         return ex.toString();
                  }
         } 
         
          @GetMapping("/ViewPhotos")
         public String ViewPhotos(HttpSession session)
         {
                 int owner_id=(int) session.getAttribute("owner_id");
                 RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
                 String ans=rdbms.generateJSON("select * from shopphotos where ownerid="+owner_id);
                 return ans;
         }
         
         @PostMapping("/DeletePhoto")
         public String DeletePhoto(@RequestParam String id_del1)
         {
                  int id_del=Integer.parseInt(id_del1);
                  ResultSet rs=DBLoader.executeSQL("select * from shopphotos where photoid="+id_del+" ");
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
         
          @PostMapping("/CheckOwnerBookings")
        public String CheckOwnerBookings(HttpSession session)
        {
              int ownerid = (int) session.getAttribute("owner_id");
              RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
              String ans=rdbms.generateJSON("select * from booking where ownerid="+ownerid);
              
               return ans;
        }
        
         @PostMapping("/CheckOwnerBookings2")
        public String CheckOwnerBookings2(HttpSession session)
        {
              int ownerid = (int) session.getAttribute("owner_id");
              RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
              String ans=rdbms.generateJSON("select * from packages where ownerid="+ownerid);
              
               return ans;
        }
        
         @PostMapping("/CheckOwnerApproval")
        public void CheckOwnerApproval(@RequestParam Integer bookingid)
        {
                   ResultSet rs=DBLoader.executeSQL("select * from booking where bookingid="+bookingid); 
                   try
                   {
                          if(rs.next())
                          {
                            System.out.println(bookingid);
                            String owner_status=rs.getString("status");
                              System.out.println(owner_status);
                            if(owner_status.equals("Pending"))
                            {
                                   rs.updateString("status","Confirmed");
                                   rs.updateRow();
                                  
                            }
                            else
                            {
                                   rs.updateString("status","Pending");
                                   rs.updateRow(); 
                        
                            }
                          }

                    
                   }
                   catch(Exception ex)
                   {
                           ex.toString();
                   }
        }   
}

