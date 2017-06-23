package br.com.wanderlei.blog.web.controller;

import br.com.wanderlei.blog.entity.Categoria;
import br.com.wanderlei.blog.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wanderlei on 09/06/17.
 */
@Controller
@RequestMapping("categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model){

        Categoria categoria = categoriaService.findById(id);
        model.addAttribute("categoria", categoria);

        Page<Categoria> page = categoriaService.findByPagination(0, 2);
        model.addAttribute("page", page);

        return new ModelAndView("categoria/cadastro", model);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") Long id){
        categoriaService.delete(id);
        return "redirect:/categoria/add";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("categoria") Categoria categoria){
        categoriaService.saveOrUpdate(categoria);
        return "redirect:/categoria/add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView cadastro(@ModelAttribute("categoria")Categoria categoria){
        ModelAndView view = new ModelAndView();

        Page<Categoria> page = categoriaService.findByPagination(0, 2);
        view.addObject("page", page);

        view.setViewName("categoria/cadastro");
        return view;
    }

    @RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
    public ModelAndView pageCategorias(@PathVariable("page") Integer pagina, @ModelAttribute("categoria") Categoria categoria){
        ModelAndView view = new ModelAndView("categoria/cadastro");
        Page<Categoria> page = categoriaService.findByPagination(pagina - 1, 2);
        view.addObject("page", page);
        return view;
    }

}
