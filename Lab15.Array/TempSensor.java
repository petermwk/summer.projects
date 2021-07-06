  
/**
 * Beschreiben Sie hier die Klasse TempSensor.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class TempSensor
{
    private final byte LEER_WERT = Byte.MIN_VALUE;
    private byte[] messwerte;

    public TempSensor(){
        messwerte = new byte[48];

        for(int i = 0; i < messwerte.length; i++){
            messwerte[i] = LEER_WERT;
        }
    }

    public TempSensor(int kapazitaet){
        if(kapazitaet > 5 && kapazitaet < 337){
            messwerte = new byte[kapazitaet];   

            for(int i = 0; i < messwerte.length; i++){
                messwerte[i] = LEER_WERT;   
            }
        }else{
            System.out.print("Fehler!");   
        }
    }

    public boolean add(byte messwert){
        for(int i = 0; i < messwerte.length; i++){
            if(messwerte[i] == LEER_WERT){
                messwerte[i] = messwert;

                return true;
            }          
        }
        return false;
    }

    public boolean remove(int idx){
        if(idx < 0 || idx > 47){
            System.out.print("Fehler!");
            return false;
        }else{
            for(int i = 0; i < messwerte.length; i++){
                messwerte[idx] = LEER_WERT;
                return true;
            }
        }
        return false;
    }

    public void setFirst(byte messwert){
        messwerte[0] = messwert;
    }

    public void setLast(byte messwert){
        messwerte[47] = messwert;
    }

    public char removeIfBad(int idx){
        if(idx <= 0 && idx >= maxUsedIdx()){
            return 'i';
        }

        byte mitte = messwerte[idx];
        byte linkerNachbar = messwerte[idx - 1];
        byte rechterNachbar = messwerte[idx + 1];

        if(linkerNachbar == LEER_WERT || rechterNachbar == LEER_WERT){
            return 'n';
        }

        byte durchschnitt = (byte)((linkerNachbar + rechterNachbar) / 2);
        if(Math.abs(mitte - durchschnitt) <= 2){
            return '$';
        }else{
            return '_';   
        }

    }

    public int maxUsedIdx(){
        for(int i = 0; i < messwerte.length; i++){
            if(messwerte[i] == LEER_WERT){
                return i - 1;  
            }
        }
        return messwerte.length - 1;
    }

    public byte minWert(){
        int minZahl = messwerte[0];
        for(int i = 0; i < messwerte.length; i++){
            if(messwerte[i] < minZahl){
                minZahl = messwerte[i];
            }
        }
        return (byte)minZahl;
    }

    public byte maxWert(){
        int maxZahl = messwerte[0];
        for(int i = 0; i < messwerte.length; i++){
            if(messwerte[i] > maxZahl){
                maxZahl = messwerte[i];
            }
        }
        return (byte)maxZahl;
    }

    public float mittelWert(){
        float mittel = 0;
        for(int i = 0; i < messwerte.length; i++){
            mittel += messwerte[i];   
        }
        return mittel / messwerte.length;
    }

    public void printMesswerte(int spalten){
        System.out.println("Anzahl  Messwerte: " + maxUsedIdx());
        for(int i = 0;i < maxUsedIdx();i ++){
            String prefix = " ";
            if (i > 0) {
                prefix = ",";
                if (i % spalten == 0) {        
                    prefix += "\n ";
                } else {
                    prefix += " "; 
                }
            }
            System.out.print(prefix + "messwerte" + "[" + i + "]=" + messwerte[i]);
        }
        System.out.println();
    }
}
