
package geolocation;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import geolocation.wsdl.GetGeoIPResponse;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner lookup(@Qualifier("locationClient")GeoLocationClient client) {
		return args -> {
			GetGeoIPResponse response = client.getIPDetails("192.168.2.250");
			System.out.println(response.getGetGeoIPResult().getReturnCodeDetails());
		};
	}

}
