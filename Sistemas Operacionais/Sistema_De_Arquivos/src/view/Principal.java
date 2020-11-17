package view;

import controller.ArquivosController;
import controller.IArquivosController;

import javax.swing.JOptionPane;
import java.io.IOException;

public class Principal {
  public static void main(String[] args) {
    IArquivosController arqController = new ArquivosController();
    int opc;

    do {
      opc = Integer.parseInt(JOptionPane.showInputDialog("Menu de opções\n1- Verificar TEMP\n2- Mostrar registros\n3- Inserir Cadastro\n9- Encerrar aplicação"
      ));

      switch (opc) {
        case 1:
        try {
          arqController.verificaDirTemp();
        } catch (IOException e) {
          e.printStackTrace();
        }
          break;
        case 2:
        try {
          String arquivo = JOptionPane.showInputDialog("Informe o nome do arquivo");
          int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código a ser encontrado"));

          arqController.imprimeCadastro(arquivo, codigo);
        } catch (IOException e) {
          e.printStackTrace();
        }
          break;
        case 3:
          try {
            String arquivo = JOptionPane.showInputDialog("Informe o nome do arquivo");
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Informe o código a ser cadastrado"));
            String nome = JOptionPane.showInputDialog("Informe o nome a ser cadastrado");
            String email = JOptionPane.showInputDialog("Informe o email a ser cadastrado");

            arqController.insereCadastro(arquivo, codigo, nome, email);
          } catch (IOException e) {
            e.printStackTrace();
          }
          break;
      }
    } while (opc != 9);
    JOptionPane.showMessageDialog(null, "Programa encerrado.");
  }
}
