
package springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import springmvc.dao.EmpDao;
import springmvc.model.Emp;
import springmvc.service.EmpService;

@Controller
public class EmpController {

    private final EmpService empService;
    private final EmpDao empDao;

    @Autowired
    public EmpController(EmpService empService, EmpDao empDao) {
        this.empService = empService;
        this.empDao = empDao;
    }

    @ModelAttribute
    public void commonDataForModel(Model m) {
        m.addAttribute("Header", "LearnCodeWithHamid");
        m.addAttribute("Desc", "Home For Programmers");
        System.out.println("adding common data to model");
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String showEmployeeList(Model model) {
       model.addAttribute("list", empDao.getAll());
        return "viewEmployee";
        
    }

   @RequestMapping(path = "/addEmployee", method = RequestMethod.GET)
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("emp", new Emp()); // Assuming you want to bind a new Emp object to the form
        return "addEmployee";
    }
   

 

   
   @RequestMapping(value = "/editemp/{id}")
   public String edit(@PathVariable int id, Model model) {
       Emp emp = null;
       try {
           emp = empService.getById(id);
       } catch (Exception e) {
           e.printStackTrace();
       }
       model.addAttribute("command", emp); // Uncomment this line if needed
       return "empeditform";
   }
   
   @RequestMapping(path = "/employeebyid", method = RequestMethod.GET)
   public String employeeByIdForm(Model model) {
       model.addAttribute("emp", new Emp());
       return "employeebyid";
   }
   
   @RequestMapping(path = "/getEmployeeById", method = RequestMethod.POST)
   public String getEmployeeById(@ModelAttribute("emp") Emp emp, RedirectAttributes redirectAttributes) {
       try {
           int id = emp.getEmployeeNo();
           Emp retrievedEmployee = empService.getById(id);

           if (retrievedEmployee != null) {
               redirectAttributes.addFlashAttribute("msg", "Employee found!");
               // Redirect to a page to display the details of the retrieved employee
               return "redirect:/empiddata" + retrievedEmployee.getEmployeeNo();
           } else {
               redirectAttributes.addFlashAttribute("msg", "Employee not found!");
               // Redirect back to the form with an appropriate message
               return "redirect:/employeebyid";
           }
       } catch (Exception e) {
           // Handle exceptions appropriately
           e.printStackTrace();
           return "redirect:/employeebyid";
       }
   }


   @RequestMapping("/empiddata")
   public String getEmployeeDetails(Model model) {
   
       Emp employee =new Emp(); // retrieve employee details

      
       model.addAttribute("emp", employee);

       // Return the view name (e.g., "empiddata.jsp")
       return "empiddata";
   }



    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public String handleForm(@ModelAttribute Emp emp, RedirectAttributes redirectAttributes) {
        int createdUser = this.empService.createEmp(emp);
        redirectAttributes.addFlashAttribute("msg", "Successfully added!");
        return "redirect:/addEmployee";
    }
    
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String updateForm(@ModelAttribute Emp emp, RedirectAttributes redirectAttributes) {
        int updatedUser = this.empService.updateEmp(emp);
        redirectAttributes.addFlashAttribute("msg", "Successfully updated!");
        // Redirect to the edit page for the updated employee
        return "redirect:/editemp/" + emp.getEmployeeNo();
    }
    
    @RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id, RedirectAttributes redirectAttributes) {
        try {
            empService.deleteEmp(id);
            redirectAttributes.addFlashAttribute("msg", "Successfully deleted!");
        } catch (Exception e) {
            // Handle exceptions appropriately
            e.printStackTrace();
        }
        return "redirect:/";
    }
    
    
    
    


}

