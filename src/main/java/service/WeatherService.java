package com.example.weatherapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class WeatherService {

    private final String API_KEY = "83a6fa9799cdacc474d60c89942a86b8"; // OpenWeatherMap API Key

    public String getWeather(String city) {
        try {
            String url = "https://api.openweathermap.org/data/2.5/weather?q="
                    + city + "&appid=" + API_KEY + "&units=metric";

            RestTemplate restTemplate = new RestTemplate();
            String jsonString = restTemplate.getForObject(url, String.class);

            // Jackson ile JSON parse
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonString);
            String cityName = root.path("name").asText();
            double temp = root.path("main").path("temp").asDouble();
            String weatherMain = root.path("weather").get(0).path("main").asText();

            return "Şehir: " + cityName + ", Sıcaklık: " + temp + "°C, Durum: " + weatherMain;
        } catch (Exception e) {
            return "Hava durumu alınamadı: " + e.getMessage();
        }
    }
}