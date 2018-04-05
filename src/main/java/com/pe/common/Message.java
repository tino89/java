package com.pe.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

	private Marked type;
	private String text;

	public Message(Marked type, String text) {
		this.type = type;
		this.text = text;
	}

	public Message() {
	}

	/**
	 * @return the level
	 */
	public Marked getLevel() {
		return type;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(Marked type) {
		this.type = type;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text
	 *            the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	public String toString() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MMM-dd hh:mm:ss a");
		return type + " [" + ft.format(dNow) + "] " + this.text + "\n";
	}

}
