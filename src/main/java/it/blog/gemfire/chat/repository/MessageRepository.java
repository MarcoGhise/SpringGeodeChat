package it.blog.gemfire.chat.repository;

import java.util.Date;

import org.springframework.data.repository.CrudRepository;

import it.blog.gemfire.chat.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Date> {

}