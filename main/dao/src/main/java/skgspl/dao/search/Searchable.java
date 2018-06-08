package skgspl.dao.search;

import java.util.List;

import skgspl.entity.AbstractEntity;

public interface Searchable<T, R extends AbstractEntity> {
	List<R> search(SortParam sortParam, T searchParam, int limit, int offset, boolean asc);
	
	Long count (T searchParam);

	}
