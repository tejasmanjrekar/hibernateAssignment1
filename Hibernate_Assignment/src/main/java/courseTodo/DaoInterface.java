package courseTodo;
import java.util.Collection;
public interface DaoInterface<T,K> {
	void createNew(T t);
	
	T getOneById(K id);
	void update(K id);
	void deleteById(K id);
}

