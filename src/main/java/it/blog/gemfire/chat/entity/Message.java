package it.blog.gemfire.chat.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.gemfire.mapping.annotation.Region;

import lombok.Getter;

@Region(value = "Message")
public class Message implements Serializable {

	@Id
	@Getter
	private final Date time;

	@Getter
	private final String message;
	
	@Getter
	private final String name;

	@PersistenceConstructor
	public Message(Date time, String message, String name) {
		this.time = time;
		this.message = message;
		this.name = name;
	}

	@Override
	public String toString() {
		return "[" + getTime() + "] " + getName() + " said:" + getMessage();
	}
}
