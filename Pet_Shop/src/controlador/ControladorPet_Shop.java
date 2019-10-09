/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import tela.manutencao.ManutencaoPet_Shop;

import dao.DaoPet_Shop;
import javax.swing.JOptionPane;
import modelo.Pet_Shop;
import tela.manutencao.ManutencaoPet_Shop;

import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorPet_Shop {

    public static void inserir(ManutencaoPet_Shop man){
        Pet_Shop objeto = new Pet_Shop();
        objeto.setNome(man.jtfNome.getText());
        objeto.setEndereco(man.jtfEndereco.getText());
        objeto.setNumero(Integer.parseInt(man.jtfNumero.getText()));
        objeto.setNota(Double.parseDouble(man.jtfNota.getText()));
        
        boolean resultado = DaoPet_Shop.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
        if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
}

   public static void alterar(ManutencaoPet_Shop man){
        Pet_Shop objeto = new Pet_Shop();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText()));
        objeto.setNome(man.jtfNome.getText());
        objeto.setEndereco(man.jtfEndereco.getText());
        objeto.setNumero(Integer.parseInt(man.jtfNumero.getText()));
        objeto.setNota(Double.parseDouble(man.jtfNota.getText()));
        
        boolean resultado = DaoPet_Shop.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
        if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
    }

    public static void excluir(ManutencaoPet_Shop man){
        Pet_Shop objeto = new Pet_Shop();
        objeto.setCodigo(Integer.parseInt(man.jtfCodigo.getText())); //só precisa definir a chave primeira
        
        boolean resultado = DaoPet_Shop.excluir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
        if (man.listagem != null) {
     atualizarTabela(man.listagem.tabela); //atualizar a tabela da listagem
}
man.dispose();//fechar a tela da manutenção
    }
    
    
    public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("Endereço");
        modelo.addColumn("Número");
        modelo.addColumn("Nota");
        List<Pet_Shop> resultados = DaoPet_Shop.consultar();
        for (Pet_Shop objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getNome());
            linha.add(objeto.getEndereco());
            linha.add(objeto.getNumero());
            linha.add(objeto.getNota());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
    
    public static void atualizaCampos(ManutencaoPet_Shop man, int pk){ 
        Pet_Shop objeto = DaoPet_Shop.consultar(pk);
        //Definindo os valores do campo na tela (um para cada atributo/campo)
        man.jtfCodigo.setText(objeto.getCodigo().toString());
        man.jtfNome.setText(objeto.getNome());
        man.jtfEndereco.setText(objeto.getEndereco());
        man.jtfNumero.setText(objeto.getNumero().toString());
        man.jtfNota.setText(objeto.getNota().toString());
        
        man.jtfCodigo.setEnabled(false); //desabilitando o campo código
        man.btnAdicionar.setEnabled(false); //desabilitando o botão adicionar
    }
    
    }
    
    
    

