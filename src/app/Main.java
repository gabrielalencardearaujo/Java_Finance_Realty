package app;

import java.util.Scanner;
import modelo.*;
import util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem vindo ao Sistema de financiamento de Imoveis: ");

        System.out.print("Gostaria de simular um financiamento? Y/N  ");
        String inputChoiceUser = input.nextLine().toUpperCase();
        System.out.println(inputChoiceUser);

        if(inputChoiceUser.equals("Y")) {
            startApp();
        } else {
            System.out.println("Obrigado por nos escolher! Tenha um bom dia!");
        }
    }

    public static void startApp(){
        InterfaceUsuario user = new util.InterfaceUsuario();

        double valorImovel = user.inputValorImovel();
        int prazoFinanciamento = user.inputPrazoFinanciamento();
        double taxaJuros = user.inputTaxaJuros();

        Financiamento financiamento = new modelo.Financiamento(valorImovel, prazoFinanciamento, taxaJuros);

        user.resultFinanciamento(financiamento.calcPagamentoMensal(), financiamento.totalPagamento());
    }
}