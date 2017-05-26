package co.edu.eafit.dis.olimpo.entity;

import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "event")
public class Event {
	@Id
	private ObjectId id;
	private String name;
	private String description;
	private Date startDate;
	private Date endDate;
	private Geolocation location;
	
	
	//Many to Many
	private List<Artist> artists;
	//Many to Many
	private List<Artwork> artworks;
}