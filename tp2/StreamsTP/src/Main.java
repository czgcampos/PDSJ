import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class Main {
    private static final String path="input/transCaixa6M.txt";
    private static List<TransCaixa> caixa = Utils_TransCaixa.setup(path);
    public static void cpuMarks(){
        System.out.println("CPUs: "+ Runtime.getRuntime().availableProcessors());
        ForkJoinPool fjpool=ForkJoinPool.commonPool();
        System.out.println("Max. JVM Threads: "+fjpool.getParallelism());
        System.out.println("Threads Potenciais: "+fjpool.getCommonPoolParallelism());
        System.out.println("Pool Size: "+fjpool.getPoolSize());
    }
    public static void main(String[] args){
        //Trans_Caixa_Streams.memoryUsage();
        //cpuMarks();
        //Queries.resolveQuery1_Arrays(caixa);
        //Queries.resolveQuery1_DoubleStream(caixa);
        //Queries.resolveQuery1_StreamDouble(caixa);
        //Queries.resolveQuery2(caixa);
        //Queries.resolveQuery3();
        //Queries.resolveQuery4(caixa);
        //Queries.resolveQuery5(caixa);
        //Queries.resolveQuery6(caixa);
        //Queries.resolveQuery7(caixa);
        //Queries.resolveQuery8(caixa);
        //Queries.resolveQuery9(caixa);
        //Queries.resolveQuery10(caixa);
    	Queries.resolveQuery11(caixa);
        //Queries.resolveQuery12(caixa);
    }
}
