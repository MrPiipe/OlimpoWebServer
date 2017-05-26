package co.edu.eafit.dis.olimpo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Like {
	private User user;
	private Artwork artwork;
}