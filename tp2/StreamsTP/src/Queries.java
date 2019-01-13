import java.time.DayOfWeek;
import java.time.Month;
import java.time.temporal.ChronoField;
import java.util.*;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.*;
import java.util.stream.*;

public class Queries{
    // QUERY 1
	private static double[] transCaixaToDouble(List<TransCaixa> ltc) {
        List<Double> doublesList = ltc.stream().map(TransCaixa::getValor).collect(Collectors.toList());
        double[] res = new double[doublesList.size()];
        int i = 0;
        for (Double d : doublesList)
            res[i++] = d;
        return res;
    }
    /*private static Supplier<DoubleStream> transCaixaToDoubleStream(List<TransCaixa> ltc){
        Supplier<DoubleStream> dstr = ()-> ltc.stream().mapToDouble(TransCaixa::getValor);
        return dstr;
    }
    private static Supplier<Stream<Double>> transCaixaToStreamDouble(List<TransCaixa> ltc){
        Supplier<Stream<Double>> strd = () ->ltc.stream().map(TransCaixa::getValor);
        return strd;
    }*/
    // double[]
    private static Double Query1_DoubleForSum(double[] lst){
        double media=0.0;
        for(int i=0;i<lst.length;i++)
            media+=lst[i];
        return media;
    }
    private static Double Query1_DoubleForEachSum(double[] lst) {
        double media=0.0;
        for(double d: lst)
            media+=d;
        return media;
    }
    private static Double Query1_DoubleForAvg(double[] lst){
        double media=0.0;
        for(int i=0;i<lst.length;i++)
            media+=lst[i];
        return media=media/lst.length;
    }
    private static Double Query1_DoubleForEachAvg(double[] lst) {
        double media=0.0;
        for(double d: lst)
            media+=d;
        return media=media/lst.length;
    }
    // DoubleStream
    private static Double Query1_DoubleStreamSumSeq(List<TransCaixa> ltc){
        return ltc.stream().mapToDouble(TransCaixa::getValor).sum();
    }
    private static Double Query1_DoubleStreamSumPar(List<TransCaixa> ltc){
        return ltc.stream().parallel().mapToDouble(TransCaixa::getValor).sum();
    }
    private static Double Query1_DoubleStreamAvgSeq(List<TransCaixa> ltc){
        return ltc.stream().mapToDouble(TransCaixa::getValor).average().getAsDouble();
    }
    private static Double Query1_DoubleStreamAvgPar(List<TransCaixa> ltc){
        return ltc.stream().parallel().mapToDouble(TransCaixa::getValor).average().getAsDouble();
    }
    // Stream<Double>
    private static Double Query1_StreamDSumSeq(List<TransCaixa> ltc){
        return ltc.stream().mapToDouble(TransCaixa::getValor).sum();
    }
    private static Double Query1_StreamDSumPar(List<TransCaixa> ltc){
        return ltc.stream().parallel().mapToDouble(TransCaixa::getValor).sum();
    }
    private static Double Query1_StreamDAvgSeq(List<TransCaixa> ltc){
        return ltc.stream().mapToDouble(TransCaixa::getValor).average().getAsDouble();
    }
    private static Double Query1_StreamDAvgPar(List<TransCaixa> ltc){
        return ltc.stream().parallel().mapToDouble(TransCaixa::getValor).average().getAsDouble();
    }
    public static void resolveQuery1_Arrays(List<TransCaixa> tc){
        double[] darr = Queries.transCaixaToDouble(tc);
        Supplier<Double> supplier_query1_1 =() -> Query1_DoubleForSum(darr);
        SimpleEntry<Double, Double> res_query1_1 = testBox.testeBoxGenW(supplier_query1_1);
        System.out.println("Sum(double[] for): " + res_query1_1.getKey() + "/"+res_query1_1.getValue());
        Supplier<Double> supplier_query1_2 =() -> Query1_DoubleForEachSum(darr);
        SimpleEntry<Double, Double> res_query1_2 = testBox.testeBoxGenW(supplier_query1_2);
        System.out.println("Sum(double[] forEach): " + res_query1_2.getKey() + "/"+res_query1_2.getValue());
        Supplier<Double> supplier_query1_3 =() -> Query1_DoubleForAvg(darr);
        SimpleEntry<Double, Double> res_query1_3 = testBox.testeBoxGenW(supplier_query1_3);
        System.out.println("Avg(double[] for): " + res_query1_3.getKey() + "/"+res_query1_3.getValue());
        Supplier<Double> supplier_query1_4 =() -> Query1_DoubleForEachAvg(darr);
        SimpleEntry<Double, Double> res_query1_4 = testBox.testeBoxGenW(supplier_query1_4);
        System.out.println("Avg(double[] forEach): " + res_query1_4.getKey() + "/"+res_query1_4.getValue());
    }
    public static void resolveQuery1_DoubleStream(List<TransCaixa> tc){
        Supplier<Double> supplier_query1_5 =() -> Query1_DoubleStreamSumSeq(tc);
        SimpleEntry<Double, Double> res_query1_5 = testBox.testeBoxGenW(supplier_query1_5);
        System.out.println("Sum(DoubleStream) seq: " + res_query1_5.getKey() + "/"+res_query1_5.getValue());
        Supplier<Double> supplier_query1_6 =() -> Query1_DoubleStreamSumPar(tc);
        SimpleEntry<Double, Double> res_query1_6 = testBox.testeBoxGenW(supplier_query1_6);
        System.out.println("Sum(DoubleStream) par: " + res_query1_6.getKey() + "/"+res_query1_6.getValue());
        Supplier<Double> supplier_query1_7 =() -> Query1_DoubleStreamAvgSeq(tc);
        SimpleEntry<Double, Double> res_query1_7 = testBox.testeBoxGenW(supplier_query1_7);
        System.out.println("Avg(DoubleStream) seq: " + res_query1_7.getKey() + "/"+res_query1_7.getValue());
        Supplier<Double> supplier_query1_8 =() -> Query1_DoubleStreamAvgPar(tc);
        SimpleEntry<Double, Double> res_query1_8 = testBox.testeBoxGenW(supplier_query1_8);
        System.out.println("Avg(DoubleStream) par: " + res_query1_8.getKey() + "/"+res_query1_8.getValue());
    }
    public static void resolveQuery1_StreamDouble(List<TransCaixa> tc){
        Supplier<Double> supplier_query1_9 =() -> Query1_StreamDSumSeq(tc);
        SimpleEntry<Double, Double> res_query1_9 = testBox.testeBoxGenW(supplier_query1_9);
        System.out.println("Sum(Stream<Double>) seq: " + res_query1_9.getKey() + "/"+res_query1_9.getValue());
        Supplier<Double> supplier_query1_10 =() -> Query1_StreamDSumPar(tc);
        SimpleEntry<Double, Double> res_query1_10 = testBox.testeBoxGenW(supplier_query1_10);
        System.out.println("Sum(Stream<Double>) par: " + res_query1_10.getKey() + "/"+res_query1_10.getValue());
        Supplier<Double> supplier_query1_11 =() -> Query1_StreamDAvgSeq(tc);
        SimpleEntry<Double, Double> res_query1_11 = testBox.testeBoxGenW(supplier_query1_11);
        System.out.println("Avg(Stream<Double>) seq: " + res_query1_11.getKey() + "/"+res_query1_11.getValue());
        Supplier<Double> supplier_query1_12 =() -> Query1_StreamDAvgPar(tc);
        SimpleEntry<Double, Double> res_query1_12 = testBox.testeBoxGenW(supplier_query1_12);
        System.out.println("Avg(Stream<Double>) par: " + res_query1_12.getKey() + "/"+res_query1_12.getValue());
    }
    // QUERY 2
    private static ToIntFunction<Double> doubleToInt = d -> d.intValue();
    private static SimpleEntry<List<TransCaixa>,List<TransCaixa>> Query2_List(List<TransCaixa> ltc){
        Collections.sort(ltc);
        List<TransCaixa> primeiros=ltc.subList(0, doubleToInt.applyAsInt(ltc.size()*0.3));
        List<TransCaixa> ultimos=ltc.subList(ltc.size()-doubleToInt.applyAsInt(ltc.size()*0.3), ltc.size());
        return new SimpleEntry<List<TransCaixa>,List<TransCaixa>>(primeiros,ultimos);
    }
    private static SimpleEntry<Set<TransCaixa>,Set<TransCaixa>> Query2_Set(List<TransCaixa> ltc){
        Set<TransCaixa> lSet = new TreeSet<TransCaixa>(ltc);
        Set<TransCaixa> primeiros=new TreeSet<TransCaixa>();
        Iterator<TransCaixa> it = lSet.iterator();
        for(int i=0;it.hasNext() && i<doubleToInt.applyAsInt(ltc.size()*0.3);i++)
            primeiros.add(it.next());
        Set<TransCaixa> ultimos=new TreeSet<TransCaixa>();
        Iterator<TransCaixa> itr = ((TreeSet<TransCaixa>) lSet).descendingIterator();
        for(int i=0;itr.hasNext() && i<doubleToInt.applyAsInt(ltc.size()*0.3);i++)
            ultimos.add(itr.next());
        return new SimpleEntry<Set<TransCaixa>,Set<TransCaixa>>(primeiros,ultimos);
    }
    private static SimpleEntry<List<TransCaixa>,List<TransCaixa>> Query2_Stream(List<TransCaixa> ltc){
        Supplier<List<TransCaixa>> s = ()-> ltc.stream().sorted().collect(Collectors.toList());
        List<TransCaixa> primeiros=s.get().subList(0, doubleToInt.applyAsInt(ltc.size()*0.3));
        List<TransCaixa> ultimos=s.get().subList(ltc.size()-doubleToInt.applyAsInt(ltc.size()*0.3), ltc.size());
        return new SimpleEntry<List<TransCaixa>,List<TransCaixa>>(primeiros,ultimos);
    }
    private static SimpleEntry<List<TransCaixa>,List<TransCaixa>> Query2_StreamParallel(List<TransCaixa> ltc){
        Supplier<List<TransCaixa>> s = ()-> ltc.parallelStream().sorted().collect(Collectors.toList());
        List<TransCaixa> primeiros=s.get().subList(0, doubleToInt.applyAsInt(ltc.size()*0.3));
        List<TransCaixa> ultimos=s.get().subList(ltc.size()-doubleToInt.applyAsInt(ltc.size()*0.3), ltc.size());
        return new SimpleEntry<List<TransCaixa>,List<TransCaixa>>(primeiros,ultimos);
    }
    public static void resolveQuery2(List<TransCaixa> ltc){
        List<TransCaixa> newltc = new ArrayList<>(ltc);
        Supplier<SimpleEntry<List<TransCaixa>,List<TransCaixa>>> supplier_query2_List = () -> Query2_List(newltc);
        SimpleEntry<Double, SimpleEntry<List<TransCaixa>, List<TransCaixa>>> res_query2_List = testBox.testeBoxGenW(supplier_query2_List);
        System.out.println(res_query2_List.getKey());
        System.out.println("------------------------------LIST------------------------------");
        List<TransCaixa> newltc2 = new ArrayList<>(ltc);
        Supplier<SimpleEntry<Set<TransCaixa>,Set<TransCaixa>>> supplier_query2_Set = () -> Query2_Set(newltc2);
        SimpleEntry<Double, SimpleEntry<Set<TransCaixa>, Set<TransCaixa>>> res_query2_Set = testBox.testeBoxGenW(supplier_query2_Set);
        System.out.println(res_query2_Set.getKey());
        System.out.println("------------------------------SET------------------------------");
        List<TransCaixa> newltc3 = new ArrayList<>(ltc);
        Supplier<SimpleEntry<List<TransCaixa>,List<TransCaixa>>> supplier_query2_Stream = () -> Query2_Stream(newltc3);
        SimpleEntry<Double, SimpleEntry<List<TransCaixa>, List<TransCaixa>>> res_query2_Stream = testBox.testeBoxGenW(supplier_query2_Stream);
        System.out.println(res_query2_Stream.getKey());
        System.out.println("------------------------------STREAM------------------------------");
        List<TransCaixa> newltc4 = new ArrayList<>(ltc);
        Supplier<SimpleEntry<List<TransCaixa>,List<TransCaixa>>> supplier_query2_StreamParallel = () -> Query2_StreamParallel(newltc4);
        SimpleEntry<Double, SimpleEntry<List<TransCaixa>, List<TransCaixa>>> res_query2_StreamParallel = testBox.testeBoxGenW(supplier_query2_StreamParallel);
        System.out.println(res_query2_StreamParallel.getKey());
        System.out.println("------------------------------PARALLEL------------------------------");
    }
    // QUERY 3 - criacao das estruturas parte da intstream de modo a que o random nao interfira nas contas.
    private static int[] randomIntArray(IntStream istr){
        int[] res = istr.toArray();
        return res;
    }
    /*private static List<Integer> randomIntList(IntStream istr){
        List<Integer> res = istr.boxed().collect(Collectors.toList());
        return res;
    }*/
    private static Supplier<IntStream> randomIntStream(int n){ // alterar esta?
        Supplier<IntStream> res = ()-> IntStream.generate(()->{return (int)(Math.random()*9999+1);}).limit(n);
        return res;
    }
    /* Com o array desordenado demora muito tempo a correr */
    private static int[] Query3_removeDupsArray(int[] iarr){
        int i=0,j=0;
        Arrays.sort(iarr);
        for(;i<iarr.length-1;i++)
            for(j=i+1;j<iarr.length && iarr[j]!=-1 && iarr[i]==iarr[j];j++)
                iarr[j] = -1;
        return iarr;
    }
    private static Supplier<List<Integer>> Query3_removeDupsList = ()->{
        List<Integer> ilist = new ArrayList<>();
        int i=6000000;
        for(;i>0;i--) ilist.add((int)(Math.random()*9999+1));
        i=0;
        List<Integer> res = new ArrayList<>(new HashSet<>(ilist));
        return res;
    };
    private static IntStream Query3_removeDupsIntStream(Supplier<IntStream> istr){
        return istr.get().distinct();
    }
    public static void resolveQuery3(){
        int n = 6000000;
        Supplier<IntStream> istr = randomIntStream(n);
        Supplier<int[]> supplier_query3_1 = () -> Query3_removeDupsArray(randomIntArray(istr.get()));
        SimpleEntry<Double, int[]> res_query3_1 = testBox.testeBoxGenW(supplier_query3_1);
        System.out.println("Remove dups(int[]): "+res_query3_1.getKey());
        Supplier<List<Integer>> supplier_query3_2 = Query3_removeDupsList;
        SimpleEntry<Double,List<Integer>> res_query3_2 =testBox.testeBoxGenW(supplier_query3_2);
        System.out.println("Remove dups(List<Integer>): "+res_query3_2.getKey());
        Supplier<IntStream> supplier_query3_3 = () -> Query3_removeDupsIntStream(istr);
        SimpleEntry<Double,IntStream> res_query3_3 =testBox.testeBoxGenW(supplier_query3_3);
        System.out.println("Remove dups(IntStream): "+res_query3_3.getKey());
    }
    // QUERY 4
    private static Double multDoublesStatic(Double d1, Double d2){
        return d1*d2;
    }
    private static BiFunction<Double, Double, Double> multDoublesBF = (d1,d2) -> d1*d2;
    private interface doubleInterface{
        Double operacao(Double d1, Double d2);
    }
    private static doubleInterface multDoubleLambda = (Double d1, Double d2) -> d1*d2;
    private static double[] Query4_Static(Supplier<Stream<TransCaixa>> tcStr){
        double[] res = tcStr.get().mapToDouble(t->multDoublesStatic(t.getValor(),5.0)).toArray();
        return res;
    }
    private static double[] Query4_BiFunction(Supplier<Stream<TransCaixa>> tcStr){
        double[] res = tcStr.get().mapToDouble(t->multDoublesBF.apply(t.getValor(),5.0)).toArray();
        return res;
    }
    private static double[] Query4_Lambda(Supplier<Stream<TransCaixa>> tcStr){
        double[] res = tcStr.get().mapToDouble(t->multDoubleLambda.operacao(t.getValor(),5.0)).toArray();
        return res;
    }
    public static void resolveQuery4(List<TransCaixa> ltc){
        Supplier<Stream<TransCaixa>> sltc = () -> ltc.stream();
        Supplier<double[]> supplier_query4_static = () -> Query4_Static(sltc);
        SimpleEntry<Double, double[]> res_query4_static = testBox.testeBoxGenW(supplier_query4_static);
        System.out.println("Static: "+res_query4_static.getKey());
        Supplier<double[]> supplier_query4_bf = () -> Query4_BiFunction(sltc);
        SimpleEntry<Double, double[]> res_query4_bf = testBox.testeBoxGenW(supplier_query4_bf);
        System.out.println("BiFunction: "+res_query4_bf.getKey());
        Supplier<double[]> supplier_query4_lambda = () -> Query4_Lambda(sltc);
        SimpleEntry<Double, double[]> res_query4_lambda = testBox.testeBoxGenW(supplier_query4_lambda);
        System.out.println("Lambda: "+res_query4_lambda.getKey());
    }
    // QUERY 5
    private static Comparator<TransCaixa> comparaTC = (t1, t2) -> t1.getValor()>t2.getValor() ? 1 : t1.getValor()<t2.getValor() ? -1 : 0;
    private static TreeSet<TransCaixa> Query5_collectToTreeSet(List<TransCaixa> ltc){
        TreeSet<TransCaixa> res = ltc.stream().collect(Collectors.toCollection(TreeSet::new));
        return res;
    }
    private static List<TransCaixa> Query5_collectToList(List<TransCaixa> ltc){
        List<TransCaixa> res = ltc.stream().sorted(comparaTC).collect(Collectors.toList());
        return res;
    }
    public static void resolveQuery5(List<TransCaixa> ltc){
        Supplier<TreeSet<TransCaixa>> supplier_query5_1 = () -> Query5_collectToTreeSet(ltc);
        SimpleEntry<Double,TreeSet<TransCaixa>> res_query5_1 = testBox.testeBoxGenW(supplier_query5_1);
        System.out.println("Coleccionar para TreeSet: "+res_query5_1.getKey());
        Supplier<List<TransCaixa>> supplier_query5_2 = () -> Query5_collectToList(ltc);
        SimpleEntry<Double,List<TransCaixa>> res_query5_2 = testBox.testeBoxGenW(supplier_query5_2);
        System.out.println("Coleccionar para List: "+res_query5_2.getKey());
    }
    // QUERY 6
    private static Map<Month,Map<Integer,Map<Integer,List<TransCaixa>>>> Query6_Catalogo_Stream(List<TransCaixa> ltc){
        Map<Month,Map<Integer,Map<Integer,List<TransCaixa>>>> mapaTxPorMDH =
                ltc.stream().collect(Collectors.groupingBy(t -> t.getData().getMonth(),
                        Collectors.groupingBy(t -> t.getData().getDayOfMonth(),
                                Collectors.groupingBy(t -> t.getData().getHour()))));
        return mapaTxPorMDH;
    }
    private static Map<Month,Map<Integer,Map<Integer,List<TransCaixa>>>> Query6_Catalogo_Java7 (List<TransCaixa> ltc){
        Map<Month,Map<Integer,Map<Integer,List<TransCaixa>>>> mapaTxPorMDH = new HashMap<>();
        for(TransCaixa tc : ltc) {
            Month mes = tc.getData().getMonth();
            int dia = tc.getData().getDayOfMonth();
            int hora = tc.getData().getHour();
            if(mapaTxPorMDH.containsKey(mes)){
                if(mapaTxPorMDH.get(mes).containsKey(dia)) {
                    if(mapaTxPorMDH.get(mes).get(dia).containsKey(hora))
                        mapaTxPorMDH.get(mes).get(dia).get(hora).add(tc);
                    else{
                        List<TransCaixa> l = new ArrayList<>();
                        l.add(tc);
                        mapaTxPorMDH.get(mes).get(dia).put(hora, l);
                    }
                }
                else {
                    List<TransCaixa> l = new ArrayList<>();
                    l.add(tc);
                    Map<Integer,List<TransCaixa>> mh = new HashMap<>();
                    mh.put(hora, l);
                    mapaTxPorMDH.get(mes).put(dia, mh);
                }
            }
            else {
                List<TransCaixa> l = new ArrayList<>();
                l.add(tc);
                Map<Integer,List<TransCaixa>> mh = new HashMap<>();
                mh.put(hora, l);
                Map<Integer,Map<Integer,List<TransCaixa>>> mdh = new HashMap<>();
                mdh.put(dia, mh);
                mapaTxPorMDH.put(mes, mdh);
            }
        }
        return mapaTxPorMDH;
    }
    private static Map<DayOfWeek,Map<Integer,List<TransCaixa>>> Query6_Catalogo_Stream_2(List<TransCaixa> ltc) {
        Map<DayOfWeek,Map<Integer,List<TransCaixa>>> mapaTxPorDSH =
                ltc.stream().collect(Collectors.groupingBy(t -> t.getData().getDayOfWeek(),
                        Collectors.groupingBy(t -> t.getData().getHour())));
        return mapaTxPorDSH;
    }
    private static Map<DayOfWeek,Map<Integer,List<TransCaixa>>> Query6_Catalogo_Java7_2 (List<TransCaixa> ltc){
        Map<DayOfWeek,Map<Integer,List<TransCaixa>>> mapaTxPorDSH = new HashMap<>();
        for(TransCaixa tc : ltc) {
            DayOfWeek diaDaSemana = tc.getData().getDayOfWeek();
            int hora = tc.getData().getHour();
            if(mapaTxPorDSH.containsKey(diaDaSemana)){
                if(mapaTxPorDSH.get(diaDaSemana).containsKey(hora))
                    mapaTxPorDSH.get(diaDaSemana).get(hora).add(tc);
                else{
                    List<TransCaixa> l = new ArrayList<>();
                    l.add(tc);
                    mapaTxPorDSH.get(diaDaSemana).put(hora, l);
                }
            }
            else {
                List<TransCaixa> l = new ArrayList<>();
                l.add(tc);
                Map<Integer,List<TransCaixa>> mh = new HashMap<>();
                mh.put(hora, l);
                mapaTxPorDSH.put(diaDaSemana, mh);
            }
        }
        return mapaTxPorDSH;
    }
    public static void resolveQuery6(List<TransCaixa> ltc) {
        Supplier<Map<Month, Map<Integer, Map<Integer, List<TransCaixa>>>>> supplier_query6_Stream =() -> Query6_Catalogo_Stream(ltc);
        SimpleEntry<Double, Map<Month, Map<Integer, Map<Integer, List<TransCaixa>>>>> res_query6_Stream = testBox.testeBoxGenW(supplier_query6_Stream);
        System.out.println("Tempo(Stream 1): "+res_query6_Stream.getKey());
        res_query6_Stream.getValue().clear();
        Supplier<Map<Month, Map<Integer, Map<Integer, List<TransCaixa>>>>> supplier_query6_Java7 = () -> Query6_Catalogo_Java7(ltc);
        SimpleEntry<Double, Map<Month, Map<Integer, Map<Integer, List<TransCaixa>>>>> res_query6_Java7 = testBox.testeBoxGenW(supplier_query6_Java7);
        System.out.println("Tempo(Seq 1): "+res_query6_Java7.getKey());
        res_query6_Java7.getValue().clear();
        Supplier<Map<DayOfWeek,Map<Integer,List<TransCaixa>>>> supplier_query6_Stream_2 =() -> Query6_Catalogo_Stream_2(ltc);
        SimpleEntry<Double, Map<DayOfWeek, Map<Integer, List<TransCaixa>>>> res_query6_Stream_2 = testBox.testeBoxGenW(supplier_query6_Stream_2);
        System.out.println("Tempo(Stream 2): "+res_query6_Stream_2.getKey());
        res_query6_Stream_2.getValue().clear();
        Supplier<Map<DayOfWeek,Map<Integer,List<TransCaixa>>>> supplier_query6_Java7_2 = () -> Query6_Catalogo_Java7_2(ltc);
        SimpleEntry<Double, Map<DayOfWeek, Map<Integer, List<TransCaixa>>>> res_query6_Java7_2 = testBox.testeBoxGenW(supplier_query6_Java7_2);
        System.out.println("Tempo(Seq 2): "+res_query6_Java7_2.getKey());
        res_query6_Java7_2.getValue().clear();
    }
    // QUERY 7
    private static Double Query7_SumWithSpliteratorStreamSeq(List<TransCaixa> ltc){
        Spliterator<TransCaixa> splitTC = ltc.spliterator();
        Spliterator<TransCaixa> splitTC1 = splitTC.trySplit();
        Spliterator<TransCaixa> splitTC2 = splitTC.trySplit();
        Spliterator<TransCaixa> splitTC13 = splitTC1.trySplit();
        Double sum1 = StreamSupport.stream(splitTC,false).mapToDouble(TransCaixa::getValor).sum();
        Double sum2 = StreamSupport.stream(splitTC1,false).mapToDouble(TransCaixa::getValor).sum();
        Double sum3 = StreamSupport.stream(splitTC2,false).mapToDouble(TransCaixa::getValor).sum();
        Double sum4 = StreamSupport.stream(splitTC13,false).mapToDouble(TransCaixa::getValor).sum();
        return sum1+sum2+sum3+sum4;
    }
    private static Double Query7_SumWithSpliteratorStreamPar(List<TransCaixa> ltc){
        Spliterator<TransCaixa> splitTC = ltc.spliterator();
        Spliterator<TransCaixa> splitTC1 = splitTC.trySplit();
        Spliterator<TransCaixa> splitTC2 = splitTC.trySplit();
        Spliterator<TransCaixa> splitTC13 = splitTC1.trySplit();
        Double sum1 = StreamSupport.stream(splitTC,false).parallel().mapToDouble(TransCaixa::getValor).sum();
        Double sum2 = StreamSupport.stream(splitTC1,false).parallel().mapToDouble(TransCaixa::getValor).sum();
        Double sum3 = StreamSupport.stream(splitTC2,false).parallel().mapToDouble(TransCaixa::getValor).sum();
        Double sum4 = StreamSupport.stream(splitTC13,false).parallel().mapToDouble(TransCaixa::getValor).sum();
        return sum1+sum2+sum3+sum4;
    }
    private static Double Query7_SumListFor(List<TransCaixa> ltc){
        Double res=0.0;
        for(TransCaixa tc: ltc)
            res+=tc.getValor();
        return res;
    }
    private static Double Query7_SumStreamSeq(List<TransCaixa> ltc){
        Double res = ltc.stream().mapToDouble(TransCaixa::getValor).sum();
        return res;
    }
    private static Double Query7_SumStreamPar(List<TransCaixa> ltc){
        Double res = ltc.parallelStream().mapToDouble(TransCaixa::getValor).sum();
        return res;
    }
    public static void resolveQuery7(List<TransCaixa> ltc){
        Supplier<Double> supplier_query7_1 =() -> Query7_SumWithSpliteratorStreamSeq(ltc);
        SimpleEntry<Double,Double> res_query_1 = testBox.testeBoxGenW(supplier_query7_1);
        System.out.println("Resultado Stream Split Seq("+res_query_1.getKey()+"): "+res_query_1.getValue());
        Supplier<Double> supplier_query7_2 =() -> Query7_SumWithSpliteratorStreamPar(ltc);
        SimpleEntry<Double,Double> res_query_2 = testBox.testeBoxGenW(supplier_query7_2);
        System.out.println("Resultado Stream Split Par("+res_query_2.getKey()+"): "+res_query_2.getValue());
        Supplier<Double> supplier_query7_3 =() -> Query7_SumStreamSeq(ltc);
        SimpleEntry<Double,Double> res_query_3 = testBox.testeBoxGenW(supplier_query7_3);
        System.out.println("Resultado Stream Seq("+res_query_3.getKey()+"): "+res_query_3.getValue());
        Supplier<Double> supplier_query7_4 =() -> Query7_SumStreamPar(ltc);
        SimpleEntry<Double,Double> res_query_4 = testBox.testeBoxGenW(supplier_query7_4);
        System.out.println("Resultado Stream Par("+res_query_4.getKey()+"): "+res_query_4.getValue());
        Supplier<Double> supplier_query7_5 =() -> Query7_SumListFor(ltc);
        SimpleEntry<Double,Double> res_query_5 = testBox.testeBoxGenW(supplier_query7_5);
        System.out.println("Resultado List ForEach("+res_query_5.getKey()+"): "+res_query_5.getValue());
    }
    // QUERY 8
    private static String Query8_ComparaCodTransList(List<TransCaixa> ltc){
        String res="T1";
        for(TransCaixa tc:ltc)
            if(tc.getData().getHour()>16 && tc.getData().getHour()<22 && res.compareTo(tc.getTrans())<0)
                res=tc.getTrans();
        return res;
    }
    private static String Query8_ComparaCodTransStream(List<TransCaixa> ltc){
        final Comparator<TransCaixa> compTC = Comparator.comparing(c -> c.getTrans().substring(1));
        Optional<TransCaixa> tc =ltc.stream()
                .filter(strdate -> strdate.getData().getHour()>16 && strdate.getData().getHour()<22)
                .max(compTC);
        return tc.get().getTrans();
    }
    public static void resolveQuery8(List<TransCaixa> ltc){
        Supplier<String> supplier_query8_1 = () -> Query8_ComparaCodTransList(ltc);
        SimpleEntry<Double,String> res_query8_1 = testBox.testeBoxGenW(supplier_query8_1);
        System.out.println("Código: "+res_query8_1.getValue()+"/"+res_query8_1.getKey());
        Supplier<String> supplier_query8_2 = () -> Query8_ComparaCodTransStream(ltc);
        SimpleEntry<Double,String> res_query8_2 = testBox.testeBoxGenW(supplier_query8_2);
        System.out.println("Código: "+res_query8_2.getValue()+"/"+res_query8_2.getKey());
    }
    // QUERY 9
    private static List<List<TransCaixa>> sortPorSemana(List<TransCaixa> ltc){
        List<List<TransCaixa>> lltc = new ArrayList<>();
        for(int i=1;i<55;i++){
            List<TransCaixa> nltc = new ArrayList<>();
            lltc.add(nltc);
        }
        for(TransCaixa tc:ltc){
            int woy = tc.getData().get(ChronoField.ALIGNED_WEEK_OF_YEAR);
            if(tc.getData().getDayOfMonth()<=7)
                lltc.get(woy).add(tc);
        }
        return lltc;
    }
    private static List<Double> Query9_totalFaturadoSemanalFor(List<List<TransCaixa>> lltc) {
        List<Double> dlist = new ArrayList<>();
        for (List<TransCaixa> ltc : lltc) {
            Double sum = 0.0;
            for (TransCaixa tc : ltc)
                sum += tc.getValor();
            dlist.add(sum);
        }
        return dlist;
    }
    private static List<Double> Query9_totalFaturadoSemanalStream(List<List<TransCaixa>> lltc){
        List<Double> dlist = lltc
                .stream().map(lista -> lista.stream().mapToDouble(TransCaixa::getValor).sum())
                .collect(Collectors.toList());
        return dlist;
    }
    public static void resolveQuery9(List<TransCaixa> ltc){
        List<List<TransCaixa>> lltc = sortPorSemana(ltc);
        Supplier<List<Double>> supplier_query9_1 = () -> Query9_totalFaturadoSemanalFor(lltc);
        SimpleEntry<Double,List<Double>> res_query9_1 = testBox.testeBoxGenW(supplier_query9_1);
        System.out.println("Total Faturado por semana("+res_query9_1.getKey()+")\n"+res_query9_1.getValue().toString());
        Supplier<List<Double>> supplier_query9_2 = () -> Query9_totalFaturadoSemanalStream(lltc);
        SimpleEntry<Double,List<Double>> res_query9_2 = testBox.testeBoxGenW(supplier_query9_2);
        System.out.println("Total Faturado por semana("+res_query9_2.getKey()+")\n"+res_query9_2.getValue().toString());
    }
    // QUERY 10
    private static Double ivaPorTransacao(Double valor){
        if(valor<20) return 0.12*valor;
        else if(valor<29) return 0.2*valor;
        else return 0.23*valor;
    }
    private static ToDoubleFunction<Double> doubleIva = d -> d<20 ? 0.12*d : d<29 ? 0.2*d : 0.23*d;
    private static Map<Month,Double> Query10_totalIvaFor(List<TransCaixa> ltc){
        Map<Month, Double> tabela = new HashMap<>();
        for(TransCaixa tc: ltc)
            if(tabela.containsKey(tc.getData().getMonth()))
                tabela.replace(tc.getData().getMonth(),tabela.get(tc.getData().getMonth())+ivaPorTransacao(tc.getValor()));
            else
                tabela.put(tc.getData().getMonth(),ivaPorTransacao(tc.getValor()));
        return tabela;
    }
    private static Map<Month,Double> Query10_totalIvaStream(List<TransCaixa> ltc){
        return ltc.stream().collect(Collectors.groupingBy(t -> t.getData().getMonth(), Collectors.mapping(TransCaixa::getValor,Collectors.summingDouble(doubleIva))));
    }
    public static void resolveQuery10(List<TransCaixa> ltc){
        Supplier<Map<Month,Double>> supplier_query10_1 = () -> Query10_totalIvaFor(ltc);
        SimpleEntry<Double,Map<Month, Double>> res_query10_1 = testBox.testeBoxGenW(supplier_query10_1);
        System.out.println("For: "+res_query10_1.getKey());
        Supplier<Map<Month,Double>> supplier_query10_2 = () -> Query10_totalIvaStream(ltc);
        SimpleEntry<Double,Map<Month,Double>> res_query10_2 = testBox.testeBoxGenW(supplier_query10_2);
        System.out.println("Stream: "+res_query10_2.getKey());
    }
    // QUERY 11
    public static void resolveQuery11(List<TransCaixa> ltc) {
    	Supplier<Double> supplier_query1_12 =() -> Query1_StreamDAvgPar(ltc);
        SimpleEntry<Double, Double> res_query1_12 = testBox.testeBoxGenW(supplier_query1_12);
        System.out.println("Tempo(1): " + res_query1_12.getKey() + "/"+res_query1_12.getValue());
    	Supplier<Double> supplier_query7_4 =() -> Query7_SumStreamPar(ltc);
        SimpleEntry<Double,Double> res_query_4 = testBox.testeBoxGenW(supplier_query7_4);
        System.out.println("Tempo(7): "+res_query_4.getKey());
    	Supplier<Map<String, Map<Month, List<TransCaixa>>>> supplier_query12_ConcurrentMap = () -> Query12_ConcurrentMap(ltc);
        SimpleEntry<Double, Map<String, Map<Month, List<TransCaixa>>>> res_query12_ConcurrentMap = testBox.testeBoxGenW(supplier_query12_ConcurrentMap);
        System.out.println("Tempo(12): "+res_query12_ConcurrentMap.getKey());
        Supplier<SimpleEntry<List<TransCaixa>,List<TransCaixa>>> supplier_query2_StreamParallel = () -> Query2_StreamParallel(ltc);
        SimpleEntry<Double, SimpleEntry<List<TransCaixa>, List<TransCaixa>>> res_query2_StreamParallel = testBox.testeBoxGenW(supplier_query2_StreamParallel);
        System.out.println("Tempo(2): "+res_query2_StreamParallel.getKey());
    }
    // QUERY 12
    private static Map<String,Map<Month,List<TransCaixa>>> Query12_Map(List<TransCaixa> ltc ) {
        Map<String, Map<Month, List<TransCaixa>>> tabela = ltc
                .stream()
                .collect(Collectors.groupingBy(t -> t.getCaixa(),
                		Collectors.groupingBy(t -> t.getData().getMonth())));
        return tabela;
    }
    private static Map<String,Map<Month,List<TransCaixa>>> Query12_ConcurrentMap(List<TransCaixa> ltc ) {
        Map<String, Map<Month, List<TransCaixa>>> tabela = ltc
                .parallelStream()
                .collect(Collectors.groupingBy(t -> t.getCaixa(),
                        Collectors.groupingBy(t -> t.getData().getMonth())));
        return tabela;
    }
    public static void resolveQuery12(List<TransCaixa> ltc) {
    	Supplier<Map<String, Map<Month, List<TransCaixa>>>> supplier_query12_Map = () -> Query12_Map(ltc);
        SimpleEntry<Double, Map<String, Map<Month, List<TransCaixa>>>> res_query12_Map = testBox.testeBoxGenW(supplier_query12_Map);
        System.out.println("Tempo(Map): "+res_query12_Map.getKey());
        Supplier<Map<String, Map<Month, List<TransCaixa>>>> supplier_query12_ConcurrentMap = () -> Query12_ConcurrentMap(ltc);
        SimpleEntry<Double, Map<String, Map<Month, List<TransCaixa>>>> res_query12_ConcurrentMap = testBox.testeBoxGenW(supplier_query12_ConcurrentMap);
        System.out.println("Tempo(CMap): "+res_query12_ConcurrentMap.getKey());
    }
}
