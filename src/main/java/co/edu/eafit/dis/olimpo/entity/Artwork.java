package co.edu.eafit.dis.olimpo.entity;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Artwork extends BaseEntity{
	private long id;
	private String name;
	private String description;
	private List<Artist> author;
	private Date releaseDate;
	private ArtType artType;
	private String url;//TODO check more//image/video/audio/text/GIF
	private Geolocation geolocation;
	
}
