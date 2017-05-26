package co.edu.eafit.dis.olimpo.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Comment {
	@Id
	private ObjectId id;
	private User user;
	private String description;
	private long entityId;
	//TODO: check identifier
	private CommentType commentType;
}
