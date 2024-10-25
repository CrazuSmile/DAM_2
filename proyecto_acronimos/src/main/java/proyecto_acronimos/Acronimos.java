package proyecto_acronimos;

public class Acronimos {   

    public String obtenerAcronimo(String cadena){
        String resultado="";
        char caracter;
        int n=cadena.length();
        for(int i=0;i<n;i++){
            caracter=cadena.charAt(i);
            if(caracter!=' '){
                if (i==0){
                    resultado=resultado+caracter+'.';
                }
                else{
                    if(cadena.charAt(i-1)==' '){
                        resultado=resultado+caracter+'.';
                    }
                }
            }
        }
        return resultado;
    }
}
