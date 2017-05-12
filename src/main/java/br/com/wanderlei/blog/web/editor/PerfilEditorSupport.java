package br.com.wanderlei.blog.web.editor;

import br.com.wanderlei.blog.entity.Perfil;

import java.beans.PropertyEditorSupport;

/**
 * Created by wanderlei on 11/05/17.
 */
public class PerfilEditorSupport extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text.equals("ADMIN")){
            super.setValue(Perfil.ADMIN);
        } else if (text.equals("AUTOR")){
            super.setValue(Perfil.AUTOR);
        } else {
            super.setValue(Perfil.LEITOR);
        }
    }
}
