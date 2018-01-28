
package geolocation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class GeoLocationConfiguration {
	 @Value("${client.default-uri}")
	  private String defaultUri;
	
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		// this package must match the package in the <generatePackage> specified in
		// pom.xml
		marshaller.setContextPath("geolocation.wsdl");
		return marshaller;
	}

	@Bean(name="locationClient")
	public GeoLocationClient locationClient(Jaxb2Marshaller marshaller) {
		GeoLocationClient client = new GeoLocationClient();
		client.setDefaultUri(defaultUri);
		client.setMarshaller(marshaller);
		client.setUnmarshaller(marshaller);
		return client;
	}
	
	@Bean(name="localDefaultClient")
	public GeoLocationClient localDefaultClient(Jaxb2Marshaller marshaller) {
		GeoLocationClient client = new GeoLocationClient();
		return client;
	}

}
