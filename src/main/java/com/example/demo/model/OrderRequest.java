package com.example.demo.model;

import java.io.Serializable;

import lombok.Data;
import org.springframework.http.StreamingHttpOutputMessage;

@Data
public class OrderRequest implements Serializable, Body {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer productId;
	private Integer amount = 1;
}
