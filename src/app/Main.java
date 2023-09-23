package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import app.modelo.*;
import app.util.*;
import model.ModelDB;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<InterFinanciamento> financiamentos = new ArrayList<InterFinanciamento>();
    

    public static void main(String[] args) throws IOException {
        System.out.println("Bem vindo ao Sistema de financiamento de Imoveis: \n");
        
        try {
            System.out.println("Seleciona uma das opcoes: \n");
            System.out.println("1 - Novo Financiamento");
            System.out.println("2 - Consultar Financiamentos");
            int choice = input.nextInt();

            switch(choice) {
                case 1:
                    Main.novosFinanciamentos();
                    break;
                case 2:
                    Main.mostrarFinanciamentosAnteriores(ModelDB.getDatabase());
                    break;
                default:
                    System.out.println("Escolha uma das opcoes acima.");
            }
        } catch(Exception err) {
            System.out.println("Escolha uma opcao valida.");
            System.out.println(err);
        }


        for(int i = 0; i < financiamentos.size(); i++) {
            ModelDB.setDatabase(financiamentos.get(i).mostrarFinanciamentos(i + 1));
        }
    }

    public static void novosFinanciamentos() {
        String control = "";
        InterfaceUsuario user = new app.util.InterfaceUsuario();
        do {
                try {
                String escolhaFinanciamento = user.presentation();

                double valorImovel = user.inputValorImovel();
                int prazoFinanciamento = user.inputPrazoFinanciamento();
                double taxaJuros = user.inputTaxaJuros();

                switch (escolhaFinanciamento.toUpperCase()) {
                    case "CASA":
                        double areaConstruida = user.areaCasaConstruida();
                        double areaTerreno = user.areaCasaTerreno();
                        float desconto = user.descontoCasa();

                        Casa finCasa = new Casa(valorImovel, prazoFinanciamento, taxaJuros, areaConstruida,
                                areaTerreno);

                        boolean checkDesconto = finCasa.verificaDesconto(desconto);

                        if (checkDesconto)
                            financiamentos.add(finCasa);

                        break;
                    case "APARTAMENTO":
                        int vagas = user.vagasGaragemApartamento();
                        int andar = user.andarApartamento();

                        Apartamento finApartamento = new Apartamento(valorImovel, prazoFinanciamento, taxaJuros, vagas,
                                andar);
                        financiamentos.add(finApartamento);
                        break;

                    case "TERRENO":
                        String zona = user.zonaTerreno();

                        Terreno finTerreno = new Terreno(valorImovel, prazoFinanciamento, taxaJuros, zona);
                        financiamentos.add(finTerreno);
                        break;

                    default:
                        System.out.println("Escolha uma das opcoes corretamente.");
                }

                System.out.print("\nGostaria fazer outro financiamento? Y/N  ");
                control = input.next().toUpperCase();

                if(control.equals("Y")) continue;
                
            } catch (Exception e) {
                System.out.println(e.getMessage());
                continue;
            } 

        user.mostrarFinanciamentos(financiamentos);
            
        } while (control.equals("Y"));
    }

    public static void mostrarFinanciamentosAnteriores(List<String> database) {
        if(database.size() > 0){
            for(String fin: database) {
                System.out.println(fin);
            }
        } else {
            System.out.println("Nenhum financiamento foi encontrado");
        }
    }
}