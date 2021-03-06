[![Build Status](https://travis-ci.org/dcorteztec/twitterClient.svg?branch=master)](https://travis-ci.org/dcorteztec/twitterClient)
<h1>Consuming twitter api with spring boot and JPA</h1>

###
Efetuar buscar de tweets que contenham o texto passado e persistindo os tweets encontrados em banco local.
<b>(Search for tweets that contain the last text and persist the tweets found in the local bank.)
<br/>
/api/tweet/captar</b>

Buscar no banco de tweets captados no serviço anterior.
(Search the bank of tweets captured in the previous service.)
<br/>
<b>/api/tweet/procurar</b>

Retornar estatísticas de um tweet persistido em banco local. Informar seguintes estatísticas: Número de palavras, o tamanho da palavra mais curta, o tamanho da palavra mais longa, média de tamanho das palavras.
<b>(Return statistics from a persistent tweet to local bank. Report the following statistics: Number of words, the size of the shortest word, the length of the longest word, average size of the words.)
<br/>
/api/tweet/{idTweet}/estatisticas</b>

"mais_comum" -- Encontrar a palavra mais comum entre os tweets persistidos em banco local. Se tiverem mais de uma palavra, ordenar.
<b>(Find the most common word among persistent tweets in local bank. If they have more than one word, sort it out.)
<br/>
/api/tweet/mais_comum</b>

"mais_longa" -- Encontrar a palavra mais longa entre os tweets persistidos em banco local. Se tiverem mais de uma palavra, ordenar.
<b>(Find the longest word among persistent tweets at local bank. If they have more than one word, sort it out.)
<br/>
/api/tweet/mais_longa</b>

"exatamente_em" -- Encontrar a palavra que pertence ao número exato de tweets persistidos em banco local. Se tiverem mais de uma palavra, ordenar.
<b>(Find the word that pertains to the exact number of persisted tweets in local bank. If they have more than one word, sort it out.)
<br/>
/api/tweet/exatamente_em/{numeroRepeticoes}</b>

