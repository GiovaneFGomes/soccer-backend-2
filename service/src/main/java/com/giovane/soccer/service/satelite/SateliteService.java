package com.giovane.soccer.service.satelite;

import com.giovane.soccer.entity.satelite.Satelite;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@AllArgsConstructor
@Service
public class SateliteService {

    public Satelite findSatelite(){
        RestTemplate template = new RestTemplate();

        return template.getForObject("https://api.wheretheiss.at/v1/satellites/25544", Satelite.class);
    }

}