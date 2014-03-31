T2 Hackathon
===========

MapReduce Jobs for Problems in T2 Hackathon


Sorular
-----------
http://serkan-ozal.github.io/t2-hackathon-answers/


Soru-1 [10 Puan]
-----------
`s3n://t2-hackathon-question-data/1` dizini altında bulunan tüm tweetler incelenerek ülke kodları ve bunların kaç tane geçtiğini bulan bir Map/Reduce uygulamasını yazınız. 

**Açıklamalar:**

1. Ülke kodu alanı tweet datasındaki `place` alanının içindeki `country_code` değeridir. 
2. Ülke kodu değeri 2 karakterlidir ve `country_code` değeri boş olan tweetlerin `country_code` değeri `??` olarak kabul edilecektir. 
3. Çıktıda her satırda ülke kodu ve bu ülke kodunun kaç kere geçtiği bilgisi olacaktır. 
4. Çıktıdaki ülke kodu ve sıklık değeri arasında bir tane **boşluk** olacaktır. 
5. Satırlar ülke kodlarının string değerlerine göre **küçükten büyüğe** göre **artan** sırada olacaktır.
6. Örnek girdi verisi `s3n://t2-hackathon-question-sampledata/1` dizininde, çıktı ise `s3n://t2-hackathon-sampleanswers/1/output.txt` dosyasında mevcuttur.

**Örnek çıktı:**

~~~
?? 19682
...
GB 24643
...
TR 30881
...
~~~

Soru-4 [10 Puan]
-----------
`s3n://t2-hackathon-question-data/4` dizini altında bulunan tüm tweetler incelenerek profil bilgisi parametre geçilen dilde olan tweet sayısını bulan bir Map/Reduce uygulamasını yazınız. 

**Açıklamalar:**

1. Dil bilgisi tweet datasındaki `user` alanının içindeki `lang` değeridir. 
2. 1. parametrenin girdi verisinin dizini, 2. parametrenin çıktı verisinin dizini olduğunu hatırlarsak dil parametresi 3. parametredir. 
3. Sonuçlar karşılaştırılırken dil parametresi `tr` (**case-insensitive**) olarak geçilmiş olan sonuçlar ile karşılaştırılacaktır. Fakat aynı zaman da sonucun doğru olması halinde tam puan alabilmek için kod incelemesi de yapılacaktır.
4. Çıktıda tek satır bulunacaktır ve bu satırda sadece belirtilen dildeki tweet sayısı belirtilecektir. 
5. Örnek girdi verisi `s3n://t2-hackathon-question-sampledata/4` dizininde, çıktı ise `s3n://t2-hackathon-sampleanswers/4/output.txt` dosyasında mevcuttur.

**Örnek çıktı:**

~~~
29634
~~~

Soru-8 [10 Puan]
-----------
`s3n://t2-hackathon-question-data/8` dizini altında bulunan tüm tweetler incelenerek toplam tweet sayısını bulan bir Map/Reduce uygulamasını yazınız. 

**Açıklamalar:**

1. Çıktıda tek bir satırda toplam tweet sayısı değeri olacaktır.
2. Örnek girdi verisi `s3n://t2-hackathon-question-sampledata/8` dizininde, çıktı ise `s3n://t2-hackathon-sampleanswers/8/output.txt` dosyasında mevcuttur.

**Örnek çıktı:**

~~~
120000
~~~
