package com.neuedu.shop.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4074774399243485575L;
	private Integer id;
	private String categoryName;
	private String categoryDescription;
	private String categoryParentId;
	private Boolean leaf;
	private Integer grade;
}
