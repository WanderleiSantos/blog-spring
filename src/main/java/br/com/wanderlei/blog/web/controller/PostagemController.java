package br.com.wanderlei.blog.web.controller;

import br.com.wanderlei.blog.entity.Postagem;
import br.com.wanderlei.blog.service.PostagemService;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wanderlei on 07/06/17.
 */
@Controller
@RequestMapping("postagem")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;


    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap modelMap){
        Postagem postagem = postagemService.findById(id);
        modelMap.addAttribute("postagem", postagem);
        return new ModelAndView("postagem/cadastro", modelMap);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id){
        postagemService.delete(id);
        return "redirect:/postagem/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listPostagem(ModelMap modelMap){
        modelMap.addAttribute("postagens", postagemService.findAll());
        return new ModelAndView("postagem/list", modelMap);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("postagem")Postagem postagem){

        postagemService.saveOrUpdate(postagem);

        return "redirect:/postagem/list";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView cadastro(@ModelAttribute("postagem")Postagem postagem){
        return new ModelAndView("postagem/cadastro");
    }
}
