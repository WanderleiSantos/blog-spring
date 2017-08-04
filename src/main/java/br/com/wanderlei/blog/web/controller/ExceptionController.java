package br.com.wanderlei.blog.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by wanderlei on 03/08/17.
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView genericException(HttpServletRequest request, Exception ex){
        ModelAndView view = new ModelAndView("error");
        view.addObject("mensagem", "Erro, tente novamente.");
        view.addObject("url", request.getRequestURL());
        view.addObject("excecao", ex);

        return view;
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, code = HttpStatus.NOT_FOUND)
    public ModelAndView noHandlerFoundException(HttpServletRequest request, NoHandlerFoundException ex){

        ModelAndView view = new ModelAndView("error");
        view.addObject("mensagem", "Ops, página não encontrada. :(");
        view.addObject("url", request.getRequestURL());
        view.addObject("excecao", ex);

        return view;
    }

}
