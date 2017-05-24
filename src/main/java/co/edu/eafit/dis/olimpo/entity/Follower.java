package co.edu.eafit.dis.olimpo.entity;

import java.util.List;

import co.edu.eafit.dis.olimpo.entity.Artist.ArtistBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Follower {
	private User user;
	private Artist artist;
}
