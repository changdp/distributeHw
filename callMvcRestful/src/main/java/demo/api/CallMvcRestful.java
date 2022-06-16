package demo.api;

import com.sun.jersey.api.client.WebResource;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.*;

@RestController
public class CallMvcRestful {

    /**
     *
     * HttpUrlConnection
     * */
    @RequestMapping(value = "getUser/{param}")
    public @ResponseBody String getUser(@PathVariable String param) {
        String url = "http://localhost:8080/user/getJson";
        url += ("/" + param);
        StringBuilder s = new StringBuilder();
        HttpURLConnection httpConnection = null;
        try {
            URL restServiceURL = new URL(url);
            httpConnection = (HttpURLConnection) restServiceURL.openConnection();
            BufferedReader responseBuffer = new BufferedReader(
                    new InputStreamReader((httpConnection.getInputStream())));
            //System.out.println("Output from Server:  \n");
            String output;
            while ((output = responseBuffer.readLine()) != null) {
                s.append(output);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(httpConnection != null)
                httpConnection.disconnect();
        }
        return s.toString();
    }

    /**
     *
     * httpclient
     * */
    @RequestMapping(value = "getUser2/{param}",produces = {"application/xml"})
    public @ResponseBody String getUser2(@PathVariable String param) {
        String s = "no data found";
        try {
            HttpClient client = HttpClients.createDefault();
            HttpGet request = new HttpGet("http://localhost:8080/user/getXml/"+param);
            request.setHeader("Accept", "application/xml");
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            s = EntityUtils.toString(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }


    @Autowired
    RestTemplate restTemplate;

    /**
     *
     *  restTemplate
     * */
    @RequestMapping("getUser3/{param}")
    public String getUser3(@PathVariable String param) {
        //查找
        return restTemplate.getForObject("http://localhost:8080/user/getJson/"+param, String.class);
    }

    /**
     * jersey client
     * */
    @RequestMapping(value = "getUser4/{param}",produces = {"application/xml"})
    public String getUser4(@PathVariable String param) throws Exception {
        String REST_API = "http://localhost:8080/user/getXml";
        Client client = Client.create();
        WebResource webResource = client.resource(REST_API + "/"+param);
        ClientResponse response =
                webResource.type(MediaType.APPLICATION_JSON).accept("application/xml")
                        .get(ClientResponse.class);
        return response.getEntity(String.class);
    }

}
