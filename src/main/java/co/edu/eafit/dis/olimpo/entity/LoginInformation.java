package co.edu.eafit.dis.olimpo.entity;

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
public class LoginInformation {
	private long id;
	private String email;
	private String password;
}
