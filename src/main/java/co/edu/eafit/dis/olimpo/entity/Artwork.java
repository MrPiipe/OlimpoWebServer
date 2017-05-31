package co.edu.eafit.dis.olimpo.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Document(collection = "artwork")
public class Artwork{
	@Id
	private String id;
	private String name;
	private String description;
	private List<String> authorIds;
	private Date releaseDate;
	private ArtType artType;
	private String url;//TODO check more//image/video/audio/text/GIF
	private Geolocation geolocation;
	
	//comments
	//likes
	//events
}
