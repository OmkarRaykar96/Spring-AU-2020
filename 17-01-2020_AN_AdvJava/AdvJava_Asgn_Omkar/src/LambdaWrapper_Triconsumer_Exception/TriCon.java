package LambdaWrapper_Triconsumer_Exception;

@FunctionalInterface
public interface TriCon <T,U,V>{
		void apply(T t, U u, V v);
}
