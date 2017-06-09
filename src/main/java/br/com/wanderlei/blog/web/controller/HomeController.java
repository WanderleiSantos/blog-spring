package br.com.wanderlei.blog.web.controller;

import br.com.wanderlei.blog.entity.Postagem;
import br.com.wanderlei.blog.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by wanderlei on 09/06/17.
 */
@Controller
public class HomeController {

    @Autowired
    private PostagemService postagemService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(ModelMap model){
        List<Postagem> postagems = postagemService.findAll();
        model.addAttribute("postagens", postagems);
        return new ModelAndView("posts", model);
    }
}
