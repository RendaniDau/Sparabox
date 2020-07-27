package com.sparabox.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean
    FirebaseApp fireBaseApp() throws IOException {
        FileInputStream serviceAccount =
                new FileInputStream("C:\\Users\\rendani.dau\\Downloads\\sparabox-firebase-adminsdk-vjzpx-67e1c7352c.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://sparabox.firebaseio.com")
                .build();

        return FirebaseApp.initializeApp(options);
    }
}
