package skgspl.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import skgspl.dao.api.AbstractDao;
import skgspl.entity.AbstractEntity;
import skgspl.entity.util.DictionaryItem;
import skgspl.service.api.AbstractService;

@Transactional
public abstract class AbstractServiceImpl<T extends AbstractEntity> implements AbstractService<T> {

	protected abstract AbstractDao<T> getDao();

	@Override
	public T create(T entity) {
		return getDao().create(entity);
	}

	@Override
	public void delete(T entity) {
		getDao().delete(entity);
	}

	@Override
	public void update(T entity) {
		getDao().update(entity);
	}

	@Override
	public T get(Long id) {
		return getDao().get(id);
	}

	@Override
	public List<T> getAll() {
		return getDao().getAll();
	}
	
	@Override
	public Long count() {
		return getDao().count();
	}

	@Override
	public List<DictionaryItem> getDictionary() {
		return getDao().getDictionary();
	}
}
