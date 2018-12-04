package telran.imagga.controller;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import telran.imagga.dto.ResultDto;
import telran.imagga.dto.Tag;

public class ImaggaClientAppl {

	public static void main(String[] args) {
		RestTemplate restTemplate = new RestTemplate();
		String url = "https://api.imagga.com/v2/tags";
		String imgUri = "https://24smi.org/public/media/235x307/person/2017/12/22/4sqqykgn04bo-cheburashka.jpg";
		UriComponentsBuilder builder = 
				UriComponentsBuilder.fromHttpUrl(url)
				.queryParam("image_url", imgUri)
				.queryParam("limit", "3")
				.queryParam("language", "ru,en,fr");
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "credentials");
		RequestEntity<String> request = 
				new RequestEntity<>(headers, HttpMethod.GET, builder.build().toUri());
		ResponseEntity<ResultDto> response =
				restTemplate.exchange(request, ResultDto.class);
		ResultDto resultDto = response.getBody();
		System.out.println(resultDto.getStatus());
		List<Tag> tags = resultDto.getResult().getTags();
		tags.forEach(System.out::println);
	}

}
