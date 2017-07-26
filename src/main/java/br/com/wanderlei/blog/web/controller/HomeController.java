package br.com.wanderlei.blog.web.controller;

import br.com.wanderlei.blog.entity.Comentario;
import br.com.wanderlei.blog.entity.Postagem;
import br.com.wanderlei.blog.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by wanderlei on 09/06/17.
 */
@Controller
public class HomeController {

    @Autowired
    private PostagemService postagemService;

    @RequestMapping(value = "/search/texto/{texto}/page/{page}", method = RequestMethod.GET)
    public ModelAndView search(@PathVariable("texto") String texto,
                               @PathVariable("page") Integer pagina, ModelMap model) {

        Page<Postagem> page = postagemService.findByTexto(pagina - 1, 2, texto);
        model.addAttribute("page", page);
        model.addAttribute("urlPagination", "/search/texto/"+ texto +"/page");
        return new ModelAndView("posts", model);
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView search(@RequestParam("texto") String texto, ModelMap model) {

        Page<Postagem> page = postagemService.findByTexto(0, 2, texto);
        model.addAttribute("page", page);
        model.addAttribute("urlPagination", "/search/texto/"+ texto +"/page");
        return new ModelAndView("posts", model);
    }

    @RequestMapping(value = "/{permalink}", method = RequestMethod.GET)
    public ModelAndView openPostagem(
            @ModelAttribute("comentario") Comentario comentario,
            @PathVariable("permalink") String permalink, ModelMap model) {

        Postagem postagem = postagemService.findByPermalink(permalink);

        model.addAttribute("postagem", postagem);

        return new ModelAndView("post", model);
    }

    @RequestMapping(value = "/autor/{id}/page/{page}", method = RequestMethod.GET)
    public ModelAndView postsByAutor(
            @PathVariable("id") Long id, @PathVariable("page") Integer pagina, ModelMap model) {

        Page<Postagem> page = postagemService.findByPaginationByAutor(pagina - 1, 2, id);
        model.addAttribute("page", page);
        model.addAttribute("urlPagination", "/autor/" + id + "/page");

        return new ModelAndView("posts", model);
    }

    @RequestMapping(value = "/categoria/{link}/page/{page}", method = RequestMethod.GET)
    public ModelAndView postsByCategoria(
            @PathVariable("page") Integer pagina,
            @PathVariable("link") String link, ModelMap model) {

        Page<Postagem> page = postagemService.findByPaginationByCategoria(pagina - 1, 2, link);
        model.addAttribute("page", page);
        model.addAttribute("urlPagination", "/categoria/" + link + "/page");

        return new ModelAndView("posts", model);
    }

    @RequestMapping(value = "/page/{page}", method = RequestMethod.GET)
    public ModelAndView pageHome(@PathVariable("page") Integer pagina, ModelMap model) {

        Page<Postagem> page = postagemService.findByPagination(pagina-1, 2);

        model.addAttribute("page", page);
        model.addAttribute("urlPagination", "/page");
        return new ModelAndView("posts", model);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home(ModelMap model) {

        Page<Postagem> page = postagemService.findByPagination(0, 2);
        model.addAttribute("page", page);
        model.addAttribute("urlPagination", "/page");

        return new ModelAndView("posts", model);
    }
}
