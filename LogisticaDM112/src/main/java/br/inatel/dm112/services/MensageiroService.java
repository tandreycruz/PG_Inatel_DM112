package br.inatel.dm112.services;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import br.inatel.dm112.model.MailRequestData;
import reactor.core.publisher.Mono;

@Service
public class MensageiroService
{
	public void callSendMailService(int orderNumber, String destino, String mensagem)
	{
		// String url = restURL + mailEndpoint ;
		String url = "http://localhost:7070/UtilityDM112/api/mail";
		System.out.println("URL: " + url);
		MailRequestData mrd = new MailRequestData(orderNumber, destino, null, mensagem);
		WebClient.create(url).post().contentType(MediaType.APPLICATION_JSON).header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE).body(Mono.just(mrd), MailRequestData.class).accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class).defaultIfEmpty("").log().block();
	}
}
