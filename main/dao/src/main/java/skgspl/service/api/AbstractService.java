package skgspl.service.api;

import java.util.List;

import skgspl.entity.AbstractEntity;
import skgspl.entity.util.DictionaryItem;

public interface AbstractService<T extends AbstractEntity> {

	T create(T entity);

	void delete(T entity);

	void update(T entity);

	T get(Long id);

	List<T> getAll();
	
	Long count();
	
	List<DictionaryItem> getDictionary();
}
