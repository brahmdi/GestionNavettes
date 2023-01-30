package com.example.gestionnav.controller;

import java.util.ArrayList;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.gestionnav.dao.ClientRepositry;
import com.example.gestionnav.dao.LoginDao;
import com.example.gestionnav.dao.NavettesRepositry;
import com.example.gestionnav.entites.Client;
import com.example.gestionnav.entites.DemandeNavettes;
import com.example.gestionnav.entites.DemandesCount;
import com.example.gestionnav.entites.Navettes;
import com.example.gestionnav.entites.Societe;
import com.example.gestionnav.entites.User;
import com.example.gestionnav.metier.ServicNavette;
import com.example.gestionnav.metier.ServiceClient;
import com.example.gestionnav.metier.ServiceDemandNav;
import com.example.gestionnav.metier.ServiceSociete;
import com.example.gestionnav.metier.ServiceUser;

@Controller
@Transactional
public class ControllerDefau {
	@Autowired
	ServicNavette serv ;
	@Autowired
	ServiceSociete servs ;
	LoginDao logindao ;
	@Autowired
	ServiceClient servc ;
	@Autowired
    ServiceUser servu ;
	@Autowired
	private PasswordEncoder passwordencoder ;
	@Autowired
	ServiceDemandNav servd ;
	
//   @GetMapping("/home")
//   public String home() {
//	   System.out.println("***********************************");
//       serv.afficheNavettes().forEach(n->{System.out.println(n.toString());});
//       System.out.println("***********************************");
//       servs.affichs().forEach(s->{
//    	   System.out.println(s.toString());
//    	   System.out.println("***********************************");
//    	   s.getNavettes().forEach(n->{System.out.println(n.toString());});
//       });
//       System.out.println("***************listes des navettes de la societe salama********************");
//       Optional<Societe> so = servs.findSociete(1) ;
//       so.get().getNavettes().forEach(s->{System.out.println(s.toString());});
//	   return"SaveNavettes";
//   }
	@GetMapping("/login")
	public String loginPage(Model model ) {
		 logindao = new LoginDao() ;
		model.addAttribute("logindao", logindao);
		
		
		return "login" ;
	}
	@GetMapping("/403")
	public String notAuthorized() {
		return "403"; // retourner la page 403.html
	}
	
	@GetMapping("/logout")
	public String logout(HttpServletRequest req) throws ServletException {
		req.logout() ;
		return "redirect:/login" ;
	}
   @GetMapping("/")
   public String home() {
//	   Societe so = servs.findSociete(Getusername());
////       so.get().getNavettes().forEach(s->{System.out.println(s.toString());});
//       model.addAttribute("navette",so.getNavettes());
//       logindao = log ;
//       System.out.println(log.toString());
//       System.out.println(Getusername());
//	   Optional<Client> c = crepo.findById((long) 1) ;
//	   c.get().getNavettes().forEach(n->{System.out.println(n.toString());});
//	   System.out.println(c.get().getUser().getUsername());
//	   ArrayList<Navettes> navettes = new ArrayList<Navettes>();
//	   navettes = serv.findnavettesbyville("", "") ;
//	   navettes.forEach(na->{System.out.println(na.toString());});
       servd.afficheDemandesCountes().forEach(d->{System.out.println(d.toString());});
	   
	   return "index" ;
   }
   @GetMapping("/Navettes")
   public String navettes(Model model) {
    Societe so = servs.findSociete(Getusername());
    model.addAttribute("navette",so.getNavettes());
	return "admin";
	   
   }
   @GetMapping("/admin")
   public String admin(Model model) {
	   Societe so = servs.findSociete(Getusername());
//     so.get().getNavettes().forEach(s->{System.out.println(s.toString());});
     model.addAttribute("navette",so.getNavettes());
     System.out.println(Getusername());
     return "admin";
   }
   @GetMapping("/AddNavette")
   public String addNavettes(Model model) {
	   Navettes nvt = new Navettes() ;
	   model.addAttribute("navettes", nvt);
//	   Navettes navettes = new Navettes("dds", "ds", "sd", "sds", "sds", "dsd", "ds", 22);
//	   serv.addNavettes(navettes, "salama");
	  
	   return "SaveNavettes" ;
   }
   @RequestMapping("/PostNavettes")
   public String saveNavettes(@ModelAttribute Navettes navettes) {
	   System.out.println("********************");
	   System.out.println(navettes.toString());
	   serv.addNavettes(navettes,Getusername());
	   System.out.println("********************");
	   return "redirect:/" ;
   }
   @GetMapping("/abonne")
   public String findabonne(Model model ,@RequestParam(name="dep" , defaultValue = "") String dep ,@RequestParam(name="arr" , defaultValue = "") String arr) {
	   Navettes nvt = new Navettes() ;
	   model.addAttribute("navette",serv.findnavettesbyville(dep, arr));
	   
	   return "abonne" ;
   }
   @GetMapping("/postAbonne")
   public String ajoutabonnement(@RequestParam(name="idNavette" , defaultValue = "1") int id_nav) {
    Optional<Navettes> nvt = serv.findByid((long) id_nav);
    User u = servu.finduserbyname(Getusername());
    Client cl = u.getClient() ;
    servc.addAbonnment(nvt, cl);
	return "redirect:abonne";
	   
   }
   @GetMapping("/registeruser")
   public String registeruser(Model model) {
	   Client cl = new Client();
	   model.addAttribute("Client", cl) ;
	   System.out.println("********************************************");
	   return "register" ;
   }
   @RequestMapping("/Postregister")
   public String register(@ModelAttribute Client cl) {
	
	User user = new User() ;
	user.setUsername(cl.getNomc());
	user.setPassword(passwordencoder.encode(cl.getUser().getPassword()));
	servu.adduser(user);
	servu.addRolToUser(user.getUsername(),"USER");
    servc.addClient(cl);
    user.setClient(cl);
	cl.setUser(user);
    
	
	return  "redirect:login";
   }
   
