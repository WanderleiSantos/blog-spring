package br.com.wanderlei.blog.web.controller;

import br.com.wanderlei.blog.entity.Comentario;
import br.com.wanderlei.blog.entity.Postagem;
import br.com.wanderlei.blog.service.ComentarioService;
import br.com.wanderlei.blog.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Wanderlei Santos on 21/06/2017.
 */
@Controller
@RequestMapping("comentario")
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private PostagemService postagemService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("comentario") @Validated Comentario comentario, BindingResult result, @RequestParam("permalink") String permalink){

        Postagem postagem = postagemService.findByPermalink(permalink);

        if (result.hasErrors()){
            return new ModelAndView("post","postagem", postagem);
        }

        comentario.setPostagem(postagem);
        comentarioService.save(comentario);
        return new ModelAndView("redirect:/" +permalink);
    }
}
