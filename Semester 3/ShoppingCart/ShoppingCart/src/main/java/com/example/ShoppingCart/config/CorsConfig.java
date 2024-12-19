package com.example.ShoppingCart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Alle Ursprünge erlauben (für Entwicklungs- und Testzwecke)
        config.addAllowedOrigin("*"); // Achtung: Für Produktionsumgebungen sollten Sie spezifische Ursprünge festlegen

        // Alle grundlegenden Methoden erlauben
        config.addAllowedMethod(CorsConfiguration.ALL); // Dies erlaubt alle Methoden. Für mehr Sicherheit können Sie spezifische Methoden auflisten.

        // Alle Header erlauben
        config.addAllowedHeader("*");

        // Zusätzliche CORS-Konfigurationen
        config.setAllowCredentials(true); // Erlaubt Cookies und Credentials bei Cross-Origin-Anfragen
        config.addExposedHeader("Authorization, x-xsrf-token, Access-Control-Allow-Headers, Origin, Accept, X-Requested-With, " +
                "Content-Type, Access-Control-Request-Method, Custom-Filter-Header");
        config.setMaxAge(3600L); // Wie lange die Antwort auf den preflight request (OPTIONS) vom Browser gecacht werden darf

        source.registerCorsConfiguration("/**", config); // Dies wendet die Konfiguration auf alle Pfade an

        return new CorsFilter(source);
    }
}
