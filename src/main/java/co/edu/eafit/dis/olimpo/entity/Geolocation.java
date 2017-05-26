package co.edu.eafit.dis.olimpo.entity;

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
public class Geolocation {
	private String latitude;
	private String longitude;
	private String zoom;
}
