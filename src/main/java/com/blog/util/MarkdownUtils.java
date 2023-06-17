package com.blog.util;

import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;

import java.sql.Blob;

/*
markdown to html
* */
public class MarkdownUtils {
    public static String marktohtml(String content) {
        Parser parser = Parser.builder().build();
        //链表节点
        Node document = parser.parse(content);
        HtmlRenderer renderer = HtmlRenderer.builder().build();
        return renderer.render(document);
    }
}
