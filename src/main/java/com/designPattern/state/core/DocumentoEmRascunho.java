package com.designPattern.state.core;

public class DocumentoEmRascunho extends DocumentoEstado{

    private static DocumentoEstado instance = new DocumentoEmRascunho();

    public static DocumentoEstado getInstance() {
        return instance;
    }

    @Override
    public boolean revisarDocumento(Documento documento)
    {
        documento.setEstado(DocumentoEmRevisao.getInstance());
        return true;
    }

    @Override
    public String getEstado() {
        return "Documento em rascunho";
    }
}
