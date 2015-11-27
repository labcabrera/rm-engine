package org.lab.rm.engine.model.common;

import java.io.Serializable;

@SuppressWarnings("serial")
public class SearchParams implements Serializable {

	private Integer currentPage;
	private Integer itemsPerPage;
	private String queryString;

	/**
	 * Constructor sin parámetros
	 */
	public SearchParams() {
	}

	/**
	 * Constructor a partir de la expresión de búsqueda, página actual y número de resultados por página
	 * 
	 * @param currentPage
	 * @param itemsPerPage
	 * @param queryString
	 */
	public SearchParams(Integer currentPage, Integer itemsPerPage, String queryString) {
		this.currentPage = currentPage;
		this.itemsPerPage = itemsPerPage;
		this.queryString = queryString;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(Integer itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}
