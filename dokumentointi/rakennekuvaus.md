Rakennekuvaus

Muistipelissä on 16 luokkaa ja ne on sijoitettu kolmeen eri pakkaukseen.

Käyttöliittymä- pakkauksessa ovat käyttöliittymä, hiirenkuuntelija, piirtoalusta, aloitus- ja lopetusvalikko sekä aloituksen- ja lopetuksenkuuntelijat. Aloitusvalikko-luokka vastaa pelin aloitusvalikkoa, jota Aloituskuuntelija kuuntelee pelaajan nimen sekä valittavan pelin vaikeustaso. Näiden perusteella se luo pelaajan, muistipelin sekä käynnistää muistipelin. Käyttöliittymä-luokka toimii pelin käyttöliittymänä, jota hiirenkuuntelija kuuntelee. Hiirenkuuntelija hoitaa klikkausten käsittelyn. Piirtoalusta hakee ohjelmaan liittyvät kuvat tiedostosta ja piirtää pelin. Lopetusvalikko-luokka vastaa lopetusvalikkoa, jota lopetuksenkuuntelija kuuntelee. Lopetuskuuntelija  näyttää aloitusvalikon ja piilottaa lopetusvalikon niin haluttaessa.

Domain-pakkauksessa olevat luokat ovat kortti, vaikeustaso, korttipakka, pelilauta, pelaaja sekä kuvallinenkortti. Pelilauta luo korttipakan ja asettaa korteille koordinaatit. Korttipakkaan liittyy kortteja, joiden määrä riippuu korttipakkaan liittyvästä vaikeustasosta. KuvallinenKortti-luokka toimii apuna korttien piirtämisvaiheessa. Muistipeliin liittyy myös pelaaja, jossa on attribuuttina pelaajan pelinaikana keräämät pisteet. Lisäksi Domain-pakkauksessa on tilastoluokka, jonka avulla pelin loputtua pelaajan tiedot tallennetaan tilastoon.

Logiikka-pakkauksessa on muistipeli-luokka, jonka vastuualueena on pelin logiikka. Muistipeli-luokka avulla käynnistetään peli sekä hoidetaan pelin kulun toiminnot.
