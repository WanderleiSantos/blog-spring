package br.com.wanderlei.blog.web.controller;

import br.com.wanderlei.blog.entity.Postagem;
import br.com.wanderlei.blog.service.CategoriaService;
import br.com.wanderlei.blog.service.PostagemService;
import br.com.wanderlei.blog.web.editor.CategoriaEditorSupport;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by wanderlei on 07/06/17.
 */
@Controller
@RequestMapping("postagem")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;
    @Autowired
    private CategoriaService categoriaService;

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(List.class, new CategoriaEditorSupport(List.class, categoriaService));
    }

    @RequestMapping(value = "/ajax/page/{page}", method = RequestMethod.GET)
    public ModelAndView pagePostagens(@PathVariable("page") Integer pagina) {

        ModelAndView view = new ModelAndView("postagem/table-rows");
        Page<Postagem> page = postagemService.findByPagination(pagina - 1, 3);
        view.addObject("page", page);

        return view;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap modelMap){
        Postagem postagem = postagemService.findById(id);
        modelMap.addAttribute("postagem", postagem);
        modelMap.addAttribute("categorias", categoriaService.findAll());
        return new ModelAndView("postagem/cadastro", modelMap);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id){
        postagemService.delete(id);
        return "redirect:/postagem/list";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView listPostagem(ModelMap modelMap){

        Page<Postagem> page = postagemService.findByPagination(0, 3);

        modelMap.addAttribute("page", page);
        //modelMap.addAttribute("urlPagination", "/postagem/page");

        return new ModelAndView("postagem/list", modelMap);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("postagem")Postagem postagem){

        postagemService.saveOrUpdate(postagem);

        return "redirect:/postagem/list";

    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView cadastro(@ModelAttribute("postagem")Postagem postagem){
        ModelAndView view = new ModelAndView("postagem/cadastro");
        view.addObject("categorias", categoriaService.findAll());
        return view;
    }

    @RequestMapping(value = "/ajax/titulo/{titulo}/page/{page}", method = RequestMethod.GET)
    public ModelAndView searchByAjax(@PathVariable("titulo") String titulo, @PathVariable("page") Integer pagina){
        ModelAndView view = new ModelAndView("postagem/table-rows");
        Page<Postagem> page = postagemService.findByTitulo(pagina -1, 2, titulo);
        view.addObject("page", page);
        return view;
    }
}
