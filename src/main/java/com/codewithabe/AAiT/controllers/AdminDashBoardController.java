// package com.EthioPharmacy.EthioPharmacy.controllers;


// import com.EthioPharmacy.EthioPharmacy.models.EventCatagory;
// import com.EthioPharmacy.EthioPharmacy.models.Medicine;
// import com.EthioPharmacy.EthioPharmacy.repository.EventCatagoryRepository;
// import com.EthioPharmacy.EthioPharmacy.repository.MedicineRepository;
// import com.EthioPharmacy.EthioPharmacy.service.MedicineService;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.util.StringUtils;
// import org.springframework.validation.Errors;
// import org.springframework.web.bind.annotation.*;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.ModelAndView;

// import javax.validation.Valid;
// import java.io.IOException;
// import java.util.Base64;
// import java.util.Optional;


// @Controller
// @RequestMapping(value="/")
// public class AdminDashBoardController {

//     @Autowired
//     private MedicineRepository medicineRepository;

//     @Autowired
//     private EventCatagoryRepository catagoryRepository;


//     @Autowired
//     private MedicineService medicineService;


//     @GetMapping("/admindashboard")
//     public String displayAdminDashBoard(Model model) {
//         model.addAttribute("title", "DashBoard");
//         model.addAttribute("medicines", medicineRepository.findAll());
//         model.addAttribute("catagories", catagoryRepository.findAll());
//         return "meds/admindashboard";
//     }



//     @GetMapping(path = "/add")
//     public String displayAddForm(Model model) {

//         model.addAttribute("catagories", catagoryRepository.findAll());
//         model.addAttribute("title", "Add Medicine");
//         model.addAttribute(  new Medicine());
//         model.addAttribute("catagories", catagoryRepository.findAll());
//         return "meds/addmedform";
//     }

//     @PostMapping("/add")
//     public String processAddForm(@ModelAttribute   Medicine newMed, Errors errors, Model model,
//                                  @RequestParam int catagoryId,

//                                  @RequestParam("file") MultipartFile file){
//         if(errors.hasErrors()) {
//             model.addAttribute("title", "Add Medicine");
//             model.addAttribute("catagories", catagoryRepository.findAll());
//             return "meds/addMedForm";
//         }

//         String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//         if (fileName.contains("...")) {
//             System.out.println("not a valid file");
//         }

//         Optional<EventCatagory> newCat = catagoryRepository.findById(catagoryId);
//         EventCatagory cat = newCat.get();
//         newMed.setCatagory(cat);
//         try {
//             newMed.setMedImage(Base64.getEncoder().encodeToString(file.getBytes()));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//         medicineRepository.save(newMed);
//         return "redirect:/admindashboard";
//     }

//     @GetMapping("/addedProduct")
//     public String showAddedProducts(Model model) {
//         model.addAttribute("medicines", medicineRepository.findAll());
//         model.addAttribute("selected" , new Medicine());
//         model.addAttribute("catagories", catagoryRepository.findAll());

//         return "admindashboard";
//     }



//     @PostMapping("/admindashboard")
//     public String processRemovedProduct(  @RequestParam int[] medIds) {
//         for(int medId : medIds) {
//             medicineRepository.deleteById(medId);
//         }
//         return "redirect:admindashboard";
//     }


//     @GetMapping("/update{id}")
//     public String displayUpdate(@PathVariable(name = "id") int id, Model model ) {
//         Medicine update = medicineRepository.findById(id).get();
//         Medicine newMed = new Medicine();
//         newMed.setId(update.getId());
//         newMed.setMedName(update.getMedName());
//         newMed.setMedPrice(update.getMedPrice());
//         newMed.setMedDescription(update.getMedDescription());
//         model.addAttribute("catagories", catagoryRepository.findAll());
//         model.addAttribute("medicine", newMed);
//         return "meds/update";
//     }


//     @PostMapping("/update")
//     public String processUpdate( @ModelAttribute("medicine") Medicine newMed,
//                                  @RequestParam(name = "id") int id,
//                                  @RequestParam int catagoryId,
//                                  @RequestParam("file") MultipartFile file) {

//         String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//         if (fileName.contains("...")) {
//             System.out.println("not a valid file");
//         }

//         try {
//             newMed.setMedImage(Base64.getEncoder().encodeToString(file.getBytes()));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }

