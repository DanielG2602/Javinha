package com.AprendendoJava.Javinha;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/primeirapagina")
    public String boasVindas() {
        return "Hello World";
    };

}
