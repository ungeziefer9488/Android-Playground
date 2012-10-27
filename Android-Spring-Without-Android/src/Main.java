import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

/**
 * Created with IntelliJ IDEA.
 * User: Ungeziefer
 * Date: 27.10.12
 * Time: 13:29
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate(true);
        restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
        final String url = "http://192.168.178.89/rest/dummy.json";
        System.out.print(url);
    }
}
