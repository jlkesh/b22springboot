
package dev.jlkeesh;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/config")
public class SwaggerConfigController {


    @Value("classpath:static/swagger-config.json")
    private Resource resourceJson;

    @Value("classpath:static/swagger-config.yaml")
    private Resource resourceYaml;

    @RequestMapping(value = "json", method = RequestMethod.GET)
    public ResponseEntity<Resource> jsonConfigGet() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resourceJson.getFilename() + "\"")
                .body(resourceJson);
    }

    @RequestMapping(value = "/yaml", method = RequestMethod.GET)
    public ResponseEntity<Resource> yamlConfigGet() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resourceYaml.getFilename() + "\"")
                .body(resourceYaml);
    }


}
