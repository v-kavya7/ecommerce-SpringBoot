package com.example.E_commerce.service;

import org.springframework.stereotype.Service;
import java.net.*;
import java.io.*;

@Service
public class RecommendationService {

    @SuppressWarnings("deprecation")
	public String getRecommendations(String product) {
        try {

        	URL url = new URL("http://localhost:5000/recommend?product=" 
        	        + URLEncoder.encode(product, "UTF-8"));

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String line;
            StringBuilder result = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                result.append(line);
            }

            reader.close();

            return result.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error getting recommendations";
        }
    }
}