   @GetMapping("/demande")
   public String demandeNavettes(Model model) {
	   DemandeNavettes demande = new DemandeNavettes() ;
	   model.addAttribute("DemandeNavettes", demande);
	   return "demande" ;
   }
   @RequestMapping("/Postdemande")
   public String savedemande(@ModelAttribute DemandeNavettes demande) {
	   User u = servu.finduserbyname(Getusername());
	   Client cl = u.getClient() ;
	   servd.addDemand(cl, demande);
	   return "redirect:" ; 
   }
   @GetMapping("/showdemandesclients")
   public String showdemandesclients(Model model) {
	model.addAttribute("demandesNavetts", servd.afficheDemandesCountes());
	return "demandebyclients";
	   
   }
   @GetMapping("/postDemande")
   public String postDemande(@RequestParam(name="demande") String demand) {
//	   serv.addNavettes(new Navettes(demand.getDate_debut(), demand.getDate_fin(), demand.getH_dep(), demand.getH_ar(), demand.getH_dep(), demand.getV_ar(),"clime,wifi", 20),Getusername());
	   System.out.println("***************************************");
	   String dem = demand ;
	   ArrayList<String> listdem = matchString(dem);
	   for (String value : listdem) {
		    System.out.println(value);
		}
	   serv.addNavettes(new Navettes(listdem.get(0), listdem.get(1), listdem.get(2), listdem.get(3), listdem.get(4), listdem.get(5), "clime,wifi", 20), Getusername());
	   servd.deletedemande(listdem.get(4), listdem.get(5));
	   System.out.println("******************************************");
	   return "redirect:/" ; 
   }
   public ArrayList<String> matchString(String input ){
	   Pattern pattern = Pattern.compile("([a-z_]+)=([^,]+)");
	   Matcher matcher = pattern.matcher(input);

	   // Create a list to store the extracted values
	   ArrayList<String> values = new ArrayList<>();

	   // Iterate through all the matches and add them to the list
	   while (matcher.find()) {
	       values.add(matcher.group(2));
	   }
	   
	   return values ;
   }
   public String Getusername() {
//	   SecurityContext  is used to store the details of the currently authenticated user, also known as a principle
//	   The SecurityContextHolder is a helper class that provides access to the security context
	   Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       String username ;
	   if (principal instanceof UserDetails) {
	      username = ((UserDetails)principal).getUsername();
	   } else {
	      username = principal.toString();
	   }
	return username;
	  
   }

}
