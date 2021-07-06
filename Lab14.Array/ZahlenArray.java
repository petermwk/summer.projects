
/**
 * Beschreiben Sie hier die Klasse ZahlenArray.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)

 */
import java.util.Random;
import java.lang.Math;
public class ZahlenArray
{
    private int[] zahlen;

    public ZahlenArray(){
        zahlen = new int[10];
    }

    public ZahlenArray(int groesse){
        if(groesse < 0){
            System.out.print("Fehler: Groesse ist kleiner als 0!");

        }else{
            zahlen = new int[groesse];
        }
    }

    public void zuweisen(int index, int wert){
        if(index >= zahlen.length || index < 0){
            System.out.print("Fehler: Index ist groesser als 9 oder kleiner als 0!");
        }else{
            this.zahlen[index] = wert;
        }
    }

    public void zufall(int von, int bis){
        Random random = new Random();

        for(int i = 0; i < zahlen.length ; i++){
            int zufallsZahl = von + random.nextInt(bis-von+1);
            this.zuweisen(i, zufallsZahl);
        }
    }

    public int minimum(){
        int minZahl = this.zahlen[0];

        for(int i = 0; i < zahlen.length ; i++){
            if(this.zahlen[i] < minZahl){
                minZahl = this.zahlen[i];
            }
        }
        return minZahl;
    }

    public int minimumIndex(){
        int minZahl = this.zahlen[0];
        int minIndex = 0;

        for(int i = 0; i < zahlen.length ; i++){
            if(this.zahlen[i] < minZahl){
                minZahl = this.zahlen[i];
                minIndex = i;
            }

        }
        return minIndex;
    }

    public void ausgabe(int vonIndex, int bisIndex){
        if(vonIndex < 0 || vonIndex > zahlen.length){
            System.out.print("Fehler!");
        }else if(bisIndex < 0 || bisIndex > zahlen.length){
            System.out.print("Fehler!");
        }else{
            for(int i = vonIndex ; i <= bisIndex  ; i++){
                System.out.println("zahlen["+ i +"] = " + zahlen[i]);
            }
        }
    }

    public boolean istPrimzahl(int zahl){
        if (zahl == 2 || zahl == 3){
            return true; 
        } 
        if (zahl % 2 == 0) {
            return false; 
        } 
        int sqrt = (int) Math.sqrt(zahl) + 1;
        for (int i = 3; i < sqrt; i += 2) {
            if (zahl % i == 0) {
                return false; 
            }
        } 
        return true;
    }

    public void berechnePrimzahlen(int limit){

        if(limit <= 0){
            System.out.println ("Fehler!"); 
        }
        else{
            int arrayLength = 0;
            for(int i = 1; i <= limit; i++){

                if(this.istPrimzahl(i)){
                    arrayLength++;
                }
            }
            int arrayPrim[] = new int[arrayLength];
            
            int primZahlIndex = 0;
            for(int i = 1; i <= limit; i++){

                if(this.istPrimzahl(i)){
                    arrayPrim[primZahlIndex++] = i;
                }
            }

            for(int i = 0; i < arrayPrim.length; i++){
                System.out.println ("zahlen[" +i+ "] = "+ arrayPrim[i]); 
            }
        }
    }
}