# DBLocalizationApplication

## Yleiskatsaus
JavaFX-sovellus, joka tukee lokalisaatiota (englanti, farsi, japani). Mahdollistaa työntekijätietojen syöttämisen ja tallentamisen tietokantaan.

## Ominaisuudet
- Kielen valinta ComboBoxilla
- Dynaamiset käyttöliittymän päivitykset
- Syöttökentät etunimelle, sukunimelle ja sähköpostille
- Tallenna-painike tietojen tallentamiseksi
- Ilmoitukset tietokantaoperaatioista

## Projektin rakenne
- `src/main/java/DBLocalizationApplication.java`: Pääsovellusluokka
JavaFX-sovellus, joka tukee lokalisaatiota (englanti, farsi, japani). Mahdollistaa työntekijätietojen syöttämisen ja tallentamisen tietokantaan.

## Ominaisuudet
- Kielen valinta ComboBoxilla
- `src/main/java/EmployeeDataHandler.java`: Käsittelee tietokantaoperaatioita
- Dynaamiset käyttöliittymän päivitykset
- `src/main/resources/MessageBundle_en.properties`: Englannin lokalisaatio
- `src/main/resources/MessageBundle_fa.properties`: Farsin lokalisaatio
- Syöttökentät etunimelle, sukunimelle ja sähköpostille
- `src/main/resources/MessageBundle_ja.properties`: Japanin lokalisaatio
- `pom.xml`: Maven-konfiguraatiotiedosto
```- Tallenna-painike tietojen tallentamiseksi
- Ilmoitukset tietokantaoperaatioista

## Projektin rakenne
- `src/main/java/DBLocalizationApplication.java`: Pääsovellusluokka
- `src/main/java/EmployeeDataHandler.java`: Käsittelee tietokantaoperaatioita
- `src/main/resources/MessageBundle_en.properties`: Englannin lokalisaatio
- `src/main/resources/MessageBundle_fa.properties`: Farsin lokalisaatio
- `src/main/resources/MessageBundle_ja.properties`: Japanin lokalisaatio