package co.edu.eafit.dis.olimpo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseEntity{
	private long id;
	private LoginInformation loginInformation;
	private ContactInformation contactInformation;
	private String profilePicture;
	
}
