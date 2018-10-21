package br.com.twitterClient.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.twitterClient.helpVO.TweetHelpVO;
import br.com.twitterClient.helpVO.TweetsStringHelperVO;
import br.com.twitterClient.repository.ITweetRepository;
import br.com.twitterClient.vo.Tweets;

@RestController
@RequestMapping(TwitterControllerBD.TWITTER_PROCURAR_URI)
public class TwitterControllerBD {

	public static final String TWITTER_PROCURAR_URI = "api/tweet/";

	// @Autowired
	// private Twitter twitter;

	@Autowired
	private ITweetRepository tweetRepository;

	@RequestMapping(value = "procurar/{busca}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Tweets> getBDTweets(@PathVariable("busca") final String busca) {
		List<Tweets> ret = (List<Tweets>) tweetRepository.findByTweets(busca);
		return ret;
	}

	@RequestMapping(value = "{idTweet}/estatisticas", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TweetHelpVO getBDTweetsEstatisticas(@PathVariable("idTweet") final Long idTweet) {
		int imenor = 0;
		int imaior = 0;
		int soma = 0;
		double media = 0.0;
		TweetHelpVO ret = new TweetHelpVO();
		Optional<Tweets> tweet = tweetRepository.findById(idTweet);
		String t = tweet.get().getText().replaceAll("\\s+", " ");
		String[] text = t.split(" ");
		ret.setNumeroPalavras(text.length);
		ret.setText(tweet.get().getText());
		for (int i = 0; i < text.length; i++) {
			soma += text[i].length();
			if (text[i].length() < text[imenor].length()) {
				imenor = i;
			}
			if (text[i].length() > text[imaior].length()) {
				imaior = i;
			}

		}
		media = soma / ret.getNumeroPalavras();
		ret.setMediaTamanho(media);
		ret.setTamanhoPalavraCurta(imenor);
		ret.setTamanhoPalavraLonga(imaior);
		return ret;
	}

	@RequestMapping(value = "mais_comum", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<TweetsStringHelperVO> getMaisComum() {
		List<TweetsStringHelperVO> retorno = new ArrayList<TweetsStringHelperVO>();
		List<Tweets> list = (List<Tweets>) tweetRepository.findAll();
		List<String> todasPalavras = new ArrayList<>();
		for (Tweets tweets : list) {
			String format = tweets.getText().replaceAll("\\s+", " ");
			String[] text = format.split(" ");
			for (String palavra : text) {
				todasPalavras.add(palavra);
			}
		}

		Map<String, Long> collect = todasPalavras.stream()
				.collect(Collectors.groupingBy(p -> p, Collectors.counting()));
		Map<String, Long> treeMap = new TreeMap<String, Long>(collect);
		for (Map.Entry<String, Long> entrada : treeMap.entrySet()) {
			TweetsStringHelperVO ret = new TweetsStringHelperVO();
			String palavra = entrada.getKey();
			Long qtd = entrada.getValue();
			if (palavra.length() > 4 && qtd > 1) {
				ret.setMaisComum(palavra);
				ret.setQtd(qtd);
				retorno.add(ret);
			}
		}
		return retorno;
	}

	@RequestMapping(value = "mais_longa", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public TweetsStringHelperVO getMaisLonga() {
		TweetsStringHelperVO retorno = new TweetsStringHelperVO();
		ArrayList<Tweets> list = (ArrayList<Tweets>) tweetRepository.findAll();
		List<String> todasPalavras = new ArrayList<>();
		for (Tweets tweets : list) {
			String format = tweets.getText().replaceAll("\\s+", " ");
			String[] text = format.split(" ");
			for (String palavra : text) {
				todasPalavras.add(palavra);
			}
		}
		int tamanho = todasPalavras.get(0).length();
		int index = 0;

		for (int i = 0; i < todasPalavras.size(); i++) {
			if (todasPalavras.get(i).length() > tamanho) {
				tamanho = todasPalavras.get(i).length();
				index = i;
			}
		}
		retorno.setMaisLonga(todasPalavras.get(index));
		retorno.setTamanho(tamanho);
		return retorno;

	}

	@RequestMapping(value = "exatamente_em/{numeroRepeticoes}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<TweetsStringHelperVO> getExatamenteEm(
			@PathVariable("numeroRepeticoes") final Integer numeroRepeticoes) {

		List<TweetsStringHelperVO> retorno = new ArrayList<TweetsStringHelperVO>();
		List<Tweets> list = (List<Tweets>) tweetRepository.findAll();
		List<String> todasPalavras = new ArrayList<>();
		for (Tweets tweets : list) {
			String format = tweets.getText().replaceAll("\\s+", " ");
			String[] text = format.split(" ");
			for (String palavra : text) {
				todasPalavras.add(palavra);
			}
		}

		Map<String, Long> collect = todasPalavras.stream()
				.collect(Collectors.groupingBy(p -> p, Collectors.counting()));
		Map<String, Long> treeMap = new TreeMap<String, Long>(collect);
		for (Map.Entry<String, Long> entrada : treeMap.entrySet()) {
			TweetsStringHelperVO ret = new TweetsStringHelperVO();
			String palavra = entrada.getKey();
			Long qtd = entrada.getValue();
			if (palavra.length() > 4 && qtd > 1 && qtd.equals(Long.parseLong(numeroRepeticoes.toString()))) {
				ret.setMaisComum(palavra);
				ret.setQtd(qtd);
				retorno.add(ret);
			}
		}
		return retorno;

	}

}
