package telran.imagga.dto;

import java.util.Map;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Tag {
	double confidence;
    Map<String, String> tag;
 
}
