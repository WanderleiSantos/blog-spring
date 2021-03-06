package br.com.wanderlei.blog.web.controller;

import br.com.wanderlei.blog.entity.Avatar;
import br.com.wanderlei.blog.entity.Perfil;
import br.com.wanderlei.blog.entity.Usuario;
import br.com.wanderlei.blog.service.AvatarService;
import br.com.wanderlei.blog.service.UsuarioService;
import br.com.wanderlei.blog.web.editor.PerfilEditorSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

/**
 * Created by wanderlei on 07/05/17.
 */
@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private AvatarService avatarService;

    @InitBinder
    public void initBinder(WebDataBinder dataBinder){
        dataBinder.registerCustomEditor(Perfil.class, new PerfilEditorSupport());
    }

    @RequestMapping(value = {"/update/senha/{id}", "/update/senha"}, method = {RequestMethod.GET, RequestMethod.POST} )
    public ModelAndView updateSenha(@PathVariable("id") Optional<Long> id, @ModelAttribute("usuario") Usuario usuario){
        ModelAndView view = new ModelAndView();

        if(id.isPresent()){
            usuario = usuarioService.findById(id.get());
            view.addObject("usuario", usuario);
            view.setViewName("usuario/atualizar");
            return view;
        }

        usuarioService.updateSenha(usuario);
        view.setViewName("redirect:/usuario/perfil/" +usuario.getId());
        return view;
    }

    @RequestMapping(value = {"/update/{id}", "/update"}, method = {RequestMethod.GET, RequestMethod.POST} )
    public ModelAndView update(@PathVariable("id") Optional<Long> id, @ModelAttribute("usuario") Usuario usuario){
        ModelAndView view = new ModelAndView();

        if(id.isPresent()){
            usuario = usuarioService.findById(id.get());
            view.addObject("usuario", usuario);
            view.setViewName("usuario/atualizar");
            return view;
        }

        usuarioService.updateNomeAndEmail(usuario);
        view.setViewName("redirect:/usuario/perfil/" +usuario.getId());
        return view;
    }


    @RequestMapping(value = "list", method = RequestMethod.GET)
    public ModelAndView listUsuario(ModelMap modelMap){
        List<Usuario> usuarios = usuarioService.findAll();
        modelMap.addAttribute("usuarios", usuarios);

        return new ModelAndView("usuario/list",modelMap);
    }

    @RequestMapping(value = "/perfil/{id}", method = RequestMethod.GET)
    public ModelAndView perfil(@PathVariable("id") Long id){
        ModelAndView view = new ModelAndView();
        Usuario usuario = usuarioService.findById(id);
        view.addObject("usuario", usuario);
        view.setViewName("usuario/perfil");
        return view;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("usuario") Usuario usuario, @RequestParam(value = "file", required = false) MultipartFile file){
        Avatar avatar = avatarService.getAvatarByUpload(file);
        usuario.setAvatar(avatar);
        usuarioService.save(usuario);
        return "redirect:/usuario/perfil/" + usuario.getId();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView showForm(@ModelAttribute("usuario")Usuario usuario){
        return new ModelAndView("usuario/cadastro");
    }

}
