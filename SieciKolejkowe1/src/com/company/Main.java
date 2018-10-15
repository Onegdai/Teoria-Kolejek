package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

	int czas;
	System.out.println("Podaj czas trwania symulacji:"); //Czas trwania symulacji
	Scanner odczytczasu=new Scanner(System.in);
    czas=odczytczasu.nextInt();

    int czasobslugi;
    System.out.println("Podaj dokoładny czas obsługi:");
    czasobslugi=odczytczasu.nextInt();

    int sredniczasprzyjazdu;
    System.out.println("Podaj średni czas przyjazdu następnego samochodu:"); //Sredni czas przyjazdu następnego samochodu
    sredniczasprzyjazdu = odczytczasu.nextInt();

    int scs=0; //sumaryczny czas symulacji
    int bufor = 0; //wskazyuje czas oczekiwanai na obsluge
    int sumabuforow = 0; //służy do policzenia średniego czasu w kolejce
    int iloscaut = 0; //służy do policzenia średniego czasu w kolejce
    int srednibufor = 0; //ja nawet nie wiem co to jest czysty kod :|
    int czywolne = 0;  //zmienna do sprawdzania stanu stanowiska

        while(scs+bufor<=czas) {
            Random generator = new Random();
            double a = 1 - generator.nextDouble();
            double xd = -(Math.log(a) * sredniczasprzyjazdu); //generowanie czasu przyjazdu następnego samochodu
            int x = (int) Math.round(xd);
            if (x==0) {
                x = 1;
            }
            if(x>=czywolne){
                bufor=0;
                czywolne=czasobslugi;
            }
            else {
                bufor = (czywolne - x);
                czywolne=bufor+czasobslugi;
            }
            scs=scs+x;
            sumabuforow=sumabuforow+bufor;
            iloscaut++;

            System.out.println("x:"+x);
            System.out.println("bufor:"+bufor);
        }
        srednibufor=sumabuforow/iloscaut;
        System.out.println("Koniec symulacji");
        System.out.println("Przyjechało "+iloscaut+" samochodów. W kolejce spędziły średnio "+srednibufor+"sekund");
    }
}
