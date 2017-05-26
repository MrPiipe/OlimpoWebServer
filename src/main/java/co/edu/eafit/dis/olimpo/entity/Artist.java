package co.edu.eafit.dis.olimpo.entity;

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
@Document(collection= "artist")
public class Artist{
	
	@Id
	private String id;
	private String displayName;
	private List<ContactInformation> contacts;
	private List<ArtType> artTypes;
	private List<GenderByArtType> genderByArtType;
	//many artwork
	//many follower
	//many event
}
