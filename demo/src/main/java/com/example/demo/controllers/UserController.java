package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import com.example.demo.entities.Offer;
import com.example.demo.entities.Request;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.OfferRepository;
import com.example.demo.repositories.RequestRepository;
import com.example.demo.repositories.UserRespository;
import com.example.demo.service.UserService;

import jakarta.persistence.criteria.CriteriaBuilder.In;


@Controller
public class UserController {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private RequestRepository requestRepository;

    @RequestMapping("/retrieve")
    public String retrieve(Authentication authentication){
        Account account = accountRepository.findByUsername(authentication.getName()).get();
        String url = "/dashboard/" + account.getId();
        return "redirect:" + url;
    }

    @RequestMapping("/dashboard/{id}")
    public String dashboard(@PathVariable("id") Integer id, Model model){
        User user = userService.loadById(id);
        model.addAttribute("user", user);
        List<Offer> offers = offerRepository.offerByIdtop(id);
        model.addAttribute("offers", offers);
        List<Request> requests = requestRepository.requestByIdtop(id);
        model.addAttribute("requests", requests);
        return "user/dashboard";
    }  

    @RequestMapping("/profile/{id}")
    public String profile(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", userService.loadById(id));
        return "user/profile";
    }

    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, Model model){
        model.addAttribute("user", userService.loadById(id));
        return "user/update";
    }

    @RequestMapping("/update/{id}/save")
    public String saveProfile(@PathVariable("id")Integer id, @ModelAttribute("user") User user, Model model){
        user.setAccountId(id);
        System.err.println(user.getAdress() + " " + user.getAccountId() + " " + user.getAuthors() + " " + user.getCategories() + " " + user.getName() + " " + user.getPhoneNumber() + " " + user.getAge());
        userService.updateUser(user);
        return "redirect:/profile/" + user.getAccountId();
    }

    @RequestMapping("/user/{id}/offers")
    public String offers(@PathVariable("id") Integer id, Model model){
        model.addAttribute("accountId", id);
        List<Offer> offers = offerRepository.offerById(id);
        model.addAttribute("offers", offers);
        return "user/offers";
    }

    @RequestMapping("/user/{id}/offers/new")
    public String offersNew(@PathVariable("id") Integer id, Model model){
        model.addAttribute("accountId", id);
        System.err.println(new Offer().getId());
        model.addAttribute("offer", new Offer());
        return "user/newOffer";
    }

    @RequestMapping("/user/{id}/offers/new/save")
    public String offerSave(@PathVariable("id") Integer id, Offer offer, Model model){
        if (!offer.notNull()){
            return"redirect:/user/" + id + "/offers/new";
        }
        offer.setId(null);
        offer.setAccountId(id);
        offerRepository.save(offer);

        return"redirect:/user/" + id + "/offers";
    }

    @RequestMapping("/user/{id}/offers/delete/{offerId}")
    public String offerDelete(@PathVariable("id") Integer id, @PathVariable("offerId") Integer offerId, Model model){
        offerRepository.deleteById(offerId);
        return "redirect:/user/" + id + "/offers";
    }

    @RequestMapping("/user/{id}/requests")
    public String requests(@PathVariable("id") Integer id, Model model){
        model.addAttribute("accountId", id);
        List<Request> requests = requestRepository.requestById(id);
        model.addAttribute("requests", requests);
        return "user/requests";
    }

    @RequestMapping("/user/{id}/requests/delete/{requestId}")
    public String requestDelete(@PathVariable("id") Integer id, @PathVariable("requestId") Integer requestId, Model model){
        requestRepository.deleteById(requestId);
        return "redirect:/user/" + id + "/requests";
    }

    @RequestMapping("/user/{id}/search")
    public String search(@PathVariable("id") Integer id, Model model){
        User user = userService.loadById(id);
        model.addAttribute("user", user);
        List<Offer> offers = offerRepository.offerByDiffId(id);
        model.addAttribute("offers", offers);
        return "user/search";
    }

    @RequestMapping("/user/{id}/search/new")
    public String searchNew(@PathVariable("id") Integer id, Request request, Model model){
        model.addAttribute("accountId", id);
        model.addAttribute("request", new Request());
        request.setAccountId(id);
        request.setId(null);
        requestRepository.save(request);
        return "user/requests";
    }

    

}
