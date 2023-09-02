package app;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.*;
import util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Financiamento> financiamentos = new ArrayList<Financiamento>();
    public static double totalFinanciamentos, totalImoveis;
    public static void main(String[] args) {
        System.out.println("Bem vindo ao Sistema de financiamento de Imoveis: \n");
        String controlador;

        do {
            System.out.println("Insira os dados abaixo \n");
            Financiamento fin = startApp();
            financiamentos.add(fin);
            
            System.out.print("\nGostaria de simular um financiamento? Y/N  ");
            controlador = input.nextLine().toUpperCase();
        } while (controlador.equals("Y"));

        int cont = 1;
        for(Financiamento fin: financiamentos) {
            System.out.println("\nFinanciamento " + cont + " - valor do Imovel: R$" + fin.getValorImovel() + ", valor total do financiamento: R$" + fin.totalPagamento());

            totalImoveis += fin.getValorImovel();
            totalFinanciamentos += fin.totalPagamento();

            cont++;
        }

        System.out.println("\nValor total dos imoveis: R$" + totalImoveis);
        System.out.println("Valor total dos financiamentos: R$" + totalFinanciamentos);
    }

    public static Financiamento startApp(){
        InterfaceUsuario user = new util.InterfaceUsuario();

        double valorImovel = user.inputValorImovel();
        int prazoFinanciamento = user.inputPrazoFinanciamento();
        double taxaJuros = user.inputTaxaJuros();
        
        Financiamento financiamento = new modelo.Financiamento(valorImovel, prazoFinanciamento, taxaJuros);

        return financiamento;
    }
}