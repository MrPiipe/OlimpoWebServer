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
public class ContactInformation {
	private String name;
	private String lastName;
	private String phone;
	private String country;
}
