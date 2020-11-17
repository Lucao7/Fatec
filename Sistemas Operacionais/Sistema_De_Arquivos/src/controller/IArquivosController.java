package controller;

import java.io.IOException;

public interface IArquivosController {
  void verificaDirTemp() throws IOException;
  boolean verificaRegistro(String arquivo, int codigo) throws IOException;
  void imprimeCadastro(String arquivo, int codigo) throws IOException;
  void insereCadastro(String arquivo, int codigo, String nome, String email) throws IOException;
}
