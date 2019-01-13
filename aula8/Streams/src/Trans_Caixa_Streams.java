/**
 *
 * @author fmm 2017
 */

import java.time.LocalDateTime;
import static java.lang.System.out;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
import java.util.*;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.InputMismatchException;
import java.lang.NumberFormatException;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.*;

public class Trans_Caixa_Streams {
    
    public static void memoryUsage() {
		final int mByte = 1024*1024;
		// Parâmetros de RunTime
		Runtime runtime = Runtime.getRuntime();
		out.println("== Valores de Utilização da HEAP [MB] ==");
		out.println("Memória Máxima RT:" + runtime.maxMemory()/mByte);
		out.println("Total Memory:" + runtime.totalMemory()/mByte);
		out.println("Memória Livre:" + runtime.freeMemory()/mByte);
		out.println("Memoria Usada:" + (runtime.totalMemory() - runtime.freeMemory())/mByte);	
    }
    
    public static TransCaixa strToTransCaixa(String linha) {
       //
       double preco = 0.0; 
       int ano = 0; int mes = 0; int dia = 0; 
       int hora = 0; int min = 0; int seg = 0;
       String codTrans, codCaixa;
       // split()
       String[] campos = linha.split("/");
       codTrans = campos[0].trim();
       codCaixa = campos[1].trim();
       try {
             preco = Double.parseDouble(campos[2]); 
       }
       catch(InputMismatchException | NumberFormatException e) { return null; }        
       String[] diaMesAnoHMS = campos[3].split("T");
       String[] diaMesAno = diaMesAnoHMS[0].split(":");
       String[] horasMin = diaMesAnoHMS[1].split(":");
       try {
             dia = Integer.parseInt(diaMesAno[0]);
             mes = Integer.parseInt(diaMesAno[1]);
             ano = Integer.parseInt(diaMesAno[2]);
             hora = Integer.parseInt(horasMin[0]);
             min = Integer.parseInt(horasMin[1]);
       }
       catch(InputMismatchException | NumberFormatException e) { return null; }
       return TransCaixa.of(codTrans, codCaixa, preco, LocalDateTime.of(ano, mes, dia, hora, min, seg));    
    }
   
    public static List<TransCaixa> setup(String nomeFich) {
      List<TransCaixa> ltc = new ArrayList<>();
      try (Stream<String> sTrans = Files.lines(Paths.get(nomeFich))) {
    	  ltc = sTrans.map(linha -> strToTransCaixa(linha)).collect(toList());
      } 
      catch(IOException exc) { out.println(exc.getMessage()); } 
      return ltc;
    }
    
    public static List<TransCaixa> setup1(String nomeFich) {
      List<String> lines = new ArrayList<>();
      try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
      catch(IOException exc) { System.out.println(exc.getMessage()); }
      // List<String> -> List<TransCaixa>
      List<TransCaixa> lTrans = new ArrayList<>();
      lines.forEach(line -> lTrans.add(strToTransCaixa(line)));
      return lTrans;
    }
    
    public static <R> SimpleEntry<Double,R> testeBoxGen(Supplier<? extends R> supplier) {
        Crono.start();
        R resultado = supplier.get();
        Double tempo = Crono.stop();
        return new SimpleEntry<Double,R>(tempo, resultado);
    }
    
    
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
        String nomeFich = "transCaixa1M.txt";
        List<TransCaixa> ltc1 = new ArrayList<>();
        
        // LE O FICHEIRO DE TRANSACÇOES PARA List<TransCaixa> sem Streams 
        Crono.start();
        ltc1 = setup1(nomeFich);
        out.println("Setup com List<String>: " + Crono.stop()*1000 + " ms");
        out.println("Transacções lidas -  Listas: " + ltc1.size());
        ltc1.clear();
       
        // LE O FICHEIRO DE TRANSACÇOES PARA List<TransCaixa> com Streams
        Crono.start();
        ltc1 = setup(nomeFich);
        out.println("Setup com Streams: " + Crono.stop()*1000 + " ms");
        out.println("Transacções lidas - Streams: " + ltc1.size());
        //memoryUsage();
        
        final List<TransCaixa> ltc = new ArrayList<>(ltc1);
        
        // Solução do prof
        DoubleSummaryStatistics stats = ltc.stream().mapToDouble(TransCaixa::getValor).summaryStatistics();
        out.println("Stats: " + stats);
        
        /* Exercicios
        double totalTrans = ltc.stream().mapToDouble(TransCaixa::getValor).sum();
        double totalTrans1 = ltc.stream().map(t -> t.getValor()).reduce(0.0, (v1,v2)->v1+v2);
        Function<TransCaixa, Double> daValoresTrans = t -> t.getValor();
        double totalTrans2 = ltc.stream().map(daValoresTrans).reduce(0.0, (v1,v2)->v1+v2);
        ToDoubleFunction<TransCaixa> valorTrans = TransCaixa::getValor;
        //não passei a linha do totalTrans3
        
        double quantosZeros = ltc.stream().mapToDouble(TransCaixa::getValor).filter(n -> n == 0.0).count();
        boolean quantosZerosProf = ltc.stream().anyMatch(t->t.getValor() == 0.0);
        out.println("Zeros: " + quantosZeros);
        double quantosCaixas = ltc.stream().map(t -> t.getCaixa()).distinct().count();
        out.println("Caixas: " + quantosCaixas);
        List<Integer> caixasProf = ltc.stream().map(t->Integer.valueOf(t.getCaixa())).distinct().sorted((i1,i2)->i1.compareTo(i2)).collect(toList());
        /*sacar o 0 e o ultimo*/
     }
}