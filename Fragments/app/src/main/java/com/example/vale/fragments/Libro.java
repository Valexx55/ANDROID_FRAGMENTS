package com.example.vale.fragments;

public class Libro
{
	private String titulo;
	private String autor;
	private String resumen;

	public Libro(String titulo, String autor, String resumen){
		this.titulo = titulo;
		this.autor = autor;
		this.resumen = resumen;
	}
	
	public String getTitulo(){
		return titulo;
	}
	
	public String getAutor(){
		return autor;
	}
	
	public String getResumen(){
		return resumen;
	}
}
