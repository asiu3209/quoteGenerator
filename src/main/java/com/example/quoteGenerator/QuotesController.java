package com.example.quoteGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//controller class takes information from service class
@Controller
public class QuotesController {
    private final Quotes quotes;
//constructor needed for springboot to inject service class into controller class
    public QuotesController(Quotes quotes){
        this.quotes = quotes;
    }
    // the slash is the file path, essentially this is homepage
    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("quotes", quotes.getQuote());
        //what should be returned is the name of the html file
        return "index";
    }
    //when /new is called from html button
    @GetMapping("/new")
    public String newQuote(Model model){
        model.addAttribute("quotes", quotes.getQuote());
        return "index";
    }
}
