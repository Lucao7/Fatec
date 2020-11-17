package controller;

import javax.swing.*;
import java.io.*;

public class ArquivosController implements IArquivosController{
  @Override
  public void verificaDirTemp() throws IOException {
    File dir = new File("C:\\TEMP");

    if (dir.exists() && dir.isDirectory()) {
      JOptionPane.showMessageDialog(null, "Diretório já criado!");
    } else {
      JOptionPane.showMessageDialog(null, "Diretório não existente, criando...");
      dir.mkdir();
    }

    File cadastro = new File("C:\\TEMP\\Cadastros.csv");

    if (cadastro.exists() && cadastro.isFile()) {
      JOptionPane.showMessageDialog(null, "Aquivo de cadastros já existe.");
      return;
    }

    String fileName = dir + "\\Cadastros.csv";

    JOptionPane.showMessageDialog(null, "Arquivo de cadastro inexistente, criando arquivo CSV...");

    FileWriter fileWriter = new FileWriter(fileName);
    PrintWriter print = new PrintWriter(fileWriter);
    print.write("Codigo; Nome; Email\n");
    print.flush();
    print.close();
    fileWriter.close();

    JOptionPane.showMessageDialog(null, "Arquivo de cadastros criado!");
  }

  @Override
  public boolean verificaRegistro(String arquivo, int codigo) throws IOException {
    File file = new File("C:\\TEMP\\" + arquivo + ".csv");

    if (!(file.exists() && file.isFile())) {
      JOptionPane.showMessageDialog(null, "Este arquivo nao existe");
      throw new IOException("Este arquivo nao existe");
    }

    FileInputStream fluxo = new FileInputStream(file);
    InputStreamReader leitor = new InputStreamReader(fluxo);
    BufferedReader buffer = new BufferedReader(leitor);
    String linha = buffer.readLine();
    String[] linhaSeparada;

    while (linha != null) {
      linhaSeparada = linha.split(";");
      if (linhaSeparada[0].equals(String.valueOf(codigo)))
        return true;

      linha = buffer.readLine();
    }

    buffer.close();
    leitor.close();
    fluxo.close();

    return false;
  }

  @Override
  public void imprimeCadastro(String arquivo, int codigo) throws IOException {
    if (!(verificaRegistro(arquivo, codigo))) {
      JOptionPane.showMessageDialog(null, "Codigo nao encontrado.");
      return;
    }

    File file = new File("C:\\TEMP\\" + arquivo + ".csv");
    FileInputStream fluxo = new FileInputStream(file);
    InputStreamReader leitor = new InputStreamReader(fluxo);
    BufferedReader buffer = new BufferedReader(leitor);
    String linha = buffer.readLine();
    String[] linhaSeparada;

    while (linha != null) {
      if (linha.contains("Codigo")) {
        linha = buffer.readLine();
      }

      linhaSeparada = linha.split(";");
      if (linhaSeparada[0].equals(String.valueOf(codigo))) {
        System.out.println("Codigo: " + linhaSeparada[0]);
        System.out.println("Nome: " + linhaSeparada[1]);
        System.out.println("Email: " + linhaSeparada[2] + "\n");
        JOptionPane.showMessageDialog(null, "Cadastrado impresso.");
        break;
      }

      linha = buffer.readLine();
    }

    buffer.close();
    leitor.close();
    fluxo.close();
  }

  @Override
  public void insereCadastro(String arquivo, int codigo, String nome, String email) throws IOException {
    if (verificaRegistro(arquivo, codigo)) {
      JOptionPane.showMessageDialog(null, "Codigo ja cadastrado.");
      return;
    }

    File file = new File("C:\\TEMP\\" + arquivo + ".csv");

    FileWriter fileWriter = new FileWriter(file, true);

    String conteudo = codigo + ";" + nome + ";" + email + "\n";
    PrintWriter print = new PrintWriter(fileWriter);
    print.write(conteudo);
    print.flush();
    print.close();
    fileWriter.close();

    JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
  }
}
