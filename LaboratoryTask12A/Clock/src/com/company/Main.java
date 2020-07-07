package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DataBase dataBase=new DataBase();
        try{
            String sql="SELECT idClock, stamp ,type ,cost ,quantity ,idCompany FROM clock.clock";
            ResultSet resultSet=dataBase.statement.executeQuery(sql);
            ArrayList<Clock> clocks=new ArrayList<>();
            while(resultSet.next()){
                clocks.add(new Clock(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getInt(4),
                        resultSet.getInt(5),
                        resultSet.getInt(6)));
            }
            sql = "SELECT idCompany, name ,country FROM clock.company";
            resultSet = dataBase.statement.executeQuery(sql);
            ArrayList<Company> companies=new ArrayList<>();
            while (resultSet.next()) {
                    companies.add(new Company(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
                }
            while(true){
                Scanner scanner=new Scanner(System.in);
                int k=0;
                System.out.println("\n1)Показать часы\n" +
                        "2)Показать компании\n"+
                        "3)Вывести марки заданного типа часов\n"+
                        "4)Вывести информацию о механических часах, цена на которые не превышает заданную\n"+
                        "5)Вывести марки часов, изготовленных в заданной стране\n"+
                        "6)Вывести производителей, общая сумма часов которых в магазине не превышает заданную\n"+
                        "0)Выход");
                k=scanner.nextInt();
                switch (k){
                    case 1:
                        for(Clock clock:clocks){
                            clock.show();
                        }
                        break;
                    case 2:
                        for(Company company:companies){
                            company.show();
                        }
                        break;
                    case 3:
                        System.out.print("Тип: ");
                        String type=scanner.next();
                        for(Clock clock:clocks){
                            if(clock.type.equals(type))
                                System.out.println(clock.stamp);
                        }
                        break;
                    case 4:
                        System.out.print("Максимальная цена: ");
                        int cost=scanner.nextInt();
                        for(Clock clock:clocks){
                            if(clock.cost<=cost && clock.type.equals("Механические")){
                                clock.show();
                            }
                        }
                        break;
                    case 5:
                        System.out.print("Страна: ");
                        String country=scanner.next();
                        int id=0;
                        for(Company company:companies){
                            if(country.equals(company.country)){
                                id=company.id;
                                break;
                            }
                        }
                        for(Clock clock:clocks){
                            if(clock.idCompany==id){
                                System.out.println(clock.stamp);
                            }
                        }
                        break;
                    case 6:
                        System.out.print("Максимальное количество: ");
                        int maxQuantity=scanner.nextInt();
                        for(Company company:companies) {
                            int quantity=0;
                            for (Clock clock : clocks) {
                                if(clock.idCompany==company.id) {
                                    quantity += clock.quantity;
                                }
                            }
                            if(quantity<maxQuantity){
                                System.out.print("quantity: "+quantity+",\t");
                                company.show();
                            }
                        }
                        break;
                    case 0:
                        System.exit(0);
                    default:System.out.println("Неверные данные");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
