
Rakennekuvaus

Muistipelissä on 16 luokkaa ja ne on sijoitettu kolmeen eri pakkaukseen.

Käyttöliittymä-pakkauksessa ovat Käyttöliittymä, Hiirenkuuntelija, Piirtoalusta, Aloitus- ja Lopetuskäyttöliittymät sekä Aloituksen- ja Lopetuksenkuuntelijat. Aloituskäyttöliittymä-luokka vastaa pelin aloitusvalikkoa, jolta Aloituskuuntelija kuuntelee pelaajan nimen sekä pelin vaikeustason. Näiden perusteella se luo pelaajan, muistipelin sekä käynnistää muistipelin. Käyttöliittymä-luokka toimii pelin käyttöliittymänä, jota hiirenkuuntelija kuuntelee. Hiirenkuuntelija hoitaa klikkausten käsittelyn. Piirtoalusta hakee ohjelmaan liittyvät kuvat tiedostosta ja piirtää pelin. Lopetuskäyttöliittymä-luokka vastaa lopetusvalikkoa, jota lopetuksenkuuntelija kuuntelee. Jos muistipeliä päätetään pelata uudestaan, niin lopetuksenkuuntelija hoitaa aloitusvalikon näyttämisen ja lopetusvalikon piilottamisen.

Domain-pakkauksessa olevat luokat ovat Kortti, Vaikeustaso, Korttipakka, Pelilauta, Pelaaja sekä KuvallinenKortti. Pelilauta luo korttipakan ja asettaa korteille koordinaatit. Korttipakkaan liittyy kortteja, joiden määrä riippuu korttipakkaan liittyvästä vaikeustasosta. KuvallinenKortti-luokka toimii apuna korttien piirtämisvaiheessa. Muistipeliin liittyy myös pelaaja, jossa on attribuuttina pelaajan pelin aikana keräämät pisteet. Lisäksi Domain-pakkauksessa on tilastoluokka, jonka avulla pelin loputtua pelaajan tiedot tallennetaan tilastoon.

Logiikka-pakkauksessa on Muistipeli-luokka, jonka vastuualueena on pelin logiikka. Muistipeli-luokkan avulla käynnistetään peli sekä hoidetaan pelin kulun toiminnot.
