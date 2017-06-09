package br.com.wanderlei.blog.web.editor;

import br.com.wanderlei.blog.entity.Categoria;
import br.com.wanderlei.blog.service.CategoriaService;
import org.springframework.beans.propertyeditors.CustomCollectionEditor;

import java.util.Collection;

/**
 * Created by wanderlei on 09/06/17.
 */
public class CategoriaEditorSupport extends CustomCollectionEditor{

    private CategoriaService service;

    public CategoriaEditorSupport(Class<? extends Collection> collectionType, CategoriaService service) {
        super(collectionType);
        this.service = service;
    }

    @Override
    protected Object convertElement(Object element) {
        Long id = Long.valueOf((String) element);
        Categoria categoria = service.findById(id);
        return super.convertElement(categoria);
    }
}
