package org.koushik.jababrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

public class Circle implements Shape, ApplicationEventPublisherAware {

	private Point center;
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	
	
	public MessageSource getMessageSource() {
		return messageSource;
	}



	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}



	public Point getCenter() {
		return center;
	}



	public void setCenter(Point center) {
		this.center = center;
	}



	@Override
	public void draw() {
		//System.out.println("Drawing circle point " + center.getX());
		System.out.println("Drawing circle point ");
		System.out.println(this.messageSource.getMessage("greeting", null, "def", null));
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
		
	}



	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
		
	}

}
