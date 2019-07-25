package org.sbr.ServiceConsumer1.model;

import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class User {
	private int id;
	private String name;
	private String email;
	private Date createTime;
	private Date updateTime;	
}
