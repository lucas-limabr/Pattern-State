package com.designPattern.state.core;

public class DocumentoEmRevisao extends DocumentoEstado {

    private static DocumentoEstado instance = new DocumentoEmRevisao();

    public static DocumentoEstado getInstance() {
        return instance;
    }

    @Override
    public boolean escreverRascunho(Documento documento)
    {
        documento.setEstado(DocumentoEmRascunho.getInstance());
        return true;
    }

    @Override
    public boolean aprovarDocumento(Documento documento)
    {
        documento.setEstado(DocumentoAprovado.getInstance());
        return true;
    }

    @Override
    public String getEstado() {
        return "Documento em revisão";
    }
}
