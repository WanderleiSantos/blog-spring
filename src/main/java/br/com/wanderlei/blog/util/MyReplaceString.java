package br.com.wanderlei.blog.util;

import java.text.Normalizer;

/**
 * Created by wanderlei on 01/06/17.
 */
public class MyReplaceString {

    public static String formatarPermalink(String value){
        String link = value.trim();
        link = link.toLowerCase();
        link = Normalizer.normalize(link, Normalizer.Form.NFD);
        link = link.replaceAll("\\s", "_");
        link = link.replaceAll("\\W", "");
        link = link.replaceAll("\\_+", "_");
        return link;
    }
}
