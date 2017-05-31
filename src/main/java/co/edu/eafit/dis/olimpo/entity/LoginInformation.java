package co.edu.eafit.dis.olimpo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "login")
public class LoginInformation {
	@Id
	private String id;
	private String email;
	private String password;
	private String role;
	private String userId; //either user.id or artist.id
}
