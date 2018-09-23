package org.parentsstepahead.psa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.parentsstepahead.psa.entity.Country;
import org.parentsstepahead.psa.entity.Parent;
import org.parentsstepahead.psa.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParentController {
	
	@Autowired
	ParentService parentService;
	

	
	@GetMapping("/parentsList")
	public String getParentsList(Model theModel) {	

		List<Parent> theParent = parentService.getParents();
		theModel.addAttribute("ParentsList", theParent);
		
		return "parentsList";
	}
    
	@PostMapping("/saveParent")
	public String saveParent(@ModelAttribute("parent") Parent theParent) {
		parentService.saveParent(theParent);	
		
		return "redirect:/parentsList";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("idParent") int theId, Model theModel) {	
		Parent theParent = parentService.getParent(theId);	
		theModel.addAttribute("parent", theParent);
				
		return "registrationForm";
	}
	
	@GetMapping("/delete")
	public String deleteParent(@RequestParam("idParent") int theId) {	
		parentService.deleteParent(theId);
		
		return "redirect:/parentsList";
	}
	
	@PostMapping("/search")
    public String searchParents(@RequestParam("theSearchName") String theSearchName, Model theModel) {
        List<Parent> parentsList = parentService.searchParents(theSearchName);
        theModel.addAttribute("ParentsList", parentsList);

        return "parentsList";
	}
	
	
    @GetMapping("/registrationForm")
    public String showRegistrationForm(Model theModel){
    	Parent theParent = new Parent();
    	theModel.addAttribute("parent", theParent);
    	initEducationLevel(theModel);
    	initIncome(theModel);
    	List<Country> countryOpt = parentService.getCountry();
    	System.out.printf("que paso %s",countryOpt);
    	theModel.addAttribute("CountryModel", countryOpt);
        return "registrationForm";
    }

	public void initEducationLevel(Model model) {
		ArrayList<String> educationLevelOptions = new ArrayList<>();
		educationLevelOptions.add("Choose...");
		educationLevelOptions.add("Elementary");
		educationLevelOptions.add("Middle");
		educationLevelOptions.add("High School");
		educationLevelOptions.add("College");
		educationLevelOptions.add("Higher education Level");
		educationLevelOptions.add("None");
		model.addAttribute("educationLevelOptModel", educationLevelOptions);
	}
	
	public void initIncome(Model model) {
		ArrayList<String> incomeOptions = parentService.getIncomeOptions();
		model.addAttribute("incomeOptModel", incomeOptions);
	}
    

}
