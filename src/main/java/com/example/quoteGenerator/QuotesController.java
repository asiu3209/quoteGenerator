package com.example.quoteGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//controller class takes information from service class
@Controller
public class QuotesController {
    private final QuoteService quotes;
    private Quote quote;
//constructor needed for springboot to inject service class into controller class
    public QuotesController(QuoteService quotes){
        this.quotes = quotes;
        quote = quotes.generateQuote();
    }
    // the slash is the file path, essentially this is homepage
    @GetMapping("/")
    public String home(Model model){
        String quoteText = (quote != null && quote.getQuote() != null) ? quote.getQuote() : "No quote available.";
        model.addAttribute("quotes", quoteText);
        model.addAttribute("author", quote.getAuthor());
        //what should be returned is the name of the html file
        return "index";
    }
    //when /new is called from html button
    @GetMapping("/new")
    public String newQuote(Model model){
        quote = quotes.generateQuote();
        String quoteText = (quote != null && quote.getQuote() != null) ? quote.getQuote() : "No quote available.";
        model.addAttribute("quotes", quoteText);
        model.addAttribute("author", quote.getAuthor());
        return "index";
    }
}
