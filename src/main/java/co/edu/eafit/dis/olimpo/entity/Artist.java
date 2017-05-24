package co.edu.eafit.dis.olimpo.entity;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Artist extends BaseEntity{
	
	private long id;
	private LoginInformation loginInformation;
	private String displayName; //or artistic name
	private List<ContactInformation> contacts;
	private List<ArtType> artTypes;
	private List<GenderByArtType> genderByArtType;
}
