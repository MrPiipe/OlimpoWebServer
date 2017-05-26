package co.edu.eafit.dis.olimpo.entity;

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
@Document(collection = "user")
public class User extends BaseEntity{
	@Id
	private ObjectId id;
	private LoginInformation loginInformation;
	private ContactInformation contactInformation;
	private String profilePicture;
	
}
