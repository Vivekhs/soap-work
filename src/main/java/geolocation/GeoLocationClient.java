
package geolocation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import geolocation.wsdl.GetGeoIP;
import geolocation.wsdl.GetGeoIPResponse;


public class GeoLocationClient extends WebServiceGatewaySupport {
	
	@Value("${client.default-uri}")
	private String defaultUri;

	private static final Logger log = LoggerFactory.getLogger(GeoLocationClient.class);

	public GetGeoIPResponse getIPDetails(String ipAddress) {

		GetGeoIP request = new GetGeoIP();
		request.setIPAddress(ipAddress);

		log.info("Requesting quote for " + ipAddress);

		GetGeoIPResponse response = (GetGeoIPResponse) getWebServiceTemplate()
				.marshalSendAndReceive(defaultUri, request, new SoapActionCallback("http://www.webservicex.net/GetGeoIP"));

		return response;
	}

}
