package br.com.twitterClient.helpVO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TweetHelpVO {

	@JsonProperty(value="Tweet")
	private String text;
	@JsonProperty(value="Numero de Palavras")
	private int numeroPalavras;
	@JsonProperty(value="Tamanho da Palavra mais Curta")
	private int TamanhoPalavraCurta;
	@JsonProperty(value="Tamanho da Palavra mais Longa")
	private int TamanhoPalavraLonga;
	@JsonProperty(value="Média do tamanho das Palavras")
	private Double mediaTamanho;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getNumeroPalavras() {
		return numeroPalavras;
	}
	public void setNumeroPalavras(int numeroPalavras) {
		this.numeroPalavras = numeroPalavras;
	}
	@JsonIgnore
	public int getTamanhoPalavraCurta() {
		return TamanhoPalavraCurta;
	}
	public void setTamanhoPalavraCurta(int tamanhoPalavraCurta) {
		TamanhoPalavraCurta = tamanhoPalavraCurta;
	}
	@JsonIgnore
	public int getTamanhoPalavraLonga() {
		return TamanhoPalavraLonga;
	}
	public void setTamanhoPalavraLonga(int tamanhoPalavraLonga) {
		TamanhoPalavraLonga = tamanhoPalavraLonga;
	}
	public Double getMediaTamanho() {
		return mediaTamanho;
	}
	public void setMediaTamanho(Double mediaTamanho) {
		this.mediaTamanho = mediaTamanho;
	}
	
	
}
