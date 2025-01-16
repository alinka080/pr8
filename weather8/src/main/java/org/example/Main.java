package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;

public class Main {
    private static final String API_KEY = "244d7a0eb22b5e0d3aa345d6a25591fe";
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather";

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner =new Scanner(System.in);
        while (true) {
            System.out.print("Введите город: ");
            final String city = scanner.nextLine();
            System.out.println("Введите нужное вам слово: ");
            System.out.println(" погода - погода на сегодня");
            System.out.println(" один - описание");
            System.out.println(" два - температура");
            System.out.println(" три - влажность");
            System.out.println(" четыре - давление");
            System.out.println(" пять - скорость ветра\n");
            final String word = scanner.nextLine();
            if(word.equals("погода")){
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    try {
                        String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric&lang=ru";
                        URL url = new URL(urlString);

                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String inputLine;
                        StringBuilder response = new StringBuilder();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();
                        conn.disconnect();

                        JSONObject jsonResponse = new JSONObject(response.toString());
                        JSONObject main = jsonResponse.getJSONObject("main");
                        JSONObject weather = jsonResponse.getJSONArray("weather").getJSONObject(0);
                        JSONObject wind = jsonResponse.getJSONObject("wind");
                        double temperature = main.getDouble("temp");
                        double feels_like = main.getDouble("feels_like");
                        String description = weather.getString("description");
                        int humidity = main.getInt("humidity");
                        double speed = wind.getDouble("speed");
                        int pressure = main.getInt("pressure");

                        System.out.println("Погода в " + city + "e"+ ":");
                        System.out.println("Описание: " + description);
                        System.out.println("Температура: " + temperature + "C");
                        System.out.println("Ощущается как: " + feels_like + "C");
                        System.out.println("Влажность: " + humidity + "%");
                        System.out.println("Давление: " + pressure );
                        System.out.println("Скорость ветра: " + speed + " м/с");
                        System.out.println("\nДля выхода из программы напишите слово Выход");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                });
                future.get();
            }else if(word.equals("один")){
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    try {
                        String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric&lang=ru";
                        URL url = new URL(urlString);

                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String inputLine;
                        StringBuilder response = new StringBuilder();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();
                        conn.disconnect();

                        JSONObject jsonResponse = new JSONObject(response.toString());
                        JSONObject weather = jsonResponse.getJSONArray("weather").getJSONObject(0);
                        String description = weather.getString("description");

                        System.out.println("Погода в " + city + "e"+ ":");
                        System.out.println("Описание: " + description);
                        System.out.println("\nДля выхода из программы напишите слово Выход!!!");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                });
                future.get();
            }else if(word.equals("два")){
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    try {
                        String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric&lang=ru";
                        URL url = new URL(urlString);

                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String inputLine;
                        StringBuilder response = new StringBuilder();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();
                        conn.disconnect();

                        JSONObject jsonResponse = new JSONObject(response.toString());
                        JSONObject main = jsonResponse.getJSONObject("main");
                        double temperature = main.getDouble("temp");
                        double feels_like = main.getDouble("feels_like");

                        System.out.println("Погода в " + city + "e"+ ":");
                        System.out.println("Температура: " + temperature + "C");
                        System.out.println("Ощущается как: " + feels_like + "C");
                        System.out.println("\nДля выхода из программы напишите слово Выход");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                });
                future.get();
            }else if(word.equals("три")){
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    try {
                        String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric&lang=ru";
                        URL url = new URL(urlString);

                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String inputLine;
                        StringBuilder response = new StringBuilder();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();
                        conn.disconnect();

                        JSONObject jsonResponse = new JSONObject(response.toString());
                        JSONObject main = jsonResponse.getJSONObject("main");
                        int humidity = main.getInt("humidity");

                        System.out.println("Погода в " + city + "e"+ ":");
                        System.out.println("Влажность: " + humidity + "%");
                        System.out.println("\nДля выхода из программы напишите слово Выход");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                });
                future.get();
            }else if(word.equals("четыре")){
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    try {
                        String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric&lang=ru";
                        URL url = new URL(urlString);

                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String inputLine;
                        StringBuilder response = new StringBuilder();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();
                        conn.disconnect();

                        JSONObject jsonResponse = new JSONObject(response.toString());
                        JSONObject main = jsonResponse.getJSONObject("main");
                        int pressure = main.getInt("pressure");

                        System.out.println("Погода в " + city + "e"+ ":");
                        System.out.println("Давление: " + pressure );
                        System.out.println("\nДля выхода из программы напишите слово Выход");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                });
                future.get();
            }else if(word.equals("пять")){
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    try {
                        String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric&lang=ru";
                        URL url = new URL(urlString);

                        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

                        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                        String inputLine;
                        StringBuilder response = new StringBuilder();
                        while ((inputLine = in.readLine()) != null) {
                            response.append(inputLine);
                        }
                        in.close();
                        conn.disconnect();

                        JSONObject jsonResponse = new JSONObject(response.toString());
                        JSONObject wind = jsonResponse.getJSONObject("wind");
                        double speed = wind.getDouble("speed");

                        System.out.println("Погода в " + city + "e"+ ":");
                        System.out.println("Скорость ветра: " + speed + " м/с");
                        System.out.println("\nДля выхода из программы напишите слово Выход");
                    } catch (Exception e) {
                        System.out.println("Ошибка: " + e.getMessage());
                    }
                });
                future.get();
            }else if(word.equals("Выход")){
                System.out.println("Выход из программы.");
                break;
            }
        }
    }
}