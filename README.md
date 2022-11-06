# UMA
User Management Application

Potreban je JDK 11 za pokretanje aplikacije.

Da preuzmete projekat:
1.  Otvorite Console ili Terminal -> Imajte git instaliran -> Napravite direktorijum za porjekat -> Izvrsite komandu u direktorijumu: 
git clone https://github.com/llagattore/UMA.git.
2.  Otvorite projekat u omiljenom IDE-u. Napravite build/run konfiguraciju za aplikacije: treba staviti JDK 11, a ulazna klasa je personal.uma.UmaApplication. 

PRIJE POKRETANJA APLIKACIJE
1. Potrebno je imati MySQL instaliran i mysql server pokrenut.
2. U application.yml (src/main/resources/application.yml) polje spring.datasource specifira neophodne parametre za pristup mysql serveru.
    Podrazumijava se da je na likalhost-u i default port-u, i user je root. Potrebno je samo unijeti password. Aplikacija nije testirana za konekcije ka       remote serveru, ali ukoliko zelite da probate, morate unijeti i url i username. User mora imati neophodne privilegije za kreiranje baze podataka. Path     varijablu '?createDatabaseIfNotExist=true' ostavite na true, kako bi se kreirala baza podataka. Takodje ce biti unijeti neki pocetni podaci.
3. Polje server.port specificira port za aplikaciju (stavljen je default port 8080).
4. Sledece methode su definisane:
    1.GET    |http://localhost:8080/api/city          |vraca sve gradove koji su u bazi podataka
    --- | --- | ---
    2.GET    |http://localhost:8080/api/company       |vraca sve kompanije koje su u bazi podataka
    3.POST   |http://localhost:8080/api/user              |dodaje novog korisnika u bazi podataka (ne smije imati id polje, u suprotnom BAD_REQUEST)
    4.PUT    |http://localhost:8080/api/user              |vrsi izmjenu specificiranih podataka nad korisnikom (mora imati id polje, u suprotnom BAD_REQUEST)
    5.DELETE |http://localhost:8080/api/user?id={?}       |brise korisnika (mora se dati id korisnika u path varijabli ?id=, npr: ?id=6)
    6.GET    |http://localhost:8080/api/user/inactive           |vraca sve neaktivne korisnike koji su u bazi podataka
    7.GET    |http://localhost:8080/api/user/{Datum}   |vraca sve korisnike kreirane na odredjeni datum (npr: http://localhost:8080/api/user/2022-11-04)
    8.GET    |http://localhost:8080/api/user?company_name={?}   |vraca sve korisnike jedne kompanije (mora se dati ime kompanije u path varijabli ?company_name=, npr: ?company_name=Company3)
   
Koristio sam Postman API Platform za testiranje metoda. GET metode mozete uputiti i preko address bar-a u browseru.
Uputite jednu od GET metoda nad userom (6, 7 ili 8), npr: http://localhost:8080/api/user/2022-11-04 da biste vidjeli podatke koji opisuju jednog usera. Mozete onda probati POST i PUT metode, dajuci pri tom BODY u JSON formatu.
Promjene stanja u bazi podataka pratite na nacin koji vam odgovara (najlakse preko mysql workbench-a ili u IDE-u ako to podrzava).
