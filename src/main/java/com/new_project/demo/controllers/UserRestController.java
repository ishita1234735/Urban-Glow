package com.new_project.demo.controllers;
import com.new_project.demo.vmm.DBLoader;
import com.new_project.demo.vmm.RDBMS_TO_JSON;
import jakarta.servlet.http.HttpSession;
import java.io.FileOutputStream;
import org.springframework.web.bind.annotation.*;
import java.sql.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UserRestController 
{
         @PostMapping("/CheckUserSignup")
         public String CheckUserSignup(@RequestParam String uname, @RequestParam String uemail,@RequestParam String upass,@RequestParam MultipartFile uphoto, @RequestParam String uaddress)
         {
                 ResultSet rs=DBLoader.executeSQL("select * from user");
                 try
                 {
                       String oname1=uphoto.getOriginalFilename();
                          byte b1[]= uphoto.getBytes();
                                
                          String photo_path2= "src/main/resources/static/myphotos/";   
                           
                          FileOutputStream fs1=new FileOutputStream(photo_path2+oname1);
                          fs1.write(b1);
                          
                     rs.moveToInsertRow();
                     
                     rs.updateString("uname",uname);
                     rs.updateString("uemail",uemail);
                     rs.updateString("upassword",upass);
                     rs.updateString("uphoto","myphotos/"+oname1);
                     rs.updateString("uaddress", uaddress);
                     
                     rs.insertRow();
                     
                     return "success";
                 }
                 catch(Exception ex)
                 {
                       return ex.toString();
                 }
         } 
         
         @PostMapping("/CheckUserLogin")
         public String CheckUserLogin(@RequestParam String uemail, @RequestParam String upass, HttpSession session)
         {
                ResultSet rs=DBLoader.executeSQL("select * from user where uemail= '"+uemail+"' and upassword='"+upass+"' ");
                try
                {
                         if(rs.next())
                         {
                               session.setAttribute("uemail", uemail);
                               session.setAttribute("user_id",rs.getInt("userid"));
                               session.setAttribute("user_name",rs.getString("uname"));
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
         
         @GetMapping("/ShowCityData")
        public String ShowCityData()
        {
              RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
              String ans=rdbms.generateJSON("select * from city");
              
               return ans;
        }
        
        @PostMapping("/ViewSalons")
        public String ViewSalons(@RequestParam Integer cid2)
        {  
              RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
              String ans=rdbms.generateJSON("select * from owner_table where cityid="+cid2+" and status='Approved' ");
              
               return ans;
        }
        
         @PostMapping("/ViewOwnerDetails")
        public String ViewOwnerDetails(@RequestParam Integer oid2)
        {
              RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
              String ans=rdbms.generateJSON("select * from owner_table where ownerid="+oid2);
              
               return ans;
        }
        
         @PostMapping("/ViewShopDetails")
        public String ViewShopDetails(@RequestParam Integer oid3)
        {
              RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
              String ans=rdbms.generateJSON("select * from shopphotos where ownerid="+oid3);
              
               return ans;
        }
        
         @PostMapping("/ViewPackageDetails")
        public String ViewPackageDetails(@RequestParam Integer oid4)
        {
              RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
              String ans=rdbms.generateJSON("select * from packages where ownerid="+oid4);
              
               return ans;
        }
        
         @PostMapping("/CheckPackageServiceDetails")
        public String CheckPackageServiceDetails(@RequestParam Integer pid1)
        {
              RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
              String ans=rdbms.generateJSON("select * from packages where packageid="+pid1);
              
               return ans;
        }
 
          
@PostMapping("/CheckUserBooking")
public String CheckUserBooking(@RequestParam String unm,
                               @RequestParam String udate,
                               @RequestParam String utime,
                               @RequestParam String umode,
                               @RequestParam String uaddress,
                               @RequestParam String upackageid,
                               HttpSession session)
{
    try
    {
        int user_id1 = (int) session.getAttribute("user_id");
        String user_email1 = (String) session.getAttribute("uemail");

        ResultSet rs1 = DBLoader.executeSQL("select * from packages where packageid='" + upackageid + "'");

        int ownerid = 0;

        if(rs1.next())
        {
            ownerid = rs1.getInt("ownerid");
        }

        ResultSet rs = DBLoader.executeSQL("select * from booking");

        rs.moveToInsertRow();

        rs.updateString("username", unm);
        rs.updateInt("userid", user_id1);
        rs.updateString("useremail", user_email1);
        rs.updateString("bookingdate", udate);
        rs.updateString("bookingtime", utime);
        rs.updateString("modeofpayment", umode);
        rs.updateString("address", uaddress);

        rs.updateInt("packageid", Integer.parseInt(upackageid));


        rs.updateInt("ownerid", ownerid);

        rs.insertRow();

        return "success";
    }
    catch(Exception ex)
    {
        ex.printStackTrace();
        return ex.toString();
    }
} 
         
        @PostMapping("/CheckUserBookingHistory")
        public String CheckUserBookingHistory(HttpSession session)
        {
              int userid = (int) session.getAttribute("user_id");
              RDBMS_TO_JSON rdbms=new RDBMS_TO_JSON();
              String ans=rdbms.generateJSON("select * from booking where userid="+userid);
              
               return ans;
        }
        
        
      
}