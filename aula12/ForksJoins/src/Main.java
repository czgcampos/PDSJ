import java.util.concurrent.ForkJoinPool;

public class Main {
	public static void main(String[] args) {
		System.out.println("CPUs: "+Runtime.getRuntime().availableProcessors());
		ForkJoinPool fjpool = ForkJoinPool.commonPool();
		System.out.println("Max. JVM Threads "+fjpool.getParallelism());
		System.out.println("Threads Potenciais: "+fjpool.getCommonPoolParallelism());
		System.out.println("Pool size: "+fjpool.getPoolSize());
	}
}