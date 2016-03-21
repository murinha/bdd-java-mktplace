package util;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.text.MaskFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class StepSupport {
	private WebDriver driver;
	private ArrayList<Integer> listaAleatoria = new ArrayList<Integer>();
    private ArrayList<Integer> listaNumMultiplicados = null;
	
	public StepSupport(WebDriver _driver){
		this.driver = _driver;
	}	
	
	public String generateEmail(String emailChar){
		Random random = new Random();
		String randomEmail = "";
		int index = -1;  
		
		for(int i = 0; i < 9; i++) {  
		   index = random.nextInt( emailChar.length() );  
		   randomEmail += emailChar.substring( index, index + 1 );  
		}
		
		return randomEmail;
	}
	
    public static int randomIndex(int lowerBound, int upperBound) {
	      return (lowerBound + (int) Math.round(Math.random()
	              * (upperBound - lowerBound)));
    }
    
    public boolean isElementPresent(By by) {
        try {
          this.driver.findElement(by);
          return true;
        } catch (NoSuchElementException e) {
          return false;
        }
    }
    
    private int geraNumAleatorio(){
        int numero = (int) (Math.random() * 10);

        return numero;
    }   

    private ArrayList<Integer> geraCPFParcial(){
        for(int i = 0; i < 9; i++){
            listaAleatoria.add(geraNumAleatorio());
        }

        return listaAleatoria;
    }

    private ArrayList<Integer> geraPrimeiroDigito(){
        listaNumMultiplicados = new ArrayList<Integer>();
        int primeiroDigito;
        int totalSomatoria = 0;
        int restoDivisao;
        int peso = 10;

        for(int item : listaAleatoria){
            listaNumMultiplicados.add(item * peso);

            peso--;
        }

        for(int item : listaNumMultiplicados){
            totalSomatoria += item;
        }

        restoDivisao = (totalSomatoria % 11);

        if(restoDivisao < 2){
            primeiroDigito = 0;
        } else{
            primeiroDigito = 11 - restoDivisao;
        }

        listaAleatoria.add(primeiroDigito);

        return listaAleatoria;
    }

    private ArrayList<Integer> geraSegundoDigito(){
        listaNumMultiplicados = new ArrayList<Integer>();
        int segundoDigito;
        int totalSomatoria = 0;
        int restoDivisao;
        int peso = 11;

        for(int item : listaAleatoria){
            listaNumMultiplicados.add(item * peso);

            peso--;
        }

        for(int item : listaNumMultiplicados){
            totalSomatoria += item;
        }

        restoDivisao = (totalSomatoria % 11);
        
        if(restoDivisao < 2){
            segundoDigito = 0;
        } else{
            segundoDigito = 11 - restoDivisao;
        }
        listaAleatoria.add(segundoDigito);

        return listaAleatoria;
    }

    public String geraCPFFinal() {
        geraCPFParcial();
        geraPrimeiroDigito();
        geraSegundoDigito();

        String cpf = "";
        String texto = "";

        for(int item : listaAleatoria){
            texto += Integer.toString(item);
        }

        try {
            MaskFormatter mf = new MaskFormatter("###.###.###-##");  
            mf.setValueContainsLiteralCharacters(false);
            cpf = mf.valueToString(texto);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return cpf; 
    }
}