package com.designPattern.state.core;

public class DocumentoPublicado extends DocumentoEstado{

    private static DocumentoEstado instance = new DocumentoPublicado();

    public static DocumentoEstado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Documento Publicado";
    }
}
