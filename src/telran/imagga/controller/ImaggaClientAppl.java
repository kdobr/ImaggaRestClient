package telran.imagga.controller;

import java.io.IOException;
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

	public static void main(String[] args) throws IOException {
		
		
		  RestTemplate restTemplate = new RestTemplate(); 
		  String url =
		  "https://api.imagga.com/v2/tags"; String imgUri =
		  "https://vokzal.ru/blog/wp-content/uploads/2018/07/30-07-2018-02.jpg";
		  UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
		  .queryParam("image_url", imgUri) .queryParam("limit", "5")
		  .queryParam("language", "ru,en,fr"); HttpHeaders headers = new HttpHeaders();
		  headers.add("Authorization",
		  "Basic YWNjX2U5OWUxMzU3NzIxOWU4MToyMjJlYzE5Y2VmMDkzYjMxZjQxNGFmMTA1ODZiMWZjNQ=="
		  ); RequestEntity<String> request = new RequestEntity<>(headers,
		  HttpMethod.GET, builder.build().toUri()); ResponseEntity<ResultDto> response
		  = restTemplate.exchange(request, ResultDto.class);
		
		ResultDto resultDto = response.getBody();
		System.out.println(resultDto.getStatus());
		List<Tag> tags = resultDto.getResult().getTags();
		tags.forEach(System.out::println);
	}

}
