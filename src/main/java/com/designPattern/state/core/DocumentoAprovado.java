package com.designPattern.state.core;

public class DocumentoAprovado extends DocumentoEstado {

    private static DocumentoEstado instance = new DocumentoAprovado();

    public static DocumentoEstado getInstance() {
        return instance;
    }

    @Override
    public boolean publicarDocumento(Documento documento)
    {
        documento.setEstado(DocumentoPublicado.getInstance());
        return true;
    }

    @Override
    public String getEstado() {
        return "Documento Aprovado";
    }
}
