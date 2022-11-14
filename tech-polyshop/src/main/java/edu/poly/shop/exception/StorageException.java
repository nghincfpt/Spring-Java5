package edu.poly.shop.exception;

public class StorageException extends RuntimeException{

	public StorageException(String message) {
		super(message);
	
	}

	public StorageException(String messege, Exception e) {
		super(messege,e);
	}

}
