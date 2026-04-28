package com.designPattern.state.core;

public abstract class DocumentoEstado {

    public boolean escreverRascunho(Documento documento)
    {
        return false;
    }

    public boolean revisarDocumento(Documento documento)
    {
        return false;
    }

    public boolean aprovarDocumento(Documento documento)
    {
        return false;
    }

    public boolean publicarDocumento(Documento documento)
    {
        return false;
    }

    public abstract String getEstado();
}
