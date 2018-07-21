package de.questor;


import de.questor.model.StartMarker;
import de.questor.services.StartMarkerService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;

@PropertySource(ignoreResourceNotFound = true, value = "assetspath.properties")
@Component
public class StartUpInit {
    @Value("${pathToResources}")
    String path;

    private final StartMarkerService startMarkerService;

    @Autowired
    public StartUpInit(StartMarkerService startMarkerService) {
        this.startMarkerService = startMarkerService;
    }

    @PostConstruct
    public void init() {
        mockStartMarkers();
    }

    private void mockStartMarkers() {
        BufferedReader br = null;
        FileReader fr = null;
        StringBuilder sb = new StringBuilder();

        try {
            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader(path + "startMarkers.json");
            br = new BufferedReader(fr);

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                sb.append(sCurrentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        JSONArray array = new JSONArray(sb.toString());
        int length = array.length();

        for (int i = 0; i < length; i++) {
            JSONObject obj = array.getJSONObject(i);
            StartMarker sm = new StartMarker();
            sm.setLongitude(obj.getFloat("longitude"));
            sm.setLatitude(obj.getFloat("latitude"));
            sm.setName(obj.getString("name"));
            System.out.println("sm = " + sm);
            startMarkerService.create(sm);
        }
    }
}
