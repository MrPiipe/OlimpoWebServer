package co.edu.eafit.dis.olimpo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
	private Date createdDate;
	private Date updatedDate;
	private String createdBy;
	private String updatedBy;
}
