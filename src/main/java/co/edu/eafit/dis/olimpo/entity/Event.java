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
public class Event {
	private long id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private Geolocation location;
	private List<Artist> artists;
	private List<Artwork> artworks;
}
