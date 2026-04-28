package com.designPattern.state.core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.print.Doc;

import static org.junit.jupiter.api.Assertions.*;

class DocumentoTest {

    Documento documento;

    @BeforeEach
    void setUp() {
        documento = new Documento();
        documento.escreverRascunho("Início do documento");
    }

    @Test
    void deveRevisarDocumentoEmRascunho() {
        assertTrue(documento.revisarDocumento());
        assertInstanceOf(DocumentoEmRevisao.class, documento.getEstado());
    }

    @Test
    void naoDeveFazerRascunhoDocumentoEmRascunho() {
        documento.setEstado(DocumentoEmRascunho.getInstance());
        assertFalse(documento.escreverRascunho("Sobrescrever"));
    }

    @Test
    void naoDeveAprovarDocumentoEmRascunho() {

        assertFalse(documento.aprovarDocumento());
        assertInstanceOf(DocumentoEmRascunho.class, documento.getEstado());
    }

    @Test
    void naoDevePublicarDocumentoEmRascunho() {
        assertFalse(documento.publicarDocumento());
        assertInstanceOf(DocumentoEmRascunho.class, documento.getEstado());
    }

    @Test
    void deveVoltarParaRascunhoDocumentoEmRevisao() {
        documento.setEstado(DocumentoEmRevisao.getInstance());
        assertTrue(documento.escreverRascunho(null));
        assertInstanceOf(DocumentoEmRascunho.class, documento.getEstado());
    }

    @Test
    void deveAprovarDocumentoEmRevisao() {
        documento.setEstado(DocumentoEmRevisao.getInstance());
        assertTrue(documento.aprovarDocumento());
        assertInstanceOf(DocumentoAprovado.class, documento.getEstado());
    }

    @Test
    void naoDevePublicarDocumentoEmRevisao() {
        documento.setEstado(DocumentoEmRevisao.getInstance());
        assertFalse(documento.publicarDocumento());
        assertInstanceOf(DocumentoEmRevisao.class, documento.getEstado());
    }

    @Test
    void devePublicarDocumentoAprovado() {
        documento.setEstado(DocumentoAprovado.getInstance());
        assertTrue(documento.publicarDocumento());
        assertInstanceOf(DocumentoPublicado.class, documento.getEstado());
    }

    @Test
    void naoDeveVoltarParaRascunhoDocumentoAprovado() {
        documento.setEstado(DocumentoAprovado.getInstance());
        assertFalse(documento.escreverRascunho(null));
        assertInstanceOf(DocumentoAprovado.class, documento.getEstado());
    }

    @Test
    void naoDeveVoltarParaRevisaoDocumentoAprovado() {
        documento.setEstado(DocumentoAprovado.getInstance());
        assertFalse(documento.revisarDocumento());
        assertInstanceOf(DocumentoAprovado.class, documento.getEstado());
    }

    @Test
    void naoDeveVoltarParaRascunhoDocumentoPublicado() {
        documento.setEstado(DocumentoPublicado.getInstance());
        assertFalse(documento.escreverRascunho(null));
        assertInstanceOf(DocumentoPublicado.class, documento.getEstado());
    }

    @Test
    void naoDeveVoltarParaRevisaoDocumentoPublicado() {
        documento.setEstado(DocumentoPublicado.getInstance());
        assertFalse(documento.revisarDocumento());
        assertInstanceOf(DocumentoPublicado.class, documento.getEstado());
    }

    @Test
    void naoDeveVoltarParaAprovadoDocumentoPublicado() {
        documento.setEstado(DocumentoPublicado.getInstance());
        assertFalse(documento.aprovarDocumento());
        assertInstanceOf(DocumentoPublicado.class, documento.getEstado());
    }
}