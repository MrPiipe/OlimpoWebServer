package co.edu.eafit.dis.olimpo.entity;

import java.util.List;

import co.edu.eafit.dis.olimpo.entity.LoginInformation.LoginInformationBuilder;
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
public class GenderByArtType {
	private ArtType artType;
	private List<String> gender;
}
