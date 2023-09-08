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
        String control;
        InterfaceUsuario user = new util.InterfaceUsuario();

        System.out.println("Bem vindo ao Sistema de financiamento de Imoveis: \n");

        do {
            System.out.println("Que tipo de financiamento deseja realizar? Temos 3 tipos de financiamento: ");
            System.out.println("1. CASA");
            System.out.println("2. APARTAMENTO");
            System.out.println("3. TERRENO");
            String escolhaFinanciamento = input.next();
            
            double valorImovel = user.inputValorImovel();
            int prazoFinanciamento = user.inputPrazoFinanciamento();
            double taxaJuros = user.inputTaxaJuros(); 

            switch(escolhaFinanciamento){
                case "1":
                    Casa finCasa = new Casa(valorImovel, prazoFinanciamento, taxaJuros);
                    financiamentos.add(finCasa);
                    break;

                case "2":
                    Apartamento finApartamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJuros);
                    financiamentos.add(finApartamento);
                    break;

                case "3":
                    Terreno finTerreno = new Terreno(valorImovel, prazoFinanciamento, taxaJuros);
                    financiamentos.add(finTerreno);
                    break;
            }
            
            System.out.print("\nGostaria fazer outro financiamento? Y/N  ");
            control = input.next().toUpperCase();

        } while (control.equals("Y"));

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

}