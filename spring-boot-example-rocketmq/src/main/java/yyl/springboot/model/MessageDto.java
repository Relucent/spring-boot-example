package yyl.springboot.model;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class MessageDto implements Serializable {
	private String message;
}