//         Optional<EventCatagory> newCat = catagoryRepository.findById(catagoryId);
//         EventCatagory cat = newCat.get();
//         newMed.setCatagory(cat);



//         Medicine update = medicineRepository.findById(id).get();
//         update.setId(newMed.getId());
//         update.setMedName(newMed.getMedName());
//         update.setMedPrice(newMed.getMedPrice());
//         update.setMedDescription(newMed.getMedDescription());
//         update.setCatagory(newMed.getCatagory());
//         update.setMedImage(newMed.getMedImage());
//         medicineRepository.save(update);
//         return "redirect:admindashboard";


//     }



// }

package com.codewithabe.AAiT.controllers;


import com.codewithabe.AAiT.models.Event;
import com.codewithabe.AAiT.models.EventCatagory;
import com.codewithabe.AAiT.repository.EventCatagoryRepository;
import com.codewithabe.AAiT.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.Base64;
import java.util.Optional;


@Controller
@RequestMapping(value="/")
public class AdminDashBoardController {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventCatagoryRepository catagoryRepository;


    @GetMapping("/admindashboard")
    public String displayAdminDashBoard(Model model) {
        model.addAttribute("title", "DashBoard");
        model.addAttribute("event", eventRepository.findAll());
        model.addAttribute("catagories", catagoryRepository.findAll());
        return "meds/admindashboard";
    }



    @GetMapping(path = "/add")
    public String displayAddForm(Model model) {

        model.addAttribute("catagories", catagoryRepository.findAll());
        model.addAttribute("title", "Add Event");
        model.addAttribute(  new Event());
        model.addAttribute("catagories", catagoryRepository.findAll());
        return "meds/addmedform";
    }

    @PostMapping("/add")
    public String processAddForm(@Valid @ModelAttribute Event newEvent, Errors errors, Model model,
                                 @RequestParam int catagoryId,

                                 @RequestParam("file") MultipartFile file){
        if(errors.hasErrors()) {
            model.addAttribute("title", "Add Medicine");
            model.addAttribute("catagories", catagoryRepository.findAll());
            return "meds/addMedForm";
        }

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("...")) {
            System.out.println("not a valid file");
        }

        Optional<EventCatagory> newCat = catagoryRepository.findById(catagoryId);
        EventCatagory cat = newCat.get();
        newEvent.setCatagory(cat);
        try {
            newEvent.setEventImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        eventRepository.save(newEvent);
        return "redirect:/admindashboard";
    }

    @GetMapping("/addedProduct")
    public String showAddedProducts(Model model) {
        model.addAttribute("Events", eventRepository.findAll());
        model.addAttribute("selected" , new Event());
        model.addAttribute("catagories", catagoryRepository.findAll());

        return "admindashboard";
    }



    @PostMapping("/admindashboard")
    public String processRemovedProduct(  @RequestParam int[] eventIds) {
        for(int eventId : eventIds) {
            eventRepository.deleteById(eventId);
        }
        return "redirect:admindashboard";
    }


    @GetMapping("/update{id}")
    public String displayUpdate(@PathVariable(name = "id") int id, Model model ) {
        Event update = eventRepository.findById(id).get();
        Event newEvent = new Event();
        newEvent.setId(update.getId());
        newEvent.setEventName(update.getEventName());
        newEvent.setEventDescription(update.getEventDescription());
        model.addAttribute("catagories", catagoryRepository.findAll());
        model.addAttribute("event", newEvent);
        return "meds/update";
    }
@PostMapping("/update")
    public String processUpdate( @ModelAttribute("medicine") Event newEvent,
                                 @RequestParam(name = "id") int id,
                                 @RequestParam int catagoryId,
                                 @RequestParam("file") MultipartFile file) {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("...")) {
            System.out.println("not a valid file");
        }

        try {
            newEvent.setEventImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Optional<EventCatagory> newCat = catagoryRepository.findById(catagoryId);
        EventCatagory cat = newCat.get();
        newEvent.setCatagory(cat);



        Event update =eventRepository.findById(id).get();
        update.setId(newEvent.getId());
        update.setEventName(newEvent.getEventName());
        update.setEventDescription(newEvent.getEventDescription());
        update.setCatagory(newEvent.getCatagory());
        update.setEventImage(newEvent.getEventImage());
        eventRepository.save(update);
        return "redirect:admindashboard";


    }



}
